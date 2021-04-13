package model.client;

import java.util.regex.Pattern;

import model.file.*;

public class ClientImpl implements Client {

    private final String name;
    private final String surname;
    private final String id;
    public ClientImpl(final String i) {
        String[] parts = i.split(Pattern.quote("."));
        name = parts[0];
        surname = parts[1];
        id = parts[2]; 
    }

    public ClientImpl(final String name, final String surname, final String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getId() {
        return id;
    }
 }