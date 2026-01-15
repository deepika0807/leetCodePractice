package geeksforgeeks.Arrays.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze
{
    public static void main(String[] args)
    {
//        System.out.println(mazeRightAndDown(3,3));
//        System.out.println(mazePathRightAndDown("", 3, 3));
//        System.out.println(mazePathRightDownAndDiagonal("", 3, 3));
        boolean[][] board =  {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
//       mazePathRestrictions("", board, 0, 0);
        mazeAllPath("" ,board,0, 0);
    }
    public static int mazeRightAndDown(int r,int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = mazeRightAndDown(r-1, c);
        int right = mazeRightAndDown(r, c-1);
        return left+right;
    }
    public static List<String> mazePathRightAndDown(String p, int r,int c){
        if(r == 1 && c == 1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(mazePathRightAndDown(p+"D", r-1, c));
        }
        List<String> rightList = new ArrayList<>();
        if(c>1){
            list.addAll(mazePathRightAndDown(p+"R", r, c-1));
        }

        return list;
    }

    public static List<String> mazePathRightDownAndDiagonal(String p, int r,int c){
        if(r == 1 && c == 1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(mazePathRightDownAndDiagonal(p+"D", r-1, c));
        }
        if(c>1){
            list.addAll(mazePathRightDownAndDiagonal(p+"R", r, c-1));
        }

        if(r>1 && c>1){
            list.addAll(mazePathRightDownAndDiagonal(p+"DI", r-1, c-1));
        }

        return list;
    }

    public static void mazePathRestrictions(String p, boolean maze[][], int r,int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length-1){
            mazePathRestrictions(p+"D", maze, r+1, c);
        }
        if(c < maze[0].length-1){
            mazePathRestrictions(p+"R",maze,  r, c+1);
        }

        return;
    }
//Backtracing is used here
    public static void mazeAllPath(String p, boolean maze[][], int r,int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        if(r < maze.length-1){
            mazeAllPath(p+"D", maze, r+1, c);
        }
        if(c < maze[0].length-1){
            mazeAllPath(p+"R",maze,  r, c+1);
        }

        if(r > 0){
            mazeAllPath(p+"U",maze,  r-1, c);
        }

        if(c > 0){
            mazeAllPath(p+"L",maze,  r, c-1);
        }

//        this line is where the function will be over
//         so before the function gets removed, also remove the changes that were made by functions

        maze[r][c] = true;
    }
}
