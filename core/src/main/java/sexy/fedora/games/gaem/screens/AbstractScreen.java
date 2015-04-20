package sexy.fedora.games.gaem.screens;

import com.badlogic.gdx.Screen;
import sexy.fedora.games.gaem.Main;

public abstract class AbstractScreen implements Screen {

    protected Main game;

    public AbstractScreen(Main game) {
        this.game = game;
    }

}
