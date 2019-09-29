package com.leetcode;
/*278. First Bad Version
Easy

774

467

Favorite

Share
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
 * 
 * 
 */
public class FirstBadVersion278 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstBadVersion278 f=new FirstBadVersion278();
		
		/*f.setBadVersion(4);		
		System.out.println(f.firstBadVersion(5));
		
		f.setBadVersion(1);		
		System.out.println(f.firstBadVersion(5));*/
		

		f.setBadVersion(1702766719);		
		System.out.println(" *** " + f.firstBadVersion(2126753390));
	}

	// seeting bad version
	private int badVersion;
	
	public void setBadVersion(int version)
	{
		badVersion=version;
	}
	
	public int getBadVersion()
	{
		return badVersion;
	}

	// checking whether this version is bad or not
public boolean isBadVersion(int ver)
{
	System.out.println(getBadVersion());
	if(getBadVersion() == ver)
	{
		return false;
		
	}
	else
		return true;
}


public int firstBadVersion(int n) {
        
        int start=1;
        int last=n;
        int mid=0;
        
       /* using binary search to find the bad version. Starting with version 1 and setting 
        last as mid as it could be first bad version instead of doing mid-1;
        Finnaly return start as it will stop there if found as bad version*/
       
        while(start < last)
        {
            mid=start+ (last-start)/2;
            
            if(isBadVersion(mid))
            {
                
                last=mid;
               
            }
            else 
            {
            	
                start=mid+1;
                System.out.println("start " + start);
            }
            
        }
        
        
        return start;
    }

}
