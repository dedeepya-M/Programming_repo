/* A transitive law is "If a == b and b == c, then a == c"
Which also says "If a == b and b != c, then a != c"

You will be given a list of strings relations[], i.e, like p==q or p!=q.
Your task is to find out whether all the relations follow the transitive law or not.
If all of them followed return true, otherwise return false.

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true
*/

import java.util.*;
class Problem
{
    public static int root(int a,int []parent)
    {
        if(parent[a]==a)
        {
            return a;
        }
        return parent[a] = root(parent[a],parent);
    }
    public static void union(int a,int b,int []parent)
    {
        a = root(a,parent);
        b = root(b,parent);
        if(a!=b)
        {
            parent[b] = a;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        HashSet<Character> hs = new HashSet<>();
        for(String str:s)
        {
            hs.add(str.charAt(0));
            hs.add(str.charAt(3));
        }
        int []parent = new int[hs.size()];
        for(int i = 0;i<hs.size();i++)
        {
            parent[i] = i;
        }
        for(int i = 0 ;i<s.length-1;i++)
        {
            if(s[i].charAt(1)!='!')
            {
                union((int)s[i].charAt(0)-97,(int)s[i].charAt(3)-97,parent);
            }
        }
       /* for(int i = 0 ;i<parent.length;i++)
        {
            System.out.println(parent[i]);
        }*/
        int a = (int)s[s.length-1].charAt(0);
        int b = (int)s[s.length-1].charAt(3);
       // System.out.print((char)a+" "+(char)b);
        if(s[s.length-1].charAt(1)=='!' ){
              int f = root(a-97,parent);
              int g = root(b-97,parent);
              if(f>g)
              {
                  System.out.print(true);
              }
              else
              {
                  System.out.print(false);
              }
        }
        else
        {
            int f = root(a-97,parent);
            int g =root(b-97,parent);
            if((f==a-97)&&(g==b-97))
            {
                System.out.print(true);
            }
            
            
        }
        
        
    }
}
