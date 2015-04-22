package sexy.fedora.games.gaem.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import sexy.fedora.games.gaem.Main;
import sexy.fedora.games.gaem.characters.AbstractCharacter;
import sexy.fedora.games.gaem.characters.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayScreen extends AbstractScreen {

    private static final float TIME_STEP = 1 / 60f;
    private static final float CAM_SPEED = 5.0f;
    private static final float GRAVITY = -100f;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Player player;
    private List<AbstractCharacter> characters;

    private TiledMap map;
    private TiledMapRenderer tiledMapRenderer;

    // Physics shit
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    public PlayScreen(Main game) {
        super(game);
        characters = new ArrayList<AbstractCharacter>();
        camera = new OrthographicCamera(Main.WIDTH / 2, Main.HEIGHT / 2);
        batch = new SpriteBatch();

        // Physics!
        world = new World(new Vector2(0, GRAVITY), true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        map = new TmxMapLoader().load("test_map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);

        camera.position.set(10f, 10f, 0);
        camera.update();
    }

    @Override
    public void render(float delta) {
        handleInput(delta);
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        box2DDebugRenderer.render(world, camera.combined);
        world.step(TIME_STEP, 6, 4);

        for (AbstractCharacter character : characters) {
            character.update();
        }

        batch.begin();
        for (AbstractCharacter character : characters) {
            character.draw(batch);
        }
        batch.end();
    }

    private void handleInput(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.position.x -= CAM_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.position.x += CAM_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.position.y += CAM_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.position.y -= CAM_SPEED;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        player = new Player(game.assetManager.get("test_sprite.png", Texture.class), world);
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
