package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchEngine.exception.BestResultNotFoundException;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> haystack;

    public SearchEngine() {
        this.haystack = new LinkedList<>();
    }

    public Map<String, List<Searchable>> search(String needle) {
        Map<String, List<Searchable>> found = new TreeMap<>();    //  result storage fast reset
        List<Searchable> setOfItems;

        for (Searchable item : this.haystack) {
            if (item.getSearchTerm().contains(needle)) {
                if (found.containsKey(item.getName())) {
                    setOfItems = found.get(item.getName());
                    setOfItems.add(item);
                    found.put(item.getName(), setOfItems);
                } else {
                    setOfItems = new LinkedList<>();
                    setOfItems.add(item);
                    found.put(item.getName(), setOfItems);
                }
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
