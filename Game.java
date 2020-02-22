import java.util.*;

public class Game {
    private static Game SINGLETON;

    private Game() {
    }

    public static Game getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new Game();
        }
        return SINGLETON;
    }

    char[][] tabel = new char [3][3];
    char currentPlayer = 'x';
    
    public void populareTabel(){
        for (char[] a: tabel) {
            Arrays.fill(a, '-');
        }
    }

    public void afisareTabel() {
        for (int i = 0; i<tabel.length; i++) {
            System.out.println("");
            if (i==0) {
                System.out.println("  0 1 2");
            }
            System.out.print(i);
            for (int j = 0; j<tabel[i].length; j++) {
                System.out.print(" " + tabel[i][j]);
            }
        }
        System.out.println("");
    }

    public void afisareCastigator(Set set) {
        if (set.size() == 1 && set.toString().charAt(1) != '-') {
            char winner = set.toString().charAt(1);
            // afisareTabel();
            System.out.println("\nThe winner is: " + winner);
        }
    }

    public void verifCastig() {
        Set resultSet4 = new HashSet();
        for (int i=0; i< tabel.length;i++) {
            Set resultSet1 = new HashSet();
            Set resultSet2 = new HashSet();
            Set resultSet3 = new HashSet();
            for (int j=0; j< tabel[i].length;j++) {
                resultSet1.add(tabel[i][j]);
                resultSet2.add(tabel[j][i]);
                resultSet3.add(tabel[j][j]);
                if( i+j == 2) {
                    resultSet4.add(tabel[i][j]);
                }
            }
            afisareCastigator(resultSet1);
            afisareCastigator(resultSet2);
            
            if (i==2) {
                afisareCastigator(resultSet3);
                afisareCastigator(resultSet4);
            }
        }
    }
    
    public char changePlayer() {
        if (currentPlayer == 'x' || currentPlayer == 'X') {
            currentPlayer = '0';
        } else currentPlayer = 'x';
        return currentPlayer;
    }
}