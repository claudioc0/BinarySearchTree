public class Main {

    public static void main(String[] args) {
        PrintableTree tree = PrintableTree.getInstance();

        tree.add(123);
        tree.add(11);
        tree.add(1);
        tree.add(100);
        tree.add(200);
        tree.add(150);
        tree.add(2000);

        System.out.println("Estrutura árvore:");
        System.out.println(tree.prettyPrint());

        // Find nodes
        System.out.println("Procurando 100: " + tree.find(100));
        System.out.println("Procurando 999: " + tree.find(999));


        System.out.println("Removendo 100...");
        tree.remove(100);
        System.out.println("Estrutura árvore:");
        System.out.println(tree.prettyPrint());
    }
}

