package org.skypro.skyshop.searchEngine;

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

    public SearchEngine add(Searchable item) {
        for (int i = 0; i < this.haystack.length; i++) {
            if (this.haystack[i] == null) {
                this.haystack[i] = item;

                return this;
            }
        }

        throw new RuntimeException("Unable to add an item. Haystack is full.");
    }
}
