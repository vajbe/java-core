package DSA.ArrayString;

//https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(new ProductArray().productExceptSelf(new int[] { 1, 2, 3, 4 })));
        System.out.println(
                java.util.Arrays.toString(new ProductArray().productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
    }
}
