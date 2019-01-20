import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage arg) throws Exception {

		BorderPane root = new BorderPane();

		SceneManager mgr = new SceneManager(root);

		mgr.addScene(new StartPanel(arg));
		mgr.addScene(new SearchPanel(arg));

		root.setPadding(new Insets(5));

		HBox down = new HBox();

		Button afterBtn = new Button("다음");
		Button beforeBtn = new Button("이전");

		down.getChildren().addAll(beforeBtn, afterBtn);

		root.setBottom(down);

		afterBtn.setOnAction(event -> {
			mgr.nextScene();
		});
		beforeBtn.setOnAction(event -> {
			mgr.backScene();
		});

		Scene scene = new Scene(root, 800, 400);
		arg.setTitle("SearchFile");
		arg.setScene(scene);
		arg.show();

	}

}
