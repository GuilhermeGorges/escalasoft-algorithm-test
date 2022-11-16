package exerciseone;

import java.util.Scanner;

public class MainInteractive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int xLength;
        int yLength;
        int[][] matrixA;
        int[][] matrixB;
        int[][] matrixReplaced;

        System.out.println("Digite o tamanho do eixo X");
        xLength = scan.nextInt();
        System.out.println("Digite o tamanho do eixo Y");
        yLength = scan.nextInt();

        matrixA = populateMatrix(xLength, yLength);

        matrixB = Matrix.replaceMatrix(matrixA);
        matrixReplaced = Matrix.compareMatrix(matrixA, matrixB);

        System.out.println("Matriz de input");
        Matrix.printMatrix(matrixA);
        System.out.println("Matriz de output");
        Matrix.printMatrix(matrixB);
        System.out.println("Valores substituídos");
        Matrix.printMatrix(matrixReplaced);


    }

    /*
     * Devido ao elevado consumo de memória do método recursivo,
     * tive que tomar algumas medidas para conseguir criar matrizes maiores:
     * Reduzir o fator do random para 0,6 resultando na incidência menor do produto 1.
     * Foi necessário aumentar a memória da IDE para 2000 MBytes.
     * Foi possível criar matrizes de até 23 * 23.
     */
    public static int[][] populateMatrix(int xLength, int yLength){
        int[][] matrix = new int[xLength][yLength];
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                matrix[x][y] = (int) Math.round(Math.random() * 0.6);
            }
        }
        return matrix;
    }
}
