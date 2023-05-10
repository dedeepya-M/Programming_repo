lass Solution {
    static int find(int a ,int []parent)
    {
        if(a==parent[a])
        {
            return a;
        }
        return parent[a] = find(parent[a],parent);
    }
    static void union(int a,int b,int[]parent)
    {
        a = find(a,parent);
        b = find(b,parent);
        if(a!=b)
        {
            parent[a] = b;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int []parent = new int[numCourses];
       for(int i = 0 ;i<numCourses;i++)
       {
           parent[i] = i;
       }
       for(int[]arr:prerequisites)
       {
           int a = find(arr[0],parent);
           int b = find(arr[1],parent);
           if(a==b)
           {
               return false;
           }
           union(arr[0],arr[1],parent);
       }
       return true;

    }
}
