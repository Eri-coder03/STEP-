class Rotate {
    int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        return newArray;
    }
}

public class E5W4 {
    public static void main(String[] args) {

        Rotate obj = new Rotate();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = obj.rotateArray(nums, k);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
