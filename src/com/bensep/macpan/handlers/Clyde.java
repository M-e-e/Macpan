package com.bensep.macpan.handlers;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.bensep.macpan.gameWorld.PacManMaze;
import com.bensep.macpan.tesxtures.Animations;

import static com.bensep.macpan.constants.Constants.TILE_SIZE;

public class Clyde extends Personality {

    public Clyde(PacManMaze maze) {
        super(maze,13.5f * TILE_SIZE, 21*TILE_SIZE, Animations.getInstance().clyde,maze.getTileAt(0f * TILE_SIZE, 0f*TILE_SIZE).getPos());
    }

    @Override
    public void setChasePos() {
       if(distanceToPacman() > 8){
           targetTile.set(maze.getTileAt(maze.getPacMan().getCenter().x, maze.getPacMan().getCenter().y).getPos());
       }
       else {
           targetTile = corner;
       }
    }

    private float distanceToPacman() {
        return ghost.getPos().dst(maze.getPacMan().getPos());
    }
}
