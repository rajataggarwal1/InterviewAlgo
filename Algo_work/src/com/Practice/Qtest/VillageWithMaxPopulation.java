package com.Practice.Qtest;

/* 
 * Matrix problem
 * number present a tribe id. Each group with the same id and next to each other
 *  (vertical of horizontal and not diagonal) live in the same village. Different id
 *   villagers live in different village. Which village has the max population. Same id
 *    villagers with different id between them live in different village
 * 
 * Find the village with max population 
 * 
 * 
 * */


public class VillageWithMaxPopulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VillageWithMaxPopulation village=new VillageWithMaxPopulation();
		
		int[][] vill= {
				{1,1,2,2,3,3,4,4,4,4},
				{1,1,2,3,3,3,4,4,4,4},
				{2,4,4,3,3,5,5,4,4,1},
				{2,5,5,3,3,5,5,4,1,1},
				{2,5,5,3,3,5,5,4,1,1}
				
		};
		
		//System.out.println(village.findMaxPopulationVillage(vill));
		
		int[][] arr2= {
				{1,1,2},
				{1,1,2},
				{3,4,4}			
		};
		
		System.out.println(village.findMaxPopulationVillage(arr2));
		
	}
	
	public int population=-1;
	public int findMaxPopulationVillage(int vill[][])
	{
		
		int visited[][]=new int[vill.length][vill[0].length];
		
		for(int i=0; i< vill.length; i++)
		{
			
			for(int j=0; j< vill[0].length; j++)
			{
				
				if(visited[i][j]==-1)
				{
					continue;
				}
				
				visited[i][j]=-1;
				int villagePopulation=findMaxPopulationVillageHelper(vill, visited, i, j , 1);
				
				
				if(population < villagePopulation)
				{
					population=villagePopulation;
				}
				
			}
			
			
			
			
		}
		
		return population;
		
		
	}
	
	
	public int findMaxPopulationVillageHelper(int vill[][],int visited[][], int row, int col, int populationSoFar)
	{
		
			
		if(row-1 >=0 && vill[row-1][col] == vill[row][col] )
		{
			if(visited[row-1][col]!=-1)
			{
				visited[row-1][col]=-1;
				populationSoFar=findMaxPopulationVillageHelper(vill,visited,row-1,col,populationSoFar+1);
			}
			
		}
		
		if(row+1 <= vill.length-1 && vill[row+1][col] == vill[row][col])
		{
			if(visited[row+1][col]!=-1)
			{
				visited[row+1][col]=-1;
				populationSoFar=findMaxPopulationVillageHelper(vill,visited,row+1,col,populationSoFar+1);
			}
		}
		
		if(col-1 >= 0 && vill[row][col-1] == vill[row][col])
		{
			if(visited[row][col-1]!=-1)
			{
				visited[row][col-1]=-1;
				populationSoFar=findMaxPopulationVillageHelper(vill,visited,row,col-1,populationSoFar+1);
			}
		}
		
		if(col+1 <= vill[0].length-1 && vill[row][col+1] == vill[row][col])
		{
			if(visited[row][col+1]!=-1)
			{
				visited[row][col+1]=-1;
				populationSoFar=findMaxPopulationVillageHelper(vill,visited,row,col+1,populationSoFar+1);
			}
		}
		
		return populationSoFar;
		
	}

}
