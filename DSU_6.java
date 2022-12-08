/*Budget Padmanabham planned to visit the tourist places. There are N tourist 
places in the city. The tourist places are numbered from 1 to N.

You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.
 
Your task is to help Budget Padmanabham to find the cheapest route plan, to 
visit all the tourist places in the city. If you are not able to find such plan, 
print -1.
 
Input Format:
-------------
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
  
Output Format:
--------------
Print an integer, minimum cost to visit all the tourist places.
 
 
Sample Input-1:
---------------
4 5
1 2 3
1 3 5
2 3 4
3 4 1
2 4 5
 
Sample Output-1:
----------------
8
 
Explanation:
------------
The cheapest route plan is as follows:
1-2, 2-3, 3-4 and cost is 3 + 4 + 1 = 8
 
 
Sample Input-2:
---------------
4 3
1 2 3
1 3 5
2 3 4
 
Sample Output-2:
----------------
-1


sol:
-----------*/
import java.util.*;
class Program
{
    static int root(int a,int [] parent)
    {
        if(parent[a]==a)
        {
            return a;
        }
        return parent[a] = root(parent[a],parent);
    }
    public static void union(int a,int b, int [] parent)
    {
        a = root(a,parent);
        b = root(b,parent);
        if(a!=b)
        {
            parent[a] = b;
        }
        
    }
    public static void main(String[] args)
    {
        int m,n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int [][] arr = new int[n][3];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<3;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(arr,(int []a,int []b)->{return a[2]-b[2];});
        int [] parent = new int [m+1];
        for(int i =  0;i<=m;i++)
        {
            parent[i] = i;
        }
        int count = 0;
        for(int i = 0 ;i<n;i++)
        {
            if(root(arr[i][0],parent)!=root(arr[i][1],parent))
            {
                union(arr[i][0],arr[i][1],parent);
                count +=arr[i][2];
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 1;i<=m;i++)
        {
            hs.add(parent[i]);
        }
        if(hs.size()==1)
        {
            System.out.print(count);
        }
        else
        {
            System.out.print(-1);
        }
    }
}
