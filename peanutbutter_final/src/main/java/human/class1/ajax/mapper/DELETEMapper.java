package human.class1.ajax.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DELETEMapper {
    void deleteProcess(String processCode); 
}
