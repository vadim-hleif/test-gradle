package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private AtomicInteger money = new AtomicInteger(100);

    public AtomicInteger getMoney() {
        return money;
    }

    public void setMoney(AtomicInteger money) {
        this.money = money;
    }
}
