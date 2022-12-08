/* Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"*/


import java.util.*;
public class Problem
{
    public static int root(int a,int  []parent)
    {
        if(a==parent[a])
        {
            return a;
        }
        return parent[a] = root(parent[a],parent);
    }
    public static void union(int a,int b,int []parent)
    {
        a = root(a,parent);
        b = root(b,parent);
        if(a<b)
        {
            parent[b] = a;
        }
        else parent[a] = b;
        
        
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String s1,s2,s3,s4;
        s1 = sc.next();
        s2 = sc.next();
        s3 = sc.next();
        int[]parent = new int[26];
        int p = 'a'-'0';
        int e = 'z'-'0';
        int j =0;
        for(int i = 0 ;i<26;i++)
        {
            parent[i] = i;
        }
        for(int i = 0;i<s1.length();i++)
        {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            union(c1,c2,parent);
        }
        s4 = "";
        for(int i= 0 ;i<s3.length();i++)
        {
            int val = root(s3.charAt(i)-'a',parent);
            s4 += (char)(val+'a');
            
        }
        System.out.print(s4);
    }
}
