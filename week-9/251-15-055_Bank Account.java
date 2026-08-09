public class BankAccount {

    private long balance = 0;
    private boolean open = false;

    public synchronized void open() {
        if (!open) {
            open = true;
            balance = 0;
        }
    }

    public synchronized void close() {
        if (open) {
            open = false;
        }
    }

    public synchronized long getBalance() {
        if (!open) {
            throw new IllegalStateException("Account is closed");
        }

        return balance;
    }

    public synchronized void deposit(long amount) {
        if (!open) {
            throw new IllegalStateException("Account is closed");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance += amount;
    }

    public synchronized void withdraw(long amount) {
        if (!open) {
            throw new IllegalStateException("Account is closed");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }
}
