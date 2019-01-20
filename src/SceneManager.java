import java.util.Vector;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class SceneManager {

	private Vector<PanelBase> scenes = new Vector<PanelBase>();
	private int size = 0;
	private int curretNum = 1;

	private BorderPane usePanel;

	public SceneManager(BorderPane usePanel) {
		this.usePanel = usePanel;
	}

	public void nextScene() {

		if (curretNum == size)
			return;

		usePanel.setCenter(scenes.get(++curretNum - 1));

	}

	public void backScene() {

		if (curretNum != 1)
			usePanel.setCenter(scenes.get(--curretNum - 1));

	}

	public void addScene(PanelBase scene) {
		if (size == 0)
			usePanel.setCenter(scene);

		scenes.add(scene);

		size++;
	}

}
