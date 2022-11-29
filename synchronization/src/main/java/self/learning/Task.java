package self.learning;

public class Task implements Comparable<Task>{
    
   
   String taskName;
   String Processor_name;

  public Task(String TaskName)
   {
    this.taskName = TaskName;
   }



private String getName() {
   return this.taskName;
}

@Override
public int compareTo(Task task) {
 
   return taskName.compareTo(task.getName());
}
  
}
