package zookeeper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utilities {
    public static String calcAnimalID(String animalSpecies) {
        String myID = "";
        if (animalSpecies.contains("hy")) {
            int myNumOfHyenas = Hyena.numOfHyenas + 1;
            myID = "Hy0" + myNumOfHyenas;
        } else if (animalSpecies.contains("li")) {
            int myNumOfLions = Lion.numOfLions + 1;
            myID = "Li0" + myNumOfLions;
        } else if (animalSpecies.contains("ti")) {
            int myNumOfTigers = Tiger.numOfTigers + 1;
            myID = "Ti0" + myNumOfTigers;
        } else if (animalSpecies.contains("be")) {
            int myNumOfBears = Bear.numOfBears + 1;
            myID = "Be0" + myNumOfBears;
        }
        return myID;
    }

    public static String arrivalDate() {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(today);
    }

    public static String calcAnimalBirthDate(int age, String theSeason) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
        String strTodaysDate = formatter.format(today);
        String strTodaysYear = formatterYear.format(today);
        System.out.println("Today's date in the format yyyy-MM-dd: " + strTodaysDate);
        String animalBirthdate = "";
        int todaysYear = Integer.parseInt(strTodaysYear);
        int animalBirthYear = todaysYear - age;

        String season = theSeason.toLowerCase();
        switch (season) {
            case "spring":
                animalBirthdate = animalBirthYear + "-03-21";
                break;
            case "fall":
                animalBirthdate = animalBirthYear + "-09-21";
                break;
            case "winter":
                animalBirthdate = animalBirthYear + "-12-21";
                break;
            case "summer":
                animalBirthdate = animalBirthYear + "-06-21";
                break;
            default:
                animalBirthdate = animalBirthYear + "-01-01";
                break;
        }
        return animalBirthdate;
    }

    public static AnimalNameListsWrapper createAnimalNameLists(String filePath) {
        ArrayList<String> hyenaNameList = new ArrayList<>();
        ArrayList<String> lionNameList = new ArrayList<>();
        ArrayList<String> tigerNameList = new ArrayList<>();
        ArrayList<String> bearNameList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            ArrayList<String> currentList = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equals("Hyena Names:")) {
                    currentList = hyenaNameList;
                } else if (line.equals("Lion Names:")) {
                    currentList = lionNameList;
                } else if (line.equals("Tiger Names:")) {
                    currentList = tigerNameList;
                } else if (line.equals("Bear Names:")) {
                    currentList = bearNameList;
                } else if (!line.isEmpty()) {
                    String[] names = line.split(",\\s*");
                    for (String name : names) {
                        if (currentList != null) {
                            currentList.add(name);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return new AnimalNameListsWrapper(hyenaNameList, lionNameList, tigerNameList, bearNameList);
    }
}
