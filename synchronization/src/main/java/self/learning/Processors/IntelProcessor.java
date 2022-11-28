package self.learning.Processors;

import java.util.LinkedList;
import java.util.Queue;

import self.learning.Task;
import self.learning.Interfaces.Processor;

public class IntelProcessor implements Processor {

    Queue<Task> tasksQueue;

    public IntelProcessor()
    {
        tasksQueue = new LinkedList<Task>();

    }
    
    @Override
    public void run() {
    
        tasksQueue.forEach(task-> process(task));
       
    }

   

    @Override
    public void process(Task task) {
        
        System.out.println("Intel Processor running....");
        
    }



    @Override
    public void setTask(Task task) {
       this.tasksQueue.add (task);   
    }


    @Override
    public Task getTask() {
        // TODO Auto-generated method stub
        return tasksQueue.peek();
    }
    
}
