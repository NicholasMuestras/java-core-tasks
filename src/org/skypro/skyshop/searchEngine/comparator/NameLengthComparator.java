package org.skypro.skyshop.searchEngine.comparator;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable objectA, Searchable objectB) {

        int result = Integer.compare(objectB.getName().length(), objectA.getName().length());

        if (result != 0) {
            return result;
        }

        return objectA.getName().compareTo(objectB.getName());
    }
}
