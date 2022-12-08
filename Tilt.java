/* Jason Statham is a well known transporter.
He transports goods from one place to other place using his container.
The container is divided into M*N slots, you can place M*N items in it.
In the container few slots are closed, you can't use them.
No other item can move from it.

When the items are loaded the container looks like an M*N grid, 
but to unload the items from the container it is turned 90-derees clockwise.
So, the Items in the container moves through the empty slots and set one on one.
If there is an closed slot, the items will be fall on the closed slot.

You will be given a matrix of size M*N, consists of 3 letters [I,O,S]
Where I indicates item, O indicates closed slot, S indicates empty slot.

Your task is to help Jason Stathamto know the positions of items, empty slots and 
closed slots after turning the container 90-degree clockwise.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the container
Next M lines: A string of length N, consists only 3 characters [I, O, S]

Output Format:
--------------
Print a charcter matrix of size N*M as described in sample.


Sample Input-1:
---------------
2 3
ISI
ISO

Sample Output-1:
----------------
SS
II
OI

Explanation:
------------
Look at hint for explanation.


Sample Input-2:
---------------
3 6
IIOSOS
IIIOSS
IIISIS

Sample Output-2:
----------------
SII
SII
IIO
IOS
ISO
ISS*/


import java.util.*;
class Program3
{
    static char[]ans(char[]p)
    {
        for(int i = 0;i<p.length-1;i++)
        {
            if(p[i]=='I' && p[i+1]=='S')
            {
                p[i] = 'S';
                p[i+1] = 'I';
            }
        }
        int flag =1;
        for(int i = 0 ;i<p.length-1;i++)
        {
            if(p[i]=='I' && p[i+1]=='S')
            {
                flag = 0;
                break;
            }
        }
        if(flag==0)
        {
            return ans(p);
        }
        return p;
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][]arr = new char[m][n];
        for(int i= 0 ;i<m;i++)
        {
            String temp =  sc.nextLine();
            char [] ar = new char[n];
            for(int j =0 ;j<n;j++)
            {
                ar[j] =temp.charAt(j);
            }
            arr[i] = ar;
        }
        char [][]res = new char[m][n];
        for(int i = 0 ;i<m;i++)
        {
            res[i] = ans(arr[i]);
        }
        char[][]tres = new char[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0 ;j<m;j++)
            {
                tres[i][j] = res[j][i];
            }
        }
        for(int i = 0 ;i<n;i++)
        {
            for(int j= m-1;j>=0;j--)
            {
                System.out.print(tres[i][j]);
            }
            System.out.println();
        }
    }
}
