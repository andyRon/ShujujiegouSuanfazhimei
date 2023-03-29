package com.andyron.ch44;

import java.util.LinkedList;

/**
 * 有向有权图的邻接表表示
 * @author andyron
 **/
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;
    /**
     * 领接表
     */
    private LinkedList<Edge> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(s, t, w));
    }
}

class Edge {
    /**
     * 边的起始顶点编号
     */
    public int sid;
    /**
     * 边的终止顶点编号
     */
    public int tid;
    /**
     * 权重
     */
    public int w;

    public Edge(int sid, int tid, int w) {
        this.sid = sid;
        this.tid = tid;
        this.w = w;
    }
}

class Vertex {
    public int id;
    public int dist;

    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}