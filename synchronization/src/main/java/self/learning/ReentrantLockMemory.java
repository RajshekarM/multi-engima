package self.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMemory {
  
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    Queue<Integer> NEW_TASK_QUEUE;
    Queue<Integer> READY_TASK_QUEUE;
    Queue<Integer> RUN_STATE;
    Queue<Integer> WAIT_STATE;
    Queue<Integer> SUSPENDED_STATE;
    List<Integer> reader;

  

    public ReentrantLockMemory()
    {
        NEW_TASK_QUEUE = new LinkedList<Integer>();
        READY_TASK_QUEUE = new LinkedList<Integer>();
        reader = new ArrayList<Integer>();
        reader.add(0);
        for(int i=1;i<=1000;i++)
            reader.add(i);
    }

    // New State: add to Memory
    public void addTasks() throws InterruptedException
    {
       
       
        lock.lock();
        System.out.println(Thread.currentThread().getName()+":Acquired Lock");
        while(reader.size()>0)
        {
            NEW_TASK_QUEUE.add(reader.get(0));
            reader.remove(0);

            if(NEW_TASK_QUEUE.size()==10)
            {
                System.out.println("Queue full Going to wait condition");
                condition.await();
            }
           
        }
        lock.unlock();            
    }


    //Ready State: put into cache 
    public void ReadyTasks()
    { 
       
        lock.lock();
        System.out.println(Thread.currentThread().getName()+":Acquired Lock");
        while(true)
        {
           
           if(NEW_TASK_QUEUE.size()==0)
            {
                System.out.println("Queue empty Calling Producer");
                condition.signal();
            }
            READY_TASK_QUEUE.add( NEW_TASK_QUEUE.remove());
           // NEW_TASK_QUEUE.remove();
        }
        
        
    }
    

}
