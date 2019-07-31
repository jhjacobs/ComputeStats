package computeCommonStatsJava;

public class CommonStatsData {
	private int min;
	private int max;
	private int sum;
	private float mean;
	private int median;
	private float standardDeviation;
	
	public CommonStatsData()
	{
		min = 0; max = 0; sum = 0;
		mean = 0; median = 0; standardDeviation = 0.0f;
	}
	
	public CommonStatsData(int parmMin, int parmMax, int parmSum, int parmMean,
			int parmMedian, float parmStandardDeviation )
	{
		min = parmMin; max = parmMax; sum = parmSum;
		mean = parmMean; median = parmMedian; standardDeviation = parmStandardDeviation;
				
	}
	
	public void SetMin(int parmMin)
	{
		min = parmMin;
	}
	
	public int GetMin()
	{
		return min;
	}
	
	public void SetMax(int parmMax)
	{
		max = parmMax;
	}
	
	public int GetMax()
	{
		return max;
	}
	public void SetSum(int parmSum)
	{
		sum = parmSum;
	}
	
	public int GetSum()
	{
		return sum;
	}	
	public void SetMean(int parmMean)
	{
		mean = parmMean;
	}
	
	public float GetMean()
	{
		return mean;
	}
	
	public void SetMedian(int parmMedian)
	{
		median = parmMedian;
	}
	
	public int GetMedian()
	{
		return median;
	}
	
	public void SetStandardDeviation(float parmStandardDeviation)
	{
		standardDeviation = parmStandardDeviation;
	}
	
	public float GetStandardDeviation()
	{
		return standardDeviation;
	}
	
}
