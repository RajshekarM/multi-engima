package self.learning.workerthreads;

public class WorkerThread2 implements Runnable  {

    int num;
    public WorkerThread2(int n)
    {
    this.num = n ;
    }
    public void Printnum()
    {
        
        for(int i=1;i<=num;i++)
        {
        
            System.out.println("Thread 2"  +": " +  i);
        }
    }
    
    @Override
    public void run() {
      
        Printnum();    
    }
    
}
