public class SequentialSum {

    private int[] numsTosum;
    private int result;

    public SequentialSum(int[] numsTosum) {
        this.numsTosum = numsTosum;
    }

    public void sumUp() {
        for(var i=0;i<numsTosum.length;i++)
            result+=numsTosum[i];
    }

    public void printArrayAndResult() {
        for(var i=0;i<numsTosum.length;i++)
            System.out.print(numsTosum[i] +" ");

        System.out.println("\nResult: " + result);
    }
}
