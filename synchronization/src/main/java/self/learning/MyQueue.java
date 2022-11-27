package self.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class MyQueue {
    
    private static final Object Lock = new Object();
    Queue<Integer> myQueue;
    int MAX_SIZE;
    int MIN_SIZE;

    public MyQueue(int min, int max)
    {
        this.MAX_SIZE = max;
        this.MIN_SIZE = min;
        myQueue = new LinkedList<>();
    }

    public void addQueue(int data)
    {
        synchronized(Lock)
        {
            while(true)
            {
                if(myQueue.size()==MAX_SIZE)
                    try {
                        System.out.println("Capacity full : waiting for you to read");
                        Lock.wait();
                    }
                     catch (InterruptedException e){  e.printStackTrace();}
                else 
                {
                    System.out.println("I am writing data to Queue:");
                    Lock.notify();
                    myQueue.add(data);
                }
             }
        }
       
    }

    public void DeQueue(int data)
    { 
        synchronized(Lock)
        {
            while(true)
            {
                if(myQueue.size()==MIN_SIZE)
                    try {
                        System.out.println("Capacity Nill : waiting for you to write");
                        Lock.wait();
                    }
                     catch (InterruptedException e){  e.printStackTrace();}
                else 
                {
                    System.out.println("I am reading data from Queue:");
                    Lock.notify();
                    myQueue.add(data);
                }
             }
        }
    }


}
