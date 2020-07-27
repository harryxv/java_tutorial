package algorithms.graphClient;

import java.util.*;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0, 1, 1, 0, 1],
 * [0, 1, 0, 1, 0],
 * [0, 0, 0, 0, 1],
 * [0, 1, 0, 0, 0]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [0, 1, 0, 1, 1],
 * [1, 1, 1, 0, 1]]
 * <p>
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1]]
 */
public class ZombieInMatrix {

    class Position {
        int row;
        int column;

        public Position(int row, int col) {
            this.row = row;
            this.column = col;

        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    int minHours(int rows, int columns, List<List<Integer>> grid) {
        //first, add all zombies into queue
        Queue<Position> queue = new LinkedList<>();
        int counter = 0; //used to count how many zombies in the start hour.
        addZombiesToQueue(queue, rows, columns, grid);
        for (int i = queue.size(); i >= 0; i--) {
            //process infection
            Position zombie = queue.poll(); //similiar to remove
            List<Position> affectPostions = new ArrayList<>();
            if(zombie.getRow()+1 <rows){
                affectPostions.add(new Position(zombie.getRow()+1, zombie.getColumn()));
            }
            if(zombie.getRow()-1 >=0){
                affectPostions.add(new Position(zombie.getRow()-1, zombie.getColumn()));
            }
            if(zombie.getColumn()+1 <columns){
                affectPostions.add(new Position(zombie.getRow(), zombie.getColumn()+1));
            }

        }
        return -1;
    }

    private void addZombiesToQueue(Queue<Position> queue, int rows, int columns, List<List<Integer>> grid) {
        for (int r = 0; r < rows; r++) {
            List<Integer> gridRow = grid.get(r);
            for (int c = 0; c < columns; c++) {
                if (gridRow.get(c) == 1) {
                    queue.add(new Position(r, c));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 1, 1, 0, 1));
        grid.add(Arrays.asList(0, 1, 0, 1, 0));
        grid.add(Arrays.asList(0, 0, 0, 0, 1));
        grid.add(Arrays.asList(0, 1, 0, 0, 0));
        ZombieInMatrix zombieInMatrix = new ZombieInMatrix();
        int minHours = zombieInMatrix.minHours(4, 5, grid);
        System.out.println("minHours =" + minHours);
    }
}
