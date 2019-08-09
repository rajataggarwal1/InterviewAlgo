
public class SprilPrint {
	
	//print in spirial order

	static int[] getSprilValue(int twoDArray[][])
	{
		
		int row = twoDArray.length;
    	int col = twoDArray[0].length;
    	
    	
    	System.out.println("twoDArray.length :"+ twoDArray.length);
    	System.out.println("twoDArray[0].length :"+ twoDArray[0].length);
		
    	int resultArraySize=0;
    			if(row>0 && col>0)
    				resultArraySize= row*col;
    			else if(col==0)
    			{
    				resultArraySize= row;
    			}
    			else
    			{
    				resultArraySize= col;
    			}
    				
    	
    	int resultArr[]= new int[resultArraySize ];
    	
    	System.out.println("resultArr :"+ resultArr.length);
    	
		int i=row-1;
		int j=0;
		int colcounter=0;
		int k=0;
		boolean status=true;
		
		do{
			if (i==row-1)
			{
				
				for (j=0;j<col;j++)
				{
					resultArr[k++]=twoDArray[i][j];		
					
				}
				
				while (i>0)
				{
					--i;
					resultArr[k++]=twoDArray[i][j-1];	
				}
				
			}
			else
			{
				int count=1;
				for(i=0;i<row-1;i++)					
				{
					if(count%2 == 0)
					{					
						
						for (j=0;j<col-1;j++)
						{
							resultArr[k++]=twoDArray[i][j];	
						}
						
						
					}
					else
					{						
						for (j=col-2;j>=0;j--)
						{
							resultArr[k++]=twoDArray[i][j];	
						}
						
						
					}
					count++;
					
				}
				status=false;
			}
			
			
			
			
		}while(status);
		
		
		
		return resultArr;
	}
	
	public static void main(String args[])
	{
		int twoDArray[][]={{0,1,2,3,50},
				{4,5,6,7,60},
				{8,9,10,11,70},
				{12,13,14,15,80}};
		
	//	sample output : 12,13,14,15,80,70,60,50,3,2,1,0,4,5,6,7,11,10,9,8,
		
		
		/*int twoDArray[][]={{4,2},
				{1,}
				};*/
		
		
		int arr[]= getSprilValue(twoDArray);
		
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + ",");
		}
	}
}
