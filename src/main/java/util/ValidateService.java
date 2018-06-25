package util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ValidateService {

//	public static void main(String[] args) {
//		System.out.println(ctbcID("A123456789A"));
//		System.out.println(ctbcID("A987654321B"));
//		System.out.println(ctbcID("A111AAAAAAC"));
//		System.out.println(ctbcID("111VVV1234D"));
//		System.out.println(ctbcID("11111CCCCCE"));
//		System.out.println(ctbcID("20180630ADF"));
//	}

	public static boolean isValidTWPID(String id) {
		// 建立字母分數陣列(A~Z)
		int[] city = new int[] { 1, 10, 19, 28, 37, 46, 55, 64, 39, 73, 82, 2, 11, 20, 48, 29, 38, 47, 56, 65, 74, 83,
				21, 3, 12, 30 };

		id = id.toUpperCase();
		// 使用"正規表達式"檢驗格式
		if (id.matches("^[A-Z](1|2)[0-9]{8}") == false) {
			return false;
		}

		// 將字串分割為陣列
		String[] idStringArray = id.split("");
		int[] idIntArray = new int[idStringArray.length];
		for (int i = 1; i < idStringArray.length; i++) {
			idIntArray[i] = Integer.parseInt(idStringArray[i].trim());
		}

		// 計算總分
		int total = city[Character.codePointAt(id, 0) - 65];
		for (int i = 1; i <= 8; i++) {
			total += (idIntArray[i]) * (9 - i);
		}
		// 補上檢查碼(最後一碼)
		total += idIntArray[9];
		// 檢查比對碼(餘數應為0)
		return ((total % 10 == 0));
	}

	public static boolean isValidTWBID(String id) {
		String weight = "12121241";
		boolean type2 = false; // 第七個數是否為七

		if (id.matches("^[0-9]{8}") == true) {
			int tmp = 0;
			int sum = 0;

			for (int i = 0; i < 8; i++) {
				tmp = Integer.parseInt(String.valueOf(id.charAt(i)))
						* Integer.parseInt(String.valueOf(weight.charAt(i)));
				
				sum += ((tmp / 10) + (tmp % 10)); // 取出十位數和個位數相加
				if (i == 6 && id.charAt(i) == '7') {
					type2 = true;
				}
			}

			if (type2 == true) {
				if ((sum % 10) == 0 || ((sum + 1) % 10) == 0) { // 如果第七位數為7
					return true;
				} else {
					if ((sum % 10) == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean isValidateDate(String dateString) {
		// First check for the pattern
		if (dateString.matches("^[0-9]{8}") == false) {
			return false;
		}

		// Parse the date parts to integers
		int year = Integer.parseInt(dateString.substring(0, 4), 10);
		int month = Integer.parseInt(dateString.substring(4, 6), 10);
		int day = Integer.parseInt(dateString.substring(6, 8), 10);
		if (year < 1000 || year > 3000 || month == 0 || month > 12) {
			return false;
		}

		int[] monthHasDayArray = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// Adjust for leap years
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			monthHasDayArray[1] = 29;
		}

		// Check the range of the day
		return day > 0 && day <= monthHasDayArray[month - 1];
	}

	public static boolean ctbcID(String customerId) {
		// 本國人身份證字號檢查
		if (customerId.matches("^[a-zA-Z][0-9]{9}") == true && isValidTWPID(customerId)) {
			return true;
		}

		// 辦事處本國人ID + A-Z
		if (customerId.matches("^[a-zA-Z][0-9]{9}[a-zA-Z]") == true && isValidTWPID(customerId.substring(0, 10))) {
			return true;
		}

		// 公司統編檢查
		if (customerId.matches("^[0-9]{8}") == true && isValidTWBID(customerId)) {
			return true;
		}
		if (customerId.matches("^[0-9]{8}[a-zA-Z]") == true) {
			String customerIdTemp = customerId.substring(0, 8);
			if (isValidTWBID(customerIdTemp) == true) {
				return true;
			}
		}

		// 境外法人檢查
		if (customerId.matches("^[a-zA-Z]{2}[0-9]{6}") == true) {
			return true;
		}

		// 外國人ID檢查
		if (customerId.matches("^[0-9]{8}[a-zA-Z]{3}") == true) {
			String birthday = customerId.substring(0, 8);

			int birthYear = Integer.parseInt(birthday.substring(0, 4), 10);
			int birthMonth = Integer.parseInt(birthday.substring(4, 6), 10);
			int birthDay = Integer.parseInt(birthday.substring(6, 8), 10);

			if (isValidateDate(birthday)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date now = Date.valueOf(simpleDateFormat.format(new java.util.Date()));
				Date birthDayDate = Date.valueOf(birthYear + "-" + birthMonth + "-" + birthDay);
				if (now.after(birthDayDate)) {
					return true;
				}
			}
		}

		return false;
	}

}
