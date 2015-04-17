package sexy.fedora.games.gaem.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadState implements AbstractState {
    @Override
    public int getStateId() {
        return GameStates.LOAD;
    }

    @Override
    public void create() {
        Gdx.app.log("LOG", "Entered load state");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {

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
