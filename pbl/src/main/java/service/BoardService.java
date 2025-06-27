package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.Board;
import domain.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import mapper.AttachMapper;
import mapper.BoardMapper;
import mapper.ReplyMapper;
import util.MybatisUtil;

@Slf4j
public class BoardService {

	public List<Board> list(Criteria cri) { 
		try(SqlSession session = MybatisUtil.getSqlSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			List<Board> list = mapper.list(cri);
			long cnt =  mapper.getCount(cri);
			return list; //1page 10개씩
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Board findBy(Long bno) { 
		try(SqlSession session = MybatisUtil.getSqlSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
//			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			mapper.increseCnt(bno);  // boardMapper.xml에서 update로 추가하고 이곳에서 추가.
			Board board = mapper.selectOne(bno);
//			board.setAttachs(attachMapper.list(bno));  
// --> 보드매퍼,xml에서 단일조회 했으니까 이 부분은 이제 필요 없음/  저 위에 두개 다
			return board;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void write(Board board) {
		SqlSession session = MybatisUtil.getSqlSession(false);
		try {	
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			mapper.insert(board);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			board.getAttachs().forEach(a -> {
				a.setBno(board.getBno());
				attachMapper.insert(a);
			});
			session.commit();  //session에 수동커밋을 한다. 하나가 실패하면 다 실패함. 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();  // 아까 데이터가 나타나지 않아서 선생님이 적어주심
		} finally {
			session.close();
		}  //try catch -> 롤백해라
	}
	
	public long getCount(Criteria cri) { 
		try(SqlSession session = MybatisUtil.getSqlSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			return mapper.getCount(cri); //1page 10개씩
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	

	public void modify(Board board) {
		SqlSession session = MybatisUtil.getSqlSession(false);
		try {	
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			mapper.update(board);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			board.getAttachs().forEach(a -> {
				a.setBno(board.getBno());
				attachMapper.insert(a);
			});
			session.commit();  //session에 수동커밋을 한다. 하나가 실패하면 다 실패함. 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();  // 아까 데이터가 나타나지 않아서 선생님이 적어주심
		} finally {
			session.close();
		}
			
	}
	
	public void remove(Long bno) { 
		SqlSession session = MybatisUtil.getSqlSession(false);
		try {	
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
					
			replyMapper.deleteByBno(bno);
			attachMapper.deleteByBno(bno);
			mapper.delete(bno);
			
			session.commit();  //session에 수동커밋을 한다. 하나가 실패하면 다 실패함. 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();  // 아까 데이터가 나타나지 않아서 선생님이 적어주심
		} finally {
			session.close();
		}
			
	
	}
	
//	public static void main(String[] args) {
//		new BoardService().list(new Criteria()).forEach(b -> log.info("{}", b.getTitle()));
//	}
//	
}

