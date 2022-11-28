package self.learning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTasks implements Runnable{

    ReentrantLockMemory memory;
    public AddTasks(ReentrantLockMemory Memory)
    {
        memory = Memory;
    }
    @Override
    public void run() {
        
        try {
            memory.addTasks();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void readFromDatabase() throws SQLException
    {
        Connection con = DriverManager.getConnection(null, null, null);
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(null);

        while(result.next())
        {
            
        }
    }


}
