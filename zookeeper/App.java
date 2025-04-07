package zookeeper;

import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to my Zoo Program!");

        String filePath = "zookeeper/animalNames.txt";
        AnimalNameListsWrapper animalLists = Utilities.createAnimalNameLists(filePath);
        ArrayList<String> hyenaNames = animalLists.getHyenaNameList();

        ArrayList<String> zooReportLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("zookeeper/arrivingAnimals.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("\nRaw Line: " + line);

                String[] parts = line.split(", ");
                String[] ageSexSpecies = parts[0].split(" ");
                int age = Integer.parseInt(ageSexSpecies[0]);
                String sex = ageSexSpecies[3];
                String species = ageSexSpecies[4].toLowerCase();

                String birthSeason = parts[1].replace("born in ", "").trim();
                String color = parts[2].replace(" color", "").trim();
                int weight = Integer.parseInt(parts[3].replace(" pounds", "").trim());
                String origin = parts[4];
                if (parts.length > 5) {
                    origin += ", " + parts[5];
                }
                origin = origin.replaceFirst("from ", "").trim();

                String id = Utilities.calcAnimalID(species);
                String birthDate = Utilities.calcAnimalBirthDate(age, birthSeason);
                String arrivalDate = Utilities.arrivalDate();

                String recordLine = "";

                if (species.equals("hyena") && !hyenaNames.isEmpty()) {
                    String name = hyenaNames.remove(0);
                    Hyena hyena = new Hyena(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                    recordLine = hyena.getAnimalID() + "; " + hyena.getAnimalName() + "; birth date: " +
                                 hyena.getAnimalBirthDate() + "; " + hyena.getAnimalColor() + "; " +
                                 hyena.getSex() + "; " + hyena.getWeight() + " pounds; from " +
                                 hyena.getAnimalOrigin() + "; arrived " + hyena.getAnimalArrivalDate();
                    System.out.println("✅ Created Hyena:\n" + recordLine);

                } else if (species.equals("lion") && !animalLists.getLionNameList().isEmpty()) {
                    String name = animalLists.getLionNameList().remove(0);
                    Lion lion = new Lion(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                    recordLine = lion.getAnimalID() + "; " + lion.getAnimalName() + "; birth date: " +
                                 lion.getAnimalBirthDate() + "; " + lion.getAnimalColor() + "; " +
                                 lion.getSex() + "; " + lion.getWeight() + " pounds; from " +
                                 lion.getAnimalOrigin() + "; arrived " + lion.getAnimalArrivalDate();
                    System.out.println("✅ Created Lion:\n" + recordLine);

                } else if (species.equals("tiger") && !animalLists.getTigerNameList().isEmpty()) {
                    String name = animalLists.getTigerNameList().remove(0);
                    Tiger tiger = new Tiger(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                    recordLine = tiger.getAnimalID() + "; " + tiger.getAnimalName() + "; birth date: " +
                                 tiger.getAnimalBirthDate() + "; " + tiger.getAnimalColor() + "; " +
                                 tiger.getSex() + "; " + tiger.getWeight() + " pounds; from " +
                                 tiger.getAnimalOrigin() + "; arrived " + tiger.getAnimalArrivalDate();
                    System.out.println("✅ Created Tiger:\n" + recordLine);

                } else if (species.equals("bear") && !animalLists.getBearNameList().isEmpty()) {
                    String name = animalLists.getBearNameList().remove(0);
                    Bear bear = new Bear(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                    recordLine = bear.getAnimalID() + "; " + bear.getAnimalName() + "; birth date: " +
                                 bear.getAnimalBirthDate() + "; " + bear.getAnimalColor() + "; " +
                                 bear.getSex() + "; " + bear.getWeight() + " pounds; from " +
                                 bear.getAnimalOrigin() + "; arrived " + bear.getAnimalArrivalDate();
                    System.out.println("✅ Created Bear:\n" + recordLine);
                }

                if (!recordLine.isEmpty()) {
                    zooReportLines.add(recordLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading arrivingAnimals.txt: " + e.getMessage());
        }

        try (PrintWriter writer = new PrintWriter("zookeeper/zooPopulation.txt")) {
            for (String line : zooReportLines) {
                writer.println(line);
            }
            System.out.println("\n📄 Zoo report saved to zooPopulation.txt");
        } catch (IOException e) {
            System.out.println("Error writing zooPopulation.txt: " + e.getMessage());
        }
    }
}
