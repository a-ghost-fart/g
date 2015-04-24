package sexy.fedora.games.gaem;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sexy.fedora.games.gaem.screens.LoadScreen;
import sexy.fedora.games.gaem.screens.PlayScreen;

public class Main extends Game {

	public static SpriteBatch batch;

	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	public static String TITLE = "Something";
	public AssetManager assetManager = new AssetManager();

	@Override
	public void create() {
		batch = new SpriteBatch();

		try {
			Gdx.graphics.setTitle(TITLE);
			Gdx.graphics.setVSync(true);
			Gdx.graphics.setDisplayMode(WIDTH, HEIGHT, false);
		} finally {
			setScreen(new LoadScreen(this));
		}
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
