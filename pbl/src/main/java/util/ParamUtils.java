package util;

import java.lang.reflect.Field;


import javax.servlet.http.HttpServletRequest;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParamUtils {

	public static <T> T get(HttpServletRequest req, Class<T> clazz) {
		try {
			
			T t = clazz.getDeclaredConstructor().newInstance();
//			Method[] methods = clazz.getDeclaredMethods();
//			for(Method m : methods) {
//				log.info(m.getName());  //메서드 간접호출 가능
//				if(m.getName().equals("setBno")) {
//					m.invoke(t,  100L);   //t 는 호출 주체를 가져옴. t는 나중에 reply가됨
//				}
//			}
			
			Field[] fields = clazz.getDeclaredFields();
			for(Field f : fields) {
				log.info("{}, {}", f.getType(), f.getName()); 
				String param = req.getParameter(f.getName());  //필드명 가져오고, 그걸가지고 리퀘스트 객체에 가지고 있냐고 물어보는거
				if(param != null) {  // 동일 이름이 있다면 다 가져옴. 
					f.setAccessible(true);
					Object o = convert(param, f.getType());
					f.set(t, o);
					// 여기까지 파라미터 끝임
				}
			
			}
			return t;
		} catch (Exception e)	{
			e.printStackTrace();
		}
		return null;
	}  
	@SuppressWarnings("unchecked")
	private static Object convert(String param, Class<?> type) {
		// int
		if(type == int.class || type == Integer.class) return Integer.parseInt(param);
		// long
		if(type == long.class || type == Long.class) return Long.parseLong(param);
		// boolean
		if(type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(param);
		// enum
		if(type.isEnum()) return Enum.valueOf(type.asSubclass(Enum.class), param.toUpperCase());
		// enum값의 value만 바꾸지 않는다면 대문자로 인식할거임. 
		// String
		return param;  // 위에 것들을 만족하면 return은 하지 않음. 
		
		
	}
	
}
