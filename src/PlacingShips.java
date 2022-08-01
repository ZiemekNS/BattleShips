import java.util.Scanner;

public class PlacingShips {

    private int[][] battleground = new int[10][10];

    public void ask(String boatType, int boatSize) {

        String point;
        String placement;

        PlacingCheck placingCheck = new PlacingCheck();


        Scanner scanner = new Scanner(System.in);
        // if placing check == true then: zrobić drugą metodę która checkuje, a pierwsza, która jeśli true to zmieniaj?
        //        PlacingCheck(place);
        //        if placing check == true then:
        //carrierSize nie powinno byc wszedzie
        System.out.println(boatType + " is a ship that takes space of " + boatSize + " holes");
        System.out.println("Where do You want to place first point of a " + boatType + "? (Write, eg. A1, B7, D9, J10)");
        point = scanner.next();
        System.out.println("Do You want to place it to the UP, RIGHT, DOWN or LEFT?");
        placement = scanner.next();
        while (!(placement.equalsIgnoreCase("up") || placement.equalsIgnoreCase("down") ||
                placement.equalsIgnoreCase("right") || placement.equalsIgnoreCase("left"))) {
            System.out.println("Please choose correct direction. Do You want to place it to the UP, RIGHT, DOWN or LEFT?");
            placement = scanner.next();
        }
        battleground = PlacingCheck.placingCheck(point, placement, battleground, boatSize);

    }

    public void askWhatships() {

        ask("Carrier", 5);
        ask("Battleship", 4);
        ask("Cruiser", 3);
        ask("Submarine", 3);
        ask("Destroyer", 2);

        for (int i = 0; i < battleground.length; i++) {
            for (int j = 0; j < battleground.length; j++) {
                System.out.println(battleground[i][j]);
            }
        }


    }


}
