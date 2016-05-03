package customFramework.behavior.damage;

import customFramework.util.Side;

public interface IDamageableBehavior
{
	Side getSide();

	void setSide(Side side);

	int getTotalHeath();

	void performDamage(int damageQuantity);
}
