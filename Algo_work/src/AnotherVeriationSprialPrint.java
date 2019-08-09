
public class AnotherVeriationSprialPrint {
	
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
	        	        
	        int resultArraySize=0;
	                
	                    
	        for (int i=0; i<row; i++)
	        {
	            resultArraySize+=twoDArray[i].length;            
	            
	        }
	        
	        int resultArr[]= new int[resultArraySize ];
	        
	        if (resultArraySize ==1 || row ==1 )
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
	        
	            while(topRow > bottomRow  && leftColumn < rightColum    )
	            {
	                    
	               if(leftColumn < rightColum && k < resultArraySize)
	               {
	                for(col=leftColumn; col< rightColum ; col++)
	                {
	                    
	                    resultArr[k++]=twoDArray[bottomRow][col];        
	                    
	                }
	            
	                bottomRow++;
	               }
	                if(topRow > bottomRow & k < resultArraySize)
	                {
		                for(row=bottomRow; row < topRow ; row++)
		                {
		                    resultArr[k++]=twoDArray[row][rightColum-1];        
		                }
		                rightColum--;
	                }
	                
	                if(leftColumn < rightColum && k < resultArraySize)
	                {
		                for(col=rightColum-1; col >= leftColumn ; col--)
		                {
		                    resultArr[k++]=twoDArray[topRow-1][col];        
		                }
	                                
		                topRow--;
	                }
	                    
	                if(topRow > bottomRow && k < resultArraySize)
	                {
		                for(row=topRow; row > bottomRow ; row--)
		                {
		                    resultArr[k++]=twoDArray[row-1][leftColumn];        
		                }
		                
		                leftColumn++;
		                    
		                
		                }
	            	}
	        }
	        
	        
	        
	        return resultArr;
	}
	
	public static void main(String args[])
	{
		int twoDArray[][]={{0,1,2,3},
				{4,5,6,7},
				{8,9,10,11},
				{12,13,14,15}};
		//output : 0,1,2,3,7,11,15,14,13,12,8,4,5,6,10,9,
		
		int twoDArray2[][]={{0,1,2,3,50},
				{4,5,6,7,60},
				{8,9,10,11,70},
				{12,13,14,15,80}};
		//output : 0,1,2,3,50,60,70,80,15,14,13,12,8,4,5,6,7,11,10,9,
		int twoDArray3[][]={{1,2},
				{3,4},
				{5,6}};
		
	//	sample output : 1,2,4,6,5,3,
		
		int twoDArray4[][]={{1,2}
				
				};
		
		int twoDArray5[][]={{1},
				{2},
				{3}
				};
		
		int twoDArray6[][]={{},
				{1}
				};
		
//		sample output : 1,	
		
		int twoDArray7[][]={{133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
				{401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
				{112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}
				};
		
		
		int arr[]= getSprilValue(twoDArray);
		
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + ",");
		}
	}
}
