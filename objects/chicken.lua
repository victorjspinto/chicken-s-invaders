local chicken = {}
local texture = love.graphics.newImage('assets/sprite-chicken.png')

function chicken.load()
	chicken.chickens = {}
end

function chicken.update(dt)
	for i,v in ipairs(chicken.chickens) do

		v.frame.time = v.frame.time + dt
		if v.frame.time < v.frame.velocity then
			goto continue
		end
		v.frame.time = 0

		-- chicken frame logic
		v.frame.position = v.frame.position + v.frame.direction

		-- if i reach the last frame then i change de frame printing direction 
		if v.frame.position == 6 or v.frame.position == 0 then
			v.frame.direction = v.frame.direction *  -1
		end

		::continue::
	end
end

-- fill the screen with chickens for each new level
function chicken.loadChickenChalengeLevel ()
	chickens = {}

	for i= 0, 11 do
		for j= 0, 3 do
			chicken = {
				x = 30 + i * 60,
				y = 30 + j * 50,
				lives = 1,
				frame = {
					time = 0,
					position = (i % 6),
					direction = 1,
					velocity = 0.1
				}
			}

			-- por algum motivo o codigo abaixo não funciona o.O
			-- chicken.chickens eh iniciado no metodo chicken.load()
			-- table.insert(chicken.chickens, chicken)

			table.insert(chickens, chicken)
		end
	end

	chicken.chickens = chickens
end

function chicken.draw()

	for i,v in ipairs(chicken.chickens) do
		
		quad = love.graphics.newQuad(v.frame.position * 54, 0, 54, 43, texture:getWidth(), texture:getHeight())
		love.graphics.draw(texture, quad, v.x, v.y)

	end

end

return chicken