/*
 * Copyright 2024 Aditya Ranjan Sahoo <adityaen.official101@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
import java.util.*;
class Edge implements Comparable<Edge>{
    int weight,src,dest;
    public int compareTo(Edge compare){
       return this.weight-compare.weight;
    }
}
class Subsets{
    int parent, rank;
}
public class MinSpanTree_Kruskal {
    int vertices,edges;
    Edge[] edge;
    MinSpanTree_Kruskal(int vertices, int edges){
        edge=new Edge[edges];
        this.vertices=vertices;
        this.edges=edges;
        //Data Population to prevent NullPointerException
        for(int i=0;i<edges;i++){
            edge[i]=new Edge();
        }
    }
    public static int find(Subsets[] s_set, int i){
        if(s_set[i].parent!=i){
            s_set[i].parent=find(s_set,s_set[i].parent);
        }
        return s_set[i].parent;
    }
    void union(Subsets[] s_set,int x, int y){
        int xroot=find(s_set,x);
        int yroot=find(s_set,y);
        if (s_set[xroot].rank < s_set[yroot].rank)
            s_set[xroot].parent = yroot;
        else if (s_set[xroot].rank > s_set[yroot].rank)
            s_set[yroot].parent = xroot;
        else {
            s_set[yroot].parent = xroot;
            s_set[xroot].rank++;
        }
        
    }
    void KruskalMST(){
        Edge[] result=new Edge[vertices];
        int i=0,e=0;
        for(;i<vertices;i++){
            result[i]=new Edge();
        }
        Arrays.sort(result);
        Subsets[] subset=new Subsets[vertices];
        for(i=0;i<vertices;i++){
            subset[i]=new Subsets();
        }
        for(int v=0;v<vertices;v++){
            subset[v].parent=v;
            subset[v].rank=0;
        }
        i=0;
        while(e<vertices-1){
            Edge next=edge[i++];
             int x = find(subset, next.src);
            int y = find(subset, next.dest);

            if (x != y) {
                result[e++] = next;
                union(subset, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -->" + result[i].dest + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }
            
            
     public static void main(String[] args){
         int vertices=4,edges=5;
         MinSpanTree_Kruskal graph=new MinSpanTree_Kruskal(vertices,edges);
         graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }
}
     
