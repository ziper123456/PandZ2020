package root.entities.plants;

import java.awt.Image;
import root.entities.PlantAttackable;
import root.entities.movable.MovableObjects;
import root.entities.movable.Snow;
import root.entities.zombies.Zombie;
import root.entities.zombies.Zombie.Effects;

public class SnowPea extends PeaShooter implements PlantAttackable {

  public SnowPea(int x, int y) {
    super(x, y);
    price = 175;
    health = 200;
  }

  @Override
  public void dealWithZom() {
    Zombie closestZom = closestZom(zomOnLane());
    for (MovableObjects movableObjects : Stuffs) {
      if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
        ((Snow) movableObjects).hitted = true;
        closestZom.specialEffect = true;
        closestZom.effects = Effects.SLOWED;
        closestZom.health -= 15;
      }
    }
  }

  @Override
  public void shoot() {
    Stuffs.add(new Snow(position.x + stuffShooter.x, position.y + stuffShooter.y));
  }

  @Override
  public Image getImage() {
    return visualMode.SnowPeaImage;
  }
}
