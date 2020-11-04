package com.isp.pset2a;

import java.util.ArrayList;

public class GetPath {

    //Fill in your answer for this method
    public static boolean getPath(int r, int c, ArrayList<Point> path, final int[][] grid) {

        path.add(0, new Point(r,c));

        //point is (0, 0)
        if (r == 0 && c == 0) {
            return true;
        }

        if (grid[r][c] != 1) {

            //move left
            if (c != 0 && grid[r][c - 1] != 1) {
                return getPath(r, c - 1, path, grid);
            }

            //move up
            else if (r != 0 && grid[r - 1][c] == 0) {
                return getPath(r - 1, c, path, grid);
            }
        }
        return false;
    }
}

    //You do not need to change any code below ---------
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    class TestRobot {

        public static void main(String[] args) {

            final int[][] grid0 = {
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1},
                    {0, 1, 0, 0}
            };


            ArrayList<Point> path = new ArrayList<>();

            boolean success = GetPath.getPath(3, 2, path, grid0);

            System.out.println(success);
            if (success)
                System.out.println(path);
            path.clear();


            final int[][] grid = {
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 1, 0, 1},
                    {0, 1, 0, 0}
            };

            success = GetPath.getPath(3, 2, path, grid);

            System.out.println(success);
            if (success)
                System.out.println(path);
            path.clear();

            final int[][] grid1 = {
                    {0, 0, 0, 1},
                    {0, 1, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 1},
                    {1, 1, 0, 0},
                    {1, 1, 1, 0}
            };

            success = GetPath.getPath(3, 2, path, grid);

            System.out.println(success);
            if (success)
                System.out.println(path);
            path.clear();


        }
    }
