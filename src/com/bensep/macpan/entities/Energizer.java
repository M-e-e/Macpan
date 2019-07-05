package com.bensep.macpan.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bensep.macpan.gameWorld.PacManMaze;
import com.bensep.macpan.myGameLib.Entity;
import com.bensep.macpan.textures.Animations;
import com.bensep.macpan.textures.Textures;

import static com.bensep.macpan.constants.Constants.TILE_SIZE;

public class Energizer extends Entity {

    public Energizer(float x, float y, PacManMaze gameWorld) {
        super(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, 0, 0, (byte) 0, IN1, Textures.getInstance().energizer, 1, 1, gameWorld);
    }

    @Override
    public void onDeath() {
        ((PacManMaze) gameWorld).getPacMan().stop(3f);
        ((PacManMaze) gameWorld).getPacMan().setSpeed(.9f,600);
        ((PacManMaze) gameWorld).setGhostState(Ghost.State.FRIGHTENED);
        super.onDeath();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(Animations.getInstance().energizer.getKeyFrame(Gdx.graphics.getFrameId(),true), x + xTextureOffset, y + yTextureOffset);
    }

    @Override
    public void updateMovement() {

    }
}
