package sexy.fedora.games.gaem.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class StateManager {

    public static List<AbstractState> states;

    public StateManager() {
        states = new ArrayList<AbstractState>();
    }

    public void addState(AbstractState state) {
        states.add(state);
    }

    public AbstractState getState(int id) {
        AbstractState selectedState = null;

        for (AbstractState state : states) {
            int sid = state.getStateId();
            if (sid == id) {
                selectedState = state;
            }
        }

        if (selectedState == null) {
            throw new GdxRuntimeException("State with id " + id + " not found.");
        }

        return selectedState;
    }

    public AbstractState enterState(int id) {
        AbstractState state = null;
        try {
            state = getState(id);
        } catch (Exception e) {
            Gdx.app.error("ERROR", e.getMessage());
        } finally {
            state.create();
            return state;
        }
    }

}
