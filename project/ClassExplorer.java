
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClassExplorer extends Application {

	Label prompt = new Label("Please enter the class file name/path :");
	TextField input = new TextField();
	Button submit = new Button("Submit");
	HBox hbox = new HBox();
	ScrollPane display = new ScrollPane();
	VBox root = new VBox();
	Scene scene = new Scene(root);
	Stage stage = new Stage();

	@Override
	public void start(Stage arg0) throws Exception {
		
		prompt.setTextFill(Color.BLUE);
		submit.setTextFill(Color.BLUEVIOLET);
		input.setPrefWidth(350);
		input.setStyle("-fx-text-inner-color: ORANGERED");
		hbox.getChildren().addAll(input, submit);
		hbox.setSpacing(10);
		display.setStyle("-fx-background-color:transparent;");
		display.setMinSize(400, 300);
		root.getChildren().addAll(prompt, hbox, display);
		root.setPadding(new Insets(15, 15, 15, 15));
		root.setSpacing(10);
		stage.setScene(scene);
		stage.setX(300);
		stage.setY(250);
		stage.setMinHeight(400);
		stage.setMinWidth(400);
		stage.setTitle("ClassExplorer");
		stage.show();
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() 
		{

			@Override
			public void handle(MouseEvent event) {
				
				String filename = input.getText();
				File file = new File(filename);
				filename = file.getName();
				int index = filename.indexOf(".java");
				if(index > 0)
				{
					filename = filename.substring(0, index);
				}
				
				try 
				{
					Class classs = Class.forName(filename);
					
					String methodString = "\nClass Methods:\n";
					Method[] methods = classs.getDeclaredMethods();
					for (Method method : methods)
					{
						methodString += method.toString() + "\n";
					}
					
					String attributeString = "\nClass Attributes:\n";
					Field[] fields = classs.getDeclaredFields();
					for(Field field : fields)
					{
						attributeString += field.toString() + "\n";
					}
					
					String result = methodString + attributeString;
					display.setContent(new Text(result));
				}
				catch (ClassNotFoundException e)
				{
					System.out.println(e);
				}
				catch (Exception ex)
				{
					System.out.println(ex);
				}
			}
		};
		
		submit.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	}
	
	public static void main(String[] args) {
		
		launch();
	}
}


