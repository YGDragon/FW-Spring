package ru.geekbrains.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.geekbrains.Person;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServiceJSON {

    /**
     * Сохранение объектов в файл формата JSON
     *
     * @param objectList Список объектов Person
     * @param path       Расположение файла JSON
     */
    public void saveToJsonFile(ArrayList<Person> objectList, String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(objectList, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение файла формата JSON
     *
     * @return Person[]
     */
    public Person[] readFromJsonFile(String path) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, Person[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Person[] {new Person()};
    }
}