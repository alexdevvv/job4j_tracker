package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        CityComparator comparator = new CityComparator();
       return profiles.stream()
               .map(p -> p.getAddress())
               .sorted(comparator)
               .distinct()
               .collect(Collectors.toList());
    }
}
