package org.example;

public class Vertex {
//   Класс Vertex представляет собой вершину графа.
    private int id;

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
