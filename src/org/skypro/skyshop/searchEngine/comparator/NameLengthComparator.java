package org.skypro.skyshop.searchEngine.comparator;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Comparator;

public class NameLengthComparator implements Comparator {
    @Override
    public int compare(Object objectA, Object objectB) {
        if (!(objectA instanceof Searchable a)) {
            throw new IllegalArgumentException("First argument must implements Searchable interface.");
        }

        if (!(objectB instanceof Searchable b)) {
            throw new IllegalArgumentException("Second argument must implements Searchable interface.");
        }

        if (!(objectA instanceof Comparable aa)) {
            throw new IllegalArgumentException("First argument must implements Comparable interface.");
        }

        if (!(objectB instanceof Comparable bb)) {
            throw new IllegalArgumentException("Second argument must implements Comparable interface.");
        }

        int result = Integer.compare(b.getName().length(), a.getName().length());

        if (result != 0) {
            return result;
        }

        return aa.compareTo(bb);
    }
}
