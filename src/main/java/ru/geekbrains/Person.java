package ru.geekbrains;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.*;


public class Person {
    private final  static String PATH = "src\\main\\java\\resources\\person.json";

    private String firstname;
    private String lastname;
    private int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    //region Getters & Setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //endregion

    //region Override methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstname", firstname)
                .append("lastname", lastname)
                .append("age", age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(age, person.age)
                .append(firstname, person.firstname)
                .append(lastname, person.lastname).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstname)
                .append(lastname)
                .append(age).toHashCode();
    }

    //endregion

    public void writeJSON(Person person) {
        try (FileWriter writer = new FileWriter(PATH)) {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            writer.write(gson.toJson(person));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Person readJSON() {
        try (FileReader reader = new FileReader(PATH)) {

            BufferedReader bufferedReader = new BufferedReader(reader);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(bufferedReader, Person.class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}