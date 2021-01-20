package strunk.entities;

import java.time.LocalDateTime;

public class Transaction {
	
	// LocalDateTime.now()
	
	private int id;
	private int userId;
	private int accountNumber;
	private double amount;
	private LocalDateTime transactionDateTime;
	private String transactionDateTimeString;
	
	public Transaction() {
		super();
	}

	public Transaction(int userId, int accountNumber, double amount) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public Transaction(int userId, int accountNumber, double amount,
			String transactionDateTimeString) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionDateTimeString = transactionDateTimeString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionDateTimeString() {
		return transactionDateTimeString;
	}

	public void setTransactionDateTimeString(String transactionDateTimeString) {
		this.transactionDateTimeString = transactionDateTimeString;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", accountNumber="
				+ accountNumber + ", amount=" + amount + ", transactionDateTime=" + transactionDateTime
				+ ", transactionDateTimeString=" + transactionDateTimeString + "]";
	}

}
