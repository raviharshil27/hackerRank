/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.math.BigDecimal;

/**
 *
 * @author Harshil
 */
public class HackerRank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(""+ 4);
        System.out.print(bd);
        // TODO code application logic here
    }
    double[] pValueDoubles ;
    
    public void double[] test()
    {
         int len = pValueDoubles.length;
                        double[] orderedPValues = new double[len];
                        double[] adjustedpValues = new double[len];
                        int[] indexOfValues = new int[len];
                        final int RESULT_SCALE = 10;
 
                        for(int i=0; i<len; i++){
                                orderedPValues[i] = pValueDoubles[i];
                        }
                        // sort the values
                        java.util.Arrays.sort(orderedPValues);
                        for(int i=0; i<len; i++){
//                              indexOfValues[i]=getIndexOf(orderedPValues, pValueDoubles[i]);
                                indexOfValues[i]=getIndexOf(orderedPValues, pValueDoubles[i]);
//                              indexOfValues[i]=getIndexOf(pValueDoubles, orderedPValues[i]);
                        }
                        // calculate the post hoc adjustment
                        BigDecimal min = new BigDecimal("" + 1);
                        BigDecimal mkprk;
                        for (int i = len; i > 0; i--) {
                                mkprk = (new BigDecimal("" + len).multiply(new BigDecimal(orderedPValues[i - 1]))).divide(new BigDecimal("" + i), RESULT_SCALE, BigDecimal.ROUND_HALF_UP);
                                if (mkprk.compareTo(min) < 0) {
                                        min = mkprk;
                                }
                                adjustedpValues[i - 1] = min.doubleValue();
                        }
                        // adjust the sequence
                        len = ;
                        int j = 0;
                        for(int i=0; i<len; i++){
                                try {
                                        //      double tmp = Double.parseDouble(proteinList.get(i).getLogRatioVariance2());
                                        double tmp = Double.parseDouble(proteinList.get(i).getVariancePvalue());
 
                                        if(tmp>-100000.0){
                                                NumberFormat formatter = new DecimalFormat("##.#####");
                                                String apvString = formatter.format(adjustedpValues[indexOfValues[j]]);
                        //                      proteinList.get(i).setPostHocP(apvString);
                                                proteinList.get(i).setVariancePvalueBH(adjustedpValues[indexOfValues[j]]);
                                                j++;
                                        }
                                        else{
                        //                      proteinList.get(i).setPostHocP("-1");
                                                proteinList.get(i).setVariancePvalueBH(-1.0);
                                        }
                                } catch(Exception e) {
                                        proteinList.get(i).setVariancePvalueBH(-1.0);
                                }
                        }
    }
    public static int getIndexOf (double[] orderedPvalues, double value)
    {
        for(int i=0;i<orderedPvalues.length;i++)
        {
            if(orderedPvalues[i] == value)
                return i;
        }
        return -1;
    }
}
