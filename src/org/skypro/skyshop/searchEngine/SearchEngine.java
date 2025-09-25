package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchEngine.comparator.NameLengthComparator;
import org.skypro.skyshop.searchEngine.exception.BestResultNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> haystack;

    public SearchEngine() {
        this.haystack = new HashSet<>();
    }

    public Set<Searchable> search(String needle) {
        Set<Searchable> found = new TreeSet<>(new NameLengthComparator());
        List<Searchable> setOfItems;

        for (Searchable item : this.haystack) {
            if (item.getSearchTerm().contains(needle)) {
                found.add(item);
            }
        }

        return found;
    }

    public Searchable searchBestResult(String needle) throws BestResultNotFoundException {
        Searchable bestResult = null;
        int bestResultScore = 0;
        int currentResultScore;

        for (Searchable item : this.haystack) {
            if (item == null) {
                continue;
            }

            currentResultScore = this.countSubstring(item.getSearchTerm(), needle);

            if (currentResultScore > bestResultScore) {
                bestResultScore = currentResultScore;
                bestResult = item;
            }
        }

        if (bestResultScore == 0) {
            throw new BestResultNotFoundException("No result found for search string: " + needle);
        }

        return bestResult;
    }

    public SearchEngine add(Searchable item) {
        this.haystack.add(item);

        return this;
    }

    private int countSubstring(String str, String sub) {
        int count = 0;
        int index = 0;

        if (str == null || sub == null || sub.isEmpty()) {
            return 0;
        }

        while (index < str.length()) {
            index = str.indexOf(sub, index);

            if (index == -1) {
                break;
            }

            count++;
            index += sub.length();
        }

        return count;
    }
}
