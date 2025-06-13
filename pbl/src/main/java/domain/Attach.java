package domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attach {
	
	private String uuid; //파일명
	private String path; //날짜에 대한 경로
	private boolean image; //파일 존재 여부
	private String origin; //파일 원본
	private Long bno;
	private Long rno;
}
