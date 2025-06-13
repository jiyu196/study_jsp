package domain;


import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Alias("board")
public class Board {

	private Long bno;
	private String title;
	private String content;
	private String id;
	private String regdate;
	private String moddate;
	private Integer cnt;
	private Integer cno;
	
}
