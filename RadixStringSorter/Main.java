package radixproject;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 * The GUI for the Radix String Sorter project. Allows the user to
 * choose the delimiter of his or her sorting process as well as
 * the separation method for each word.
 * @author Drake Doss
 * @version 2018.07.24
 *
 */
public class Main extends Application {
    
    private Group root;
    private ObservableList<Node> list;
    private Font defaultFont;
    private Color generalText;
    
    /**
     * Creates and initializes the GUI for visual use.
     */
	@Override
	public void start(Stage primaryStage) {
		try {
		    
		    // Initialize the window with welcoming text
		    setFields();
		    root = new Group();
		    list = root.getChildren();
		    Scene scene = new Scene(root);
		    initializeWindow(primaryStage, scene);
		    Text text = new Text("");
		    text = setText("Welcome to the Radix String\nSorter! Enter the "
		        + "text you \n desire to be sorted in the box\nto the right, "
		        + "then press\n the \"Sort\" button to sort the text.", 20, 20, 
		        defaultFont, generalText);
		    text.setTextAlignment(TextAlignment.CENTER);
		    Bounds textBounds = text.getLayoutBounds();
            double textWidth = textBounds.getWidth();
            double textHeight = textBounds.getHeight();
            double textPosX = text.getLayoutX();
            text.setY(50);
            
            // Create TextArea object to take user input.
		    TextArea txtbox = new TextArea();
		    txtbox.setPromptText("Enter text here");
		    txtbox.setEditable(true);
		    txtbox.setPrefHeight(400);
		    txtbox.setPrefWidth(350);
		    txtbox.setWrapText(true);
		    txtbox.setLayoutX(textPosX + textWidth + 25);
		    txtbox.setLayoutY(10);
		    
		    // Create a button for the user to sort their data with as well as
		    // a button for the user to exit the program.
		    Button sort = new Button("Sort");
		    sort.setStyle("-fx-border-color: rgba(153, 217, 234, 0.7); "
		        + "-fx-border-width: 5px; -fx-border-radius: 1px 1px 1px "
		        + "1px;");
		    ChoiceBox<String> outputType = new ChoiceBox<>();
		    outputType.getItems().addAll("Spaces", "New lines");
		    outputType.setValue("Spaces");
		    Button exit = new Button("Exit program");
		    
		    
		    // Create text to prompt the user for his or her String separation
		    // method
		    Text outputPrompt = setText("Select string \nseparation method:", 20, 
		        (int)(text.getY() + textHeight + 15), Font.font("Helvetica", 
		            FontWeight.NORMAL, 12), generalText);
		    
		    // Use the width and height of the Text object to help set the
		    // dropdown menu's coordinates
		    Bounds outPromptBounds = outputPrompt.getLayoutBounds();
		    double outputPromptWidth = outPromptBounds.getWidth();
		    double outputPromptHeight = outPromptBounds.getHeight();
		    outputType.setLayoutY(outputPrompt.getY() - 7);
		    outputType.setLayoutX(outputPromptWidth + outputPrompt.getX() + 10);
		    
		    // Create dropdown menu for user to choose a delimiter.
		    ChoiceBox<String> userDelimiter = new ChoiceBox<>();
		    userDelimiter.getItems().addAll("Whitespace", ", *", ". *", "| *", "\\ *", ",", ".", "|", "\\");
		    userDelimiter.setValue("Whitespace");
		    userDelimiter.setLayoutX(outputType.getLayoutX());
		    userDelimiter.setLayoutY(outputType.getLayoutY() + 40);
		    
		    // Create text object for user to be informed about delimiter choice.
		    Text userDelimPrompt = setText("Select delimiter:", 20, 
		        (int)(outputPrompt.getY() + outputPromptHeight + 15), 
		        Font.font("Helvetica", FontWeight.NORMAL, 12), generalText);
		    setActions(txtbox, scene, sort, outputType, userDelimiter, exit);
		    
		    // Add all visual nodes to the ObservableList of the Group root
		    list.addAll(text, txtbox, sort, outputType, outputPrompt, 
		        userDelimiter, userDelimPrompt, exit);
		    root.requestFocus();
		    primaryStage.setScene(scene);
		    primaryStage.show();
		    sort.setLayoutX(txtbox.getLayoutX());
            sort.setLayoutY(txtbox.getLayoutY() + txtbox.getHeight() + 5);
            sort.setPrefWidth(txtbox.getWidth());
            exit.setLayoutX(20);
            exit.setLayoutY(sort.getLayoutY());
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Launches the application with the GUI.
	 * @param args Args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * A method to create a new Text object with set parameters.
	 * @param text The String displayed by the Text object.
	 * @param x The x-coordinate of the Text object.
	 * @param y The y-coordinate of the Text object.
	 * @param font The font property of the Text object.
	 * @param color The color of the Text object.
	 * @return Returns the new Text object.
	 */
	public Text setText(String text, int x, int y, Font font, Color color) { 
	    Text temp = new Text();
	    temp.setText(text);
	    temp.setX(x);
	    temp.setY(y);
	    temp.setFill(color);
	    temp.setFont(font);
	    return temp;
	}
	
	/**
	 * Sets the default font and default font color for this GUI.
	 */
	private void setFields() {
        defaultFont = Font.font("Helvetica", FontWeight.BOLD, 20);
        generalText = Color.rgb(153, 217, 234);
	}
	
	/**
	 * Initializes the window, giving it a pretty icon and setting the size
	 * to a static 720x480 pixel dimension. Also defines its title and back-
	 * ground color.
	 * @param stage The stage of this GUI.
	 * @param scene The scene of this GUI.
	 */
	private void initializeWindow(Stage stage, Scene scene) {
	    stage.getIcons().add(new Image("file:radixstringsorter.png"));
	    stage.setResizable(false);
	    stage.setWidth(720);
	    stage.setHeight(480);
	    stage.setTitle("Radix String Sorter");
	    scene.setFill(Color.rgb(76, 76, 76));
	}
	
	/**
	 * Sets the actions of all user-interactive buttons.
	 * @param txtbox The TextArea object containing the user's String(s).
	 * @param scene The scene of this JavaFX GUI.
	 * @param sort The sort button.
	 * @param outputPrompt The dropdown menu for the String separation type.
	 * @param delimiter The delimiter choice dropdown menu.
	 * @param exit The exit button.
	 */
	private void setActions(TextArea txtbox, Scene scene, Button sort,
	    ChoiceBox<String> outputPrompt, ChoiceBox<String> delimiter, Button exit) {
	    
	    // Set up sort button
	    sort.setOnAction(e -> {
            String str = txtbox.getText();
            String delim = delimiter.getValue();
            Sorter slv = new Sorter(str, delim);
            InputAnalyzer ia = slv.getAnalyzer();
            
            slv.sort(ia.getNumPlaces());
            
            // Set up how the text will be displayed to the user based on his
            // or her choice
            if (outputPrompt.getValue() == "Spaces")
                txtbox.setText(slv.printOut());
            else
                txtbox.setText(slv.printOutWithNewLine());
        });
        
	    // Allow user to click out of TextArea to "unhighlight" it
	    scene.setOnMouseClicked(e -> {
            root.requestFocus();
        });
        
	    // Allow user to exit the program
	    exit.setOnAction(e -> {
	        System.exit(0);
	    });
	}
}
