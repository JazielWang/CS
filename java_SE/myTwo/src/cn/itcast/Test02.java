package cn.itcast;

import com.itheima_03.MyService;

import java.security.Provider;
import java.util.ServiceLoader;

public class Test02 {
    public static void main(String[] args) {
        ServiceLoader<MyService> myServices = ServiceLoader.load(MyService.class);
        for (MyService my:myServices){
            my.service();
        }
    }
}
