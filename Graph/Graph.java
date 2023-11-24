package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Graph {

    private int numVertices;
    private int numEdges;
    private boolean directed;

    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        this(false);
    }

    public Graph(boolean directed) {
        this.numVertices = 0;
        this.numEdges = 0;
        this.directed = directed;

        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    // Загрузка данных о графе из текстового файла

    public void loadFromFile(String filename, boolean asMatrix) throws IOException {
        Scanner scanner = new Scanner(new File(filename));

        if (asMatrix) {
            loadMatrixFromFile(scanner);
        } else {
            loadEdgesFromFile(scanner);
        }

        scanner.close();
    }

    public void loadMatrixFromFile(Scanner scanner) throws IOException {
        this.numVertices = scanner.nextInt();

        // Создаем матрицу смежности
        int[][] adjacencyMatrix = new int[this.numVertices][this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        this.vertices = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            this.vertices.add(new Vertex(i));
        }

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    this.addEdge(this.vertices.get(i), this.vertices.get(j), adjacencyMatrix[i][j]);
                }
            }
        }
    }

    private void loadEdgesFromFile(Scanner scanner) throws IOException {
        this.numVertices = scanner.nextInt();
        this.numEdges = scanner.nextInt();

        // Создаем список ребер
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < this.numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int weight = scanner.nextInt();

            edges.add(new Edge(this.vertices.get(vertex1), this.vertices.get(vertex2), weight));
        }

        this.edges = edges;
    }

    // Сохранение графа в текстовый файл

    public void saveToFile(String filename, boolean asMatrix) throws IOException {
        PrintWriter writer = new PrintWriter(new File(filename));

        if (asMatrix) {
            saveMatrixToFile(writer);
        } else {
            saveEdgesToFile(writer);
        }

        writer.close();
    }

    public int getNumVertices() {
        return this.numVertices;
    }

// Количество ребер

    public int getNumEdges() {
        return this.numEdges;
    }

    public void saveMatrixToFile(PrintWriter writer) {
        writer.println(this.numVertices);

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                if (this.directed) {
                    writer.print(this.getEdgeWeight(this.vertices.get(i), this.vertices.get(j)));
                } else {
                    writer.print(this.getEdgeWeight(this.vertices.get(i), this.vertices.get(j))
                            + " "
                            + this.getEdgeWeight(this.vertices.get(j), this.vertices.get(i)));
                }
                writer.print(" ");
            }
            writer.println();
        }
    }

    private void saveEdgesToFile(PrintWriter writer) {
        writer.println(this.numVertices);
        writer.println(this.numEdges);

        for (Edge edge : this.edges) {
            writer.println(edge.getVertex1().getId() + " " + edge.getVertex2().getId() + " " + edge.getWeight());
        }
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, int weight) {
        if (!this.vertices.contains(vertex1)) {
            this.vertices.add(vertex1);
        }

        if (!this.vertices.contains(vertex2)) {
            this.vertices.add(vertex2);
        }

        for (Edge edge : this.edges) {
            if (edge.getVertex1() == vertex1 && edge.getVertex2() == vertex2) {
                return;
            }
        }

        this.edges.add(new Edge(vertex1, vertex2, weight));
        this.numEdges++;
    }

    public void removeVertex(Vertex vertex) {
        // Удаляем вершину из списка вершин
        this.vertices.remove(vertex);

        // Удаляем все ребра, исходящие из этой вершины
        for (Edge edge : this.edges) {
            if (edge.getVertex1() == vertex) {
                this.edges.remove(edge);
            }
        }

        // Удаляем все ребра, входящие в эту вершину
        for (Edge edge : this.edges) {
            if (edge.getVertex2() == vertex) {
                this.edges.remove(edge);
            }
        }

        // Уменьшаем количество вершин
        this.numVertices--;
    }

    // Добавление вершины в граф

    public void addVertex(Vertex vertex) {
        if (!this.vertices.contains(vertex)) {
            this.vertices.add(vertex);
            this.numVertices++;
        }
    }

// Получение веса ребра

    public int getEdgeWeight(Vertex vertex1, Vertex vertex2) {
        for (Edge edge : this.edges) {
            if (edge.getVertex1() == vertex1 && edge.getVertex2() == vertex2) {
                return edge.getWeight();
            }
        }

        return 0;
    }
}