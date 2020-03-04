import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EasyTest {

    @Test()
    @Parameters({"clientId","currency","accountType","sum"})
    public void test(String clientId,String currency,String accountType, String sum){
        //подтягиваем клиента из бд
        Client client=new Client(clientId);
        //подтягиваем произвольную карту, принадлежащую клиенту сверху, открытую рублевую с суммой не меньше 250 (эмитент и тип нам здесь не важны)
        Card card=new Card(client,currency,"OPEN",null,null,sum);
        //а вот счет мы не подтягиваем а делаем от него только заглушку по которой будем его собирать
        Account account=new Account(); //вот про это вопрос в задачке
        //создаем заглушку для операции, по которой будем ее выполнять (отдаем ей account еще без номера, в расчете, что он заполнится потом)
        Operation operation=new Operation(card,account,currency,sum);
        //создаем счет для клиента
        //сохраняем счет в объект счета
        Pseudo.createAccount(client,account);
        //делаем перевод с карты на новый счет
        Pseudo.executeOperation(operation);
    }
}
