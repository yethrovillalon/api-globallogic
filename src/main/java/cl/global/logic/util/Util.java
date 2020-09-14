package cl.global.logic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Util {
	
	private static final String REGEXEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String REGEXUpper = "[A-Z ]";
	private static final String REGEXLower = "[a-z ]";
	private static final String REGEXDigit = "[0-9 ]";
	
	public boolean isValidEmail(String correo) {
		boolean r = false;
		try {
			Pattern pattern = Pattern.compile(REGEXEmail);
			
			Matcher matcher = pattern.matcher(correo);
			
			return matcher.matches();
		} catch (Exception e) {
			log.error("isValidEmail : ", e);
		}
		return r;
	}
	
	public boolean isValidPassword(String contrasena) {

		boolean r=true;
		try {
			Pattern UpperCasePatten = Pattern.compile(REGEXUpper);
			Pattern lowerCasePatten = Pattern.compile(REGEXLower);
			Pattern digitCasePatten = Pattern.compile(REGEXDigit);
			
			if (!UpperCasePatten.matcher(contrasena).find()) {
		        return false;
		    }
		    if (!lowerCasePatten.matcher(contrasena).find()) {
		        return false;
		    }
		    if (!digitCasePatten.matcher(contrasena).find()) {
		        return false;
		    }
		    int count = 0;
		    for (int i = 0, len = contrasena.length(); i < len; i++) {
		        if (Character.isDigit(contrasena.charAt(i))) {
		            count++;
		        }
		    }
		    if (count <= 1) {
		        return false;
		    }
		    
		    count = 0;
		    for (int k = 0; k < contrasena.length(); k++) {
		        if (Character.isLowerCase(contrasena.charAt(k))) count++;
		    }
		    if (count <= 1) {
		        return false;
		    }
		} catch (Exception e) {
			log.error("isValidPassword : ", e);
		}	    
	    return r;
	}

}
