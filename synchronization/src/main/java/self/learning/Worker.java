package self.learning;

public class Worker implements Runnable{

   
int  counter = 0;
   int num ;

   public void setWorker(int num)
   {
    this.num = num;
   }
    @Override
    public void run() {
      
        for(int i=1;i<num;i++)
        counter = counter + i;

            System.out.println(Thread.currentThread().getName()+"::Sum of first- " + num+ ":Done and sum is-"  +counter);
        }

       
        
    }

    
