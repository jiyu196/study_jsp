package util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordEncoder {


	    public static String encode(String rawPassword) {
	        return BCrypt.withDefaults().hashToString(10, rawPassword.toCharArray());
	    }

	    public static boolean matches(String rawPassword, String encodedPassword) {
	        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
	        return result.verified;
	    }
	    
	    public static void main(String[] args) {
	    	String origin = "평문";
	    	String encoded = encode(origin);
	    	String encoded2 = encode(origin);
	    	String encoded3 = encode(origin);
	    	
	    	System.out.println(encoded);
	    	System.out.println(encoded2);
	    	System.out.println(encoded3);
	    	
	    	String[] encodeds = {
	    			"$2a$10$Miv/lRctHq5rMGFLKuUhZu.P.j/5y9UwOcCqsQPkSWWl9Ey6M.8Vy"
	    			,"$2a$10$HZpjJTKbDja1Ul4HTNXohuhWe90gLeijwEk36zvyXac1EQG.ND1eC"
	    			,"$2a$10$I9Bsw/QNE.y1nOF/1c1J/uD2DGjUgNdglHcSvRG0Ga.BLvyHt1tvG"
	    			//암호 나온거
	    	};
	    	System.out.println(matches("평문", encodeds[0]));
	    	System.out.println(matches("평문2", encodeds[0]));
	    	// true, false로 나옴
	    }
	
}
