package self.learning.Processors;

import java.util.LinkedList;
import java.util.Queue;

import self.learning.Task;
import self.learning.Interfaces.Processor;

public class MacProcessor implements Processor {

    Queue<Task> tasksQueue;

    public MacProcessor()
    {
        tasksQueue = new LinkedList<Task>();
    }
    
    @Override
    public void run() {
    
        tasksQueue.forEach(task-> process(task));
       
    }

   

    @Override
    public void process(Task task) {
        
        System.out.println("Mac Processor running...");
        
    }



    @Override
    public void setTask(Task task) {
       this.tasksQueue.add (task);   
    }

    @Override
    public Task getTask() {
        return tasksQueue.peek();
    }



    
    
}
