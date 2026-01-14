package h1;

public class H1_main {

    private static int counter;

    public static void main(String[] args) {

        //Node Chain
        /*
        Node e = new Node(null);
        Node d = new Node(e);
        Node c = new Node(d);
        Node b = new Node(c);
        Node a = new Node(b);
         */
        //Print distance between x and y
        //System.out.println(distance(a, d));
    }

    public static int distance(Node x, Node y) {
        if(x == y) {
            return 0;
        }
        else if(x.next == y) {
            return counter++;
        }
        else {
            counter++;
            distance(x.next, y);
        }
        return counter;
    }
}
