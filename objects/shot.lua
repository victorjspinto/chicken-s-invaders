local shot = {}
local texture = love.graphics.newImage('assets/sprite-shot.png')

function shot.load()
	shots = {}

	shot.velocity = 100
end

function shot.update(dt)
	for i,v in ipairs(shots) do
		v.position.x = v.position.x + v.direction.x * v.velocity * dt
		v.position.y = v.position.y + v.direction.y * v.velocity * dt
	end
end

function shot.draw()
	for i,v in ipairs(shots) do
		quad = love.graphics.newQuad(2 * 11, 0, 11, 21, texture:getWidth(), texture:getHeight())
		love.graphics.draw(texture, quad, v.position.x, v.position.y)
	end
end


function shot.addShot(position)

	table.insert(shots, {
		position = position,
		direction = {
			x = 0,
			y = -1
		},
		velocity = shot.velocity
	})

end

return shot
