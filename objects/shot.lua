local shot = {}
local texture = love.graphics.newImage('assets/sprite-shot.png')
local colisionUtil = require "util.colision"
local movementUtil = require "util.movement"

function shot.load()
	shot.shots = {}
	shot.damage = 1
	shot.velocity = 100
end

function shot.update(dt)
	for i,v in ipairs(shot.shots) do

		movementUtil.performMovement(v, dt)

		if isOutOfScreen(v) then
			table.remove(shot.shots, i)
		end
	end
end

function shot.draw()
	for i,v in ipairs(shot.shots) do
		quad = love.graphics.newQuad(2 * 11, 0, 11, 21, texture:getWidth(), texture:getHeight())
		love.graphics.draw(texture, quad, v.position.x, v.position.y)
	end
end


function isOutOfScreen(shot)
	local screenLimits = {
		position = {
			x = 0,
			y =0
		},
		size = {
			x = 800,
			y = 600
		}
	}

	return not colisionUtil.isBoxColision(shot, screenLimits)
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
