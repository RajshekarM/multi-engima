package self.learning;

import java.util.LinkedList;
import java.util.Queue;
public class MyQueue {
    
    private static final Object Lock = new Object();
    Queue<Integer> NEW_STATE;
    Queue<Integer> READY_STATE;
    Queue<Integer> RUN_STATE;
    Queue<Integer> WAIT_STATE;
    Queue<Integer> SUSPENDED_STATE;
    

    int MAX_SIZE;
    int MIN_SIZE;

    public MyQueue(int min, int max)
    {
        this.MAX_SIZE = max;
        this.MIN_SIZE = min;
        NEW_STATE = new LinkedList<>();
        READY_STATE = new LinkedList<>();
    }

    // New State: add to Memory
    public void addQueue(int data) throws InterruptedException
    {
        synchronized(Lock)
        { 
        System.out.println(Thread.currentThread().getName()+":Acquired Lock");
           while(true)
            { 
              if(NEW_STATE.size()>=MAX_SIZE)
              {
                System.out.println(Thread.currentThread().getName() + "Queue Size is full");
                
                System.out.println(Thread.currentThread().getName() + ":Notify to awaken other threads");
                 System.out.println(Thread.currentThread().getName() + "Going to waiting state untill someone awakens");
                 Lock.wait(5000); 
              }
              else
              {
                NEW_STATE.add(data);
                Lock.notify();
              }
             
            }
             
          
        }
       
    }


    //Ready State: put into cache 
    public void DeQueue() throws InterruptedException
    { 
        synchronized(Lock)
        {          
            System.out.println(Thread.currentThread().getName()+":Acquired Lock");

            while(true)
            {
                if(NEW_STATE.size()==MIN_SIZE)
                {
                    System.out.println(Thread.currentThread().getName() + "Queue Size is zero");
                    
                    System.out.println(Thread.currentThread().getName() + ":Notify to awaken other threads");
  
                    System.out.println(Thread.currentThread().getName() + "Going to waiting state untill someone awakens");
                    Lock.wait(5000);
                }
                else
                {
                    System.out.println("Removing Data from the Queue"+  NEW_STATE.remove());
                    READY_STATE.add(NEW_STATE.remove());
                    Lock.notify();
                }

            }
         
            
     
        }
    }


}
