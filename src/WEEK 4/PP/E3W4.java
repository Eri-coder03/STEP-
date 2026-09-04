class Duplicate {
    boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class E3W4 {
    public static void main(String[] args) {

        Duplicate obj = new Duplicate();

        int[] nums = {1, 2, 3, 1};

        System.out.println(obj.containsDuplicate(nums));
    }
}
