local chicken = {}
local texture = love.graphics.newImage('assets/sprite-chicken.png')
local chickenLeg = require "objects.chickenLeg"

function chicken.load()
	chicken.chickens = {}
end

function chicken.update(dt)
	for i,v in ipairs(chicken.chickens) do

		if v.lives < 1 then
			table.remove(chicken.chickens, i)
			chickenLeg.addChickenLeg(v.position)
			goto continue
		end

		updateFrame(v, dt)
		::continue::
	end
end

function chicken.draw()

	for i,v in ipairs(chicken.chickens) do
		
		quad = love.graphics.newQuad(v.frame.position * 54, 0, 54, 43, texture:getWidth(), texture:getHeight())
		love.graphics.draw(texture, quad, v.position.x, v.position.y)

	end

end

function updateFrame(chicken, dt)
	chicken.frame.time = chicken.frame.time + dt
	if chicken.frame.time < chicken.frame.velocity then
		return
	end
	chicken.frame.time = 0

	-- chicken frame logic
	chicken.frame.position = chicken.frame.position + chicken.frame.direction

	-- if i reach the last frame then i change de frame printing direction 
	if chicken.frame.position == 6 or chicken.frame.position == 0 then
		chicken.frame.direction = chicken.frame.direction *  -1
	end
end


-- fill the screen with chickens for each new level
function chicken.loadChickenChalengeLevel()

	for i= 0, 11 do
		for j= 0, 3 do
			newChicken = {
				position = {
					x = 30 + i * 60,
					y = 30 + j * 50
				},
				size = {
					x = 54,
					y = 43
				},
				lives = 1,
				frame = {
					time = 0,
					position = (i % 6),
					direction = 1,
					velocity = 0.1
				}
			}

			table.insert(chicken.chickens, newChicken)
		end
	end

end

return chicken