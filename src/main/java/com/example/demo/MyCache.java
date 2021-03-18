package com.example.demo;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyCache {

public static Map<Integer, String> cache= new HashMap<>();

    public String get(int key){
        String s = cache.get(key);
        //System.out.println(s);
        return s;
    }
    public void set(int key, String value){
        cache.put(key, value);
    }

    public boolean has(int key){
        boolean a = false;
        if(cache.containsKey(key)){
            a = true;
        }
        //System.out.println(a);
        return a;

    }
    public void delete(int key){
       cache.remove(key);
    }

    public void setTTL(int key, int ttl) throws InterruptedException {
        System.out.println("This Cache has been saved for: "+ttl+" seconds");
        TimeUnit.SECONDS.sleep(ttl);
        cache.remove(key);
    }
}
