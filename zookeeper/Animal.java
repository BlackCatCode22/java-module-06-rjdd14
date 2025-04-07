package zookeeper;

import java.time.LocalDate;

public class Animal {
    // Static total count
    static int numOfAnimals = 0;

    // Static counters per species
    static int numOfHyenas = 0;
    static int numOfLions = 0;
    static int numOfTigers = 0;
    static int numOfBears = 0;

    // Fields
    private String sex;
    private int age;
    private int weight;
    private String animalName;
    private String animalID;
    private String animalBirthDate; // ISO 8601 format: YYYY-MM-DD
    private String animalColor;
    private String animalOrigin;
    private String animalArrivalDate;

    // Default constructor
    public Animal() {
        numOfAnimals++;
        this.animalArrivalDate = LocalDate.now().toString();
    }

    // Full constructor
    public Animal(String sex, int age, int weight, String animalName,
              String animalID, String animalBirthDate, String animalColor,
              String animalOrigin, String animalArrivalDate) {
    this.sex = sex;
    this.age = age;
    this.weight = weight;
    this.animalName = animalName;
    this.animalID = animalID;
    this.animalBirthDate = animalBirthDate;
    this.animalColor = animalColor;
    this.animalOrigin = animalOrigin;
    this.animalArrivalDate = animalArrivalDate;
    numOfAnimals++;
}

    // Getters and Setters
    public String getAnimalOrigin() {
        return animalOrigin;
    }

    public void setAnimalOrigin(String animalOrigin) {
        this.animalOrigin = animalOrigin;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalBirthDate() {
        return animalBirthDate;
    }

    public void setAnimalBirthDate(String animalBirthDate) {
        this.animalBirthDate = animalBirthDate;
    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAnimalArrivalDate() {
        return animalArrivalDate;
    }

    public void setAnimalArrivalDate(String animalArrivalDate) {
        this.animalArrivalDate = animalArrivalDate;
    }
}
