local chickenLeg = {}
local texture = love.graphics.newImage('assets/sprite-miscellaneous.png')
local movementUtil = require "util.movement"

function chickenLeg.load()
	chickenLeg.chickenLegs = {}
	chickenLeg.velocity = 100
	chickenLeg.floor = 560
	chickenLeg.remainTime = 1 -- seconds
end

function chickenLeg.update(dt)
	for i,v in ipairs(chickenLeg.chickenLegs) do
		movementUtil.performMovement(v, dt)

		if v.position.y > chickenLeg.floor then
			v.velocity = 0
			v.remainingTime = 0
			v.position.y = chickenLeg.floor
		end

		-- remove a coxinha de galinha apos {chickenLeg.remainTime} segundos
		if v.velocity == 0 then
			v.remainingTime = v.remainingTime + dt
			if v.remainingTime > chickenLeg.remainTime then
				table.remove(chickenLeg.chickenLegs, i)
			end
		end
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
