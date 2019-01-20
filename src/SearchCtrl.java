import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.Patch;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SearchCtrl {
	/*
	 * 파일 검색과 파일 검색에 관한 여러 이벤트 담당
	 */
	enum FindType {
		EXTENTION, NAME, ONLYNAME
	};

	private TextArea progressOutput;
	private ProgressBar pb;
	private Label completionTimeOutput;
	private File startFile;

	private int titleFileCount = 0;
	private float completionTime;
	private String searchFileName;
	private long size;
	private ArrayList<File> findFiles = new ArrayList<File>();

	private FindType findType;

	public SearchCtrl(TextArea progressOutput, ProgressBar pb, Label completionTimeOutput) {
		// TODO Auto-generated constructor stub
		this.progressOutput = progressOutput;
		this.pb = pb;
		this.completionTimeOutput = completionTimeOutput;
	}

	public void setSearchFileName(File startFile, String name) {

		this.startFile = startFile;

		int pos = name.lastIndexOf(".");

		findType = (pos == 0) ? FindType.EXTENTION : (pos != -1) ? FindType.NAME : FindType.ONLYNAME;

		this.searchFileName = fileNameFormat(name);

		// getSize(startFile);
		System.out.println(size);
	}

	public void startSearch() {

		progressOutput.setText("");
		searchFile(startFile);
	}

	private void searchFile(final File sendFile) {

		File file = sendFile;

		File[] files = file.listFiles();

		if (files == null)
			return;

		ArrayList<Integer> paths = new ArrayList<Integer>();

		int number = 0;

		if (file.isDirectory())
			printOutput(file.getName() + "을 탐색중입니다...");

		for (int i = 0; i < files.length; i++) {

			if (files[i].isDirectory()) {
				paths.add(i);
			} else {

				if (fileNameFormat(files[i].getName()).equals(searchFileName)) {
					findFiles.add(files[i]);
					number++;
				}
				printOutput(files[i].getName() + "(크기 : " + files[i].length() + "byte)");
				titleFileCount++;
				// dataSize -= files[i].length();
				// printProgressBar();
			}
			System.out.println(fileNameFormat(files[i].getName()) + "==? " + searchFileName);
		}

		printOutput(number + "개의 파일을 찾았습니다!");

		for (int i = 0; i < paths.size(); i++) {
			int index = paths.get(i);
			searchFile(files[index]);
		}

	}

	private void printProgressBar() {
		// pb.setProgress(dataSize / DATA_START_SIZE);
	}

	private void printOutput(String message) {
		progressOutput.appendText(message + "\n");
	}

	private void result() {
		ResultCtrl action = new ResultCtrl(this);
	}

	private String fileNameFormat(String fileName) {

		String newFilename = null;
		int pos = fileName.lastIndexOf(".");

		switch (findType) {
		case EXTENTION:
			newFilename = fileName.substring(pos+1);
			break;
		case NAME:
			newFilename = fileName.substring(0, pos);
			break;
		case ONLYNAME:
			newFilename = fileName;
			break;
		}

		return newFilename;
	}
}
/*
 * legth로는 폴더 하위 디렉토리의 크기를 바로 구할 수 없다
 */
