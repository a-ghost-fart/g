package sexy.fedora.games.gaem.characters;

public class Player {

    private State currentState = State.IDLE;
    private boolean onGround = false;

    public Player() {

    }

    public enum State {
        IDLE,
        WALKING,
        RUNNING,
        JUMPING
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
