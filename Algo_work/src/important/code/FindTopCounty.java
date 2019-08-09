package important.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * 1) California Cities and Towns - At the bottom of this file is a list of cities and towns in California.
Calculate the 5 largest counties, print them out with total population.

"Adelanto,City,San Bernardino,31765"
Agoura Hills,City,Los Angeles,20330
Alameda,City,Alameda,73812
Albany,City,Alameda,18539
Alhambra,City,Los Angeles,83089
Aliso Viejo,City,Orange,47823
Alturas,City,Modoc,2827
Amador City,City,Amador,185
American Canyon,City,Napa,19454
Anaheim,City,Orange,336265
Anderson,City,Shasta,9932
Angels Camp,City,Calaveras,3836
Antioch,City,Contra Costa,102372
Apple Valley,Town,San Bernardino,69135
Arcadia,City,Los Angeles,56364
Arcata,City,Humboldt,17231
Arroyo Grande,City,San Luis Obispo,17252
Artesia,City,Los Angeles,16522
 * 
 * 
 * 
 * 
 * 
 */

// Solution will be that first need to store the population of each city into map by keep checking whether value exist or not
// if exist then add into population
// Create custom class which can store required value such as population and cityname and also helps us in sorting lateron.
// We have to sort based on value
// We will convert maps values in the arraylist and will sort arraylist cusing custom comaparater class written for sorting based on population.
// here we have created SortCityByPopulation and because we have to display top 5 then we use comparator return in reverse order.
// If first population is greater then return -1 else 1
// this comparator will be pass in the Collections.sort methoods as type to sort.

// This is very usefull

class CitiList 
{
	String countyName;
	int population;
	
	public CitiList()
	{
		
	}
	public CitiList(String countyName, int population) {
		super();
		this.countyName = countyName;
		this.population = population;
	}
}


class SortCityByPopulation implements Comparator
{
	@Override
	public int compare(Object obj1, Object obj2)
	{
		CitiList ci1=(CitiList) obj1;
		CitiList ci2=(CitiList) obj2;
		
		if(ci1.population > ci2.population)
			return -1;
		else if(ci1.population == ci2.population)
			return 0;
		else
			return 1;
	}


}


public class FindTopCounty {
	
	
	public void findCounty( String[] cityList )
	{
		if(cityList.length == 0)
		{
			System.out.println(" No city");			
			
		}
		
		Map<String,CitiList> cityMap=new TreeMap<String,CitiList>();
		
		for(int i=0; i< cityList.length ; i++)
		{
			String[] firstCity= cityList[i].split(",");
			
			CitiList newCity=	new	CitiList(firstCity[2],Integer.parseInt(firstCity[3]));
			
			// building unique map
			if(cityMap.containsKey(firstCity[2]))
			{
				CitiList city=(CitiList)cityMap.get(firstCity[2]);
				int population= city.population;
				city.population=city.population+Integer.parseInt(firstCity[3]);
				cityMap.put(firstCity[2], city );
			}
			else
			{
				cityMap.put(firstCity[2],newCity );
			}
			
		}
		
			
		List<CitiList> list=new ArrayList<CitiList>();
		
		//Iterating map and building list to sort
			for(Map.Entry<String, CitiList> entry:cityMap.entrySet())
			{
				
				list.add((CitiList)entry.getValue());
				//System.out.println(entry.getValue().population +" : " +entry.getKey() );
			}
			
			// sorting list based on comparator created for Citilist
			Collections.sort(list, new SortCityByPopulation());
		
			
			// print from list
			for(int i=0; i< list.size(); i++) {
				
				System.out.println(list.get(i).population +" " + list.get(i).countyName);
				
			}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTopCounty f=new FindTopCounty();
		
		String [] input= {"Adelanto,City,San Bernardino,31765",
				"Agoura Hills,City,Los Angeles,20330",
				"Alameda,City,Alameda,73812",
				"Albany,City,Alameda,18539",
				"Alhambra,City,Los Angeles,83089",
				"Aliso Viejo,City,Orange,47823",
				"Alturas,City,Modoc,2827",
				"Amador City,City,Amador,185",
				"American Canyon,City,Napa,19454",
				"Anaheim,City,Orange,336265",
				"Anderson,City,Shasta,9932",
				"Angels Camp,City,Calaveras,3836",
				"Antioch,City,Contra Costa,102372",
				"Apple Valley,Town,San Bernardino,69135",
				"Arcadia,City,Los Angeles,56364",
				"Arcata,City,Humboldt,17231",
				"Arroyo Grande,City,San Luis Obispo,17252",
				"Artesia,City,Los Angeles,16522"};
		f.findCounty(input);
	}

}
