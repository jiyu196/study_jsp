package mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Board;
import domain.Reply;
import domain.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import util.MybatisUtil;

@Slf4j
public class ReplyMapperTest {
	
    private ReplyMapper replyMapper = MybatisUtil.getSqlSession().getMapper(ReplyMapper.class);


    @Test
    @DisplayName("단일 조회")
    public void testSelectOne() {
        Long rno = 7L;

        Reply reply = replyMapper.selectOne(rno);

        log.info("{}", reply);
    }


    @Test
    @DisplayName("댓글 목록 조회")
    public void testList() {
        List<Reply> list = replyMapper.list(4L, 35L);
        list.forEach(b->log.info(b.getContent()));

    }
    
    @Test
    @DisplayName("댓글 목록 조회")
    public void testListRnoNull() {
    	List<Reply> list = replyMapper.list(4L, null);
    	list.forEach(b->log.info(b.getContent()));
    	
    }
//
    @Test
    @DisplayName("댓글 추가 테스트")
    public void testInsert() {
        Reply reply = Reply.builder().content("매퍼 테스트").id("sae").bno(3L).build();
        replyMapper.insert(reply);
    }

    @Test
    @DisplayName("댓글수정 테스트")
    public void testUpdate() {

        Long rno = 5L;
        Reply reply = replyMapper.selectOne(rno);
        reply.setContent("수정하기");
        replyMapper.update(reply);
    }

    @Test
    @DisplayName("댓글삭제 테스트")
    public void testdelete() {

        Long rno = 4L;
        replyMapper.delete(rno);


    }

	
	

	
	
}


