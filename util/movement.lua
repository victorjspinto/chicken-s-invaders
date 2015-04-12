local movement = {}

-- object must have properties position { x , y }, direct { x, y } and velocity (scalar)
function movement.performMovement(object, gametime) 

	object.position.x = object.position.x + object.direction.x * object.velocity * gametime
	object.position.y = object.position.y + object.direction.y * object.velocity * gametime

end

return movement