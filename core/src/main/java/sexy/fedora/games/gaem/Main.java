package sexy.fedora.games.gaem;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import sexy.fedora.games.gaem.states.*;

public class Main implements ApplicationListener {
	private SpriteBatch batch;
	private AbstractState currentState;
	private StateManager stateManager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		stateManager = new StateManager();

		initStates();
	}

	public void initStates() {
		stateManager.addState(new LoadState());
		stateManager.addState(new PlayState());

		currentState = stateManager.enterState(GameStates.LOAD);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		// Update the current state
		currentState.update();

		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		// Render the current state
		batch.begin();
		currentState.render(batch);
		batch.end();
	}

	@Override
	public void pause() {
		currentState.pause();
	}

	@Override
	public void resume() {
		currentState.resume();
	}

	@Override
	public void dispose() {
		currentState.dispose();
	}
}
