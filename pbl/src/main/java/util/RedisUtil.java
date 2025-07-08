package util;

import redis.clients.jedis.JedisPooled;

public class RedisUtil {  
	// redis db 접속. 기본적인 메서드는 set, get. 추가적으로 ttl, exists를 넣음. 
	// 예전에 로컬스토리지했던거. 쿠키의 대용. set item, get item 하루동안 창 안보기 구현했었던
	// 아까 도커에서 안했으면 6380 이거 안했음 여기서 터졌음
    private static final JedisPooled JEDIS_POOLED = new JedisPooled("localhost", 6380);

    // 기본 10분
    public static void set(String key, String value) {  // key, value 넣고, 600초로 넣음 초는 int, 밀리세컨드는 long. 메일인증 토큰 기다리는 시간
        set(key, value, 600);
    }

    public static void set(String key, String value, int expiry) {
        JEDIS_POOLED.setex(key, expiry, value);
    }

    public static String get(String key) {
        return JEDIS_POOLED.get(key);
    }

    public static Long ttl(String key) { // ttl => time to left  남은 시간을 뜻하는거
        return JEDIS_POOLED.ttl(key);
    }
    
    public static void remove(String key) {
    	JEDIS_POOLED.del(key);  // session에서 invalidate(로그아웃) 하는 것 같이 
    }
    
    public static boolean exists(String key) {  //  ttl 시간 끝나고 key가 사라졌는지 확인하는거
        return JEDIS_POOLED.exists(key);
    }
}