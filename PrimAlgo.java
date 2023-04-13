import java.util.Arrays;

public class PrimAlgo {

  public void Prim(int adjacentyMatrix[][], int nodeCount) {

    char[] nodeNames = {'A', 'B', 'D', 'E', 'F','G', 'H', 'J', 'K', 'L','M', 'N','P', 'Q', 'S', 'T', 'U','X','Y','Z'};
    
    // later compares travel distace < intMax (set intMax to the max integer possible so the first integer thats not 0 is set to the minDistance no matter its size)
    int intMax = Integer.MAX_VALUE;
    
    // number of edges
    int edgeCount;

    // inTree will become true otherwise false
    boolean[] inTree = new boolean[nodeCount];

    // set all inTree [0-19] to false
    Arrays.fill(inTree, false);

    // set number of edge to 0
    edgeCount = 0;

    // inTree[0] ( node A ) will be the starting node in the algorithm. Therefore set to true
    inTree[0] = true;

    // Sums the distance for output format
    int sum = 0;

    // Starts the output format
    System.out.print("A (0), ");
    
    // number of edges will always be nodeCount - 1 (first and last won't connect)
    while (edgeCount < nodeCount - 1) {

      int minDistance = intMax;

      // row
      int currentNode = 0;

      // column
      int nextNode = 0;

      for (int i = 0; i < nodeCount; i++) {
        if (inTree[i] == true) {
          for (int j = 0; j < nodeCount; j++) {

            // if [j] is in inTree dont check it for an edge (already in the tree dont transverse | would create a loop / circle )
            // && checks skips if [i][j] = 0 (no edge between those nodes)
            if (!inTree[j] && adjacentyMatrix[i][j] != 0) {
            
              // > and not >= will maintain alphabetical precedence when path distance is the same
              if (minDistance > adjacentyMatrix[i][j]) {
                minDistance = adjacentyMatrix[i][j];

                // saves currentNode -> nextNode as the current shortest path (last update of the variables will be the shortest next path)
                currentNode = i;
                nextNode = j;
              }
            }
          }
        }
      }

      sum = sum + adjacentyMatrix[currentNode][nextNode];
      
      System.out.print(nodeNames[nextNode] + " " + "(" + (sum) + "), ");

      //adds next node to inTree (false -> true)
      inTree[nextNode] = true;

      edgeCount++;
    }
  }

  public static void main(String[] args) {

    PrimAlgo prim = new PrimAlgo();

    int nodeCount = 20;
  
    int[][] adjacentyMatrix = { { 0,5,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0 },
        { 5,0,0,0,0,0,0,0,0,0,0,0,0,4,2,0,0,0,0,0 },
        { 0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,10,0,0,4,0 },
        { 0,0,0,0,0,0,5,0,0,18,0,0,11,0,0,0,0,0,0,2 },
        { 0,0,0,0,0,0,0,0,0,0,11,0,0,0,0,0,0,2,0,0 },
        { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,6,0,0,0 },
        { 0,0,0,5,0,0,0,15,0,0,0,0,0,11,13,0,0,0,0,0 },
        { 0,0,3,0,0,0,15,0,5,0,0,0,10,0,0,0,0,0,0,0 },
        { 0,0,0,0,0,0,0,5,0,0,0,0,0,0,1,0,0,0,2,0 },
        { 0,0,0,18,0,0,0,0,0,0,8,0,0,0,0,0,8,0,0,0 },
        { 0,0,0,0,11,0,0,0,0,8,0,0,0,0,0,0,0,0,0,2 },
        { 5,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,2,0,0 },
        { 0,0,0,11,0,0,0,10,0,0,0,0,0,0,0,6,30,0,0,0 },
        { 0,4,0,0,0,0,11,0,0,0,0,2,0,0,0,0,0,0,0,2 },
        { 0,2,0,0,0,0,13,0,1,0,0,0,0,0,0,0,0,0,0,0 },
        { 0,0,10,0,0,16,0,0,0,0,0,0,6,0,0,0,0,0,0,0 },
        { 0,0,0,0,0,6,0,0,0,8,0,0,30,0,0,0,0,0,0,0 },
        { 0,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2 },
        { 0,0,4,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0 },		   
        { 0,0,0,2,0,0,0,0,0,0,2,0,0,2,0,0,0,2,0,0 } };

    prim.Prim(adjacentyMatrix, nodeCount);
    
  }
}