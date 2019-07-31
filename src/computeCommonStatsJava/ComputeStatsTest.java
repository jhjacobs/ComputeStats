package computeCommonStatsJava;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ComputeStatsTest {

	@Test
	void test() {
		try
		{
			ComputeStats cs = new ComputeStats();
			CommonStatsData csd = new CommonStatsData();
			String numString = "1 5 2 4 3";
			String[] numStringsArr = numString.split(" ", 0);
			List<String> try1Strings = Arrays.asList(numStringsArr);
			List<Integer> try1Ints = ComputeStats.transform(try1Strings, Integer::parseInt);
			cs.JJQuickSort(try1Ints, 0, try1Ints.size() - 1);
			assertEquals(try1Ints.get(1), 2);		
			csd = cs.CalcStats(try1Strings);
			assertEquals(csd.GetMin(), 1);
			assertEquals(csd.GetMax(), 5);
			assertEquals(csd.GetMean(), 3.0f);
			assertEquals(csd.GetMedian(), 3);
			assertEquals(csd.GetStandardDeviation(), 1.4142135f);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			fail("CalcStats Failed");
		}
		
		
	}

}
