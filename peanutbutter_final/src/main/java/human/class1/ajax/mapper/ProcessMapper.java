package human.class1.ajax.mapper;

import human.class1.ajax.dto.Process;
import human.class1.ajax.dto.Process2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcessMapper {

    void saveProcess(Process process);

    void saveProcess2(Process2 process2);

    Process getProcessByCode(String processCode);

    void deleteProcess(String processCode);

    void deleteProcess2(String processCode);
}
