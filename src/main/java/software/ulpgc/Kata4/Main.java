package software.ulpgc.Kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kata4.db")){
            DataBaseRegisterLoader loader = new DataBaseRegisterLoader(connection);
            List<Register> registers = loader.loadAll();
            DataBaseRegisterProcessor processor = new DataBaseRegisterProcessor();
            Map<String, Integer> medalsByCountryIn2008 = processor.process(registers);
            System.out.println(medalsByCountryIn2008);
        }
    }
}
