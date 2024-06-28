package software.ulpgc.Kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseRegisterLoader implements RegisterLoader{

    private final Connection connection;

    private final String query = "SELECT * FROM SummerOlympics_medals WHERE Year == 2008";

    public DataBaseRegisterLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Register> loadAll() {
        try {
            return load(resultSetOf(query));
        } catch (SQLException e){
            System.out.println(e);
            return Collections.emptyList();
        }
    }

    private List<Register> load(ResultSet resultSet) throws SQLException{
        List<Register> result = new ArrayList<>();
        while (resultSet.next()){
            Register reg = RegisterFrom(resultSet);
            result.add(reg);
        }
        return  result;
    }

    private Register RegisterFrom(ResultSet resultSet) throws SQLException{
        return new Register(
                resultSet.getInt("Rank"),
                resultSet.getString("Country"),
                resultSet.getInt("Golds"),
                resultSet.getInt("Silvers"),
                resultSet.getInt("Bronzes"),
                resultSet.getInt("Medals"));

    }

    private ResultSet resultSetOf(String query) throws SQLException{
        return connection.createStatement().executeQuery(query);
    }
}
