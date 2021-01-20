package strunk.entities;

public class Account {
	
	private int id;
	private int userId;
	private double balance;
	
	public Account() {
		super();
	}
	
	public Account(int userId) {
		super();
		this.userId = userId;
		this.balance = 0.0;
	}

	public Account(int id, int userId) {
		super();
		this.id = id;
		this.userId = userId;
	}

	public Account(int id, int userId, double balance) {
		super();
		this.id = id;
		this.userId = userId;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setAccountOwner(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + id + ", id=" + userId + ", balance=" + balance
				+ "]";
	}
	
}
