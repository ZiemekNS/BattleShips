import java.util.regex.*;

public class PlacingCheck {


    static int[][] placingCheck(String point, String placement, int[][] battleground, int holesAmount) {
        // Checker miejsca, jesli jest ok to zwraca true i mozna dodac statek w pozycje

        //Change the char values to specified place in the array
        int a = Character.getNumericValue(point.charAt(0)) - 10;
//        Pattern p;
//        Matcher m = p.matcher("^[A-Ja-j]([0-9]|10)$");

//        if (Regex.IsMatch(myString, @ "^[A-Ja-j]([0-9]|10)$")){
//            // ...
//        }

        //add while until user chooses right
        if (!(a >= 0 && a < 10)) {
            System.out.println("Please choose correct point.");
        }

        int b = Integer.valueOf(point.charAt(1)) - 48;

        //value to check if the space is free, so the ship can be placed
        boolean isFree = true;


        //Check if ground can be taken
        //Need to add function to leave the loop as the mistype occurs (righ5t)
        try {
            if (placement.equals("UP")) {
                for (int i = 0; i < holesAmount; i++) {
                    if (battleground[a - i][b] != 0) {
                        isFree = false;
                    }
                }
                if (isFree) {
                    for (int i = 0; i < holesAmount; i++) {
                        battleground[a - i][b] = 1;
                    }
                } else {
                    System.out.println("This point is taken, please choose different one.");
                }
            } else if (placement.equals("DOWN")) {
                for (int i = 0; i < holesAmount; i++) {
                    if (battleground[a + i][b] != 0) {
                        isFree = false;
                    }
                }
                if (isFree) {
                    for (int i = 0; i < holesAmount; i++) {
                        battleground[a + i][b] = 1;
                    }
                } else {
                    System.out.println("This point is taken, please choose different one.");
                }
            } else if (placement.equals("LEFT")) {
                for (int i = 0; i < holesAmount; i++) {
                    if (battleground[a][b - i] != 0) {
                        isFree = false;
                    }
                }
                if (isFree) {
                    for (int i = 0; i < holesAmount; i++) {
                        battleground[a][b - i] = 1;
                    }
                } else {
                    System.out.println("This point is taken, please choose different one.");
                }
            } else if (placement.equals("RIGHT")) {
                for (int i = 0; i < holesAmount; i++) {
                    if (battleground[a][b + i] != 0) {
                        isFree = false;
                    }
                }
                if (isFree) {
                    for (int i = 0; i < holesAmount; i++) {
                        battleground[a][b + i] = 1;
                    }
                } else {
                    System.out.println("This point is taken, please choose different one.");
                }
            } else {
                System.out.println("Please choose correct method.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("You gotta it wrong.");
        }

        return battleground;
    }

}