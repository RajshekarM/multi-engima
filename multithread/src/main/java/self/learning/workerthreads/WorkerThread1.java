package self.learning.workerthreads;

public class WorkerThread1 implements Runnable  {

    int num;
    public WorkerThread1(int n)
    {
    this.num = n ;
    }
    public void Printnum()
    {
        
        for(int i=1;i<=num;i++)
        {
           
            System.out.println("Thread 1" +": " +  i);
        }
    }
    
    @Override
    public void run() {
      
        Printnum();    
    }
    
}
