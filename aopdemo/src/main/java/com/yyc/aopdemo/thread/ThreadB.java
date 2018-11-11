package com.yyc.aopdemo.thread;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 09:52
 * @Description:
 */
public class ThreadB implements Runnable {
    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        //lock.notifyAll();//唤醒所有等待该锁的线程
                        lock.notify();//只会唤醒其中一个等待该锁的线程,第一个等待的
                        System.out.println("我是B---已发出通知 但需要我执行完所有代码你们才能拿到锁！");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素!");
                }
            }

    }

}
