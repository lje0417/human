package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardPageDAO;


public class BoardPageService {

	public Map getBoardPage(String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo - 1) * count) + 1;
		int end = pageNo * count;
		
		BoardPageDAO bpd = new BoardPageDAO();
		List list = bpd.selectBoardPage(start, end);
		
		int totalCount = bpd.totalBoardPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
