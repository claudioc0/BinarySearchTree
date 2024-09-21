public class BinarySearchTree implements PrintableTree {
    private static class Node {
        private int data;
        private Node left = null;
        private Node right = null;

        public Node(int data) {
            this.data = data;
        }

        public int getSize() {
            return Integer.toString(data).length();
        }
    }

    private Node root = null;
    private StringBuilder mainSB = new StringBuilder();

    @Override
    public void add(int i) {
        root = add(root, i);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (value < node.data) {
            node.left = add(node.left, value);
        } else {
            node.right = add(node.right, value);
        }
        return node;
    }

    @Override
    public boolean find(int i) {
        return find(root, i);
    }

    private boolean find(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.data) {
            return true;
        }
        return value < node.data ? find(node.left, value) : find(node.right, value);
    }

    @Override
    public void remove(int i) {
        root = remove(root, i);
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.data) {
            node.left = remove(node.left, value);
        } else if (value > node.data) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }


            node.data = minValue(node.right);
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    private int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    @Override
    public String prettyPrint() {
        mainSB.setLength(0); 
        printTree(root, 0, false);
        return mainSB.toString();
    }

    private void printTree(Node node, int space, boolean isRight) {
        if (node == null) return;

        space += node.getSize() + 1;

        printTree(node.right, space, true);

        if (node == root) {
            mainSB.append(" ".repeat(Math.max(0, space - node.getSize() - 1)));
            mainSB.append(node.data).append("\n");
        } else {
            mainSB.append(" ".repeat(Math.max(0, space - node.getSize() - 1)));
            mainSB.append(isRight ? "┌" : "└").append(node.data).append("\n");
        }

        printTree(node.left, space, false);
    }
}