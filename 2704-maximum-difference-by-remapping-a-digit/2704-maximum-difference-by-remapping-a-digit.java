class Solution {
    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
        char ch = '&';

        for(char c: str.toCharArray()){
            if(Character.getNumericValue(c) < 9){
                ch = c;
                break;
            }
        }

        String strMin = new String(str);
        for(char c: strMin.toCharArray()){
            if(c != '0'){
                strMin = strMin.replace(c, '0');
                break;
            }
        }
        str = str.replace(ch, '9');
        int num2 = Integer.valueOf(str);
        int num3 = Integer.valueOf(strMin);
        int ans = Math.abs(num3 - num2);
        return ans;
    }
}