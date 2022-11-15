package exerciseone;

public class Matrix {

    private static String before = "0";
    private static int initialPosition = 0;
    private static int returnValue = 0;

    private static void recursiveSearch(int matrix[][], int x, int y) {

        if (    y < matrix[x].length-1  &&
                matrix[x][y + 1] == 1   &&
                returnValue == 0              &&
                (initialPosition == 0 || !"Y-".equals(before))) {
            initialPosition++;
            before = "Y+";
            recursiveSearch(matrix, x, (y+1));
            initialPosition--;
        } else if ( matrix[x][y] == 1   &&
                    y == matrix[x].length-1) {
            returnValue = 1;
        }

        if (    x < matrix.length -1    &&
                matrix[x + 1][y] == 1   &&
                returnValue == 0              &&
                (initialPosition == 0 || !"X-".equals(before))) {
            initialPosition++;
            before = "X+";
            recursiveSearch(matrix, (x+1), y);
            initialPosition--;
        } else if ( matrix[x][y] == 1   &&
                    x == matrix.length-1) {
            returnValue = 1;
        }

        if (    x > 0                   &&
                matrix[x - 1][y] == 1   &&
                returnValue == 0              &&
                (initialPosition == 0 || !"X+".equals(before))) {
            initialPosition++;
            before = "X-";
            recursiveSearch(matrix, (x-1), y);
            initialPosition--;
        } else if ( matrix[x][y] == 1   &&
                    x == 0) {
            returnValue = 1;
        }

        if (    y > 0                   &&
                matrix[x][y - 1] == 1   &&
                returnValue == 0              &&
                (initialPosition == 0 || !"Y+".equals(before))) {
            initialPosition++;
            before = "Y-";
            recursiveSearch(matrix, x, (y-1));
            initialPosition--;
        } else if ( matrix[x][y] == 1   &&
                    y == 0) {
            returnValue = 1;
        }
    }

    public static int[][] replaceMatrix(int matrix[][]) {
            int xLength = matrix.length;
            int yLength = matrix[0].length;
            int matrixReplaced[][] = new int[xLength][yLength];

            for(int x = 0; x < xLength; x++) {
                for (int y = 0; y < yLength; y++) {
                    if (    !( x == 0 || y == 0 || x == (xLength-1) || y == (yLength-1)) &&
                            (matrix[x][y] == 1)) {
                        if ((   matrix[x-1][y] == 0 &&
                                matrix[x+1][y] == 0 &&
                                matrix[x][y-1] == 0 &&
                                matrix[x][y+1] == 0)) {
                            matrixReplaced[x][y] = 0;
                        } else {
                            before = "0";
                            returnValue = 0;
                            recursiveSearch(matrix, x, y);
                            matrixReplaced[x][y] = returnValue;
                        }
                    } else {
                        matrixReplaced[x][y] = matrix[x][y];
                    }
                }
            }
            return matrixReplaced;
    }

    public static int[][] compareMatrix(int matrixA[][], int matrixB[][]) {
        int[][] returnMatrix = new int[0][0];

        if (matrixA.length == matrixB.length &&
            matrixA[0].length == matrixB[0].length) {
            int xMatrix = matrixA.length;
            int yMatrix = matrixA[0].length;

            returnMatrix = new int[xMatrix][yMatrix];
            for(int i = 0; i < xMatrix; i++) {
                for(int j = 0; j < yMatrix; j++){
                    if( matrixA[i][j] !=  matrixB[i][j]) {
                        returnMatrix[i][j] = 1;
                    } else {
                        returnMatrix[i][j] = 999;
                    }
                }
            }
        }
        return returnMatrix;
    }

    public static void printMatrix(int matrix[][]) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 999) {
                    System.out.print("  " + matrix[i][j] + "  ");
                } else {
                    System.out.print("  -  ");
                }
            }
            System.out.println();
        }
    }
}
