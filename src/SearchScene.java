import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class SearchScene extends SceneBase {

	File startFile = File.listRoots()[0];

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void startScene() {
		launch();
	}

	@Override
	public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
		TextField inputFileName = new TextField();
		Button searchBtn = new Button("검색");
		Button setParentBtn = new Button("...");
		Label label = new Label("시작폴더가 지정되어 있지 않습니다.");
		ProgressBar pb = new ProgressBar();
		TextArea progressOutput = new TextArea();

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));

		// Top
		HBox top = new HBox();
		top.setSpacing(5);

		inputFileName.setPromptText("파일 이름을 입력하시오");

		top.setHgrow(inputFileName, Priority.ALWAYS);
		top.getChildren().addAll(inputFileName, searchBtn, setParentBtn);
		root.setTop(top);

		// Center
		BorderPane center = new BorderPane();

		center.setMargin(center, new Insets(10, 0, 0, 0));

		VBox center_top = new VBox();

		pb.setPrefWidth(Double.MAX_VALUE);

		center_top.getChildren().addAll(label, pb);

		center.setTop(center_top);
		center.setCenter(progressOutput);
		center.setMargin(progressOutput, new Insets(5, 0, 5, 0));
		progressOutput.setEditable(false);

		pb.setVisible(false);
		progressOutput.setVisible(false);

		root.setCenter(center);

		// Action

		searchBtn.setOnAction(event -> {

			SearchCtrl search = new SearchCtrl(progressOutput, pb, label);
			search.setSearchFileName(startFile, inputFileName.getText());

			pb.setVisible(true);
			progressOutput.setVisible(true);

			search.startSearch();

		});

		setParentBtn.setOnAction(event -> {
			DirectoryChooser dc = new DirectoryChooser();
			File setFile = dc.showDialog(arg);

			if (setFile != null) {
				startFile = setFile;
				label.setText(startFile.getAbsolutePath());
			}
		});

		Scene scene = new Scene(root, 800, 400);
		arg.setTitle("SearchFile");
		arg.setScene(scene);
		arg.show();
	}

}
