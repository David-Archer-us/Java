
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
	
	Button operation = null;
	String operant_1 = "";
	String operant_2 = "";
	double result = 0.0;

	public static void main(String[] args) {	
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		TextField display = new TextField();
		display.setPrefWidth(100);
		display.setAlignment(Pos.CENTER_RIGHT);
		
		Button button_0 = new Button("0");
		button_0.setPrefWidth(60);
		button_0.setPrefHeight(31);
		Button button_1 = new Button("1");
		button_1.setPrefWidth(60);
		button_1.setPrefHeight(31);
		Button button_2 = new Button("2");
		button_2.setPrefWidth(60);
		button_2.setPrefHeight(31);
		HBox hbox_1 = new HBox();
		hbox_1.getChildren().addAll(button_0, button_1, button_2);
		hbox_1.setSpacing(10);
		
		Button button_3 = new Button("3");
		button_3.setPrefWidth(60);
		button_3.setPrefHeight(31);
		Button button_4 = new Button("4");
		button_4.setPrefWidth(60);
		button_4.setPrefHeight(31);
		Button button_5 = new Button("5");
		button_5.setPrefWidth(60);
		button_5.setPrefHeight(31);
		HBox hbox_2 = new HBox();
		hbox_2.getChildren().addAll(button_3, button_4, button_5);
		hbox_2.setSpacing(10);
		
		Button button_6 = new Button("6");
		button_6.setPrefHeight(31);
		button_6.setPrefWidth(60);
		Button button_7 = new Button("7");
		button_7.setPrefWidth(60);
		button_7.setPrefHeight(31);
		Button button_8 = new Button("8");
		button_8.setPrefWidth(60);
		button_8.setPrefHeight(31);
		HBox hbox_3 = new HBox();
		hbox_3.getChildren().addAll(button_6, button_7, button_8);
		hbox_3.setSpacing(10);
		
		Button button_9 = new Button("9");
		button_9.setPrefWidth(60);
		button_9.setPrefHeight(31);
		Button button_d = new Button(".");
		button_d.setPrefWidth(60);
		button_d.setPrefHeight(31);
		Button button_ac = new Button("AC");
		button_ac.setPrefWidth(60);
		button_ac.setPrefHeight(31);
		HBox hbox_4 = new HBox();
		hbox_4.getChildren().addAll(button_9, button_d, button_ac);
		hbox_4.setSpacing(10);
		
		VBox vbox_1 = new VBox();
		vbox_1.getChildren().addAll(hbox_1, hbox_2, hbox_3, hbox_4);
		vbox_1.setSpacing(10);
		
		Button button_add = new Button("+");
		button_add.setPrefWidth(120);
		Button button_sub = new Button("-");
		button_sub.setPrefWidth(120);
		Button button_mul = new Button("*");
		button_mul.setPrefWidth(120);
		Button button_div = new Button("/");
		button_div.setPrefWidth(120);
		Button button_eql = new Button("=");
		button_eql.setPrefWidth(120);
		VBox vbox_2 = new VBox();
		vbox_2.getChildren().addAll(button_add, button_sub, button_mul, button_div, button_eql);
		vbox_2.setSpacing(7);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox_1, vbox_2);
		hbox.setSpacing(10);
		
		VBox root = new VBox();
		root.getChildren().addAll(display, hbox);
		root.setPadding(new Insets(15, 15, 15, 15));
		root.setSpacing(10);
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		
		stage.setX(300);
		stage.setY(250);
		stage.setTitle("Calculator");
		stage.show();
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Object source = (Object) event.getSource();
				if ((Button)source == button_add)
				{
					display.setText("");
					operation = button_add;
				}
				else if ((Button)source == button_mul)
				{
					display.setText("");
					operation = button_mul;
				}
				else if ((Button)source == button_sub)
				{
					display.setText("");
					operation = button_sub;
				}
				else if ((Button)source == button_div)
				{
					display.setText("");
					operation = button_div;
				}
				
				if ((Button)source == button_eql)
				{
					if(operation == button_add)
					{
						result = Double.parseDouble(operant_1) + Double.parseDouble(operant_2);
					}
					else if (operation == button_sub)
					{
						result = Double.parseDouble(operant_1) - Double.parseDouble(operant_2);
					}
					else if (operation == button_mul)
					{
						result = Double.parseDouble(operant_1) * Double.parseDouble(operant_2);
					}
					else if (operation == button_div)
					{
						result = Double.parseDouble(operant_1) / Double.parseDouble(operant_2);
					}
					
					display.setText(Double.toString(result));
					operant_1 = "";
					operant_2 = "";
					operation = null;
				}
				if((Button)source == button_ac)
				{
					display.setText("");
					operant_1 = "";
					operant_2 = "";
					operation = null;
				}
				
				Button[] operants = new Button[] {button_0, button_1, button_2, 
				                     button_3, button_4, button_5, 
				                     button_6, button_7, button_8, 
				                     button_9, button_d};
				List<Button> buttonList = Arrays.asList(operants);
				
				if (buttonList.contains((Button)source))
				{
					String s = ((Button)source).getText();
					if(operation == null)
					{
						operant_1 += s;
						display.setText(operant_1);
					}
					else
					{
						operant_2 += s;
						display.setText(operant_2);
					}
				}
			}
		};
		
		button_0.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_2.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_3.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_4.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_5.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_6.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_7.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_8.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_9.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_d.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_ac.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_add.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_sub.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_mul.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_div.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		button_eql.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	}
}
