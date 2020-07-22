package com.zz.leecode.rotated;

/**
 * @author zzj
 * @className RotatedSortArray
 * @description TODO
 * @date 2020/7/22
 *
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *
 */

public class RotatedSortArray {

    /**
     * 暴力递归
     * @param numbers
     * @return 最小值
     */
    public int myMinArray(int[] numbers) {
        int temp = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(temp > numbers[i]){
                temp = numbers[i];
            }
        }
        return temp;
    }

    /**
     * 二分法解决
     *什么是   旋转数组  就是  先递增再递减 或是先递减在递增的数组，所以这是部分有序的数组，可以采用二分法
     * 解析
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            }
            else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

}
