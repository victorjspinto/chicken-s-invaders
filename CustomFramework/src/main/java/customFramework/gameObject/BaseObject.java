package customFramework.gameObject;

import java.awt.Image;

import javax.swing.ImageIcon;

import customFramework.behavior.IBaseObject;
import customFramework.gameWindow.Game;
import customFramework.util.Point;
import customFramework.util.Rectangle;

public abstract class BaseObject implements IBaseObject
{
	Point Position = Point.Zero();
	Point Size = null;

	Image Texture;

	public Point getPosition()
	{
		return Position;
	}

	public void setPosition(Point position)
	{
		Position = position;
	}

	public Point getSize()
	{
		if (Size != null)
			return Size;
		return new Point(Texture.getWidth(null), Texture.getHeight(null));
	}

	public void setSize(Point size)
	{
		Size = size;
	}

	public Image getTexture()
	{
		return Texture;
	}

	public void setTexture(Image texture)
	{
		Texture = texture;
	}

	public BaseObject(String fileName)
	{
		loadImage(fileName);
	}

	public void loadImage(String fileName)
	{
		ImageIcon icon = new ImageIcon(fileName);
		this.Texture = icon.getImage();
	}

	public void Update(float gameTime)
	{

	}

	protected void Draw(float gameTime, Rectangle targetWindowLocation,
			Rectangle sourceImageLocation)
	{
		sourceImageLocation = sourceImageLocation.Clone();
		targetWindowLocation = targetWindowLocation.Clone();

		sourceImageLocation.set_width(sourceImageLocation.get_width()
				+ sourceImageLocation.get_x());
		sourceImageLocation.set_height(sourceImageLocation.get_height()
				+ sourceImageLocation.get_y());
		targetWindowLocation.set_width(targetWindowLocation.get_width()
				+ targetWindowLocation.get_x());
		targetWindowLocation.set_height(targetWindowLocation.get_height()
				+ targetWindowLocation.get_y());

		Game.GetGame()
				.GetWindow()
				.getGameGraphics()
				.drawImage(Texture, (int) targetWindowLocation.get_x(),
						(int) targetWindowLocation.get_y(),
						(int) targetWindowLocation.get_width(),
						(int) targetWindowLocation.get_height(),
						(int) sourceImageLocation.get_x(),
						(int) sourceImageLocation.get_y(),
						(int) sourceImageLocation.get_width(),
						(int) sourceImageLocation.get_height(), null);
	}

	public void Draw(float gameTime)
	{
		Rectangle targetWindowLocation;
		Rectangle sourceImageLocation;

		targetWindowLocation = new Rectangle(Position.Clone(), getSize()
				.get_x() + Position.get_x(), getSize().get_y()
				+ Position.get_y());

		sourceImageLocation = new Rectangle(Point.Zero(),
				Texture.getWidth(null), Texture.getHeight(null));

		Game.GetGame()
				.GetWindow()
				.getGameGraphics()
				.drawImage(Texture, (int) targetWindowLocation.get_x(),
						(int) targetWindowLocation.get_y(),
						(int) targetWindowLocation.get_width(),
						(int) targetWindowLocation.get_height(),
						(int) sourceImageLocation.get_x(),
						(int) sourceImageLocation.get_y(),
						(int) sourceImageLocation.get_width(),
						(int) sourceImageLocation.get_height(), null, null);
	}

	public Rectangle getBoundingArea()
	{
		return new Rectangle(this.getPosition(), this.getSize());
	}
}
