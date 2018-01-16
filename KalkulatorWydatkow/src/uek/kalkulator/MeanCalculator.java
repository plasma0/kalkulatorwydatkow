package uek.kalkulator;

public class MeanCalculator {
    private double _mean;
    public MeanCalculator(double mean)
    {
        _mean=mean;
    }
    public String mountChain(double num)
    {
        double diff = num - _mean;
        if(diff<0)
        {
            String result = "";
            result += "<font color=\"red\">";
            result += diff;
            result += "</font>";
            return result;
        }
        else
        {
            String result = "";
            result += "<font color=\"green\">";
            result += diff;
            result += "</font>";
            return result;
        }
    }
}
