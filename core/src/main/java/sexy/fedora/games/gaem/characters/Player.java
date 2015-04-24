package sexy.fedora.games.gaem.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends AbstractCharacter {

    private State currentState = State.IDLE;
    private boolean onGround = false;
    private Body body;

    private static final float MOVEMENT_FORCE = 5f;
    private static final float MAX_VELOCITY = 20f;

    public Player(Texture _texture, World world) {
        super(_texture, new Vector2(10.0f, 10.0f));
        initPhysics(world);
    }

    private void initPhysics(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(200, 300);

        body = world.createBody(bodyDef);

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(16f, 16f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = poly;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.4f;

        body.setFixedRotation(true);
        body.createFixture(fixtureDef);
        body.setBullet(true);

        poly.dispose();

        body.setAwake(true);
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

        Vector2 position = body.getPosition();
        Vector2 vel = body.getLinearVelocity();

        if(Math.abs(vel.x) > MAX_VELOCITY) {
            vel.x = Math.signum(vel.x) * MAX_VELOCITY;
            body.setLinearVelocity(vel.x, vel.y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && vel.x < MAX_VELOCITY) {
            body.applyLinearImpulse(MOVEMENT_FORCE * body.getMass(), 0, position.x, position.y, true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && vel.x > -MAX_VELOCITY) {
            body.applyLinearImpulse(-MOVEMENT_FORCE * body.getMass(), 0, position.x, position.y, true);
        }
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
