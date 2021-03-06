package com.bensep.macpan.handlers;

import com.bensep.macpan.gameWorld.PacManMaze;
import com.bensep.macpan.textures.Animations;

import static com.bensep.macpan.constants.Constants.TILE_SIZE;

public class Blinky extends Personality {

    public Blinky(PacManMaze maze) {
        super(maze,13.5f * TILE_SIZE, 21*TILE_SIZE, Animations.getInstance().blinky,maze.getTileAt(26f * TILE_SIZE, 35f*TILE_SIZE).getPos());
    }

    @Override
    public void setChasePos() {
        targetTile.set(maze.getTileAt(maze.getPacMan().getCenter().x, maze.getPacMan().getCenter().y).getPos());
    }
}
