package self.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class AddTaskQueue implements Runnable{

    private BlockingQueue<Task> queue;
    public AddTaskQueue(BlockingQueue<Task> Queue)
    {
        queue = Queue;
    }

    @Override
    public void run() {
        
        addToQueue();
        
    }

    private void addToQueue() {
        
        List<Task> TaskList = new ArrayList<>();
        
        Task t1 = new Task("first"); t1.Processor_name = "AMD";
        Task t2 = new Task("second"); t2.Processor_name = "Intel";
        Task t3 = new Task("third"); t3.Processor_name ="Mac";
        Task t4 = new Task("fourth"); t4.Processor_name ="Mac";
        Task t5 = new Task("fifth"); t5.Processor_name = "Intel";
        Task t6 = new Task("sixth"); t6.Processor_name = "AMD";
        
        
        TaskList.add(t1);  TaskList.add(t2);  TaskList.add(t3); TaskList.add(t4); TaskList.add(t5);  TaskList.add(t6);

        for (Task task : TaskList) {  
            try 
            {
                
                System.out.println(Thread.currentThread().getName() +  " is Adding Task to Queue");
                queue.put(task);
            } 
            catch (InterruptedException e) {           
                e.printStackTrace();
            }        
        }


    }
    
}
