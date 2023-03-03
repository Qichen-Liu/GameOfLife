public class GameOfLife {

    // Output the next generation
    static void nextGeneration(int grid[][], int M, int N) {
        int[][] future = new int[M][N];

        // Loop through every cell
        for (int l = 0; l < M; l++) {
            for (int m = 0; m < N; m++) {
                // find the number of alive neighbours
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l + i >= 0 && l + i < M) && (m + j >= 0 && m + j < N))
                            aliveNeighbours += grid[l + i][m + j];

                // remove double counted cells
                aliveNeighbours -= grid[l][m];

                //Rules of Life
                // Cell dead
                if ((grid[l][m] == 1) && (aliveNeighbours < 2)){
                    future[l][m] = 0;
                }// Cell dead due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) {
                    future[l][m] = 0;
                }// A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) {
                    future[l][m] = 1;
                }// Nothing changes
                else {
                    future[l][m] = grid[l][m];
                }
            }
        }

        // Print out visualization
        System.out.println("Next Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0)
                    System.out.print("."); // dead cell
                else
                    System.out.print("*"); // alive cell
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int M = 10, N = 10;

        // Initializing the 10 x 10 grid.
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        // Print a few generations
        System.out.println();
        nextGeneration(grid, M, N);
        System.out.println();
        nextGeneration(grid, M, N);
    }
}
