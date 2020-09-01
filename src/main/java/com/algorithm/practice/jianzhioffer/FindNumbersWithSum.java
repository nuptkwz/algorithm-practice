package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;

/**
 * Description
 * 和为S的两个数字
 * Date 2020/9/1 23:45
 * Created by kwz
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {

    }


    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        int sul=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==sum){
                    if(list1.size()==0){
                        list1.add(i*j);
                        sul=array[i]*array[j];
                        if(i<=j){
                            list2.add(array[i]);
                            list2.add(array[j]);
                        }else{
                            list2.add(array[j]);
                            list2.add(array[i]);
                        }
                    }else if(sul>array[i]*array[j]){
                        list1.remove(0);
                        list1.add(i*j);
                        if(i<=j){
                            list2.clear();
                            list2.add(array[i]);
                            list2.add(array[j]);
                        }else{
                            list2.clear();
                            list2.add(array[j]);
                            list2.add(array[i]);
                        }

                    }
                }
            }
        }
        return list2;
    }
}
