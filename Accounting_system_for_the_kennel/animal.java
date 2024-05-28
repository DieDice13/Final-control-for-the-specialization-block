package Accounting_system_for_the_kennel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

abstract class animal implements Serializable {
    private static int nextId = 1;

    private int id;
    private String name;
    private LocalDate birth_date;
    private String breed;
    private String commands;

    public animal(String name, LocalDate birth_date, String breed, String commands) {
        this.id = nextId++;
        this.name = name;
        this.birth_date = birth_date;
        this.breed = breed;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public void addCommand(String newCommand) {
        this.commands += ", " + newCommand;
    }

    public int calculateAgeInMonths() {
        return Period.between(birth_date, LocalDate.now()).getYears() * 12 + Period.between(birth_date, LocalDate.now()).getMonths();
    }

    public abstract String getAnimalType();
}


