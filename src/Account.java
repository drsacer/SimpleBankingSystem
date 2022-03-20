import java.util.List;

public class Account {

    private String cardNumber;
    private String pin;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String makeAccountNumber () {
        String accountNumberWithoutCheckDigit = "400000" + String.format("%09d", (long) (Math.random() * 999999999L));
        this.cardNumber = accountNumberWithoutCheckDigit;
        return accountNumberWithoutCheckDigit;
    }

    public String makePIN () {
        String pin = String.format("%04d", (long) (Math.random() * 9999));
        this.pin = pin;
        return pin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
