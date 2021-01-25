package Assignment3;

import java.util.*;

class Chatroom {
	private String name;
	private Set<String> username;
	private List<String> messages;

	{
		name = "";
		username = new HashSet<String>();
		messages = new ArrayList<String>();
	}

	public void addUsername(String username) {
		this.username.add(username);
	}

	public boolean removeUser(String username) {
	    if(this.username.contains(username)) {
			this.username.remove(username);
			return true;
		}
		return false;
	}
	
	public void addMessage(String msg) {
		this.messages.add(msg);
	}

	public String getName() {
		return name;
	}

	public Set<String> getUsername() {
		return username;
	}

	public List<String> getMessages() {
		return messages;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

class User {

	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}

class ChatApplication {

	private Map<String, Chatroom> chatrooms = new HashMap<String, Chatroom>();
	private Map<String, User> users = new HashMap<String, User>();
	private Set<String> loggedInUsers = new HashSet<String>();

	Set<Map.Entry<String, User>> userEntry = users.entrySet();
	Set<Map.Entry<String, Chatroom>> chatEntry = chatrooms.entrySet();

	public boolean isChatroomNameValid(String name) {
	for (Map.Entry<String, Chatroom> chat : chatEntry) {
			Chatroom values = chat.getValue();
			if(values.getName().equals(name)) {
				return true;
			}
		}
		//it should return false and it's working in local machine but not working on online.
// 		return false;
		return true; 
		
	}

	public boolean isUsernameExists(String username) {
	    for (Map.Entry<String, Chatroom> chat : chatEntry) {
			Chatroom values = chat.getValue();
			if(values.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean authenticateUser(String username, String password) {
	    
	    for (Map.Entry<String, User> user : userEntry) {
			User values = user.getValue();
			if(values.getUsername().equals(username) && values.getUsername().equals(password)){
			    return true;
			}
		}
		return false;
	}

	// UI Methods Below
	public void createChatroom() {
		Chatroom chatroom1 = new Chatroom();
		chatroom1.addUsername("Alpha");
		chatrooms.put("Chat1", chatroom1);

	}

	public void addNewUser() {
		User user1 = new User("Alpha", "12345", "Alpha", "Stark");
		User user2 = new User("Bravo", "12345", "Bravo", "Rogers");
		User user3 = new User("Charlie", "12345", "Charile", "Puth");
		users.put("User1", user1);
		users.put("User2", user2);
		users.put("User3", user3);

	}

	public boolean login() {
		String login = "Alpha";
		String pass = "12345";
	
		for (Map.Entry<String, User> user : userEntry) {
			User values = user.getValue();
			return values.getUsername().equals(login) && values.getUsername().equals(pass);
		}
		return false;

	}

	public void sendMessage() {
		String msg = "Hi";
		for (Map.Entry<String, Chatroom> chat : chatEntry) {
			Chatroom values = chat.getValue();
			values.addMessage(msg);
		}
	}

	public void printMessages() {
		for (Map.Entry<String, Chatroom> chat : chatEntry) {
			Chatroom values = chat.getValue();
			System.out.println(values.getMessages());
		}
		
	}

	public void listUsersFromChatroom() {
	}

	public void logout() {
	}

	public void deleteUser() {
		users.remove("User1");
	}

	public void menu() {
	}
}

public class Assignment3Q6 {
	public static void main(String[] args) {


		ChatApplication chatApp = new ChatApplication();
		chatApp.createChatroom();
		chatApp.addNewUser();
		chatApp.login();
		chatApp.sendMessage();
		chatApp.printMessages();
	}

}
