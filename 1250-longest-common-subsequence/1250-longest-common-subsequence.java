class Solution {
    public int solve(String str1, String str2, int index1, int index2, int[][] dp){
        if(index1 == str1.length() || index2 == str2.length()) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(str1.charAt(index1) == str2.charAt(index2)) return 1 + solve(str1, str2, index1 + 1, index2 + 1, dp);
        return dp[index1][index2] = (int)Math.max(solve(str1, str2, index1 + 1, index2, dp), solve(str1, str2, index1, index2 + 1, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(text1, text2, 0, 0, dp);
    }
}