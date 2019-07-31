package computeCommonStatsJava;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class ComputeStats {
	List <Integer> listOfNumbers = new Vector<Integer>();
	int QsCalls = 0;

	ComputeStats()
	{
		QsCalls = 0;
	}
	
	ComputeStats(List<Integer> numberList)
	{
		listOfNumbers = numberList;
	}
	
	void PrintListOfNumbers(List<Integer> parmListOfNums)
	{
		parmListOfNums.forEach((parmlistOfNums)-> {
			System.out.print(parmlistOfNums + " ");
		});
		System.out.println("\n");
		
	}
	
	private void Swap(List<Integer> unsortedList, int index1, int index2)
	{
		int temp = unsortedList.get(index1);
		unsortedList.set(index1, unsortedList.get(index2));
		unsortedList.set(index2, temp);
	}
	
	private int Partition(List<Integer> unsortedList, int lowIndex, int highIndex)
	{
		try
		{
			// Pivot point is set to median of high low and mid
			int midIndex = (lowIndex + highIndex) / 2;
			if(unsortedList.get(midIndex) < unsortedList.get(lowIndex) )
				Swap(unsortedList, lowIndex, midIndex);
			if(unsortedList.get(highIndex) < unsortedList.get(lowIndex) )
				Swap(unsortedList, lowIndex, highIndex);
			if(unsortedList.get(midIndex) < unsortedList.get(highIndex) )
				Swap(unsortedList, midIndex, highIndex);
	
			int pivot = unsortedList.get(highIndex);
			
			while(true)
			{
				while(unsortedList.get(lowIndex) < pivot)
					lowIndex += 1;
				
				while(unsortedList.get(highIndex) > pivot)
					highIndex -= 1;
				
				if(lowIndex > highIndex)
					return highIndex;
				
				Swap(unsortedList, highIndex, lowIndex);
				lowIndex += 1;
				highIndex -= 1;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
	
	void JJQuickSort(List<Integer> unsortedList, int lowIndex, int highIndex)
	{
		try
		{
			QsCalls += 1;
			System.out.println("In JJQuickSort printing unsortedList");
			PrintListOfNumbers(unsortedList);
			System.out.println("In JJQuickSort lowIndex: " + lowIndex);
			System.out.println("In JJQucikSort highIndex: " + highIndex);
			if(lowIndex < highIndex)
			{
				if(unsortedList != null)
				{
					int part = Partition(unsortedList, lowIndex, highIndex);
					if( unsortedList != null)
						JJQuickSort(unsortedList, lowIndex, part);
					if( unsortedList != null)
						JJQuickSort(unsortedList, part + 1, highIndex);
				}
			}
		}	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	// Generic function to convert List of String to List of Integer
	public static <T, U> List<U> transform(List<T> list, 
										Function<T, U> function)
	{
		try
		{
			return list.stream()
					.map(function)
					.collect(Collectors.toList());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}	
	}
	
	float CalculateStandardDeviation( float statMean, List<Integer> numList )
	{
		try
		{
			int sumPortion = 0;
			for(int i: numList)
			{
				sumPortion += Math.pow( (i - statMean), 2);
			}
			return (float)(Math.pow(sumPortion / numList.size(),  0.5));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return -1.0f;
		}	
	}
	
	
	CommonStatsData CalcStats(List<String> numberString)
	{
		try
		{
			CommonStatsData csd = new CommonStatsData();
			List<Integer> numList = transform(numberString,Integer::parseInt);
			int min = numList.get(0);
			int max = 0;
			int sum = 0;
			// int j = 5/0;
			// System.out.println(j);
			
			for(int i: numList)
			{
				// System.out.println(i);
				if(i < min)
					min = i;
				if(i > max)
					max = i;
				sum += i;
			}
			csd.SetMin(min);
			csd.SetMax(max);
			csd.SetMean(sum / numList.size());
			JJQuickSort(numList, 0, numList.size() - 1);
			System.out.println("In CalcStats printing numList.");
			PrintListOfNumbers(numList);
			csd.SetMedian(numList.get(numList.size() / 2));
			csd.SetStandardDeviation(CalculateStandardDeviation(csd.GetMean(), numList));
			return csd;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}	
	}

}
