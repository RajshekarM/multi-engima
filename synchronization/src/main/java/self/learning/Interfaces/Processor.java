package self.learning.Interfaces;

import self.learning.Task;

public interface Processor extends Runnable{
    

    public void process(Task task);

    public void setTask(Task task);

    public  Task getTask();

}
