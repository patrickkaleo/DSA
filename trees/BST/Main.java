
public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n[DSA in JAVA] -> The code is correctly set up and ready to run. STARTING...\n\n");

        // tests go here
        StringBuilder depthSb = new StringBuilder();
        StringBuilder heightSb = new StringBuilder();

        BinarySearchTree<Integer> BST = new BinarySearchTree<>();

        //HEIHGT of EMPTY TREE
        heightSb.append("Height of TREE: ").append(BST.getHeight());
        System.out.println(heightSb.toString());
        Node<Integer> abitraryNode = new Node<>(73);
        // empty tree
        BST.print();
        depthSb.append("Depth of null => ").append(BST.getDepth(null));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("Depth of [").append(abitraryNode.getData()).append("] => ").append(BST.getDepth(null));
        System.out.println(depthSb.toString());


        Node<Integer> root = BST.insert(60);
        heightSb.setLength(0); //reset
        heightSb.append("TREE HEIGHT: ").append(BST.getHeight());
        System.out.println(heightSb.toString());
        BST.print(); // one node inserted into the tree
        // INSERT NODES INTO THE TREE
        Node<Integer> n1 = BST.insert(80);

        //TREE HEIGHT PROGRESSION
        heightSb.setLength(0); //reset
        heightSb.append("TREE HEIGHT: ").append(BST.getHeight());
        System.out.println(heightSb.toString());

        Node<Integer> n2 = BST.insert(70);
        //TREE HEIGHT PROGRESSION
        heightSb.setLength(0); //reset
        heightSb.append("TREE HEIGHT: ").append(BST.getHeight());
        System.out.println(heightSb.toString());


        Node<Integer> n3 = BST.insert(5);
        //TREE HEIGHT PROGRESSION
        heightSb.setLength(0); //reset
        heightSb.append("TREE HEIGHT: ").append(BST.getHeight());
        System.out.println(heightSb.toString());


        Node<Integer> n4 = BST.insert(4);
        Node<Integer> n5 = BST.insert(10);
        Node<Integer> n6 = BST.insert(90);
        Node<Integer> n7 = BST.insert(7);
        Node<Integer> n8 = BST.insert(11);
        Node<Integer> n9 = BST.insert(100);
        Node<Integer> n10 = BST.insert(102);
        //TREE HEIGHT PROGRESSION
        heightSb.setLength(0); //reset
        heightSb.append("TREE HEIGHT: ").append(BST.getHeight());
        System.out.println(heightSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("Depth of [").append(abitraryNode.getData()).append("] ( Tree not empty ) => ").append(BST.getDepth(null)); //-1 coz 73 aint in there
        System.out.println(depthSb.toString()); //after some node have been ionerted and the tree is not null empty enymore

        // DEPTH OF NODE
        depthSb.setLength(0); //reset 
        depthSb.append("\nDepth of n1: ").append(BST.getDepth(n1));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("\nRoot depth: ").append(BST.getDepth(root));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n2.getData()).append("] =>  ").append(BST.getDepth(n2));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n3.getData()).append("] =>  ").append(BST.getDepth(n3));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n4.getData()).append("] =>  ").append(BST.getDepth(n4));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n5.getData()).append("] =>  ").append(BST.getDepth(n5));
        System.out.println(depthSb.toString());

        depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n6.getData()).append("] =>  ").append(BST.getDepth(n6));
        System.out.println(depthSb.toString());

         depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n7.getData()).append("] =>  ").append(BST.getDepth(n7));
        System.out.println(depthSb.toString());

         depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n8.getData()).append("] =>  ").append(BST.getDepth(n8));
        System.out.println(depthSb.toString());

         depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n9.getData()).append("] =>  ").append(BST.getDepth(n9));
        System.out.println(depthSb.toString());

         depthSb.setLength(0); //reset
        depthSb.append("\ndepth of [").append(n10.getData()).append("] =>  ").append(BST.getDepth(n10));
        System.out.println(depthSb.toString());

       


        BST.print();

        System.out.println(BST.BFS());

        BST.print();

        System.out.println(BST.DFSPreorder());
        System.out.println(BST.DFSInorder());
        System.out.println(BST.DFSPostorder());
        BST.print();

        System.out.println("\n\n[DSA in JAVA] -> END OF PROGRAM\n\n");

    }
}