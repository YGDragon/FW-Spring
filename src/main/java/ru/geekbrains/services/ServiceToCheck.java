package ru.geekbrains.services;

import org.apache.commons.lang3.StringUtils;
import ru.geekbrains.Person;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceToCheck {

    /* Проверка заполнения данных о персонах */
    public List<Person> checkFillData(Person[] personArray) {
        System.out.println("Вывод списка персона с незаполненными данными: ");
        return Arrays.stream(personArray)
                .filter(person ->
                        StringUtils.isBlank(person.getFirstname()) ||
                                StringUtils.isBlank(person.getLastname()) ||
                                StringUtils.isBlank(String.valueOf(person.getAge())))
                .toList();
    }

    /* Формирование списка HashCode персон из массива списка */
    public TreeMap<String, Integer> getListHC(Person[] personArray) {
        System.out.println("Вывод списка HashCode всех персон из массива: ");
        final int[] count = {1};
        return Arrays.stream(personArray)
                .collect(Collectors.toMap(k -> "Персона " + count[0]++, Person::hashCode, Integer::min, TreeMap::new));
    }
}
