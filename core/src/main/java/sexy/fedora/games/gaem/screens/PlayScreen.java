package sexy.fedora.games.gaem.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sexy.fedora.games.gaem.Main;
import sexy.fedora.games.gaem.characters.AbstractCharacter;
import sexy.fedora.games.gaem.characters.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayScreen extends AbstractScreen {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Player player;
    private List<AbstractCharacter> characters;

    public PlayScreen(Main game) {
        super(game);
        characters = new ArrayList<AbstractCharacter>();
        camera = new OrthographicCamera(Main.WIDTH / 2, Main.HEIGHT / 2);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        for (AbstractCharacter character : characters) {
            character.update();
        }

        batch.begin();
        for (AbstractCharacter character : characters) {
            character.draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        Texture playerTexture = game.assetManager.get("test_sprite.png", Texture.class);
        player = new Player(playerTexture);

        characters.add(player);
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
