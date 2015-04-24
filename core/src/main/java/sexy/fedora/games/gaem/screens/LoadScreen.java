package sexy.fedora.games.gaem.screens;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import sexy.fedora.games.gaem.Main;

import javax.xml.soap.Text;

public class LoadScreen extends AbstractScreen {

    public LoadScreen(Main game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        if (game.assetManager.update()) {
            game.setScreen(new PlayScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        game.assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        game.assetManager.load("test-assets/test_sprite.png", Texture.class);
        game.assetManager.load("test-assets/test_tileset.png", Texture.class);
        game.assetManager.load("test-assets/test_map.tmx", TiledMap.class);
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
