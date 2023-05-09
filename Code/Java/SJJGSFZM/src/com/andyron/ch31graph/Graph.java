package com.andyron.ch31graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * @author andyron
 **/
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索
     * @param s 起始顶点
     * @param t 终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 记录顶点是否已经被访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // 记录搜索路径。反向存储，prev[w]存储的是，顶点w是从哪个前驱顶点遍历过来的。
        int[] prev = new int[v];
        int w = queue.poll();
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                if (q == t) {
                    print(prev, s, t);
                    return;
                }
                visited[q] = true;
                queue.add(q);
            }
        }

    }
    /**
     * 递归打印s->t路径
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "");
    }

    /**
     * 全局变量或者类成员变量
     * 作用：当已经找到终止顶点 t 之后，就不再递归地继续查找了。
     */
    boolean found = false;

    /**
     * 深度优先搜索
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}