package com.kheirallah.inc.facebook;

import java.util.LinkedList;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public static void main(String args[]) {
        int[][] prerequisites = new int[][]{{1, 0}};
        int[][] prerequisites2 = new int[][]{{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prerequisites));
        System.out.println(canFinish(2, prerequisites2));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        //counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) queue.add(i);
        }

        int count = queue.size(); //courses with no prerequisites go in the queue

        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == val) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        count++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
