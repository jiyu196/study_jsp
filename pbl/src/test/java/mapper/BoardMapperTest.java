package mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Board;
import domain.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import util.MybatisUtil;

@Slf4j
public class BoardMapperTest {
	
	private BoardMapper boardMapper = MybatisUtil.getSqlSession().getMapper(BoardMapper.class);
	
	
	@Test
	public void addTest() {
		int result = 1 + 1;
		assertEquals(2, result);
	}
	
	@Test
	@DisplayName("단일 게시글 조회용 테스트")
	public void testSelectOne() {
		// given
		Long bno = 3L;  // 3번 게시물 글 확인하는거 3L
		
		// when
		Board board = boardMapper.selectOne(bno);
		
		// then ~ actual, expect
		assertNotNull(board);
		
		log.info("{}", board);
	}
	
	//list
	@Test
	@DisplayName("목록 조회 3페이지 10개씩 2번카테고리")
	public void testList() {
		
		Criteria cri = new Criteria(3, 10, 2);
		List<Board> list = boardMapper.list(cri);
		list.forEach(b -> log.info("{}", b.getTitle()));
	}
	
	@Test
	@DisplayName("목록 조회 검색어 테스트")
	public void testList2() {
		
		Criteria cri = new Criteria(1, 10, 2, "TI", "오늘");  //1페이지 10개, 2번 카테고리
		// 오늘이라는 키워드를 1페이지에 10개씩 카테고리에 보이게 하겠다
		log.info(Arrays.toString(cri.getTypes()));
		List<Board> list = boardMapper.list(cri);
//		list.forEach(b -> log.info("{}", b.getTitle()));
	}
	
	@Test
	@DisplayName("글 수정 테스트")
	public void testUpdate() {
		Long bno = 3L;
		Board board =  boardMapper.selectOne(bno);
		board.setTitle("제목만 수정하기");
		
		boardMapper.update(board);
	}
}
