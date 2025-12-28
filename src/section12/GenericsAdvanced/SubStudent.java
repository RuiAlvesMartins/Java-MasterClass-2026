package section12.GenericsAdvanced;

public class SubStudent extends Student {

    private double percentComplete;

    //  REMEMBER: this constructor will implicitly call the super constructor!
    public SubStudent() {
        //  Upper bound is excluded, so the maximum value is 100.00!
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
    
}
