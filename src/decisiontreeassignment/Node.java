package decisiontreeassignment;

public class Node {
    String value;
    Node yes;
    Node no;
    
    public Node (String value) {
        this.value = value;
        this.yes = null; //Left
        this.no = null; //Right
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getYes() {
        return yes;
    }

    public void setYes(Node yes) {
        this.yes = yes;
    }

    public Node getNo() {
        return no;
    }

    public void setNo(Node no) {
        this.no = no;
    }
    
    public boolean isEmpty() {
        return yes == null && no == null;
    }
}
