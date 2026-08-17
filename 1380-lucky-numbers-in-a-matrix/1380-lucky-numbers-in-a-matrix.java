class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            int min = matrix[i][0];
            int col = 0;

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }

            int max = matrix[0][col];

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[j][col] > max) {
                    max = matrix[j][col];
                }
            }

            if (min == max) {
                list.add(min);
            }
        }

        return list;
    }
}