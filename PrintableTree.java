public interface PrintableTree {
    void add(int i);
    String prettyPrint();
    boolean find(int i);
    void remove(int i);

    static PrintableTree getInstance() {
        return new BinarySearchTree();
    }
}