package eu.davidsalac.grid;

import java.util.LinkedList;


/**
 * Define a line in a grid
 * @author David Salac <info@davidsalac.eu>
 */
public class Line {
    /**
     * Vertical or horizontal
     */
    LineType lineType;
    
    /**
     * x offset
     */
    double xCoord;
    
    /**
     * x offset
     */
    double yCoord;
    
    /**
     * label of line
     */
    String label;
    
    /**
     * List of nodes on line
     */
    //AVLTreeST<Double, Node> nodes;
    LinkedList<Node> nodes;
    
    /**
     * Get the label
     * @return label 
     */
    String getLabel() {
        return this.label;
    }
    
    /**
     * Return the value of x coordinate
     * @return x-offset 
     */
    public double getXCoord() {
        return this.xCoord;
    }
    
    /**
     * Return the value of y coordinate
     * @return x-offset 
     */
    public double getYCoord() {
        return this.yCoord;
    }
    
    /**
     * Definition of new line
     * @param lineType vertical or horizontal
     * @param coord offset
     * @param label label of the line
     */
    public Line(String label, LineType lineType, double coord) {
        this.lineType = lineType;
        this.label = label;
        //this.nodes = new AVLTreeST<>();
        this.nodes = new LinkedList<>();
        if(lineType == LineType.HORIZONTAL) {
            yCoord = coord;
        }
        else {
            xCoord = coord;
        }
    }
    
    /**
     * Append the node
     * @param node particular node
     */
    public void appendNode(Node node) {
        //Create the sorted linked list
        if(this.lineType == LineType.HORIZONTAL) {
            if (nodes.isEmpty()) {
                nodes.add(node);
            } else if (nodes.get(0).getXIntersect() > node.getXIntersect()) {
                nodes.add(0, node);
            } else if (nodes.get(nodes.size() - 1).getXIntersect() < node.getXIntersect()) {
                nodes.add(nodes.size(), node);
            } else {
                int i = 0;
                while (nodes.get(i).getXIntersect() < node.getXIntersect()) {
                    i++;
                }
                nodes.add(i, node);
            }
        }
        else {
            if (nodes.isEmpty()) {
                nodes.add(node);
            } else if (nodes.get(0).getYIntersect() > node.getYIntersect()) {
                nodes.add(0, node);
            } else if (nodes.get(nodes.size() - 1).getYIntersect() < node.getYIntersect()) {
                nodes.add(nodes.size(), node);
            } else {
                int i = 0;
                while (nodes.get(i).getYIntersect() < node.getYIntersect()) {
                    i++;
                }
                nodes.add(i, node);
            }
        }
        //System.out.println(nodes.size());
        //nodes.insert(new NodeOnLine(node, lineType));
    }
    
    /**
     * Find the nearest left or down node
     * @param node selected node
     * @return nearest node
     */
    public Node getNearest(Node node) {
       // return getNearest(nd, true);
       //return nodes.findLeftMost( lineType == LineType.HORIZONTAL ? nd.getXIntersect() : nd.getYIntersect() );
       if(lineType == LineType.HORIZONTAL) {
            int i = 0;
            while (nodes.get(i).getXIntersect() < node.getXIntersect()) {
                i++;
            }
            if(i == 0) return null;
            return nodes.get(i - 1);
       } 
       else {
            int i = 0;
            while (nodes.get(i).getYIntersect() < node.getYIntersect()) {
                i++;
            }
            if(i == 0) return null;
            return nodes.get(i - 1);
       }
    }
    
    /**
     * Get the type of line
     * @return horizontal / vertical
     */
    public LineType getLineType() {
        return this.lineType;
    }
    
}
