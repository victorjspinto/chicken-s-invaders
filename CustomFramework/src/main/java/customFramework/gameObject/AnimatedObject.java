package customFramework.gameObject;

import customFramework.util.Rectangle;

public class AnimatedObject extends BaseObject
{
	float frameRate;
	int currentFrame;
	int totalFrame;
	int operation;
	boolean goBackFrames;
	int frame;

	int frameWidth;
	int frameHeight;

	public AnimatedObject(String fileName, float frameRate, int totalFrames,
			int frameWidth, int frameHeigth, boolean goBackFrames)
	{
		super(fileName);

		this.frame = 0;
		this.currentFrame = 0;
		this.operation = 1;
		this.frameRate = frameRate;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeigth;
		this.totalFrame = totalFrames;
		this.goBackFrames = goBackFrames;
	}

	@Override
	public void Update(float gameTime)
	{
		currentFrame++;
		if (currentFrame > frameRate)
		{
			currentFrame = 0;
			frame += operation;
			if (frame == 6 || frame == 0)
			{
				operation *= -1;
			}

			// currentFrame = 0;
			// if (goBackFrames && (frame == totalFrame - 1 || frame == 0))
			// {
			// operation *= -1;
			// } else if (!goBackFrames && frame >= totalFrame)
			// {
			// currentFrame = 0;
			// }
			// frame += operation;
		}

		super.Update(gameTime);
	}

	@Override
	public void Draw(float gameTime)
	{
		Rectangle sourceImageLocation = new Rectangle((frame * frameWidth), 0,
				frameWidth, frameHeight);

		Rectangle targetWindowLocation = new Rectangle(Position, frameWidth,
				frameHeight);

		super.Draw(gameTime, targetWindowLocation, sourceImageLocation);
	}
}
