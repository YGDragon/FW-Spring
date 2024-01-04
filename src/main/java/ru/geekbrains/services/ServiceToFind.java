package ru.geekbrains.services;

import org.apache.commons.lang3.StringUtils;
import ru.geekbrains.Person;

import java.util.Arrays;
import java.util.List;

public class ServiceToFind {

    /* Поиск персон в массиве по имени
     * с использованием класса StringUtils */
    public List<Person> findByFirstName(String firstName, Person[] listPerson) {
        System.out.printf("Поиск персон по имени %s в списке >> ", firstName);
        List<Person> persons = Arrays.stream(listPerson)
                .filter(person -> StringUtils.equals(firstName, person.getFirstname()))
                .toList();

        boolean check = (persons.size() == 0);
        System.out.println(
                check ?
                        "В списке отсутствуют персоны с именем " + firstName :
                        "В списке присутствуют персоны с именем " + firstName
        );
        return persons;
    }

    /* Поиск персон в массиве по фамилии
     * с использованием класса StringUtils */
    public List<Person> findByLastName(String lastName, Person[] listPerson) {
        System.out.printf("Поиск персон по фамилии %s в списке >> ", lastName);
        List<Person> persons = Arrays.stream(listPerson)
                .filter(person -> StringUtils.equals(lastName, person.getLastname()))
                .toList();

        boolean check = (persons.size() == 0);
        System.out.println(
                check ?
                        "В списке отсутствуют персоны с фамилией " + lastName :
                        "В списке присутствуют персоны с фамилией " + lastName
        );
        return persons;
    }

}
