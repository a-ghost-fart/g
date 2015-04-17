package sexy.fedora.games.gaem.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import sexy.fedora.games.gaem.characters.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayState implements AbstractState {

    private Player player;
    private List<Actor> actors;

    @Override
    public void create() {
        Gdx.app.log("LOG", "Entered play state");

        actors = new ArrayList<Actor>();
        player = new Player();

        actors.add(player);
    }

    @Override
    public void update() {

        for (Actor actor : actors) {
            actor.act(Gdx.graphics.getDeltaTime());
        }

    }

    @Override
    public void render(SpriteBatch batch) {

        for (Actor actor : actors) {
            actor.draw(batch, 1.0f);
        }

    }

    @Override
    public int getStateId() {
        return GameStates.PLAY;
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
