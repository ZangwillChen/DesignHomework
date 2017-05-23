package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public class ReserveStatus {

    private int class1;
    private int class2;
    private int class3;
    private int class4;
    private int class5;
    private int class6;

    public ReserveStatus(){

    }

    public ReserveStatus(int class1,int class2,
                         int class3,int class4,
                         int class5,int class6){
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.class4 = class4;
        this.class5 = class5;
        this.class6 = class6;
    }

    public int getClass1() {
        return class1;
    }

    public int getClass2() {
        return class2;
    }

    public int getClass3() {
        return class3;
    }

    public int getClass4() {
        return class4;
    }

    public int getClass5() {
        return class5;
    }

    public int getClass6() {
        return class6;
    }

    public void setClass1(int class1) {
        this.class1 = class1;
    }
    public void setClass2(int class2) {
        this.class2 = class2;
    }

    public void setClass3(int class3) {
        this.class3 = class3;
    }

    public void setClass4(int class4) {
        this.class4 = class4;
    }

    public void setClass5(int class5) {
        this.class5 = class5;
    }

    public void setClass6(int class6) {
        this.class6 = class6;
    }
}
