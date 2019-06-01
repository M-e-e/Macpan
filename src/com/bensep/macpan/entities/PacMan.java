package com.bensep.macpan.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bensep.macpan.gameWorld.PacManMaze;
import com.bensep.macpan.handlers.InputHandler;
import com.bensep.macpan.myGameLib.Direction;
import com.bensep.macpan.myGameLib.Entity;
import com.bensep.macpan.tesxtures.Animations;

import java.util.Stack;

import static com.bensep.macpan.constants.Constants.*;

public class PacMan extends Entity {

    private Direction direction;
    private Animation animation;
    private float speed;
    private float speedBuffer;

    public PacMan(float x, float y, PacManMaze gameWorld, float speed) {
        super(x * TILE_SIZE, y * TILE_SIZE, 8, 8, -4, -4, (byte) (OUT1 | OUT2), (byte) (OUT1 | IN2), null, 1, 1, gameWorld);
        animation = Animations.getInstance().pacMan;
        direction = Direction.UP;
        this.speed = speed;
    }

    @Override
    public void update() {
        gameWorld.hitEntity(getCenter(), 1, dmgCollide);
    }

    @Override
    public void updateMovement() {
        speedBuffer += speed;
        if (speedBuffer >= 1) {
            speedBuffer--;
            handleWalk(InputHandler.getInstance().getDirections());
        }
    }

    public void handleWalk(Stack<Direction> directions) {
        if (directions.size() > 0) {
            Direction direction = directions.pop();
            switch (direction) {
                case UP:
                    if (!translate(0, MOVEMENT_SPEED)) {
                        handleWalk(directions);
                    } else this.direction = direction;
                    break;
                case DOWN:
                    if (!translate(0, -MOVEMENT_SPEED)) {
                        handleWalk(directions);
                    } else this.direction = direction;
                    break;
                case LEFT:
                    if (!translate(-MOVEMENT_SPEED, 0)) {
                        handleWalk(directions);
                    } else this.direction = direction;
                    break;
                case RIGHT:
                    if (!translate(MOVEMENT_SPEED, 0)) {
                        handleWalk(directions);
                    } else this.direction = direction;
                    break;
            }
            directions.add(direction);
        } else {
            switch (direction) {
                case UP:
                    translate(0, MOVEMENT_SPEED);
                    break;
                case DOWN:
                    translate(0, -MOVEMENT_SPEED);
                    break;
                case LEFT:
                    translate(-MOVEMENT_SPEED, 0);
                    break;
                case RIGHT:
                    translate(MOVEMENT_SPEED, 0);
                    break;
            }
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        switch (direction) {
            case UP:
                spriteBatch.draw(animation.getKeyFrame((x + y + 4f), true), x + xTextureOffset, y + yTextureOffset, TILE_SIZE, TILE_SIZE, TILE_SIZE * 2, TILE_SIZE * 2, 1, 1, 0);
                break;
            case DOWN:
                spriteBatch.draw(animation.getKeyFrame((x + y + 4f), true), x + xTextureOffset, y + yTextureOffset, TILE_SIZE, TILE_SIZE, TILE_SIZE * 2, TILE_SIZE * 2, 1, -1, 0);
                break;
            case LEFT:
                spriteBatch.draw(animation.getKeyFrame((x + y + 4f), true), x + xTextureOffset, y + yTextureOffset, TILE_SIZE, TILE_SIZE, TILE_SIZE * 2, TILE_SIZE * 2, 1, 1, 90);
                break;
            case RIGHT:
                spriteBatch.draw(animation.getKeyFrame((x + y + 4f), true), x + xTextureOffset, y + yTextureOffset, TILE_SIZE, TILE_SIZE, TILE_SIZE * 2, TILE_SIZE * 2, 1, -1, 90);
                break;
        }
    }

    @Override
    public boolean translate(float moveX, float moveY) {
        return super.translate(moveX, moveY);
    }

    public void stop(float frames) {
        speedBuffer -= frames * speed;
    }
}
