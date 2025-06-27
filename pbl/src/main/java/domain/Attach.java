package domain;


import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("attach")
public class Attach {
	
	private String uuid; //파일명
	private String path; //날짜에 대한 경로
	private boolean image; //파일 존재 여부
	private String origin; //파일 원본
	private Long bno;
	private Long rno;
	private int odr;  //integer 은 기본값이 0
	private long size;  //null이 올 필요가 없는 애들
	
	public Attach(String uuid, String path, boolean image, String origin, Long bno, int odr, long size) {
		super();
		this.uuid = uuid;
		this.path = path;
		this.image = image;
		this.origin = origin;
		this.bno = bno;
		this.odr = odr;
		this.size = size;
	}

	
	
//	@Setter
//	private String info;  // 값이 null인애들은 안가져옴
//	
//	public String getInfo() {
//		String[] strs = {"uuid=" + uuid, "path=" + path, "origin=" + origin};
//		return String.join("&", strs); // 다운로드, 이미지 보여지기
//	}
}
