class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        sb.append(num / den);
        num %= den;

        if (num == 0) return sb.toString();
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();  // 用map把<余数, index>存起来，如果出现了相同的余数，则说明出现了循环节
        map.put(num, sb.length());

        while (num != 0) {            
            num *= 10;

            sb.append(num / den);
            num %= den;
            
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else map.put(num, sb.length());
        }
        
        return sb.toString();
    }
}