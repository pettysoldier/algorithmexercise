package com.richborn.multiThread;

import java.util.concurrent.*;

/**
 * \,,,/
 * (o o)
 * -----oOOo-(3)-oOOo-----
 *
 * @Description:
 * @Author: zhushengguo@autohome.com.cn
 * @Version:
 * @Date: 12:23 PM 2020/5/16
 **/
class Foo {
    CountDownLatch c1 ;
    CountDownLatch c2 ;
    public Foo() {
        c1 = new CountDownLatch(1);
        c2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new FutureTask<Integer>(()->{
            foo.third(()->{
                System.out.println("third");
            });
            return 3;
        }));
        executorService.execute(new FutureTask<Integer>(()->{
            foo.second(()->{
                System.out.println("second");
            });
        return 2;
        }));

        executorService.execute(new FutureTask<Integer>(()->{
            foo.first(()->{
                System.out.println("first");
            });
        return 1;
        }));

        return;
    }
}
