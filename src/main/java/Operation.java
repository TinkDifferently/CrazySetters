@Generated(table="dbo.Operation")
public class Operation extends MoneyModel {
    MoneyModel from;
    MoneyModel to;

    public Operation(MoneyModel from, MoneyModel to, String currency, String sum) {
        super();
        this.from=from;
        this.to=to;
        setCurrency(currency);
        setSum(sum);
    }
}
