package self.learning;
import java.util.Queue;

public class TaskReadingThread implements Runnable{

    
    private Queue<TaskModel> taskQueue;

    public TaskReadingThread(Queue<TaskModel> TaskQueue) {
        this.taskQueue = TaskQueue;
    }

    
    @Override
    public void run() {
        
        //reading task configurations from database
        Object readerobj = getTasks();
        int reader = 10;
        while((reader--)>0)
        {
            String location="";
            //readFile
            //Map file to Object
            TaskModel obj = createTask();
            enqueue(obj);
        }
    }


    private Object getTasks() {
        return null;
    }

    private void enqueue(TaskModel obj) {
        taskQueue.add(obj);
    }   

    public TaskModel createTask() {
        return null;
    }
    
}
