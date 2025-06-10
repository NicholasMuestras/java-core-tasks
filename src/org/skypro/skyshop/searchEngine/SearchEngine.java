package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchEngine.exception.BestResultNotFoundException;

public class SearchEngine {
    private static final int RESULT_ITEMS_COUNT_MAX = 5;

    private final Searchable[] haystack;

    public SearchEngine(int haystackSize) {
        this.haystack = new Searchable[haystackSize];
    }

    public Searchable[] search(String needle) {
        Searchable[] found = new Searchable[RESULT_ITEMS_COUNT_MAX];    //  result storage fast reset
        int countFounded = 0;

        for (Searchable item : this.haystack) {
            if (item == null) {
                continue;
            }

            if (countFounded == RESULT_ITEMS_COUNT_MAX) {
                return found;
            }

            if (item.getSearchTerm().contains(needle)) {
                found[countFounded] = item;
                countFounded++;
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
        for (int i = 0; i < this.haystack.length; i++) {
            if (this.haystack[i] == null) {
                this.haystack[i] = item;

                return this;
            }
        }

        throw new RuntimeException("Unable to add an item. Haystack is full.");
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
