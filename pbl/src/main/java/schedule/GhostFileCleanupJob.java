package schedule;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import controller.attach.UploadFile;
import domain.Attach;
import lombok.extern.slf4j.Slf4j;
import mapper.AttachMapper;
import util.MybatisUtil;

@Slf4j
public class GhostFileCleanupJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		// File 인스턴스 생성 > 어제 날짜의 업로드 폴더
//		String path = "D:\\upload\files\2025\06";  //o6/30 으로 적으면  -1을 해줘야하는것?
////		String realPath = UPLOAD_PATH
//		if(file.exists()) {  // 만약 파일이 존재한다면
////			log.info("{}" ,file.getAbsolutePath());
//		}
		
//		final String UPLOAD_PATH = "d:/upload/files";
		File file = new File(UploadFile.UPLOAD_PATH, genYesterdayPath());
		log.info("{},{}", file, file.exists());
			
		if(!file.exists() && !file.isDirectory()) {
			return;   // 파일이 존재하지 않으면, 디렉토리가 존재하지 않아도 끝
		}
//		String[] strings = file.list();  //파일리스트에서 파일리스트를 뺄 수 있는가?
//		File[] files= file.listFiles();  
//		log.info("{}", Arrays.toString(files));  // 배열로 나오게하는 
//		
//		List<String> fsList = new ArrayList<String>(List.of("a.txt","b.txt","c.txt"));
//		List<String> dbList = new ArrayList<String>(List.of("a.txt","b.txt"));  //db에서는 attach로 나옴
		
		List<File> fsListFiles = new ArrayList<>(Arrays.asList(file.listFiles()));
		SqlSession session = MybatisUtil.getSqlSession();
		
		//현재 이슈
        //dbListFiles에는 thumbnail 파일에 대한 추가가 되지 않음
        //이미지 파일 2개 일반 파일 1개로 구성된 총 3개의 attach라면
		List<Attach> attachs = new ArrayList<>(session.getMapper(AttachMapper.class).selectYesterdayList());
		//log.info("attachs : {} ", attachs);
		log.info("===================attach================");
		attachs.forEach(a -> log.info("{}", a));
		
		List<Attach> thumbs = new ArrayList<>(attachs).stream().filter(Attach::isImage).map(Attach :: toThumb).toList();
		log.info("===================thumbs================");
		thumbs.forEach(a -> log.info("{}", a));
		//log.info("thumbs : {} ", thumbs);
		
        //이미지 파일 2개 + 썸네일 2개 + 일반 파일 1개로 구성된 총 5개의 attachlist로 변경되어야함
		attachs.addAll(thumbs);
		
		log.info("===================attachs================");
		attachs.forEach(a -> log.info("{}", a));
		//log.info("attachs : {}", attachs);
        //체이닝을 통해 한꺼번에 처리하기보단 List<ATTACH> 상태에서 추가 작업 후 추후에 List<File>로 변경하라
		
		List<File> dbListFiles = session.getMapper(AttachMapper.class).selectYesterdayList().stream().map(Attach::toFile).toList();
		log.info("===================삭제하지 말아야할 파일================");
		attachs.forEach(a -> log.info("{}", a));
		//log.info("dbListFiles : {}", dbListFiles);
		session.close();
				// 디렉토리가 정확하게 일치해야 빠짐. 
	
		fsListFiles.removeAll(dbListFiles);
		log.info("===================삭제 대상 파일들================");
		fsListFiles.forEach(a -> log.info("{}", a));
//		
//		fsList.removeAll(dbListFiles);
//		
//		log.info("{}", fsList);
		log.info("{}", fsListFiles);
		
//		String 
	}
	private String genYesterdayPath() {
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date().getTime() - 1000 * 60 * 60 * 24 );
	}
	
	public static void main(String[] args) throws Exception{
		new GhostFileCleanupJob().execute(null);
	}
//	public static void main(String[] args) {
//		log.info("{}", );
//	}

	
}
