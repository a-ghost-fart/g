package sexy.fedora.games.gaem.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends AbstractCharacter {

    private State currentState = State.IDLE;
    private boolean onGround = false;
    private Body body;

    public Player(Texture _texture, World world) {
        super(_texture, new Vector2(10.0f, 10.0f));
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
    }

    public enum State {
        IDLE,
        WALKING,
        RUNNING,
        JUMPING
    }

    @Override
    public void update() {
        sprite.setPosition(pos.x, pos.y);
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
