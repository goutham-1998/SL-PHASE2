import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ValidateUser {

	public static boolean validate(String uname, String pass) {
		Map<String,String> u= getUsers();
		Iterator it = u.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry element = (Map.Entry) it.next();
			if(pass.equals(element.getValue()) && uname.equals(element.getKey())) {
				return true;
			}
			
		}
		return false;
	}



	private static Map<String, String> getUsers() {
		Map<String,String> users = new HashMap<>();
		users.put("Ram","1234");
		users.put("Goutham","1234");
		users.put("Vinay","5678");
		users.put("Sanjana","5678");
		
		return users;
	}
}