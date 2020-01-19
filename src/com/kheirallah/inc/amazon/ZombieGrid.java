package com.kheirallah.inc.amazon;

//Hard

/*
Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?

Example:

Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
 */

import java.util.LinkedList;
import java.util.Queue;

public class ZombieGrid {

    private static final int ZOMBIE = 1;
    private static final int[][] FOUR_DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //Time Complexity O(row * columns)
    private static int getHoursToComplete(int[][] grid) {
        int uninfectedPeople = 0;
        Queue<int[]> zombies = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ZOMBIE) {
                    zombies.add(new int[]{i, j});
                } else {
                    uninfectedPeople++;
                }
            }
        }

        //grid is already fully zombified
        if (uninfectedPeople == 0) {
            return 0;
        }

        for (int hoursToComplete = 0; !zombies.isEmpty(); hoursToComplete++) {
            for (int zombiesRemaining = zombies.size(); zombiesRemaining > 0; zombiesRemaining--) {
                int[] zombie = zombies.poll();
                for (int[] adjacents : FOUR_DIRECTIONS) {
                    int row = zombie[0] + adjacents[0];
                    int col = zombie[1] + adjacents[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == ZOMBIE) {
                        uninfectedPeople--;
                        if (uninfectedPeople == 0) {
                            return hoursToComplete;
                        }
                        grid[row][col] = ZOMBIE;
                        zombies.add(new int[]{row, col});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };

        System.out.println(getHoursToComplete(grid));
    }
}
