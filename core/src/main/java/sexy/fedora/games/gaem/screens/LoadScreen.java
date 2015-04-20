package sexy.fedora.games.gaem.screens;

import com.badlogic.gdx.graphics.Texture;
import sexy.fedora.games.gaem.Main;

public class LoadScreen extends AbstractScreen {

    public LoadScreen(Main game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        if (game.assetManager.update()) {
            game.setScreen(Main.playScreen);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        game.assetManager.load("test_sprite.png", Texture.class);
        game.assetManager.finishLoading();
    }

    @Override
    public void hide() {

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
