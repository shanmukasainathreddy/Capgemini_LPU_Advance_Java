package mockito;

public class UserService {
	private UserDao dao;
	
	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	public String typeOfUser(int id) {
		   User u = dao.findById(id);
		   
		   if(u.getBalance() > 0 && u.getBalance() <=  1000) return "New Account Holder";
			else if(u.getBalance() > 1001 && u.getBalance() <=2000) return "Regular Account Holder";
			else return "Premium Account Holder";
}
}
