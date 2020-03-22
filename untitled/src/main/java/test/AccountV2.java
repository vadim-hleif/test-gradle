package test;

public class AccountV2 {

    private Integer id;
    private Integer money = 100;

    public Integer getId() {
        return id;
    }

    public AccountV2 setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
