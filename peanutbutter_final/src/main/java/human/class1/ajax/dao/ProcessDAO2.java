package human.class1.ajax.dao;

import human.class1.ajax.dto.Process2;
import human.class1.ajax.dto.Process3;

import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface ProcessDAO2 {

    void deleteProcess(String processCode) throws SQLException; // 기존 코드

    void updateProcess(human.class1.ajax.dto.Process process) throws SQLException; // Process2 업데이트 메서드 추가

    void saveProcess(Process3 process3) throws SQLException; // 기존 코드


}
