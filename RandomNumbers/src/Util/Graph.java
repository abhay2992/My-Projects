/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;

/**
 *
 * @author Abhay
 */
public class Graph {
    
    int v;
    ArrayList<Integer> adj[];
    
    Graph(int v)
    {
        this.v=v;
        adj=new ArrayList[v];
        
        for(int i=0; i<v; i++)
        {
            adj[i]=new ArrayList();
        }
    }
    
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    
    void bfs(int x)
    {
        boolean visited[]=new boolean[v];
        
        visited[x]=true;
        ArrayList<Integer> a=new ArrayList<>();
        a.add(x);
        
        while(!a.isEmpty())
        {
            x=a.remove(0);
            System.out.println(x);
            
            for(int i=0; i<adj[x].size();i++)
            {
                int s=adj[x].get(i);
                if(!visited[s])
                {
                    visited[s]=true;
                    a.add(s);
                }
            }
        }
    }
    
    void dfs(int x)
    {
        boolean visited[]=new boolean[v];
        
        dfsUtil(x,visited);
    }
    
    void dfsUtil(int x, boolean visited[])
    {
        visited [x]=true;
        System.out.println(x);
        
        for(int i=0; i<adj[x].size(); i++)
        {
            int s=adj[x].get(i);
            if(!visited[s])
            {
                dfsUtil(s, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g=new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
//        g.bfs(2);
        g.dfs(2);
    }
}
