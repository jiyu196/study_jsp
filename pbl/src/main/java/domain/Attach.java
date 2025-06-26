package domain;


import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Alias("attach")
public class Attach {
	
	private String uuid; //파일명
	private String path; //날짜에 대한 경로
	private boolean image; //파일 존재 여부
	private String origin; //파일 원본
	private Long bno;
	private Long rno;
	private int odr;  //integer 은 기본값이 0
	
	@Setter
	private String info;  // 값이 null인애들은 안가져옴
	
	public String getInfo() {
		String[] strs = {"uuid=" + uuid, "path=" + path, "origin=" + origin};
		return String.join("&", strs); // 다운로드, 이미지 보여지기
	}
}
