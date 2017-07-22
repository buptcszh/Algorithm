public class Solution {
	
	private static int[] integer = new int[] {
		1,   4,   5,   9,
		10,  40,  50,  90,
		100, 400, 500, 900,
		1000
	};
	
	private static String[] roman = new String[] {
		"I", "IV", "V", "IX",
		"X", "XL", "L", "XC",
		"C", "CD", "D", "CM",
		"M"
	};
	
	public String intToRoman(int num) {
		
		StringBuilder sb = new StringBuilder();
		transform(num, sb);
		return sb.toString();
	}
	
	private void transform(int num, StringBuilder sb) {
		
		int start = 0, end = integer.length - 1;
		while (start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if (num < integer[mid]) {
				
				end = mid - 1;
			}
			else if (num > integer[mid]) {
				
				start = mid + 1;
			}
			else {
				
				sb.append(roman[mid]);
				return;
			}
		}
		
		int pos = start - 1;
		for (int i = 0; i < num / integer[pos]; i++) {
		
			sb.append(roman[pos]);
		}
		
		if (num % integer[pos] == 0) return;
		transform(num % integer[pos], sb);
	}
}