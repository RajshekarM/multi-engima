package self.learning;

import self.learning.processors.Processor;

public class TaskModel implements Runnable{
    
    int scheduledTime;
    //i will decide the processor on run time.
    String processor_name;
    Processor processor;
    public void process() {
    }

    @Override
    public void run() {
        Process();
    }

    private void Process() {

    }

    public void SymbolLookup() {
    }

    


}
