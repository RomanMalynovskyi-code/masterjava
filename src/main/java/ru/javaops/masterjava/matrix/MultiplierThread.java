package ru.javaops.masterjava.matrix;

class MultiplierThread implements Runnable {
    private final int[][] firstMatrix;
    private final int[][] secondMatrix;
    private final int[][] resultMatrix;
    private final int firstIndex;
    private final int lastIndex;
    private final int sumLength;

    public MultiplierThread(final int[][] firstMatrix,
                            final int[][] secondMatrix,
                            final int[][] resultMatrix,
                            final int firstIndex,
                            final int lastIndex) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        sumLength = secondMatrix.length;
    }

    @Override
    public void run() {
        int[] thatColumn = new int[sumLength];
        for (int j = firstIndex; j < lastIndex; j++) {
            for (int k = 0; k < sumLength; k++) {
                thatColumn[k] = secondMatrix[k][j];
            }
            for (int i = 0; i < sumLength; i++) {
                int[] thisRow = firstMatrix[i];
                int sum = 0;
                for (int k = 0; k < sumLength; k++) {
                    sum += thisRow[k] * thatColumn[k];
                }
                resultMatrix[i][j] = sum;
            }
        }
    }
}