

import javax.swing.JFrame;

import com.sun.javafx.scene.BoundsAccessor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainWindow extends Application{
/*
 * SearchFile 프로그램의 메인 UI 담당
 */
	
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage arg) throws Exception {
		
		TextField inputFileName = new TextField();
		Button searchBtn = new Button("검색");
		Label completeTimeOutput = new Label("예상시간 00:00");
		ProgressBar pb = new ProgressBar();
		TextArea progressOutput = new TextArea();
		
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		//Top
		HBox top = new HBox();
		top.setSpacing(5);
		
		inputFileName.setPromptText("파일 이름을 입력하시오");
	
		
		top.setHgrow(inputFileName, Priority.ALWAYS);
		top.getChildren().addAll(inputFileName , searchBtn);
		root.setTop(top);
		
		//Center
		BorderPane center = new BorderPane();
		
		center.setMargin(center, new Insets(10,0,0,0)); //위를 띄움
		
		VBox center_top = new VBox();
				
		//completeTimeOutput.setTextAlignment(TextAlignment.RIGHT); > 글짜를 오른쪽 정렬
		//completeTimeOutput.setAlignment(Pos.CENTER_RIGHT); > 컴포넌트를 오른쪽 배치
		pb.setPrefWidth(Double.MAX_VALUE);
	
		center_top.getChildren().addAll(completeTimeOutput , pb);	
		
		center.setTop(center_top);
		center.setCenter(progressOutput);
		center.setMargin(progressOutput, new Insets(5,0,5,0));
		progressOutput.setEditable(false);
		
		root.setCenter(center);
		root.getCenter().setVisible(false);
		
		//Action
		searchBtn.setOnAction(event -> {
			Search search = new Search(progressOutput, pb, completeTimeOutput);
			search.searchFile(inputFileName.getText());
			root.getCenter().setVisible(true);
		});	
		
		Scene scene = new Scene(root , 800 , 400);
		arg.setTitle("SearchFile");
		arg.setScene(scene);
		arg.show();
		
	}

}

/*
 * Hbox 는 HorizontalBox, Vbox는 VerticalBox 
 */
