class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void setZeroes(int[][] matrix) {
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    arr.add(new Pair(i, j));
                }
            }
        }

        for(int i = 0; i < arr.size(); i++){
            Pair p = arr.get(i);
            int row = p.r;
            int col = p.c;

            for(int j = 0; j < matrix[0].length; j++){
                matrix[row][j] = 0;
            }

            for(int j = 0; j < matrix.length; j++){
                matrix[j][col] = 0;
            }
        }

        return;
    }
}