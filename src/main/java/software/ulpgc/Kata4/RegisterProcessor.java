package software.ulpgc.Kata4;

import java.util.List;
import java.util.Map;

public interface RegisterProcessor {
    Map<String, Integer> process(List<Register> registers);
}
