package software.ulpgc.Kata4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseRegisterProcessor implements RegisterProcessor{

    @Override
    public Map<String, Integer> process(List<Register> registers) {
        Map<String, Integer> res = new HashMap<>();
        for (Register reg: registers){
            String country = reg.Country();
            int medals = reg.Medals();
            res.put(country, medals);
        }
        return  res;
    }
}
