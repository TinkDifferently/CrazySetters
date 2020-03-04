import java.math.BigDecimal;

public abstract class MoneyModel  implements IHaveNumber {
    protected Currency currency;
    protected BigDecimal sum;
    protected String number;

    protected void setCurrency(String currency){
        try {
            this.currency= currency == null || currency.length() == 0 ? Currency.UNDEFINED : Currency.valueOf(currency);
        } catch (Exception any){
            throw new RuntimeException(String.format("Валюта '%s' не поддерживается", currency));
        }
    }
    protected void setSum(String sum){
        try {
            this.sum = new BigDecimal(sum);
        } catch (Exception e){
            throw new RuntimeException(String.format("Не удалось распарсить сумму '%s'", sum));
        }
    }

    public String getNumber(){
        if (number==null || number.length()==0)
            throw new RuntimeException("Номер еще не был создан");
        return number;
    }
}
