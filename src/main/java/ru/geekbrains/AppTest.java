package ru.geekbrains;

import ru.geekbrains.services.ServiceJSON;
import ru.geekbrains.services.ServiceToCheck;
import ru.geekbrains.services.ServiceToFind;

import java.util.*;

public class AppTest {
    public static void main(String[] args) {
        /* Путь к файлу формата JSON */
        String path = "src\\main\\java\\resources\\person.json";

        /*
         * Подключение сервиса ServiceJSON
         * для сериализации/десериализации объектов
         */
        ServiceJSON jsonService = new ServiceJSON();

        /* Формирование списка объектов Person */
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Евгений", "Адамов", 53));
        personList.add(new Person("Виктор"));
        personList.add(new Person("Инна", "Белая"));
        personList.add(new Person("Павел", "Черный", 37));
        personList.add(new Person("Юрий", "Грэй"));
        personList.add(new Person("Мария"));

        /* Сериализация списка объектов Person в формат JSON */
        jsonService.saveToJsonFile(personList, path);

        /* Десериализация файла формата JSON
         * и получение массива объектов Person */
        System.out.println("Вывод результата десериализации файла формата JSON");
        Person[] personArray = jsonService.readFromJsonFile(path);
        Arrays.stream(personArray).forEach(System.out::println);

        /*
         * Подключение сервиса ServiceToFind
         * для поиска объектов Person
         */
        ServiceToFind checkPersonService = new ServiceToFind();

        /* Проверка совпадения имени */
        System.out.println();
        String firstName = "Евгений";
        List<Person> find1 = checkPersonService.findByFirstName(firstName, personArray);
        find1.forEach(System.out::println);

        /* Проверка совпадения фамилии */
        System.out.println();
        String lastName = "Белая";
        List<Person> find2 = checkPersonService.findByLastName(lastName, personArray);
        find2.forEach(System.out::println);

        /*
         * Подключение сервиса ServiceToCheck
         * для проверки данных объектов Person
         */
        ServiceToCheck serviceToCheck = new ServiceToCheck();

        /* Проверка данных персон из массива */
        System.out.println();
        List<Person> check1 = serviceToCheck.checkFillData(personArray);
        check1.forEach(System.out::println);

        /* Получение HashCode всех персон из массива */
        System.out.println();
        TreeMap<String, Integer> check2 = serviceToCheck.getListHC(personArray);
        check2.entrySet().forEach(System.out::println);
    }

}
