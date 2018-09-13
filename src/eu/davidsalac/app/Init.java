/*
Application for storing of a set of vertical and horizontal lines and defined grids among these lines. 
The purpose of the application is to write nearest neighbour (grid) of each grid on left and down.
*/

package eu.davidsalac.app;


import eu.davidsalac.grid.Grid;
import eu.davidsalac.grid.LineType;

/**
 * Initial class
 * @author David Salac <info@davidsalac.eu>
 */
public class Init {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grid grid = new Grid();
        
        grid.addLine("h1", -1.09, LineType.HORIZONTAL);
        grid.addLine("h2", -2.33, LineType.HORIZONTAL);
        grid.addLine("h3", -3.07, LineType.HORIZONTAL);
        grid.addLine("h4", -4.08, LineType.HORIZONTAL);
        grid.addLine("h5", -5.57, LineType.HORIZONTAL);
        
        grid.addLine("v1", 1.2, LineType.VERTICAL);
        grid.addLine("v2", 2.3, LineType.VERTICAL);
        grid.addLine("v3", 2.5, LineType.VERTICAL);
        grid.addLine("v4", 2.8, LineType.VERTICAL);
        grid.addLine("v5", 3.9, LineType.VERTICAL);
        grid.addLine("v6", 4.1, LineType.VERTICAL);
        grid.addLine("v7", 5.3, LineType.VERTICAL);
        
        grid.addNode("N1", "h1", "v5");
        grid.addNode("N2", "h1", "v7");
        grid.addNode("N3", "h3", "v1");
        grid.addNode("N4", "h3", "v3");
        grid.addNode("N5", "h3", "v4");
        grid.addNode("N6", "h3", "v6");
        grid.addNode("N7", "h4", "v2");
        grid.addNode("N8", "h4", "v4");
        grid.addNode("N9", "h5", "v2");
        grid.addNode("N10", "h5", "v6");
        
        grid.writeNodesAndNeighbour();
        
    }
    
}
