package human.class1.ajax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    List<String> getProductCodes(); 
}