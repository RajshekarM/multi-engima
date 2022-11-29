package self.learning;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import self.learning.Interfaces.Processor;

public class Cache {
 
    List<String> ProcessorList;
    HashMap<String, Processor> processorCache;


    public Cache()
    {
       //establish connection.
       ProcessorList = new ArrayList<>();
       processorCache = new HashMap<>();
    }

    public void  BuildProcessorCache ()
    {    
        ProcessorList = getProcessor();
        
        ProcessorList.forEach((Processor)->{
            try {
                processorCache.put(Processor, BuildProcessors(Processor)); }
            catch (NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
               System.out.println("Cannot instantiate Processor for : " +Processor);
            }
        });   
        
        System.out.println("Number of Processors created : "+ processorCache.size());
    }

    private List<String> getProcessor() 
    {
        List<String> res=new ArrayList<>();
        res.add("AMD");
        res.add("Intel");
        res.add("Mac");
        return res;
    }

    public Processor BuildProcessors(String Processor) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
       
        Class<?> claszz = Class.forName("self.learning.Processors."+Processor+"Processor");
        Processor p;
        p = (self.learning.Interfaces.Processor) claszz.getDeclaredConstructor().newInstance();
        return p;
        
    }


}
