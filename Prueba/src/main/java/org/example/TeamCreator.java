package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TeamCreator {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> players = new ArrayList<String>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            players.add(data);
//            System.out.println(data);
        }

//        String[] teams = players.toArray(new String[players.size()]);
        Collections.shuffle(players);
        int half = players.size()/2 + new Random().nextInt(2);
        List<String> team1 = players.subList(0, half);
        List<String> team2 = players.subList(half, players.size());
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);
//        System.out.println(Arrays.toString(teams));
//        System.out.println(new Random().nextInt(arrLength));
    }

}
