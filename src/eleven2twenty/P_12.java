package eleven2twenty;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-12 09:55
 * @Description: 数值的整数次方 p110
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class P_12 {
    //全局异常变量
    boolean invalidInput=false;
    public double Power(double base, int exponent) {
        if(equal(base,0.0)&&exponent<0){
            invalidInput=true;
            return 0.0;
        }
        int absexponent=exponent;
        if(exponent<0)
            absexponent=-exponent;
        double res=getPower(base,absexponent);
        if(exponent<0)
            res=1.0/res;
        return res;
    }
    boolean equal(double num1,double num2){
        if(num1-num2>-0.000001&&num1-num2<0.000001)
            return true;
        else
            return false;
    }
    double getPower(double b,int e){
        if(e==0)
            return 1.0;
        if(e==1)
            return b;
        //右移除以二
        double result=getPower(b,e>>1);
        result*=result;
        //判断是否为奇数
        if((e&1)==1)
            result*=b;
        return result;
    }
    @Test
    public void Test(){
        int i=9;
        System.out.println(i >> 1);

    }
}
