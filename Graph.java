import java.util.*;
class Edge{
    int src;
    int dest;
    int weight;
    Edge(int src,int dest,int weight)
    {
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
}
public class Graph {

    // For Creating graph:

   static  ArrayList <Edge>graph[];
   static int v;
    Graph(int v)
    {
        this.v=v;
       this.graph=new ArrayList[v];
       for(int i=0;i<v;i++)
       { 
           graph[i]=new ArrayList<Edge>();
       }
    }
    
    // addEdge : For Adding Edge

    public static void addEdge(int src,int dest, int weight)
    {
        Edge e=new Edge(src,dest,weight);
         
       graph[src].add(e);
       
    }

    // Normal Print
    public static void print()
    {
        for(int i=0;i<v;i++)
        { 
            for(Edge e:graph[i])
            {
            
           System.out.println(e.src+"---"+e.dest+"="+e.weight);
            }
            
        }
    }
    
  // BFS implementation:

    public static void breadthFirstSearch()
    {
        boolean visited[]=new boolean[v];
        int count=1;
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                System.out.println("Starting of graph"+count+" : "+i );
         BFS(i,visited);
            count++;
            }
        }
    }
    public static void BFS(int node,boolean visited[])
    {
      Queue <Integer> q=new LinkedList<>();
      
      q.add(node);
      while(!q.isEmpty())
      {
       int curr=q.poll();
      
       if(!visited[curr])
       {
        System.out.println(curr);
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
          Edge e=graph[curr].get(i);
          q.add(e.dest);
        }
       }

      }
    }

    // DFS Implementation:

    public static void depthFirstSearch()
    {
        boolean visited[]=new boolean[v];
        int count=1;
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                System.out.println("Starting of graph"+count+" : "+i );
         DFS(i,visited);
            count++;
            }
        }
    }

    public static void DFS(int curr,boolean visited[])
    {
        if(visited[curr])
        {
           return;
        }
        else
        {
            visited[curr]=true;
            System.out.println(curr);
            for(int i=0;i<graph[curr].size();i++)
            {
              Edge e=graph[curr].get(i);
              DFS(e.dest,visited);
            }
        }
    }

    // print All Possible Path in Graph src to dest
    public static void printSourceToDestination(int src,int dest)
    {
        System.out.println("All possible path from "+src+" to "+dest+" :");
        boolean visited[]=new boolean[v];
        String path="";
        MDFS(src,dest,visited,path+Integer.toString(src));
    }
    public static void  MDFS(int src,int dest,boolean visited[],String path)
    {
       if(src==dest)
       {
        System.out.println(path);
        return;
       }
       else
       {
        for(int i=0;i<graph[src].size();i++)
            {
              Edge e=graph[src].get(i);
              if(!visited[e.dest])
              {
                visited[src]=true;
              MDFS(e.dest,dest,visited,path+Integer.toString(e.dest));
              visited[src]=false;
              }
            }
       }
    }
    public static void main(String args[]) {
      Graph g=new Graph(7);
      addEdge(0,1,2);
      addEdge(0,2,3);
      addEdge(1,3,5);
      addEdge(2,4,2);
      addEdge(3,4,4);
      addEdge(3,5,5);
      addEdge(4,5,2);
      addEdge(5,6,4);
      addEdge(4,3,4);
      addEdge(1,0,2);
      addEdge(3,1,4);
      addEdge(2,0,4);
      addEdge(6,5,4);
      addEdge(5,4,2);
      addEdge(5,3,2);
      addEdge(3,1,5);
      print();
      System.out.println();
      System.out.println("BFS Implementation:");
      breadthFirstSearch();
      System.out.println();
      System.out.println("DFS Implementation:");
      depthFirstSearch();
      System.out.println();
      printSourceToDestination(0,5);

      
    }
}