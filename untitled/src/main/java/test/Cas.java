package test;

public class Cas {

    public static void main(String[] args) {
        Account first = new Account();
        Account second = new Account();

        transfer(first, second, 20);
        transfer(second, first, 15);

        System.out.println(first.getMoney());
        System.out.println(second.getMoney());

    }

    public static void transfer(Account source, Account target, int amount) {
        int money;
        do {
            //A: get value from AtomicInteger
            money = source.getMoney().get();
        }
        //B: code tries to set new value only if there aren't any changes
        while (!source.getMoney().compareAndSet(money, money - amount));

        do {
            //A: get value from AtomicInteger
            money = target.getMoney().get();
        }
        //B: code tries to set new value only if there aren't any changes
        while (!target.getMoney().compareAndSet(money, money + amount));
    }

    public void transfer(AccountV2 source, AccountV2 target, int amount) {
        AccountV2 first = source.getId() > target.getId() ? source : target;
        AccountV2 second = source.getId() > target.getId() ? target : source;

        synchronized (first) {
            synchronized (second) {
                source.setMoney(source.getMoney() - amount);
                target.setMoney(target.getMoney() + amount);
            }
        }
    }

}
