local shot = {}
local texture = love.graphics.newImage('assets/sprite-shot.png')

function shot.load()
	shot.shots = {}
	shot.damage = 1
	shot.velocity = 100
end

function shot.update(dt)
	for i,v in ipairs(shot.shots) do
		v.position.x = v.position.x + v.direction.x * v.velocity * dt
		v.position.y = v.position.y + v.direction.y * v.velocity * dt
	end
end

function shot.draw()
	for i,v in ipairs(shot.shots) do
		quad = love.graphics.newQuad(2 * 11, 0, 11, 21, texture:getWidth(), texture:getHeight())
		love.graphics.draw(texture, quad, v.position.x, v.position.y)
	end
end


function shot.addShot(position)

	table.insert(shot.shots, {
		position = position,
		size = {
			x = 11,
			y = 21
		},
		direction = {
			x = 0,
			y = -1
		},
		damage = shot.damage,
		velocity = shot.velocity
	})

end

return shot
