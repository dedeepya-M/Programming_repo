/* There are N computers in a network, all the computers are connected as tree 
structure. And one new connection is added in the Network. The computers in 
the network are identified with their IDs, the IDs are numbered between 1 to N.

The connections in the network is given as coonection[i] = [comp-A, comp-B], 
there is a connection between comp-A and comp-B.

Your task is to remove a connection in the network and print it, so that 
all the computers are connected as tree structure. If there are multiple 
options to remove, remove the connection that occurs last in the input.


Input Format:
-------------
Line-1: Two space separated integers N, number of computers.
Next N lines: Two space separated integers, comp-A & comp-B.

Output Format:
--------------
Print the connection which is removed.


Sample Input-1:
---------------
6
1 2
3 4
3 6   
4 5
5 6
2 3

Sample Output-1:
---------------
5 6


Sample Input-2:
---------------
4
1 2
2 3
3 4
2 4

Sample Output-2:
---------------
2 4

*/


import java.util.*;
class Program
{
    static int root(int a,int []parent)
    {
        if(a==parent[a])
        {
            return a;
        }
        return parent[a] = root(parent[a],parent);
    }
     static void union(int a,int b,int []parent)
    {
        a--;
        b--;
        int p = a+1;
        int q = b+1;
        a = root(a,parent);
        b = root(b,parent);
      
        if(a!=b)
        {
            parent[b] = a;
            
        }
        else
        {
            System.out.print(p+" "+q);
            return ;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]arr = new int[n][2];
        for(int i = 0 ;i<n ;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int []parent  = new int [n];
        for(int i = 0;i<n;i++)
        {
            parent[i] = i;
        }
       
        for(int i = 0;i<n;i++)
        {
            union(arr[i][0],arr[i][1],parent);
           
            
        }
        
    }
    
}
