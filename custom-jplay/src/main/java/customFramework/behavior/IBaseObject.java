package customFramework.behavior;

import java.awt.Image;

import customFramework.util.Point;
import customFramework.util.Rectangle;

public interface IBaseObject
{
	Point getPosition();
	void setPosition(Point size);
	
	Point getSize();
	void setSize(Point size);
	
	Image getTexture();
	void setTexture(Image texture);
	
	Rectangle getBoundingArea();
	
	void Update(float gameTime);
	void Draw(float gameTime);
}
