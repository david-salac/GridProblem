package eu.davidsalac.grid;

/**
 * The node on line
 * @author David Salac <info@davidsalac.eu>
 */
public class Node {
    /**
     * The horizontal line of node
     */
    Line horizontal;
    /**
     * The vertical line of node
     */
    Line vertical;
    /**
     * Label of node
     */
    String label;

    /**
     * Create new instance
     * @param label label of node
     * @param horizontal horizontal line of node
     * @param vertical vertical line of node
     */
    public Node(String label, Line horizontal, Line vertical) {
        if(horizontal.getLineType() != LineType.HORIZONTAL) {
            throw new IllegalArgumentException("The vertical line instead of horizontal line.");
        }
        if(vertical.getLineType() != LineType.VERTICAL) {
            throw new IllegalArgumentException("The horizontal line instead of vertical line.");
        }
        this.label = label;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    
    /**
     * Get the label of line
     * @return label
     */
    public String getLabel() {
        return this.label;
    }
    
    /**
     * Get the horizontal line
     * @return horizontal line 
     */
    public Line getHorizontal() {
        return this.horizontal;
    }
    
    
    /**
     * Get the vertical line
     * @return vertical line 
     */
    public Line getVertical() {
        return this.vertical;
    }
    
    /**
     * Vertical coordinate of intersect
     * @return x coordinate  
     */
    public double getXIntersect() {
        return this.vertical.getXCoord();
    }
    
    /**
     * Horizontal coordinate of intersect
     * @return y coordinate  
     */
    public double getYIntersect() {
        return this.horizontal.getYCoord();
    }
    
    /**
     * Get the label of node
     * @return label of node
     */
    @Override
    public String toString() {
        return this.label;
    }
    
    /**
     * Find orthogonal distance between two nods
     * @param nd node
     * @return orthogonal distance
     */
    public double orthogonalDistance(Node nd) {
        return Math.abs(nd.getXIntersect() - this.getXIntersect()) + Math.abs(nd.getYIntersect() - this.getYIntersect());
    }
    
}
