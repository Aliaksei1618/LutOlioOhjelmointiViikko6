package BankViikko6;

public abstract class Account {
    private String number;
    private int money;

    public Account(String accountNumber, int money) {
        this.number = accountNumber;
        this.money = money;
    }

    public String getAccountNumber() {
        return number;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void depositmoney(int deposit) {
        this.setMoney(this.getMoney() + deposit);
    }

    public void withdrawmoney(int withdraw) {
    }

    @Override
    public String toString() {
        return "Account number: " + number + " Amount of money: " + money;
    }



    public static class RegularAccount extends Account {

        public RegularAccount(String accountNumber, int money) {
            super(accountNumber, money);
        }

        @Override
        public void withdrawmoney(int withdraw) {
            if ((super.getMoney() - withdraw) >= 0) super.setMoney(super.getMoney() - withdraw);
        }
    }



    public static class CreditAccount extends Account {
        private int limit;

        public CreditAccount(String accountNumber, int money, int limit) {
            super(accountNumber, money);
            this.limit = limit;
        }

        @Override
        public void withdrawmoney(int withdraw) {
            if ((super.getMoney() - withdraw) >= -limit) super.setMoney(withdraw);
        }

        @Override
        public String toString() {
            return super.toString() + " Credit limit: " + limit;
        }
    }
}
