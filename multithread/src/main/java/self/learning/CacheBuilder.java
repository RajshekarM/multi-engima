package self.learning;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import self.learning.processors.Processor;

public class CacheBuilder {
    
    HashMap<String, Processor> ProcessorCache = new HashMap<>();

        public void buildProcessors()
        {
            getProcessors().forEach(processorName->{
                String p = processorName;
                processorName = "self.learning.processors." + processorName;
                
                Class<?> clazz;
                try {
                    clazz = Class.forName(processorName);
                    Processor processor;
                    processor = (Processor)clazz.getDeclaredConstructor().newInstance();
                    ProcessorCache.put(p,processor);
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException| InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }      
            });
        } 
    

    private List<String> getProcessors() {

        List<String> processors = new ArrayList<>();
        processors.add("AMDProcessor");
        //query to Database to get Processor.
        return processors;
    }

}