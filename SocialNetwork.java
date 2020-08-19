import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// use javaFX to build GUI
public class SocialNetwork extends Application {
	// attribute
	private static Graph network;
	// constructor
	public SocialNetwork()
	{
		network = new Graph();
	}
	// create the class Profile
	static class Profile
	{
		private String email;
		private String name;
		private String status;
		private String imageFile;
		private List<String> friends;  // list of friends's email
		// constructor
		Profile(String sEmail, String sName, String sStatus)
		{
			email = sEmail;
			name = sName;
			status = sStatus;
			imageFile = "";
			friends = new LinkedList<>(); // use a linkedList to fix the order
		}
		// some setters
		public void setEmail(String sEmail)
		{
			email = sEmail;
		}
		public void setName(String sName)
		{
			name = sName;
		}
		public void setStatus(String sStatus)
		{
			status = sStatus;
		}
		public void setImageFile(String sImageFile)
		{
			imageFile = sImageFile;
		}
		// email will be frined's id
		public void addFriendUsername(String email)
		{
			// check if the friend is already in the list
			if(!friends.contains(email))
			{
				friends.add(email);
			}
		}
		// cut off some friendship
		public void removeFriendUsername(String username)
		{
			friends.remove(username);
		}
		//some getters
		public String getName()
		{
			return name;
		}
		public String getStatus()
		{
			return status;
		}
		// get a list of friends
		public List<String> getFriends()
		{
			return friends;
		}
		public String getEmail()
		{
			return email;
		}
		public String getImageFile()
		{
			return imageFile;
		}
		// override toString()
		public String toString()
		{
			String result = "Name: " + name + ", \nEmail: " + email + ", \nStatus: "
					+ status + "\nFriends: ";
			for (String email : friends)
			{
				result += network.map.get(email).getName() + ", ";
			}
			return result;
		}
	}
	// create the class Graph
	static class Graph { 
		  
	    // We use Hashmap to store the edges in the graph 
	    private Map<String, Profile> map = new HashMap<>(); 
	  
	    // This function adds a new vertex to the graph 
	    public String addVertex(Profile person) 
	    { 
	    	String email = person.getEmail();
	    	if (!map.containsKey(email))
	    	{
	    		map.put(email, person); 
	    		return email;
	    	}
	    	else
	    	{
	    		return null;
	    	}
	    } 
	    // get the profile of a friend in the graph
	    public Profile getVertex(String email)
	    {
	    	if (map.containsKey(email))
	    	{
	    		return map.get(email);
	    	}
			return null;	
	    }
	  
	    // This function adds the edge 
	    // between source to destination 
	    public String addEdge(String email_1, String email_2) 
	    { 
	        if (map.containsKey(email_1) && map.containsKey(email_2)) {
	        	map.get(email_1).addFriendUsername(email_2); 
		        map.get(email_2).addFriendUsername(email_1);
		        String result = map.get(email_1).getName() + " and " 
		        		+ map.get(email_2).getName() + " has been best friends.";
		        return result;
	        }
	        else
	        {
	        	return null;
	        }
	    } 
	    
	    // get the adjacency list of each vertex. 
	    @Override
	    public String toString() 
	    { 
	        StringBuilder builder = new StringBuilder(); 
	  
	        for (String email : map.keySet()) { 
	            builder.append(email + ": "); 
	            for (String friendsEmail : map.get(email).getFriends()) { 
	                builder.append(friendsEmail + " "); 
	            } 
	            builder.append("\n"); 
	        }  
	        return (builder.toString()); 
	    } 
	} 
	// method adding a new user
	String addUser(Profile person)
	{
		return network.addVertex(person);
	}
	// method for a person quitting
	String leave(String email)
	{
		if(network.map.containsKey(email))
		{
			for (String friendsEmail: network.map.get(email).getFriends())
			{
				network.map.get(friendsEmail).getFriends().remove(email);
			}
			network.map.remove(email);
			return "This person has been moved from the network.";
		}
		else
		{
			return "This person is not in the network.";
		}
	}
	// method for modifying the profile
	String modifyProfile(Profile person)
	{
		if(network.map.containsKey(person.getEmail()))
		{
			network.map.put(person.getEmail(), person);
			return "You have modified you profile.";
		}
		else
		{
			return "This person is not in the network.";
		}
	}
	// method for check the profile
	String getProfile(String email)
	{
		if(network.map.containsKey(email))
		{
			return network.map.get(email).toString();
		}
		else
		{
			return "This person is not in the network.";
		}
	}
	// method for add a new friend
	String addFriend(String email_1, String email_2)
	{
		return network.addEdge(email_1, email_2);
	}
	// method for a person get the friends list
	List getFriendsList(String email)
	{
		if(network.map.containsKey(email))
		{
			return network.map.get(email).getFriends();
		}
		else
		{
			return null;
		}
	}
	// method to view friends list
	String viewFriendsList(String email)
	{
		String result = "";
		if(network.map.containsKey(email))
		{
			result = "\n" + network.map.get(email).getName() + "'s Friends:\n";
			List<String> friends = getFriendsList(email);
			for (String friendEmail : friends)
			{
				result += network.map.get(friendEmail).getName() + ", ";
			}
		}
		else
		{
			result += "This person is not in the network.";
		}
		return result;
	}
	// method to view friends' friends
	String viewFriendsFriendsList(String email)
	{
		String result = "";
		if(network.map.containsKey(email))
		{
			result += "\n" + network.map.get(email).getName() + "'s Friends' Friends:\n";
			List<String> friendsemails = getFriendsList(email);
			for (String friendsemail : friendsemails)
			{
				String friendsName = network.map.get(friendsemail).getName();
				result += "\n" + friendsName + "'s Friends: \n";
				List<String> friendsfriendsemails = getFriendsList(friendsemail);
				for (String friendsfriendsemail: friendsfriendsemails)
				{
					result += network.map.get(friendsfriendsemail).getName() + ", ";
				}
			}
		}
		else
		{
			result += "This person is not in the network.";
		}
		return result;
	}
	// main function call this start() method
	@Override
	public void start(Stage arg0) throws Exception {
		// initialize the graph and some examples
		SocialNetwork socialNetwork = new SocialNetwork();
		Profile newP = new Profile("a@sjsu.edu", "James Smith", "Executive Memeber");
		newP.setImageFile("https://images.unsplash.com/photo-1587461680328-b1f484811c8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80");
		Profile newQ = new Profile("b@sjsu.edu", "Jill Holmes", "Professor");
		Profile newR = new Profile("c@sjsu.edu", "Tom Thomas", "Business Lecturer");
		Profile newS = new Profile("d@sjsu.edu", "Lisa Dickinson", "Newbie");
		// put those examples in the graph
		socialNetwork.addUser(newP);
		socialNetwork.addUser(newQ);
		socialNetwork.addUser(newR);
		socialNetwork.addUser(newS);
		socialNetwork.addFriend(newP.getEmail(), newQ.getEmail());
		socialNetwork.addFriend(newP.getEmail(), newR.getEmail());
		socialNetwork.addFriend(newQ.getEmail(), newS.getEmail());
		socialNetwork.addFriend(newS.getEmail(), newR.getEmail());
		socialNetwork.addFriend(newR.getEmail(), newQ.getEmail());
		// set up the GUI
		Label first = new Label("Start here!");
		first.setPrefWidth(100);
		first.setBackground(new Background(new BackgroundFill(Color.PEACHPUFF, null, null)));
		first.setPrefHeight(25);
		first.setRotate(5);
		first.setTextFill(Color.DARKCYAN);
		first.setAlignment(Pos.CENTER);
		// set up the choices
		ChoiceBox<String> choices = new ChoiceBox<>();
		choices.getItems().addAll("Please select the function you desired :", 
				"Join the network", "Leave the network", "Create a new profile",
				"Modify my profile", "Add/Change my image", "Search for a profile",
				"Add a friend", "Remove a friend",
				"View my friends", "View my friends' friends");
		choices.setMinWidth(300);
		choices.setValue("Please select the function you desired :");
		HBox hbox0 = new HBox();
		hbox0.getChildren().addAll(first, choices);
		hbox0.setSpacing(10);
		// create the prompt for users
		Label asking = new Label(" ");
		asking.setTextFill(Color.PURPLE);
		asking.setMaxWidth(400.0);
		asking.setMinHeight(50);
		asking.setWrapText(true);
		Separator separator = new Separator();
		// indicate the purposes of the textFields respectively
		Label nameLabel = new Label(" ");
		nameLabel.setTextFill(Color.BLUE);
		TextField nameField = new TextField();
		nameField.setStyle("-fx-text-inner-color: ORANGERED");
		nameField.setPrefWidth(100);
		Label emailLabel = new Label(" ");
		emailLabel.setTextFill(Color.BLUE);
		TextField emailField = new TextField();
		emailField.setStyle("-fx-text-inner-color: ORANGERED");
		emailField.setPrefWidth(100);
		Label statusLabel = new Label(" ");
		statusLabel.setTextFill(Color.BLUE);
		VBox  vbox = new VBox();
		vbox.getChildren().addAll(asking, separator, emailLabel, emailField, nameLabel, nameField, statusLabel);
		vbox.setSpacing(10);
		TextField statusField = new TextField();
		statusField.setStyle("-fx-text-inner-color: ORANGERED");
		statusField.setPrefWidth(300);
		// set up the submit button for users
		Button submit = new Button("Submit");
		submit.setPrefWidth(100);
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(statusField, submit);
		hbox1.setSpacing(10);
		// set up the display area
		ScrollPane display = new ScrollPane();
		display.setStyle("-fx-background-color:transparent;");
		display.setMinSize(200, 150);
		display.setMaxSize(200, 200);
		// initialize the image area
		String imageFile = "https://images.unsplash.com/photo-1587618420001-024eaae2aa7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60";
		ImageView image = new ImageView(new Image(imageFile));
		image.setFitHeight(200);
		image.setFitWidth(200);
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(display, image);
		// set up the scene and stage
		VBox root = new VBox();
		root.getChildren().addAll(hbox0, vbox, hbox1, hbox2);
		root.setPadding(new Insets(15, 15, 15, 15));
		root.setSpacing(10);
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setX(200);
		stage.setY(300);
		stage.setMinHeight(250);
		stage.setMinWidth(400);
		stage.setMaxWidth(500);
		stage.setTitle("Welcome to the Social Network!");
		stage.show();
		
		// create the event handler for user's choice
		EventHandler<ActionEvent> choiceEventHandler = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				// initialize the UI
				display.setContent(new Text(" "));
				image.setImage(null);
				nameLabel.setText(" ");
				emailLabel.setText(" ");
				statusLabel.setText(" ");
				nameField.clear();
				emailField.clear();
				statusField.clear();
				asking.setText(" ");
				// get the choice of user
				String choice = choices.getValue();
				if (choice != "Please select the function here :")
				{
					// give feedback to user depending on the choice of "create new profile"
					if(choice == "Create a new profile")
					{
						asking.setText("Please enter your name, email, and status");
						nameLabel.setText("Name: ");
						emailLabel.setText("Email:");
						statusLabel.setText("Status:");
					}
					// feedback for "add/change my image"
					if(choice == "Add/Change my image")
					{
						asking.setText("Please enter your email and your imagefile path");
						emailLabel.setText("Email:");
						nameLabel.setText("Imagefile name/path:");
						
					}
					// feedback for "join the network"
					if(choice == "Join the network")
					{
						asking.setText("Please enter your name, email, and status");
						nameLabel.setText("Name: ");
						emailLabel.setText("Email:");
						statusLabel.setText("Status:");
					}
					// feedback for "leave the network"
					if(choice == "Leave the network")
					{
						asking.setText("Please enter your email");
						emailLabel.setText("Email:");
					}
					// feedback for "modify my profile"
					if(choice == "Modify my profile")
					{
						asking.setText("Please enter your name, email, and status");
						nameLabel.setText("Name: ");
						emailLabel.setText("Email:");
						statusLabel.setText("Status:");
					}
					// feedback for "search for a profile"
					if(choice == "Search for a profile")
					{
						asking.setText("Please enter the email");
						emailLabel.setText("Email:");
					}
					// feedback for "add a friend"
					if(choice == "Add a friend")
					{
						asking.setText("Please enter your own and your friend's emails. "
								+ "\nIf your friend is not in the network, "
								+ "\nplease also enter your friend's name and status.");
						nameLabel.setText("Your Friend's Name: ");
						emailLabel.setText("Your email, then Your friend's email, separate by comma :");
						statusLabel.setText("Your Friend's Status:");
					}
					// feedback for "remove a friend"
					if(choice == "Remove a friend")
					{
						asking.setText("please enter your email and your friend's email");
						emailLabel.setText("Your email:");
						nameLabel.setText("Your friend's email:");
					}
					// feedback for "view my friends"
					if (choice == "View my friends")
					{
						asking.setText("Please enter your email");
						emailLabel.setText("Your email");
					}
					// feedback for "view my friends' friends"
					if (choice == "View my friends' friends")
					{
						asking.setText("Please enter your email");
						emailLabel.setText("Your email");
					}
				}
			}
		};
		// set up event handler for user's submit
		EventHandler<MouseEvent> textFieldHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// get the user's answers
				String email = emailField.getText().trim();
				String name = nameField.getText();
				String status = statusField.getText();
				String choice = choices.getValue();
				// action for "create a new profile" with the answers
				if(choice == "Create a new profile")
				{
					Profile person = new Profile(email, name, status);
					if (socialNetwork.network.map.containsKey(email))
					{
						display.setContent(new Text("Your profile is already in the network."));
					}
					else
					{
						String announcement = "Your username in the network is: " + socialNetwork.addUser(person);
						display.setContent(new Text(name + "'s profile has been created.\n" + announcement));
					}
				}
				// action for "add/change my image" with the answers
				if(choice == "Add/Change my image")
				{
					if (socialNetwork.network.map.containsKey(email))
					{
						display.setContent(new Text("You have added/changed your image file."));
						socialNetwork.network.map.get(email).setImageFile(name);
						
					}
					else
					{
						display.setContent(new Text("This person is not in the network."));
					}
				}
				// action for "join the network" with the answers
				if (choice == "Join the network")
				{
					Profile person = new Profile(email, name, status);
					if (socialNetwork.network.map.containsKey(email))
					{
						display.setContent(new Text("Your profile is already in the network."));
					}
					else
					{
						String announcement = "Your username in the network is: " + socialNetwork.addUser(person);
						display.setContent(new Text(name + "'s profile has been created.\n" + announcement));
					}
				}
				// action for "leave the network" with the answers
				if (choice == "Leave the network")
				{
					display.setContent(new Text(socialNetwork.leave(email) + " We'll miss you!"));
				}
				// action for "modify my profile" with the answers
				if (choice == "Modify my profile")
				{
					Profile person = new Profile(email, name, status);
					display.setContent(new Text(socialNetwork.modifyProfile(person)));
				}
				// action for "search for a profile" with the answers
				if (choice == "Search for a profile")
				{
					display.setContent(new Text(socialNetwork.getProfile(email)));
					String photofile = socialNetwork.network.map.get(email).getImageFile();
					if (photofile != "")
					{
						image.setImage(new Image(photofile));
					}
					
				}
				// action for "add a friend" with the answers
				if (choice == "Add a friend")
				{
					String[] emails = email.split(",");
					String yemail = emails[0].trim();
					String femail = emails[1].trim();
					Profile fperson = new Profile(femail, name, status);
					String result = "";
					if (socialNetwork.network.map.containsKey(femail))
					{
						result += "Your friend is already in the network.\n";
					}
					else
					{
						result += "Your friend's username in the network is: ";
						result += socialNetwork.addUser(fperson) + "\n";
					}
					
					if (socialNetwork.network.map.containsKey(yemail))
					{
						result += socialNetwork.addFriend(yemail, femail);
					}
					else
					{
						result += "You are not in the network.";
					}
					display.setContent(new Text(result));
				}
				// action for "remove a friend" with the answers
				if(choice == "Remove a friend")
				{
					if (!socialNetwork.network.map.containsKey(name))
					{
						display.setContent(new Text("Your friend is not in the network"));
					}
					else if (!socialNetwork.network.map.containsKey(email))
					{
						display.setContent(new Text("You are not in the network"));
					}
					else
					{
						socialNetwork.network.map.get(email).getFriends().remove(name);
						socialNetwork.network.map.get(name).getFriends().remove(email);
						display.setContent(new Text("You have cut off the friend."));
					}
				}
				// action for "view my friends" with the answers
				if (choice == "View my friends")
				{
					display.setContent(new Text(socialNetwork.viewFriendsList(email)));
				}
				// action for "view my frineds' friends" with the answers
				if (choice == "View my friends' friends")
				{
					display.setContent(new Text(socialNetwork.viewFriendsFriendsList(email)));
				}
			}	
		};
		// set up the handler for the events
		choices.setOnAction(choiceEventHandler);
		submit.addEventHandler(MouseEvent.MOUSE_CLICKED, textFieldHandler);	
	}
	// main function
	public static void main(String[] args) {
		Application.launch(args);
	}
}

