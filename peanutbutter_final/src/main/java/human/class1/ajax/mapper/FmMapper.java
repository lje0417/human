package human.class1.ajax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import human.class1.ajax.dto.FmDTO;

@Mapper
public interface FmMapper {
    List<FmDTO> getProcesses();
}