package com.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @
 * @date 2020/9/4 - 15:49
 */
public class HeapSort {
    public static void main(String[] args) {
        /*int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);*/
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    public static void heapSort(int[] arr) {
        System.out.println("heap sort!!!");
        int temp;
        /*adjustHeap(arr, 1, arr.length);
        System.out.println("第一次调整"+ Arrays.toString(arr));*/
        //完成我们最终代码
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        // 3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int i = arr.length - 1; i > 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
//        System.out.println(Arrays.toString(arr));
    }

    //将一个数组(二叉树), 调整成一个大顶堆
    /**
     * 功能：完成将以 i 对应的非叶子节点的树调整为大顶堆
     *
     * @param arr    需要调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param lenght 表示对多少个元素进行调整，length 是在逐渐的减少
     */
    public  static void adjustHeap(int arr[], int i, int lenght) {

        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //说明
        //1. k = i * 2 + 1 k 是 i结点的左子结点
        for(int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if(k+1 < lenght && arr[k] < arr[k+1]) { //说明左子结点的值小于右子结点的值
                k++; // k 指向右子结点
            }
            if(arr[k] > temp) { //如果子结点大于父结点
                arr[i] = arr[k]; //把较大的值赋给当前结点
                i = k; //!!! i 指向 k,继续循环比较
            } else {
                break;//!
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
