package org.skypro.skyshop.searchEngine;

public class SearchEngine {
    private static final int RESULT_ITEMS_COUNT_MAX = 5;

    private final Searchable[] haystack;
    private Searchable[] found;

    public SearchEngine(int haystackSize) {
        this.haystack = new Searchable[haystackSize];
        this.found = new Searchable[RESULT_ITEMS_COUNT_MAX];    //  result storage init. This step is important for code stability after changes.
    }

    public Searchable[] search(String needle) {
        this.found = new Searchable[RESULT_ITEMS_COUNT_MAX];    //  result storage fast reset
        int countFounded = 0;

        for (Searchable item : this.haystack) {
            if (item == null) {
                continue;
            }

            if (countFounded == RESULT_ITEMS_COUNT_MAX) {
                return this.found;
            }

            if (item.getSearchTerm().contains(needle)) {
                this.found[countFounded] = item;
                countFounded++;
            }
        }

        return this.found;
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
