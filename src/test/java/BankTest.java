import org.junit.Assert;
import org.junit.Test;

public class BankTest {

    Account testAccount = new Account();
    Account underTest = new Account("12345", "Checking", 90);


    @Test
    public void testIfAccountIsCreated() {
        //Assert.assertEquals(90.75, 90.75, underTest.getBalance());
        Assert.assertEquals("12345", underTest.getAccountNumber());

    }


    @Test
    public void testAddFunds(){
        underTest.deposit(10);
       // Assert.assertEquals( 100, underTest.getBalance());
    }


    @Test
    public void testIfBankObjectIsCreated() {
        Bank bank = new Bank();
    }

    @Test
    public void testingBankMap() {
        Bank bank = new Bank();
        bank.openNewAccount(underTest);
        Assert.assertEquals(1, bank.accounts.size());
    }

    @Test
    public void canWeGetAccountByID() {
        Bank bank = new Bank();
        bank.openNewAccount(underTest);
        Assert.assertEquals(underTest, bank.getAccount("12345"));
    }

    @Test
    public void testAccountClosing() {
        Bank bank = new Bank();
        bank.openNewAccount(underTest);
        bank.closeAccount("12345");
        Assert.assertEquals(0, bank.accounts.size());
    }


}