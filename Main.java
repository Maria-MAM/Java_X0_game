import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] input;
        Game game = Game.getInstance();
        game.populareTabel();
        char simbol = ' ';
        char currentPlayer = 'x';
        System.out.println("\nBegin playing with 0!");
        while(true) {
            try{
                game.afisareTabel();
                System.out.print("\nType your choice in the format 'line column X/0' , EXIT or NEW: ");
                line = scanner.nextLine();
                input = line.split("\\s+");
                switch(input[0].toLowerCase()) {
                    case "new":
                        game.populareTabel();
                        break;
                    case "exit": 
                        System.exit(0);
                        break;
                    default:
                        currentPlayer = game.changePlayer();
                        int orizontal = Integer.parseInt(input[0]);
                        int vertical = Integer.parseInt(input[1]);
                        if (Character.toLowerCase(input[2].charAt(0)) == Character.toLowerCase(currentPlayer)) {
                            if (game.tabel[orizontal][vertical] == '-') {
                                game.tabel[orizontal][vertical] = currentPlayer;
                            } else {
                                System.out.println("Not allowed! Choose a free spot! :) ");
                                game.changePlayer();
                            }
                        } else {
                            System.out.println("Choose for  " + currentPlayer + " now!");
                            System.out.println("\n" + currentPlayer + "'s turn now!");
                            game.changePlayer();
                        }
                        game.verifCastig();
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e ) {
                System.out.println("\nSomething was wrong! Please stick to the rules and try again!");
            }
        }

    }  
}