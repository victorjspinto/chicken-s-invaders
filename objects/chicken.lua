local chicken = {}
local texture = love.graphics.newImage('assets/sprite-chicken.png')
local time = 0

function chicken.load()
	chicken.position = { x=0, y=0 }
	chicken.frame = 0
	chicken.velocity = 0.1
	chicken.frameDirection = 1
end

function chicken.update(dt)
	time = time + dt
	if time < chicken.velocity then
		return
	end
	time = 0

	-- chicken frame logic
	chicken.frame = chicken.frame + chicken.frameDirection

	-- if i reach the last frame then i change de frame printing direction 
	if chicken.frame == 6 or chicken.frame == 0 then
		chicken.frameDirection = chicken.frameDirection *  -1
	end
end

function chicken.draw()

	quad = love.graphics.newQuad(chicken.frame * 54, 0, 54, 43, texture:getWidth(), texture:getHeight())
	love.graphics.draw(texture, quad, 0, 0)

end


return chicken