package io.github.froggers_revenge;

import java.awt.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Frogger {

    // Player data
    private int x, y;
    private int width, height;
    private int speed;
    private boolean hasGun;
    private Rectangle hitbox;

    private Texture spriteSheet;
    private TextureRegion currentFrame; //allows you to extract individual frames from a sprite sheet
    private int frameWidth, frameHeight;

//default constructor
public Frogger() {
    spriteSheet = new Texture("froggerSpriteSheet.png");
}

//Constructor
public Frogger(int initialX, int initialY, int initialWidth, int initialHeight, int initialSpeed) {

    

    frameWidth = 32;
    frameHeight = 32;

    currentFrame = new TextureRegion(spriteSheet, 0, 0, frameWidth, frameHeight);

    x = 50;
    y = 50;

    //move
    this.x = initialX;
    this.y = initialY;
    this.width = initialWidth;
    this.height = initialHeight;
    this.speed = initialSpeed;

    //passive/revenge mode
    this.hasGun = false;

    //hitbox
    this.hitbox = new Rectangle(x, y, width, height);

}

//Render the player
public void render(SpriteBatch batch) {
    batch.draw(currentFrame, x, y);
}

public void dispose() {
    spriteSheet.dispose();
}

//Move methods
public void moveUp() {
    y -= speed;
    updateHitbox();
}
public void moveDown() {
    y += speed;
}
public void moveLeft() {
    x -= speed;
}
public void moveRight() {
    x += speed;
}

//Position Getters and Setters
public int getX() {
    return x;
}

public void setX(int x)
{
    this.x = x;
    updateHitbox();
}

public int getY() {
    return y;
}

public void setY(int y)
{
    this.y = y;
    updateHitbox();
}

//set gun to true when they reach the end
public void giveGun() {
    this.hasGun = true;
}

//move hitbox along with frogger
private void updateHitbox() {
    hitbox.setBounds(x, y, width, height);
}

//Getter for hitbox
public Rectangle getHitbox() {
    return hitbox;
}

//Check for collisions with other hitboxes
public boolean checkCollision(Rectangle obstacleHitbox) {
    return hitbox.intersects(obstacleHitbox);
}

}