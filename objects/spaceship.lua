local spaceship = {}
local texture = love.graphics.newImage('assets/sprite-spaceship.png')

function spaceship.load()
	spaceship.velocity = 40
	spaceship.frame = 0
	spaceship.x = 400
	spaceship.y = 540
end

function spaceship.update()

end

function spaceship.draw(dt)

	quad = love.graphics.newQuad(spaceship.frame * 43, 0, 43, 45, texture:getWidth(), texture:getHeight())
	love.graphics.draw(texture, quad, spaceship.x, spaceship.y)

end

return spaceship