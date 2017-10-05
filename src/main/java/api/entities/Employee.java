package api.entities;

import java.util.Calendar;

public class Employee {

	private long id;

	private String surname;

	private Calendar entry;

	private boolean active;

	public Employee(String surname, boolean active) {
		this.surname = surname;
		this.active = active;
		this.entry = Calendar.getInstance();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Calendar getEntry() {
		return entry;
	}

	public void setEntry(Calendar entry) {
		this.entry = entry;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", surname=" + surname + ", entry=" + entry + ", active=" + active + "]";
	}

}
