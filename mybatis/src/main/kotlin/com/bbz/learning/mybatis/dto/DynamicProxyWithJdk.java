package com.bbz.learning.mybatis.dto;


import org.apache.ibatis.reflection.Reflector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Hello {
    User printName(String name);

    User printName(int name);
}
//
//class HelloImpl implements Hello {
//
//    @Override
//    public void printName(String name) {
//        System.out.println(name);
//    }
//}

class HelloProxy<T> implements InvocationHandler {

//    private T target;

    HelloProxy() {
//        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            User user = new User();
            user.setName("abcd" + "|" + args[0]);
            return user;
        }
    }

    T getProxy() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Hello.class}, this);
    }
}

public class DynamicProxyWithJdk {
    public static void main(String[] args) {
//        HelloImpl hello = new HelloImpl();
        Hello proxy = new HelloProxy<Hello>().getProxy();
        User user = proxy.printName("范德萨发生地方");
        System.out.println(user.getName());

        Map<Method, Integer> map = new HashMap<>();

        int i = 0;
        for (Method declaredMethod : Hello.class.getDeclaredMethods()) {
            map.put(declaredMethod, i++);
        }
        System.out.println(map);
        Reflector reflector = new Reflector(Hello.class);
        reflector.findPropertyName("ab");
    }
}
