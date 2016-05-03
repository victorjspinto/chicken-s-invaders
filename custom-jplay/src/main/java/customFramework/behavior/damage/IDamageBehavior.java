package customFramework.behavior.damage;

import customFramework.util.Side;

public interface IDamageBehavior
{
	void setSide(Side side);

	Side getSide();

	int getDamageQuantity();
}
