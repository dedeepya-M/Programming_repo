/* Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution"

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100


Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution
*/


import java.util.*;
public class Problem
{
    public static boolean isSafe(int board[][],int row,int col)
    {
        int N = board.length;
        int i,j;
        for(i = 0 ;i<col;i++)
        {
            if(board[row][i]==1)
            return false;
        }
        for(i = row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]==1)
            return false;
        }
        for(i = row,j=col;j>=0 && i<N;i++,j--)
        {
            if(board[i][j]==1) return false;
        }
        return true;
    }
    public static boolean solve(int [][]board,int col)
    {
        int N = board.length;
        if(col>=N)
        {
            return true;
        }
        for(int i = 0 ;i<N;i++)
        {
            if(isSafe(board,i,col))
            {
                board[i][col]=1;
                if(solve(board,col+1))
                {
                    return true;
                }
                board[i][col] = 0;
            }
            
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        int n ;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int [][]arr = new int[n][n];
        if(!solve(arr,0))
        {
            System.out.print("No Solution");
        }
        else
        {
         for(int i = 0 ;i<n;i++)
         {
             for(int j = 0;j<n;j++)
             {
                 System.out.print(arr[i][j]);
             }
             System.out.println();
         }
        }
    }
}
