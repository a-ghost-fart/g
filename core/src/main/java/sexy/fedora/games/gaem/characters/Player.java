package sexy.fedora.games.gaem.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends AbstractCharacter {

    private State currentState = State.IDLE;
    private boolean onGround = false;

    public Player(Texture _texture) {
        super(_texture, new Vector2(10.0f, 10.0f));
    }

    public enum State {
        IDLE,
        WALKING,
        RUNNING,
        JUMPING
    }

    @Override
    public void update() {
        pos.x += 0.1f;
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
