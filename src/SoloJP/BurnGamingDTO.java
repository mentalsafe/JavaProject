package SoloJP;

public class BurnGamingDTO {
private String bId;
private String bPw;
private String bName;
private String bBirth;
private String bEmail;
private String bPhone;
private String bAccountType;
private int bAccount;
private int bCredit;
//////////////////////////////////////////////////////////////////////////////////
public String getbId() {
	return bId;
}

public void setbId(String bId) {
	this.bId = bId;
}

public String getbPw() {
	return bPw;
}

public void setbPw(String bPw) {
	this.bPw = bPw;
}

public String getbName() {
	return bName;
}

public void setbName(String bName) {
	this.bName = bName;
}

public String getbBirth() {
	return bBirth;
}

public void setbBirth(String bBirth) {
	this.bBirth = bBirth;
}

public String getbEmail() {
	return bEmail;
}

public void setbEmail(String bEmail) {
	this.bEmail = bEmail;
}

public String getbPhone() {
	return bPhone;
}

public void setbPhone(String bPhone) {
	this.bPhone = bPhone;
}

public String getbAccountType() {
	return bAccountType;
}

public void setbAccountType(String bAccountType) {
	this.bAccountType = bAccountType;
}

public int getbAccount() {
	return bAccount;
}

public void setbAccount(int bAccount) {
	this.bAccount = bAccount;
}

public int getbCredit() {
	return bCredit;
}

public void setbCredit(int bCredit) {
	this.bCredit = bCredit;
}
//////////////////////////////////////////////////////////////////////////////////

@Override
public String toString() {
	return "BurnGamingDTO [bId=" + bId + ", bPw=" + bPw + ", bName=" + bName + ", bBirth=" + bBirth + ", bEmail="
			+ bEmail + ", bPhone=" + bPhone + ", bAccountType=" + bAccountType + ", bAccount=" + bAccount + ", bCredit="
			+ bCredit + "]";
}

//////////////////////////////////////////////////////////////////////////////////

public BurnGamingDTO() {
	super();
}

public BurnGamingDTO(String bId, String bPw, String bName, String bBirth, String bEmail, String bPhone,
		String bAccountType, int bAccount, int bCredit) {
	super();
	this.bId = bId;
	this.bPw = bPw;
	this.bName = bName;
	this.bBirth = bBirth;
	this.bEmail = bEmail;
	this.bPhone = bPhone;
	this.bAccountType = bAccountType;
	this.bAccount = bAccount;
	this.bCredit = bCredit;
}



//////////////////////////////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////////////////////////
}
