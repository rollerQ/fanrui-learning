package com.dream.sort;

/**
 * 快速排序
 * 时间复杂度: 平均情况是O(nlog(n)),最差情况是O(n^2)
 * 空间复杂度: O(1)
 * @author fanrui
 * @time 2019-03-22 11:38:04
 * @see ISort
 * @see SortTest
 */
public class ObjectQuickSort implements ObjectSort {

	public void sort(Object[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * 从 p 到 r 排序数组array
	 * @param array
	 * @param p
	 * @param r
	 */
	private void quickSort(Object[] array, int p, int r){
		if (p >= r) {
			return;
		}

		// 获取分区点 使得分区点左边的数据比分区点数据小，分区点右边的数据比分区点数据大
		int q = partition(array, p, r);
		quickSort(array, p, q-1);
		quickSort(array, q+1, r);
	}
	
	/**
	 * 找出一个基准点，排列数组array左边的都小于它，右边的都大于它
	 * @param array
	 * @param left
	 * @param right
	 * @return 基准值数组索引
	 */
	private int partition(Object[] array, int left, int right){

        //temp中存的就是基准数
        Object pivot = array[left];
        int i = left;
        int j = right;

        //顺序很重要，要先从右边开始找
        while(i != j) {
            // 从右边开始遍历，找到比 pivot小的数
            while(((Comparable) array[j]).compareTo(pivot) >= 0 && i < j){
                j--;
            }

            // 从左边开始遍历，找到比 pivot小的数
            while(((Comparable) array[i]).compareTo(pivot) <= 0 && i < j) {
                i++;
            }

            //  交换两个数在数组中的位置
            if(i < j){
                Object tmp;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // 最终将基准数归位
        array[left] = array[i];
        array[i] = pivot;
        return i;
	}
}
