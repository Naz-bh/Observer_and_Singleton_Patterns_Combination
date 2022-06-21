package ceng.anadolu.bim492;

import java.util.Random;
import java.util.ArrayList;

public class SingletonRandom{

    private volatile static SingletonRandom singleInstance = null;

    private ArrayList<Integer> randomNumbers;

    private int winner;

    private Random generator;

    //public Object gameLock=new Object(); we can use lock object as well for synchronizing

    private SingletonRandom()
    {

        randomNumbers = new ArrayList<Integer>();
        winner = -1;
        generator = new Random();

    }

    public static SingletonRandom getInstance()
    {
        if(singleInstance == null)
        {
            synchronized (SingletonRandom.class)
            {
                if(singleInstance == null) {
                    singleInstance = new SingletonRandom();
                }
            }
        }

        return singleInstance;
    }



    public int nextRandom(int temp) {

        int val=generator.nextInt(temp);
        randomNumbers.add(val);
        return val; }

    public ArrayList<Integer> getRandom()
    {
        return randomNumbers;
    }



    public int getWinner() {

        return winner;
    }

    public void setWinner(int player) {
        winner = player;
    }








}