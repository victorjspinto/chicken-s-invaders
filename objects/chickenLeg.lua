local chickenLeg = {}
local texture = love.graphics.newImage('assets/sprite-miscellaneous.png')
local movementUtil = require "util.movement"

function chickenLeg.load()
	chickenLeg.chickenLegs = {}
	chickenLeg.velocity = 100
end

function chickenLeg.update(dt)
	for i,v in ipairs(chickenLeg.chickenLegs) do
		movementUtil.performMovement(v, dt)
	end
end

function chickenLeg.draw()
	for i,v in ipairs(chickenLeg.chickenLegs) do
		quad = love.graphics.newQuad(66, 0, 33, 21, texture:getWidth(), texture:getHeight())
		love.graphics.draw(texture, quad, v.position.x, v.position.y)
	end
end


function chickenLeg.addChickenLeg(position)
	local newChickenLeg = {
		position = {
			x = position.x,
			y = position.y
		},
		direction = {
			x = 0,
			y = 1
		},
		velocity = chickenLeg.velocity
	}

	table.insert(chickenLeg.chickenLegs, newChickenLeg)
end

return chickenLeg
