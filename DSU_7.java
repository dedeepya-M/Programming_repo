/* In an exam hall, seating arrangement is done in a row, When an invigilator 
enters into exam hall he wants to exchange(swap) some students places in pairs.

Note: student names will be alphabets(a,b,c...z) may be repeated,
and seat number starts from zero(0 to N-1) where N is the number of students.

Invigilator may swap the students at any pair of seats(indices) in 
the given pairs any number of times.

Given the seating-arrangement s, and list of pairs of seats(indices) in 
seating-arrangement pairs where pairs[i]=[x,y] denotes 2 indices 
(index starts from zero(0)) of the seating-arrangement s.

Your task is to print the lexicographically smallest seating-arrangement S
that has been changed after using the swaps.


Input Format:
-------------
Line-1: Read a String seating-arrangement s.
Line-2: Read the number of pairs of seat numbers to swap R.
Next R lines: Two space separated integers, pair of seat numbers.

Output Format:
--------------
Print the lexicographically smallest seating-arrangement s after using the swaps.

Sample Input-1:
---------------
feabdc
2       
0 4
1 3

Sample Output-1:
----------------
dbaefc

Explanation:
------------
Swap s[0] and s[4], s = "deabfc"
Swap s[1] and s[3], s = "dbaefc"

Sample Input-2:
---------------
edb
2
0 1
1 2

Sample Output-2:
----------------
bde

Explanation:
------------
Swap s[0] and s[1], s = "deb"
Swap s[1] and s[2], s = "dbe"
Swap s[0] and s[1], s = "bde"

*/

import java.util.*;

    class UnionFind
    {
        int []parent;
        int []rank;
        UnionFind(int n)
        {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank,1);
            for(int i = 0;i<n;i++)
            {
                parent[i] = i;
            }
        }
        int find(int val)
        {
            if(parent[val]==val) return val;
            return find(parent[val]);
        }
         void union(int a,int b)
        {
            int v1 = find(a);
            int v2 = find(b);
            if(v1!=v2)
            {
                if(rank[v1]>=rank[v2])
                {
                    parent[v2] = v1;
                    rank[v1]+=rank[v2];
                }
                else
                {
                    parent[v1]=v2;
                    rank[v2] += rank[v1];
                }
            }
        }
    }
class Problem{    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int c;
        String s = sc.next();
        c = sc.nextInt();
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i = 0 ;i<c;i++)
        {
            List<Integer> lis = new ArrayList<>();
            lis.add(sc.nextInt());
            lis.add(sc.nextInt());
            pairs.add(lis);
        }
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for(List<Integer> pair:pairs)
        {
            uf.union(pair.get(0),pair.get(1));
        }
        Map<Integer,PriorityQueue<Character>> map = new HashMap();
        for(int i = 0;i<n;i++)
        {
            int ar = uf.find(i);
            map.putIfAbsent(ar,new PriorityQueue<Character>());
            map.get(ar).offer(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ;i<n;i++)
        {
            int ar = uf.find(i);
        
        result.append(map.get(ar).poll());
        }
        System.out.print(result.toString());
    }
    
}
