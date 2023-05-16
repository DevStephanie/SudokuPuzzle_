public class SudokuPuzzle {
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) {
        int[][] puzzle  = {
                {1, 0, 5, 0, 0, 4, 0, 0, 0},
                {0, 4, 0, 8, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 9, 2, 5, 0},
                {0, 5, 0, 0, 7, 3, 0, 6, 2},
                {0, 0, 0, 0, 0, 0, 0, 7, 0},
                {6, 0, 0, 9, 0, 0, 0, 3, 0},
                {0, 8, 1, 6, 0, 0, 0, 4, 0},
                {0, 3, 0, 1, 0, 0, 7, 0, 0},
                {5, 0, 0, 0, 0, 7, 0, 9, 0},

        };
        printPuzzle(puzzle);

        if (solvePuzzle(puzzle)) {
            System.out.println("Congratulations, you've done it! You solved the Puzzle.");
        } else {
            System.out.println("Not quite! Please try again.");

        }
        printPuzzle(puzzle);
    }

    private static void printPuzzle(int[][] puzzle) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.println("l");
                }
                System.out.print(puzzle[row][column]);
            }
            System.out.println();
        }

    }

    private static boolean isNumberInRow(int[][] puzzle, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (puzzle [row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] puzzle, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (puzzle[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] puzzle, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int k = localBoxColumn; k < localBoxColumn + 3; k++) {
                if (puzzle[i][k] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCorrectPlacement(int[][] puzzle, int number, int row, int column) {
        return !isNumberInRow(puzzle, number, row) &&
                !isNumberInColumn(puzzle, number, column) &&
                !isNumberInBox(puzzle, number, row, column);
    }

    private static boolean solvePuzzle(int[][] puzzle) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (puzzle[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isCorrectPlacement(puzzle, numberToTry, row, column)) {
                            puzzle[row][column] = numberToTry;

                            if (solvePuzzle(puzzle)) {
                                return true;
                            }
                            else {
                                puzzle[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



}




