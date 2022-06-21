package ceng.anadolu.bim492;

import java.util.ArrayList;

import java.util.Random;

public class Player extends Thread implements Observer{



    private static int playerIDTracker = 0;

    private Boolean access=false;


    private int playerID;

    private int score;

    // Will hold reference to the gameData object

    SingletonRandom gameData;

    //reference to moderator instance

    Moderator game;

    Random rand = new Random();

    ArrayList<Integer> val = new ArrayList<Integer>(10);

    public Player(Moderator game){

        this.game = game;

        // player ID assigned and increment the player counter

        this.playerID = ++playerIDTracker;


        System.out.println("Player " + this.playerID +" entered :");

        // Add the player to the player ArrayList

        game.register(this);

        gameData=SingletonRandom.getInstance();

        for(int i=0;i<10;i++)
        {
            val.add(rand.nextInt(50));
        }
        System.out.println("- "+val.toString());


    }

    public void grantAccess()
    {
        access=true;
    }

    public Boolean isaccess()
    {
        return access;
    }

    public ArrayList<Integer> getList()
    {
        return val;
    }

    public void printInfo()
    {
        System.out.println("Player " + this.playerID + " |  " + this.score+ "     | ");
    }


    @Override
    synchronized public void check()
    {

        access=true;

        ArrayList<Integer> temp = new ArrayList<Integer>(val);

        temp.retainAll(game.getRandom());

        score=temp.size();

        //condition for winning

        if((score>=3) && gameData.getWinner()==-1)
        {
            System.out.println("\nPlayer" + playerID + " has won!");

            gameData.setWinner(playerID);


        }

    }


    public void run() {

        while(gameData.getWinner() == -1)
        {
            while(access == false)
            {
                try
                {
                    gameData.wait();
                    //gameData.gameLock.wait();
                } catch (InterruptedException e) { }
                catch (IllegalMonitorStateException e) { }
            }
            check();
            access = false;
        }
    }



}






