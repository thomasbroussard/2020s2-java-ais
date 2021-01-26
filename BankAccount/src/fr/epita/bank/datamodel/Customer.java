package fr.epita.bank.datamodel;

public class Customer {

	private String name;
	public String address;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		//validation at datamodel level
		if (address.contains("WHERE") || address.contains("DROP")){
			return;
		}
		this.address = address;
	}
}
