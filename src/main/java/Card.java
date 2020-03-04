@Generated(table="dbo.Card")
public class Card extends MoneyModel {
    /**
     * ищет карту по условиям
     * @param client айди клиента
     * @param currency валюта
     * @param status статус
     * @param type тип карты
     * @param emitent эмитент карты
     * @param sum сумма
     */
    public Card(Client client, String currency, String status, String type, String emitent, String sum) {
        super();
        try {
            setCurrency(currency);
            setSum(sum);
            this.status = CardStatus.valueOf(status);
            if (type!=null)
            this.type = CardType.valueOf(type);
            if (emitent!=null)
            this.emitent = Emitent.valueOf(emitent);
        } catch (Exception any){
            throw new RuntimeException("не удалось создать карту");
        }
        //запрос в бд c учетом всех данных выше чтобы получить остальные поля
    }



    public enum Emitent{
        VISA,MIR,MAESTRO,MASTERCARD
    }
    public enum  CardType {
        MULTICARD, CREDIT, DEBET
    }

    public enum CardStatus {
        OPEN,CLOSED,FROZEN,BLOCKED
    }
    private Emitent emitent;
    private CardType type;
    private CardStatus status;
}
