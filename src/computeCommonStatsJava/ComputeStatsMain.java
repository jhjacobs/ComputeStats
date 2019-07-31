package computeCommonStatsJava;
import java.util.*;

public class ComputeStatsMain {

	public static void main(String args[])
	{
		int i = 0;
		// System.out.println("Hey how r ya");
		i+=1;
		List<Integer> theIntList = new Vector<Integer>();
		theIntList = Arrays.asList(1, 5, 2, 4, 9, 5, 32, 157, 78, 952);
		
		String numString = "1 5 2 4 3";
		String[] numStringsArr = numString.split(" ", 0);
		List<String> try1Strings = Arrays.asList(numStringsArr);
		List<Integer> try1Ints = ComputeStats.transform(try1Strings, Integer::parseInt);
		// ComputeStats cs = new ComputeStats(theIntList);
		ComputeStats cs = new ComputeStats();
		System.out.println("Sorting theIntList");
		System.out.println("Printing theIntList");
		cs.PrintListOfNumbers(theIntList);
		cs.JJQuickSort(theIntList, 0, theIntList.size() - 1);
		System.out.println("Printing try1Ints in main");
		cs.PrintListOfNumbers(try1Ints);
		// cs.JJQuickSort(theIntList, 0, theIntList.size() - 1);
		// cs.JJQuickSort(try1Ints, 0, try1Ints.size() - 1);
		
		CommonStatsData mcsd = cs.CalcStats(try1Strings);
		// System.out.println("Printing try1Ints in main");
		// scs.PrintListOfNumbers(try1Ints);
		System.out.println("Min: " + mcsd.GetMin());
		System.out.println("Max: " + mcsd.GetMax());
		System.out.println("Mean: " + mcsd.GetMean());
		System.out.println("Median: " + mcsd.GetMedian());
		System.out.println("Standard Deviation: " + mcsd.GetStandardDeviation());
		
	}
}
