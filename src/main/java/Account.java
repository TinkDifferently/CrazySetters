@Generated(table="dbo.Account")
public class Account extends MoneyModel {
    public enum  AccountType {
        SOCIAL,OPEN,LOCKED,MASTER
    }

    public enum AccountStatus {
        OPEN,CLOSED,FROZEN,BLOCKED
    }
    AccountType type;
    AccountStatus status;

}
