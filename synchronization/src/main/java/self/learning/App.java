package self.learning;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    
      int no = Runtime.getRuntime().availableProcessors();
      System.out.println("Cores avaliable:" + no);

      Executors ex = new Executors();
      ex.Start();

        
    }
}
