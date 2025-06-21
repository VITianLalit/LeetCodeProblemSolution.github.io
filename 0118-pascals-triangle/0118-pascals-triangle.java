class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1) return ans;
        
        for(int i = 2; i <= numRows; i++){
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            List<Integer> prevRow = ans.get(ans.size()-1);
            for(int j = 3; j <= i; j++){
                newList.add(prevRow.get(j-3) + prevRow.get(j-2));
            }
            newList.add(1);
            ans.add(new ArrayList<>(newList));
        }

        return ans;
    }
}