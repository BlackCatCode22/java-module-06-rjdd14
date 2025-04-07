package zookeeper;

public class Bear extends Animal {
    public static int numOfBears = 0;

    public Bear() {
        super();
        numOfBears++;
    }

    public Bear(String sex, int age, int weight, String animalName,
                String animalID, String animalBirthDate, String animalColor,
                String animalOrigin, String animalArrivalDate) {
        super(sex, age, weight, animalName, animalID, animalBirthDate, animalColor,
              animalOrigin, animalArrivalDate);
        numOfBears++;
    }
}
