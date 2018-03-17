package decisiontreeassignment;

import java.util.ArrayList;

public class DecisionTreeAssignment {

    private static Node root;
    private static Node subtree;
    
    public DecisionTreeAssignment() {
        //Nodes
        Node n0 = new Node("Hand ins made in time");
        Node n1 = new Node("You could easily fail the exam");
        Node n2 = new Node("Attend lectures");
        Node n3 = new Node("Read textbook");
        Node n4 = new Node("Make exercises");
        Node n5 = new Node("You should be able to pass the exam");
        
        root = n0;
        root.setNo(n1);
        root.setYes(n3);
        root.getYes().setNo(n2);
        root.getYes().getNo().setNo(n1);
        root.getYes().getNo().setYes(n5);
        root.getYes().setYes(n2);
        root.getYes().getYes().setNo(n4);
        root.getYes().getYes().getNo().setNo(n1);
        root.getYes().getYes().getNo().setYes(n5);
        root.getYes().getYes().setYes(n5);
    }
    
    public String getValue(int[] arr) {
        subtree = root;
        for (int num : arr) {
            if (subtree.isEmpty()){
                return subtree.getValue();
            } else if (num == 0) {
                subtree = subtree.getNo();
            } else {
                subtree = subtree.getYes();
            }
        }
        return subtree.getValue();
    }
    
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList();
        DecisionTreeAssignment dta = new DecisionTreeAssignment();
        
        //Fails the exam because student made no hand ins.
        list.add(new int[] {0, 1, 1, 1});
        
        //Fails the exam because student didn't attend the lectures
        //and read the textbook
        list.add(new int[] {1, 0, 0, 0});
        
        //Fails the exam because student didn't attend the lectures
        //and make the exercises
        list.add(new int[] {1, 1, 0, 0});
        
        //Passes to attend and read textbook, but not to make exercises
        list.add(new int[] {1, 0, 1 ,0});
        
        //Passes to attend and make exercises, but not to read textbook
        list.add(new int[] {1, 0, 0, 1});
        
        //Perfect student passes everything
        list.add(new int[] {1, 1, 1, 1});
        
        //print out the values
        list.forEach((arr) -> {
            System.out.println(dta.getValue(arr) + "\n");
        });
    }
}
