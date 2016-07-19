package bean;

public class Kullanici {

	private String email="";

	private String password="";

	private String message="" ;
	
	
	public Kullanici(String email, String password) {

		this.email = email;
		this.password = password;
	}
	
	public Kullanici() {
		// TODO Auto-generated constructor stub
	}

	
	public void setMessage(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean validate(){
		
		String messages[]={
				"email boþ olamaz.",
				"geçersiz email.",
				"parola boþ olamaz",
				"parola en az 8 karakter olmalý",
				"parola boþluk karakter içeremez"
				};
		 
		 if (email=="") {
			message+=messages[0];
			return false;
		}if(!email.matches("\\w+@\\w+\\.\\w+")){
			message=messages[1];
			return false;
		}if (password=="") {
			 message=messages[2];
			return false;
		 
		 
		}if(password.length()<8){
			message=messages[3];
			return false;
		} if(password.matches("\\w*\\s+\\w*")){
			message=messages[4];
			return false;
		}
		
		 
		
		 
		 
		
		 
		 return true;
	}

}
