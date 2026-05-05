import java.util.Arrays;

public class N0001TwoSum {

    //todo: remove static
    public static int[] twoSum(int[] nums, int target) {

        int[] solution = new int[2];
        boolean solutionFound = false;

        for(int i=0; i<nums.length; i++) {

            for(int j=0; j<nums.length; j++) {

                //  can't use same element twice;
                if (i==j) {
                    continue;
                }

                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    solutionFound = true;
                }

            }

        }

        if (!solutionFound) {
            System.out.println("No solution exists for %s given %s".formatted(target, Arrays.toString(nums)));
        }
        System.out.println("Solution = " + Arrays.toString(solution));

        return solution;

    }

    public static void main(String[] args) {
        
        int[] values = new int[] {2, 7, 11, 15};
        int targetSum = 9;

        twoSum(values, targetSum);

    }

}
