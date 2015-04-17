package sexy.fedora.games.gaem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import sexy.fedora.games.gaem.screens.LoadScreen;
import sexy.fedora.games.gaem.screens.PlayScreen;

public class Main extends Game {

	private SpriteBatch batch;

	private static LoadScreen loadScreen;
	private static PlayScreen playScreen;

	@Override
	public void create() {
		batch = new SpriteBatch();

		initScreens();

		setScreen(loadScreen);
	}

	public void initScreens() {
		loadScreen = new LoadScreen();
		playScreen = new PlayScreen();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		batch.begin();
		getScreen().render(Gdx.graphics.getDeltaTime());
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
