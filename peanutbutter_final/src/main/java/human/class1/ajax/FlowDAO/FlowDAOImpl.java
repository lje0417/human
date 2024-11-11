package human.class1.ajax.FlowDAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


@Repository
public class FlowDAOImpl implements FlowDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectflPage(int start, int end, String process_code) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("process_code", process_code);
		List list = sqlSession.selectList("mapper.pl_sp.selectflPage",searchMap);
		System.out.println("list :"+ list);
		return list;
	}
	
	@Override
	public int totalflPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.pl_sp.totalflPage");
		return result;
	}
}
