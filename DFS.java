class GFG
{
  static int row = 20;
  static int column = 20;
  static char letter(int a)
  {
    if(a == 0)
    {
      return 'A';
    }
    else if(a == 1)
    {
      return 'B';
    }
    else if(a == 2)
    {
      return 'S';
    }
    else if(a == 3)
    {
      return 'K';
    }
    else if(a == 4)
    {
      return 'Y';
    }
    else if(a == 5)
    {
      return 'N';
    }
    else if(a == 6)
    {
      return 'Q';
    }
    else if(a == 7)
    {
      return 'H';
    }
    else if(a == 8)
    {
      return 'J';
    }
    else if(a == 9)
    {
      return 'D';
    }
    else if(a == 10)
    {
      return 'X';
    }    
    else if(a == 11)
    {
      return 'Z';
    }    
    else if(a == 12)
    {
      return 'E';
    }    
    else if(a == 13)
    {
      return 'P';
    }    
    else if(a == 14)
    {
      return 'T';
    }    
    else if(a == 15)
    {
      return 'F';
    }    
    else if(a == 16)
    {
      return 'M';
    }
    else if(a == 17)
    {
      return 'L';
    }  
    else if(a == 18)
    {
      return 'U';
    }
    else if(a == 19)
    {
      return 'G';
    }  
    else
    {
      return 'A';
    }
  }
    static int linearSearch(int grid[][], int grid_col, int target)
  {
    int found_target = -1;
    for(int i = 0; i < row; i++)
    {
      if(grid[grid_col][i] == target)
      {
        found_target = i;
      }
    }
    System.out.println(found_target);
    return found_target;
  }
  static int linearSearch(int grid[][], int grid_col, int target, int start)
  {
    int found_target = -1;
    for(int i = start; i < row; i++)
    {
      if(grid[grid_col][i] == target)
      {
        found_target = i;
      }
    }
    System.out.println(found_target);
    return found_target;
  }
  static Boolean isValid(Boolean visit[],int grid_col)
  {
    //Checking to make sure the call isn't out of bounds
    if (row < 0 || column < 0 || grid_col >= column)
    {
      return false;
    }
    //Checking to see if that cell has already been visited
    if (visit[grid_col])
    {
      return false;
    }

// Can visit if it is not out of bounds and has been visited
    return true;
  }
  static int optimalPath(int grid[][], Boolean visit[], int grid_col)
  {
    int lowest_distance = 10000;
    int lowest_distance_index = 0;
    for(int i = 0; i < row; i++)
    {
      if(grid[grid_col][i] < lowest_distance && grid[grid_col][i] != 0)
      {
        lowest_distance = grid[grid_col][i];
        lowest_distance_index = i;
      } 
    }
    System.out.println(letter(lowest_distance_index) + "(" + lowest_distance + ")");
    return lowest_distance;
  }
  static int pathing(int grid[][], Boolean visit[], int start_point)
  {
    int target = optimalPath(grid, visit, start_point);
    return linearSearch(grid, start_point, target);
  }
static void build_DFS(int grid[][], Boolean visit[], int start_point)
  {
  System.out.println(letter(start_point) + "(0)");
    int counter = 20;
    int total_distance = 0;
    while(counter != 0)
    {
      start_point = pathing(grid, visit, start_point);
      counter--;
    }
  }
  public static void main(String[] args)
  {
    int matrix[][] = { { 0,5,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0 },
                    { 5,0,2,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0 },
                    { 0,2,0,1,0,0,0,13,0,0,0,0,0,0,0,0,0,0,0,0 },
                    { 0,0,1,0,2,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0 },
                    { 0,0,0,2,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0 },
                    { 5,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,0 },
                    { 0,4,0,0,0,2,0,11,0,0,0,2,0,0,0,0,0,0,0,0 },
                    { 0,0,13,0,0,0,11,0,15,0,3,0,10,0,0,0,0,0,0,0 },
                    { 0,0,0,5,0,0,0,15,0,3,0,0,0,0,0,0,0,0,0,0 },
                    { 0,0,0,0,4,0,0,0,3,0,0,0,0,0,10,0,0,0,0,0 },
                    { 0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,2,0,0,0,0 },
                    { 0,0,0,0,0,0,2,0,0,0,2,0,2,0,0,0,2,0,0,0 },
                    { 0,0,0,0,0,0,0,5,0,0,0,2,0,11,0,0,0,18,0,0 },
                    { 0,0,0,0,0,0,0,0,10,0,0,0,11,0,6,0,0,0,30,0 },
                    { 0,0,0,0,0,0,0,0,0,10,0,0,0,6,0,0,0,0,0,16 },
                    { 0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,11,0,0,0 },
                    { 0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,11,0,8,0,0 },
                    { 0,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0,8,0,8,0 },
                    { 0,0,0,0,0,0,0,0,0,0,0,0,0,30,0,0,0,8,0,6 },     
                    { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,6,0 } }; 
    Boolean visited[] = new Boolean[column];
      for(int i = 0; i < column; i++)
      {
        visited[i] = false;
      }
      build_DFS(matrix, visited, 0);
    
  }
}