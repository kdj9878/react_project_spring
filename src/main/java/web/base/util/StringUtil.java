package web.base.util;

import java.net.URLDecoder;

import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.CaseFormat;

import web.base.exception.BaseException;


public final class StringUtil {
	
	
	public static String toString(Object o) {
		if (o == null) {
			return null;
		}
		return o.toString();
	}
	
	
	public static String toString(Object o, String defaultValue) {
		if (o == null) {
			return defaultValue;
		}
		return o.toString();
	}
	
	
	public static boolean isEmpty(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
	
	
	public static String trim(String value) {
		if(value == null) {
			return null;
		}
		return value.trim();
	}
	
	
	public static String lpad(String value, int len, String pad) {
		if(value == null) {
			value = "";
		}
		return StringUtils.leftPad(value, len, pad);
	}
	
	
	public static String rpad(String value, int len, String pad) {
		if(value == null) {
			value = "";
		}
		return StringUtils.rightPad(value, len, pad);
	}
	
	
	public static String camelLower(String name) {
    	return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name);
    }
	
	
	public static String camelUpper(String name) {
    	return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, name);
    }
	
	
	/**
	 * 메시지 Format
	 * 
	 * @param msg - "{0}는 {1}자리입니다."
	 * @param params - new Object[]{"ID", 8}
	 * @return
	 */
	public static String msgFormat(String msg, Object ... params) {
		String formatMsg = null;
		if(StringUtil.isNotEmpty(msg)) {
			if(params != null && params.length > 0) {
				formatMsg = MessageFormat.format(msg, params);
			} else {
				formatMsg = msg;
			}
		}
		return formatMsg;
	}
	
	
	/**
	 * 메시지 Parse
	 * 
	 * @param pattern - "{0}는 {1}자리입니다."
	 * @param msg - "ID는 8자리입니다."
	 * @return new Object[]{"ID", 8}
	 */
	public static Object[] msgParse(String pattern, String msg) {
		Object[] params = null;
		if(StringUtil.isEmpty(pattern)) {
			return params;
		}
		if(StringUtil.isEmpty(msg)) {
			return params;
		}
		try {
			MessageFormat formatter = new MessageFormat(pattern);
			params = formatter.parse(msg);
		} catch (ParseException e) {
			throw new BaseException(e);
		}
		return params;
	}
	
	
	public static String formatAmount(String value, String pattern) {
		String format = null;
		if(StringUtil.isNotEmpty(value)) {
			Double number = Double.parseDouble(value);
			DecimalFormat formatter = new DecimalFormat(pattern);
			format = formatter.format(number);
		}
		return format;
	}
	
	
	public static String formatAmount(Object value, String pattern) {
		return StringUtil.formatAmount(String.valueOf(value), pattern);
	}
	
	
	public static String formatAmount(String value) {
		return StringUtil.formatAmount(value, "#,###");
	}
	
	
	public static String formatAmount(Object value) {
		return StringUtil.formatAmount(String.valueOf(value));
	}
	
	
	/**
	 * 문자열을 Byte로 (한글 중간에 안 짤리게) 자름
	 * 
	 * @param str
	 * @param len
	 * @param encoding
	 * @return
	 */
	public static String subByte(String str, int len, String encoding) {
		try {
			if (StringUtil.isEmpty(str)) {
				return str;
			}
			byte[] strBytes = str.getBytes(encoding);
			int strLength = strBytes.length;
			int minusByteNum = 0;
			int offset = 0;
			int hangulByteNum = encoding.equals("UTF-8") ? 3 : 2;
			if (strLength > len) {
				minusByteNum = 0;
				offset = len;
				for (int j = 0; j < offset; j++) {
					if (((int) strBytes[j] & 0x80) != 0) {
						minusByteNum++;
					}
				}
				if (minusByteNum % hangulByteNum != 0) {
					offset -= minusByteNum % hangulByteNum;
				}
				return new String(strBytes, 0, offset, encoding);
			} else {
				return str;
			}
		} catch (Exception e) {
			throw new BaseException(e);
		}
	}
	
	/**
	 * 문자열을 Byte로 (한글 중간에 안 짤리게) 자름 (UTF-8)
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static String subByte(String str, int len) {
		return StringUtil.subByte(str, len, "UTF-8");
	}
	
	/**
	 * 문자열을 Byte로 (한글 중간에 안 짤리게) 자름 (EUC-KR)
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static String subByteEucKr(String str, int len) {
		return StringUtil.subByte(str, len, "EUC-KR");
	}
	
	
	public static String urlEncoding(String value, String charset) {
		String encode = null;
		try {
			encode = URLEncoder.encode(value, charset);
		} catch (Exception e) {
			throw new BaseException(e);
		}
		return encode;
	}
	
	
	public static String urlEncoding(String value) {
		return StringUtil.urlEncoding(value, "UTF-8");
	}
	
	
	public static String urlDecoding(String value, String charset) {
		String encode = null;
		try {
			encode = URLDecoder.decode(value, charset);
		} catch (Exception e) {
			throw new BaseException(e);
		}
		return encode;
	}
	
	
	public static String urlDecoding(String value) {
		return StringUtil.urlDecoding(value, "UTF-8");
	}
	
	/**
	 * <p>String 배열에서 같은 문자열이 있는지 찾는다.</p>
	 * 
	 * @param strs
	 * @param findstr
	 * @return
	 */
	public static boolean hasData(String[] strs, final String findstr) {
		return Arrays.stream(strs).anyMatch(x -> x.equals(findstr) );
	}
	
	/**
	 * <p>String을 구분자로 배열로 만든 뒤  배열에서 같은 문자열이 있는지 찾는다.</p>
	 * 
	 * @param str
	 * @param delimiter
	 * @param findstr
	 * @return
	 */
	public static boolean hasData(String str, String delimiter, final String findstr) {
		return Arrays.stream(StringUtils.split(str, delimiter)).anyMatch(x -> x.equals(findstr) );
	}
	
	/**
	 * <p>영문숫자 조합 랜덤문자열 생성 </p>
	 * @param length
	 * @return
	 */
	public static String randomString(int length) {
	    char[] charaters = {
	            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
	            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
	            '0','1','2','3','4','5','6','7','8','9'};
        StringBuffer sb = new StringBuffer();
        Random rn = new Random();
        for (int i = 0; i < length; i++ ) {
            sb.append(charaters[rn.nextInt(charaters.length)]);
        }
        
        return sb.toString();
	}
	
	/**
	 * 버전 1.0
	 * 
     * ca ldap date format convert to general date format
     * @param date - ca ldap의 날짜형   
     * @param return - data의 문자형
     */
    public static String caDate(String date) {
		String retVar = date.substring(5, 10);
		String sYear = "20" + retVar.substring(0, 2);
		int Year = Integer.parseInt(sYear); //00001 08 099
		
		int dayVal = Integer.parseInt(retVar.substring(2, 5));
		int[] intArray;
		String[] monthVal = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

		if (((Year % 4 == 0) && (Year % 100 != 0)) || (Year % 400 == 0)) {			//윤달인 경우
			int[] dArray = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			intArray = dArray;
		} else {
			int[] dArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			intArray = dArray;
		}

		String day = "";
		int j = 0;
		for (int i=0; i < intArray.length; i++){
			if (dayVal - intArray[i] > 0) {
				dayVal = dayVal - intArray[i];
				j++;
			}

			if (dayVal < 0) {
				break;
			}
		}

		return Year + "-" +  monthVal[j] + "-" + (dayVal < 10 ? ("0" + Integer.toString(dayVal)) : Integer.toString(dayVal));
	}
    
    public static String twoRandChars(String src) {
        Random rnd = new Random();
        int index1 = (int) (rnd.nextFloat() * src.length());
        int index2 = (int) (rnd.nextFloat() * src.length());
        return "" + src.charAt(index1) + src.charAt(index2);
    }
    public static String randomPW() {
        

        String chars = "abcdefghijklmnopqrstuvwxyz";
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NUMS = "1234567890";
        String SPEC = "!@#%^";
        String pass = twoRandChars(chars) + twoRandChars(CHARS) + twoRandChars(NUMS) + twoRandChars(SPEC);
        return pass;
    }
    
    
}
