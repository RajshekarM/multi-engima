package self.learning.processors;

import self.learning.TaskModel;

public class AMDProcessor implements Processor{

    TaskModel task;
    @Override
    public void run() {
        Process();
    }

    @Override
    public void Process() {
           SymbolLookup();  
           task.SymbolLookup();   

           CalculatePosition();
    }

    private void CalculatePosition() {
    }

    private void SymbolLookup() {
    }
    
}
