local background = {}
local texture = love.graphics.newImage('assets/sprite-background.png')

function background.load()
	background.velocity = 40
	-- 1 for up to down and left to right 
	-- -1 for down to up and right to left
	-- 0 to stop axys
	background.direction = { vertical = 1, horizontal = 0 }

	-- control variable to see sprite relative location
	background.relativeLocation = 0
end

function background.update(dt)
	background.relativeLocation = background.relativeLocation + background.velocity * dt
	
	if background.relativeLocation > 40 then
	    background.relativeLocation = 0
	end
end

function background.draw()
	width = love.window.getWidth()
	heigth = love.window.getHeight()
	
	for j= -1, heigth / 40 do

		for i= -1, width / 40 do

			love.graphics.draw(texture, 
				i * 40 + background.relativeLocation * background.direction.horizontal, 
				j * 40 + background.relativeLocation * background.direction.vertical)

		end

	end

end

return background