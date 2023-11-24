package org.example;

public class Edge {
// Класс Edge представляет собой ребро графа. Он имеет три атрибута: две вершины, которые оно соединяет, и вес ребра.
    private Vertex vertex1;
    private Vertex vertex2;
    private int weight;

    public Edge(Vertex vertex1, Vertex vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", vertex1.getId(), vertex2.getId(), weight);
    }
}