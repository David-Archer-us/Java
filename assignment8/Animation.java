
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	Menu shapes = new Menu("Shapes");
	RadioMenuItem sphere = new RadioMenuItem("Sphere");
	RadioMenuItem cylinder = new RadioMenuItem("Cylinder");
	RadioMenuItem box = new RadioMenuItem("Box");
	RadioMenuItem polygon = new RadioMenuItem("Polygon");
	ToggleGroup shapeGroup = new ToggleGroup();
	
	Menu animation = new Menu("Animation");
	RadioMenuItem rotateTransition = new RadioMenuItem("RotateTransition");
	RadioMenuItem scaleTransition = new RadioMenuItem("ScaleTransition");
	RadioMenuItem fadeTransition = new RadioMenuItem("FadeTransition");
	RadioMenuItem sequentialTransition = new RadioMenuItem("SequentialTransition");
	ToggleGroup actionGroup = new ToggleGroup();
	
	Object sphereShape = new Sphere();
	Cylinder cylinderShape = new Cylinder();
	Box boxShape = new Box();
	Polygon polygonShape = new Polygon();

	GridPane gridLayout = new GridPane();
	VBox root = new VBox();
	
	Scene scene = new Scene(root, 230, 250);
	Stage stage = new Stage();
	
	public void acting(RadioMenuItem shapeItem, RadioMenuItem actionItem)
	{
		Object shape = null;
		if (shapeItem == sphere)
		{
			shape = sphereShape;
		}
		else if(shapeItem == cylinder)
		{
			shape = cylinderShape;
		}
		else if(shapeItem == box)
		{
			shape = boxShape;
		}
		else if(shapeItem == polygon)
		{
			shape = polygonShape;
		}
		
		if(actionItem == rotateTransition)
		{
			RotateTransition rotate = new RotateTransition();
			rotate.setDuration(Duration.millis(500));
			rotate.setNode((Node)shape);
			rotate.setByAngle(360);
			rotate.setCycleCount(5);
			rotate.setAutoReverse(true);
			rotate.play();
		}
		if(actionItem == scaleTransition)
		{
			ScaleTransition scale = new ScaleTransition();
			scale.setDuration(Duration.millis(500));
			scale.setNode((Node)shape);
			scale.setByY(0.5);
			scale.setByX(0.5);
			scale.setByZ(0.5);
			scale.setCycleCount(6);
			scale.setAutoReverse(true);
			scale.play();
		}
		if(actionItem == fadeTransition)
		{
			FadeTransition fade = new FadeTransition();
			fade.setDuration(Duration.millis(1000));
			fade.setNode((Node)shape);
			fade.setFromValue(10);
			fade.setToValue(0.1);
			fade.setCycleCount(10);
			fade.setAutoReverse(true);
			fade.play();
		}
		
		if(actionItem == sequentialTransition)
		{
			RotateTransition rotate = new RotateTransition();
			rotate.setDuration(Duration.millis(250));
			rotate.setNode((Node)shape);
			rotate.setAxis(Rotate.Z_AXIS);
			rotate.setByAngle(360);
			rotate.setCycleCount(5);
			rotate.setAutoReverse(true);
			
			ScaleTransition scale = new ScaleTransition();
			scale.setDuration(Duration.millis(250));
			scale.setNode((Node)shape);
			scale.setByY(0.5);
			scale.setByX(0.5);
			scale.setByZ(0.5);
			scale.setCycleCount(6);
			scale.setAutoReverse(true);
			
			FadeTransition fade = new FadeTransition();
			fade.setDuration(Duration.millis(250));
			fade.setNode((Node)shape);
			fade.setFromValue(10);
			fade.setToValue(0.1);
			fade.setCycleCount(10);
			fade.setAutoReverse(true);
			
			SequentialTransition sequential = new SequentialTransition(scale, rotate, fade);
			sequential.play();
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {

		shapeGroup.getToggles().addAll(sphere, cylinder, box, polygon);
		shapes.getItems().addAll(sphere, cylinder, box, polygon);
		
		actionGroup.getToggles().addAll(rotateTransition, scaleTransition, fadeTransition, sequentialTransition);
		animation.getItems().addAll(rotateTransition, scaleTransition, fadeTransition, sequentialTransition);
		
		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(shapes, animation);
		
		((Sphere)sphereShape).setRadius(50.0f);
		PhongMaterial sphereMaterial = new PhongMaterial();
		sphereMaterial.setDiffuseColor(Color.LIGHTSTEELBLUE);
		((Sphere)sphereShape).setMaterial(sphereMaterial);

		cylinderShape.setRadius(50.0f);
		cylinderShape.setHeight(60);
		PhongMaterial cylinderMaterial = new PhongMaterial();
		cylinderMaterial.setDiffuseColor(Color.LIGHTPINK);
		cylinderShape.setMaterial(cylinderMaterial);
		
		boxShape.setDepth(80);
		boxShape.setHeight(80);
		boxShape.setWidth(80);
		PhongMaterial boxMaterial = new PhongMaterial();
		boxMaterial.setDiffuseColor(Color.GOLD);
		boxShape.setMaterial(boxMaterial);

		polygonShape.getPoints().addAll(new Double[] {
				350.0, 350.0,
				400.0, 350.0,
				450.0, 380.0,
				400.0, 400.0,
				380.0, 450.0,
				350.0, 450.0,
		});
		PhongMaterial polygonMaterial = new PhongMaterial();
		polygonMaterial.setSpecularColor(Color.AQUAMARINE);
		polygonShape.setFill(Color.AQUAMARINE);

		gridLayout.setGridLinesVisible(true);
		gridLayout.addRow(0, (Sphere)sphereShape, cylinderShape);
		gridLayout.addRow(1, boxShape, polygonShape);
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		gridLayout.setPadding(new Insets(10, 10, 10, 10));
		gridLayout.setAlignment(Pos.CENTER);
	
		root.getChildren().addAll(menubar, gridLayout);
		root.setPadding(new Insets(0, 0, 15, 0));
		
		stage.setScene(scene);
		stage.setX(200);
		stage.setY(300);
		stage.setMinHeight(295);
		stage.setMinWidth(230);
		stage.setTitle("Homework8-Exercise2");
		stage.show();
		
		EventHandler<ActionEvent> shapeHandler = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				RadioMenuItem sourceAction = (RadioMenuItem)actionGroup.getSelectedToggle();
				RadioMenuItem sourceShape = (RadioMenuItem)event.getSource();
				
				if(sourceShape == sphere || sourceShape == cylinder || sourceShape == box)
				{
					fadeTransition.setDisable(true);
				}
				if(sourceShape == polygon)
				{
					fadeTransition.setDisable(false);
				}
				
				acting(sourceShape, sourceAction);
			}
		};
		
		EventHandler<ActionEvent> actionHandler = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				RadioMenuItem sourceAction = (RadioMenuItem)event.getSource();
				RadioMenuItem sourceShape = (RadioMenuItem)shapeGroup.getSelectedToggle();
				
				if(sourceShape == sphere || sourceShape == cylinder || sourceShape == box)
				{
					fadeTransition.setDisable(true);
				}
				if(sourceShape == polygon)
				{
					fadeTransition.setDisable(false);
				}
				
				acting(sourceShape, sourceAction);
			}
		};
		
		sphere.setOnAction(shapeHandler);
		cylinder.setOnAction(shapeHandler);
		box.setOnAction(shapeHandler);
		polygon.setOnAction(shapeHandler);
		rotateTransition.setOnAction(actionHandler);
		scaleTransition.setOnAction(actionHandler);
		fadeTransition.setOnAction(actionHandler);
		sequentialTransition.setOnAction(actionHandler);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
