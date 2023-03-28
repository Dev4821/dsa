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
    
    public static void addEdge(int src,int dest, int weight)
    {
        Edge e=new Edge(src,dest,weight);
         
       graph[src].add(e);
       
    }
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
    public static void main(String args[]) {
      Graph g=new Graph(5);
      addEdge(0,1,2);
      addEdge(1,2,3);
      addEdge(2,3,5);
      addEdge(3,4,2);
      addEdge(2,4,4);
      print();
      
    }
}