package com.zz.leecode.twoint;

/**
 * @author zzj
 * @className TwoInt
 * @description TODO
 * @date 2020/6/1
 */

import com.sun.javafx.binding.StringFormatter;

import javax.jnlp.IntegrationService;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 *@author: zzj
 *@date: 2020/6/1
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/
public class TwoInt {

    /**
     * 最开始的想法
     * 1.先排序
     * 2.找出符合值
     * 问题
     * 1. 错 排序位置变了
     * 2. 整数 包含负数 错
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){

        int[] result = new int[2];
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > target){
                return null;
            }
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] > target){
                    return null;
                }
                sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 修改后的
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumProve(int[] nums, int target){

        int[] result = new int[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 大神的写法
     * hashmap存放 补数
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumNiu(int[] nums, int target){

        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                result[0] = i;
                result[1] = hashMap.get(nums[i]);
                return result;
            }

            hashMap.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {5,8,6,3,10,13,2,0,7};
        int target = 20;

        long start = System.currentTimeMillis();
        //int[] ints = twoSum(nums, target);
        //int[] ints = twoSumProve(nums, target);
        int[] ints = twoSumNiu(nums, target);
        long stop = System.currentTimeMillis();
        System.out.println("cost time " + (stop - start));
        System.out.println(Arrays.toString(ints));
        System.out.println(MessageFormat.format("第一个数字 {0} ，第二个数字{1}", nums[ints[0]], nums[ints[1]]).toString());
    }
}
