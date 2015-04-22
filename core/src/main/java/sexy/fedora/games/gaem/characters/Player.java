package sexy.fedora.games.gaem.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends AbstractCharacter {

    private State currentState = State.IDLE;
    private boolean onGround = false;
    private Body body;

    public Player(Texture _texture, World world) {
        super(_texture, new Vector2(10.0f, 10.0f));
        something(world);
    }

    private void something(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(100, 300);

        body = world.createBody(bodyDef);

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(16f, 16f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = poly;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;

        body.createFixture(fixtureDef);

        poly.dispose();
    }

    public enum State {
        IDLE,
        WALKING,
        RUNNING,
        JUMPING
    }

    @Override
    public void update() {
        //sprite.setPosition(body.getPosition().x - (sprite.getWidth() / 2), body.getPosition().y - (sprite.getHeight() / 2));
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }
}
