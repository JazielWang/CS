package com.ItHeima_javabase_011;
/*测试类*/
public class PhoneClass {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.call("liujing");
        System.out.println("-----------");
        NewPhone np = new NewPhone();
        np.call("liujing");
    }
}
