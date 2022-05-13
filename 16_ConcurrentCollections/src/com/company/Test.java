package com.company;

import java.util.*;

public class Test {

    static Long count = 0L;
    public static void main(String[] args) throws Exception {
        List<String> ls = new ArrayList<>();
        ls.add("Serg");ls.add("Mary");ls.add("Ron");ls.add("Ann");ls.add("Max");
        ls.add("Lucy");ls.add("Mary");ls.add("Bred");ls.add("Ann");ls.add("Mark");
        ls.add("Lucy");ls.add("Mary");ls.add("Bred");ls.add("Ann");ls.add("Pete");
        List<String> ls2 = new ArrayList<>();
        ls2.add("Serg");ls2.add("Mary");ls2.add("Ron");ls2.add("Ann");ls2.add("Vas");
        ls2.add("Lucy");ls2.add("Mary");ls2.add("Bred");ls2.add("Ann");ls2.add("Vas");
        ls2.add("Lucy");ls2.add("Mary");ls2.add("Bred");ls2.add("Ann");ls2.add("Pete");
        List<String> ls3 = new ArrayList<>();
        ls3.add("Serg");ls3.add("Mary");ls3.add("Ron");ls3.add("Ann");ls3.add("Max");
        ls3.add("Lucy");ls3.add("Mary");ls3.add("Bred");ls3.add("Ann");ls3.add("Max");
        ls3.add("Lucy");ls3.add("Mary");ls3.add("Bred");ls3.add("Ann");ls3.add("Pete");



        Map<String, Long> words = Collections.synchronizedMap(new HashMap<>());
//    ConcurrentHashMap<String, Long> words = new ConcurrentHashMap<>();


        TreeSet<String> ts = new TreeSet<>(ls);


        System.out.println(ts);
        Runnable r = () -> {
            for(String temp : ls) {
                words.compute(temp, (key, value) -> value == null ? 1 : ++value);
            }
        };
        class MyThread extends Thread{
            List<String> list;
            MyThread(List<String> list, Runnable r){
                super(r);
                this.list = list;
            }
        }
        Thread t1 = new MyThread(ls, r);
        Thread t2 = new MyThread(ls2, r);
        Thread t3 = new MyThread(ls3, r);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println(words);
    }

}
//    public static void main(String[] args) throws InterruptedException {
//        List<String> ls = new ArrayList<>(Arrays.asList("Dima", "Serg", "Dima", "Bob", "Bob"));
//        List<String> ls2 = new ArrayList<>(Arrays.asList("Dima", "Serg", "Dima", "Bob", "Bob"));
//        List<String> ls3 = new ArrayList<>(Arrays.asList("Dima", "Serg", "Dima", "Bob", "Bob"));
//
//        Map<String, Long> result = Collections.synchronizedMap(new HashMap<>());
//
//
//        Thread tr1 = new MyTread(ls, result);
//        Thread tr2 = new MyTread(ls2, result);
//        Thread tr3 = new MyTread(ls3, result);
//        tr1.start();
//        tr2.start();
//        tr3.start();
//
//        tr1.join();
//        tr2.join();
//        tr3.join();
//        System.out.println(result);
//
//    }
//}
//
//class MyTread extends Thread {
//    List<String> list;
//    Map<String, Long> result;
//
//    MyTread(List<String> list, Map<String, Long> result) {
//        this.list = list;
//        this.result = result;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Start");
//        for (String temp : list) {
////                synchronized (Runnable.class) {
////                    count = result.get(temp);
////                    count = count == null ? 1 : ++count;
////                    result.put(temp, count);
////
////                }
//            result.compute(temp, (str, count) -> count == null ? 1 : ++count);
//
//        }
//    }
//}