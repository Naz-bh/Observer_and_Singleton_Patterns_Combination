package ceng.anadolu.bim492;

import java.util.ArrayList;

// The Moderator is used to update all Players 

public class Moderator extends Thread implements Subject{

    private ArrayList<Player> players;

    private SingletonRandom gameData;




    public Moderator(){

        // an ArrayList to hold all players

        players = new ArrayList<Player>();

        gameData = SingletonRandom.getInstance();

    }

    public void register(Player newPlayer) {

        //a new player added to the playerList

        players.add(newPlayer);

    }

    public void unregister(Player deletePlayer) {

        // to get the index of the player to delete

        int observerIndex = players.indexOf(deletePlayer);


        System.out.println("Player" + (observerIndex+1) + " deleted");

        // to Remove player from the playerList

        players.remove(observerIndex);

    }



    public void notifyObserver() {

        // All players are notified when a random number is generated

        for(Player player : players)
        {

            player.grantAccess();

        }
    }

    //Moderator thread runs and notifies every players when random number set is updated

    public void run()
    {

        for(int i=0; i<10; i++)
        {
            if(gameData.getWinner() != -1)
                break;

            System.out.println("Moderator has generated: " + setRandom());

            notifyObserver();


            try
            {
                sleep(2000);
            } catch(InterruptedException e) {
            } catch(IllegalMonitorStateException e) { }


            try
            {
                gameData.notifyAll();
                //gameData.gameLock.notifyAll();

            } catch(IllegalMonitorStateException e) { }
        }

        if(gameData.getWinner() == -1)
            System.out.println("\nNo-one won the game!");

        System.out.println("\n SCORE TABLE \n");

        System.out.println("Player "+"  | "+"Score  |   ");



        for(Player player : players)
        {

            player.printInfo();
        }
    }





    public int setRandom() {

        int val=gameData.nextRandom(50);
        return val;

    }

    public ArrayList<Integer> getRandom() {
        return gameData.getRandom();
    }

}