package mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Board;
import domain.Category;
import domain.Reply;
import domain.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import util.MybatisUtil;

@Slf4j
public class CategoryMapperTest {
	
    private CategoryMapper categoryMapper = MybatisUtil.getSqlSession().getMapper(CategoryMapper.class);



    @Test
    @DisplayName("목록 조회")
    public void testList() {
        List<Category> list = categoryMapper.list();
        list.forEach(b -> log.info("{}", b));
 
    }
    
  
	
}


