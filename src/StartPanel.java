import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class StartPanel extends PanelBase {

	public StartPanel(Stage arg) {
		
		HBox center = new HBox();
		
		Image backgroundImage = new Image("/image/background1.png");
		ImageView imv = new ImageView();		
		imv.setImage(backgroundImage);
		
		center.setHgrow(imv , Priority.ALWAYS);
		
		Label label = new Label("ÆÄÀÏ Å½»ö±â");
		
		center.getChildren().addAll( label);
		
		setCenter(center);
		
		
	}
}
