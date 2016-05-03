package customFramework.behavior;

import customFramework.behavior.damage.IDamageableBehavior;

public interface IPlayer extends IDamageableBehavior, IBaseObject
{
	int getLife();
	void addLife();
	int getScore();
	void addScore();
	void addScore(int value);
	void removeLife();
}
