public class AdjMatrix {
    public int adjMatrix[][];
    private int numVertices;

    /**
     *
     * @param numVertices amount of family members
     */
    public AdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int [numVertices][numVertices];
    }

    /**
     *
     * @param i Parent (from)index
     * @param j Child (to)index
     */
    public void addEdge(int i, int j) {
        adjMatrix[i][j]= 1;
        adjMatrix[j][i] = 1;

    }

    /**
     *
     * @return formatting for printing adjacency matrix
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : adjMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
