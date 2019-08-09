
public class CorrectSprialPrint {
	
	//print in spirial order

	static int[] getSprilValue(int twoDArray[][])
	{
		
		 int row = twoDArray.length;
	        int col = twoDArray[0].length;
	        
	        int topRow=row;
	        int rightColum=col;
	        int leftColumn=0;
	        int bottomRow=0;
	        int k=0;
	        boolean status=true;
	        
	        int resultArraySize=0;
	                
	                    
	        for (int i=0; i<row; i++)
	        {
	            resultArraySize+=twoDArray[i].length;            
	            
	        }
	        
	        int resultArr[]= new int[resultArraySize ];
	        
	        if (resultArraySize ==1)
	        {
	            for (int i=0; i<row; i++)
	            {
	                for (int j=0; j<twoDArray[i].length; j++)
	                    resultArr[k++]=twoDArray[i][j]   ;         
	                
	            }
	            return resultArr;
	        }
	             
	        
	        
	        
	     //   System.out.println("resultArr :"+ resultArr.length);
	        
	        
	        if(resultArr.length>0)
	        {
	        
	            while(topRow>bottomRow && leftColumn < rightColum)
	            {
	                    
	                
	                for(col=leftColumn; col< rightColum ; col++)
	                {
	                    
	                    resultArr[k++]=twoDArray[topRow-1][col];        
	                    
	                }
	            
	                topRow--;
	                
	                for(row=topRow-1; row >= bottomRow ; row--)
	                {
	                    resultArr[k++]=twoDArray[row][rightColum-1];        
	                }
	                rightColum--;
	                    
	                for(col=rightColum-1; col >= leftColumn ; col--)
	                {
	                    resultArr[k++]=twoDArray[bottomRow][col];        
	                }
	                
	                                
	                bottomRow++;
	                    
	                for(row=bottomRow; row <topRow ; row++)
	                {
	                    resultArr[k++]=twoDArray[row][leftColumn];        
	                }
	                
	                leftColumn++;
	                    
	                
	                }
	        }
	        
	        
	        
	        return resultArr;
	}
	
	public static void main(String args[])
	{
		int twoDArray1[][]={{0,1,2,3},
				{4,5,6,7},
				{8,9,10,11},
				{12,13,14,15}};
		
		
		int twoDArray2[][]={{0,1,2,3,50},
				{4,5,6,7,60},
				{8,9,10,11,70},
				{12,13,14,15,80}};
		
		int twoDArray[][]={{1,2},
				{3,4},
				{5,6}};
		
	//	sample output : 12,13,14,15,80,70,60,50,3,2,1,0,4,5,6,7,11,10,9,8,
		
		
		int twoDArray3[][]={{},
				{1}
				};
		
		
		int arr[]= getSprilValue(twoDArray);
		
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + ",");
		}
	}
}
