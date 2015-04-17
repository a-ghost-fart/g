package sexy.fedora.games.gaem.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface AbstractState {

    int getStateId();

    void create();

    void update();

    void render(SpriteBatch batch);

    void pause();

    void resume();

    void dispose();
}
