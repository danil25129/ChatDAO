package chatDAO.entities;

public class Clients {
	private int clientsCode;
	private String family;
	private String name;
	private String patronymic;
	private String passportData;
	private String comment;
	
	public Clients(int clientsCode, String family, String name, String patronymic, String passportData,
			String comment) {
		this.clientsCode = clientsCode;
		this.family = family;
		this.name = name;
		this.patronymic = patronymic;
		this.passportData = passportData;
		this.comment = comment;
	}

	public int getClientsCode() {
		return clientsCode;
	}

	public String getFamily() {
		return family;
	}

	public String getName() {
		return name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public String getPassportData() {
		return passportData;
	}

	public String getComment() {
		return comment;
	}
	
	
	
	
}
