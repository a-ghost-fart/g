package sexy.fedora.games.gaem.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractCharacter {

    protected Sprite sprite;
    protected Texture texture;
    protected Vector2 pos;

    public AbstractCharacter(Texture _texture, Vector2 _pos) {
        texture = _texture;
        pos = _pos;
        sprite = new Sprite(texture);
        sprite.setPosition(pos.x, pos.y);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void update() {
        sprite.setPosition(pos.x, pos.y);
    }
}
