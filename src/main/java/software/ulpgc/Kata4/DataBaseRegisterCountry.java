package software.ulpgc.Kata4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseRegisterCountry implements RegisterCountry{

    @Override
    public Map<String, Integer> country(List<Register> registers) {
        Map<String, Integer> res = new HashMap<>();
        for (Register reg: registers){
            String country = reg.Country();
            res.put(country, res.getOrDefault(country, 0));
        }
        return  res;
    }
}
