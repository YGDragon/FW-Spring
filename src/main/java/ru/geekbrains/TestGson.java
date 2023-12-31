package ru.geekbrains;

public class TestGson {
    public static void main(String[] args) {
        Person person = new Person("Father", " Frost", 180);
        person.writeJSON(person);
        System.out.println(person.readJSON());
    }
}
