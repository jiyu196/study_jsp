package domain.dto;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PageDto {
	private Criteria cri;
	private long total;
	
	private int start;
	private int end;
	
	private boolean left;
	private boolean right;
	
	private boolean doubleLeft;
	private boolean doubleRight;
	
	private int realEnd;
	
	public PageDto(Criteria cri, long total) {
		this.cri = cri;
		this.total = total;
		// total = 123   -총 게시글 갯수
		// page = 1
		// amount = 10
		
		// start = 1
		// end = 10
		
		// 만약 page = 12 면 start = 11, end = 13  --> 이렇게되면  realEnd = 12 
		
		/* 119 12   119+ 9 =128 /10 = 12 +1
		 * 120 12 120 + 9 = 129/ 10 = 12
		 * 121 12
		 * 122 13
		 *	
		*/
		
		// end값으로 계산. end에서 start를 유도. 제일 중요한건 페이지번호. 
		// cri에 들어있고, get으로 호출해야함
		// 그걸가지고 end값 유도
		
		// 일의자리에서 올림연산 => end
		// 십의자리에서 올림연산?
		end = (cri.getPage() + 9) / 10 * 10; 
		//(1+9)/10 -> 나머지는 1 -> 1 * 10 => 10   / 
		//cir이 11이되었을 때 (11 + 9)/10 -> 나머지는 2 -> 2 * 10 => 20
		start = end - 9;
		
		// 123
		// 20  --> 7페이지가 있어야함 132/20 -6 123+19
		realEnd = (int)((total  + cri.getAmount() - 1) / cri.getAmount()); 
		//amount 랑 total 나머지연산
		//9가 나온 이유는 amount값을 기반으로해서 1을 뺸거니까
		
		if(end > realEnd) {
			end = realEnd;   // 만약 
		}
		
		
		left = start > 1; // start가 1인지 여부를 따지는
		right = end < realEnd; 
		
		doubleLeft = cri.getPage() > 1;
		doubleRight = cri.getPage() < realEnd;
	}
	
	
}

