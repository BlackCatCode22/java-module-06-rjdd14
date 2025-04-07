package zookeeper;

public class Lion extends Animal {
    public static int numOfLions = 0;

    public Lion() {
        super();
        numOfLions++;
    }

    public Lion(String sex, int age, int weight, String animalName,
                String animalID, String animalBirthDate, String animalColor,
                String animalOrigin, String animalArrivalDate) {
        super(sex, age, weight, animalName, animalID, animalBirthDate, animalColor,
              animalOrigin, animalArrivalDate);
        numOfLions++;
    }
}
