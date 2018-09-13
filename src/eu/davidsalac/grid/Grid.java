package eu.davidsalac.grid;

import java.util.HashMap;

/**
 * Define a grid of lines
 * @author David Salac <info@davidsalac.eu>
 */
public class Grid {
    /**
     * List of lines
     */
    HashMap<String, Line> lines;
    
    /**
     * List of nodes
     */
    HashMap<String, Node> nodes;
    
    
    public Grid() {
        lines = new HashMap<>();
        nodes = new HashMap<>();
    }
    
    /**
     * Add new line in the grid
     * @param line new line
     */
    public void addLine(Line line) {
        lines.put(line.getLabel(),line);
    }
    
    /**
     * Add new line to grid
     * @param label label of line
     * @param coord coordinate of line
     * @param type type of line
     */
    public void addLine(String label, double coord, LineType type) {
        lines.put(label, new Line(label, type, coord));
    }
    
    /**
     * Add new node in grid
     * @param node new node
     */
    public void addNode(Node node) {
        node.getHorizontal().appendNode(node);
        node.getVertical().appendNode(node);
        nodes.put(node.getLabel(), node);
    }
    
    /**
     * Add new node in grid
     * @param horizontalLine label of horizontal lane
     * @param verticalLine label of vertical line
     * @param label label of the node
     */
    public void addNode(String label, String horizontalLine, String verticalLine) {
        Node node = new Node(label, lines.get(horizontalLine), lines.get(verticalLine));
        node.getHorizontal().appendNode(node);
        node.getVertical().appendNode(node);
        nodes.put(label, node);
    }
    
    /**
     * Get concrete node
     * @param label label of node
     * @return concrete node
     */
    public Node getNode(String label) {
        return nodes.get(label);
    }
    
    /**
     * Get concrete line
     * @param label label of line
     * @return the line
     */
    public Line getLine(String label) {
        return lines.get(label);
    }
    
    /**
     * Write each node and it's adjacent nodes
     */
    public void writeNodesAndNeighbour() {
        nodes.forEach(
            (k, nd) -> {
                System.out.print("NODE: " + nd + " (x: " + nd.getXIntersect()  +", y: " + nd.getYIntersect()  +"), ");
                System.out.print("left naighbour: ");
                Node left = nd.getHorizontal().getNearest(nd);
                if(left != null) {
                    double dist = left.orthogonalDistance(nd);
                    System.out.print(left + " (distance: " + dist + "),");
                }
                else {
                    System.out.print("NONE,");
                }

                Node down = nd.getVertical().getNearest(nd);
                System.out.print(" down naighbour: ");
                if(down != null) {
                    double dist = down.orthogonalDistance(nd);
                    System.out.print(down + " (distance: " + dist + ")");
                }
                else {
                    System.out.print("NONE");
                }
                System.out.println(";");
            } 
        );
    }

}
