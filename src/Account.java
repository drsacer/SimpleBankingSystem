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
        this.cardNumber = accountNumberWithoutCheckDigit + generateCheckDigit(accountNumberWithoutCheckDigit);
        return this.cardNumber;
    }

    public String makePIN () {
        String pin = String.format("%04d", (long) (Math.random() * 9999));
        this.pin = pin;
        return pin;
    }

    private static int generateCheckDigit(String number) {
        int sum = 0;
        int remainder = (number.length() + 1) % 2;
        for (int i = 0; i < number.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == remainder) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        int checkDigit = ((mod == 0) ? 0 : 10 - mod);

        return checkDigit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
