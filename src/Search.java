import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Search {
/*
 *파일 검색과 파일 검색에 관한 여러 이벤트 담당
 */
	TextArea progressOutput;
	ProgressBar pb;
	Label completionTimeOutput;
	
	private float completionTime;
	private int dataSize;
	
	public Search(TextArea progressOutput , ProgressBar pb , Label completionTimeOutput) {
		// TODO Auto-generated constructor stub
	
		this.progressOutput = progressOutput;
		this.pb = pb;
		this.completionTimeOutput = completionTimeOutput;
	}
	
	public void searchFile(String parentfileName) {	
		System.out.println("파일 이름이 전송되었습니다 : "+parentfileName);
		
		
		printProgress();
		
	}
	
	private void printProgress() {
		
	}
	
	private void result() {
		ResultAction action = new ResultAction(this);
	}
}
