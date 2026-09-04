class ProductArray {
    int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int product = 1;

        // Left products
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        product = 1;

        // Right products
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }
}

public class A1W4 {
    public static void main(String[] args) {

        ProductArray obj = new ProductArray();

        int[] nums = {1, 2, 3, 4};

        int[] result = obj.productExceptSelf(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
