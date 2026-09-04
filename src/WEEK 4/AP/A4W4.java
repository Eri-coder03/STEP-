import java.util.HashMap;

class SubarraySum {
    int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            map.put(currentSum,
                    map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}

public class A4W4 {
    public static void main(String[] args) {

        SubarraySum obj = new SubarraySum();

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(obj.subarraySum(nums, k));
    }
}
