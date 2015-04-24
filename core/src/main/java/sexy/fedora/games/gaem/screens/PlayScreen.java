package sexy.fedora.games.gaem.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import sexy.fedora.games.gaem.Main;
import sexy.fedora.games.gaem.characters.AbstractCharacter;
import sexy.fedora.games.gaem.characters.Player;
import sexy.fedora.games.gaem.core.CollisionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
    private CollisionListener collisionListener;

    public PlayScreen(Main game) {
        super(game);
        characters = new ArrayList<AbstractCharacter>();
        camera = new OrthographicCamera(Main.WIDTH / 2, Main.HEIGHT / 2);
        batch = new SpriteBatch();

        // Physics!
        world = new World(new Vector2(0, GRAVITY), true);
        box2DDebugRenderer = new Box2DDebugRenderer();
        collisionListener = new CollisionListener();
        world.setContactListener(collisionListener);

        map = game.assetManager.get("test-assets/test_map.tmx");
        initMapColliders();
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

    private void initMapColliders() {
        MapObjects obstacles = map.getLayers().get("obstacles").getObjects();

        for (MapObject obstacle : obstacles) {
            // Yeah ok, only handling rectangles for now
            if (obstacle instanceof RectangleMapObject) {
                // Get the rectangle from the object layer
                Rectangle rect = ((RectangleMapObject) obstacle).getRectangle();
                // New body definition
                BodyDef bodyDef = new BodyDef();
                // Set to the position from the tiled map
                bodyDef.position.set(rect.getX(), rect.getY());
                // Create a body on the world
                Body rectBody = world.createBody(bodyDef);
                // Create the shape it'll be
                PolygonShape poly = new PolygonShape();
                // Set the box to be the object's dimensions
                poly.setAsBox(rect.getWidth(), rect.getHeight());
                // Create a fixture from all'a this
                rectBody.createFixture(poly, 0.0f);
                // Chuck out that box
                poly.dispose();
            }
        }

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

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        player = new Player(game.assetManager.get("test-assets/test_sprite.png", Texture.class), world);
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
