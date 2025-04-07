package zookeeper;

public class Tiger extends Animal {
    public static int numOfTigers = 0;

    public Tiger() {
        super();
        numOfTigers++;
    }

    public Tiger(String sex, int age, int weight, String animalName,
                 String animalID, String animalBirthDate, String animalColor,
                 String animalOrigin, String animalArrivalDate) {
        super(sex, age, weight, animalName, animalID, animalBirthDate, animalColor,
              animalOrigin, animalArrivalDate);
        numOfTigers++;
    }
}
