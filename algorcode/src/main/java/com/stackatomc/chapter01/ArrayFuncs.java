package com.stackatomc.chapter01;

/**
 * @Description:
 * @User: stackc
 * @Date: 2018/7/21 1:05
 * @Version: 1.0
 */
public class ArrayFuncs {

    /* 找出数组中最大的元素 */
    public double maxElem(Double[] array){
        double max=array[0];
        for(int i=0;i<array.length;++i){
            if(array[i]>max) max=array[i];
        }
        return max;
    }

    /* 计算数组元素的平均值 */
    public double avgValues(Double[] array){
        double avgValue=0;
        for(int i=0;i<array.length;++i){
            avgValue+=array[i];
        }
        return avgValue/array.length;
    }

    /* 复制数组 */
    public Double[] copyArrays(Double[] array){
        Double[] newarray=null;
        for(int i=0;i<array.length;++i){
            newarray[i]=array[i];
        }
        return newarray;
    }

    /* 颠倒数组元素的顺序 */
    public Double[] revearray(Double[] array){
        for(int i=0;i<(array.length-1+0)/2;++i){
            double temp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
        return array;
    }

    /* 矩阵相乘（方阵）*/
    public void multiarrays(Double[][] a,Double[][] b){
        Double[][] c=new Double[a.length][b.length];
        for(int i=0;i<a.length;++i)
        {
            for(int j=0;j<b.length;++j){
                for(int k=0;k<a[0].length;++k){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
    }
}
