package exerciseone;

public class Main {
    public static void main(String[] args) {
        int xLength = 6;
        int yLength = 6;

        int[][] matrixA = new int[xLength][yLength];
        int[][] matrixB;
        int[][] matrixReplaced;

        int count = 0;
        int[] input = { 1, 0, 0, 0, 0, 0,
                        0, 1, 0, 1, 1, 1,
                        0, 0, 1, 0, 1, 0,
                        1, 1, 0, 0, 1, 0,
                        1, 0, 1, 1, 0, 0,
                        1, 0, 0, 0, 0, 1};

        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                matrixA[x][y] = input[count];
                count++;
            }
        }

        matrixB = Matrix.replaceMatrix(matrixA);
        matrixReplaced = Matrix.compareMatrix(matrixA, matrixB);

        System.out.println("Matriz de input");
        Matrix.printMatrix(matrixA);
        System.out.println("Matriz de output");
        Matrix.printMatrix(matrixB);
        System.out.println("Valores substituídos");
        Matrix.printMatrix(matrixReplaced);

    }
}
