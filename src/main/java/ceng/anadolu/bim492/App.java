package ceng.anadolu.bim492;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {

    public static void main(String[] args) throws NumberFormatException, IOException {


        int playerCount = 5;

        //If you want to let the user decide on player count, use the below command lines
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         Reading player count using readLine
//        System.out.println("Enter player Count:\n");
//        playerCount=Integer.parseInt(reader.readLine());


        Moderator game = new Moderator();

        ArrayList<Player> playerList = new ArrayList<Player>(playerCount);

        System.out.println("Player List\n");

        for(int i=0; i<playerCount; i++)
        {
            playerList.add(new Player(game));
        }


        for(Player player : playerList) player.start();

        System.out.println("\n....Game starts...\n");

        game.start();

    }

}

