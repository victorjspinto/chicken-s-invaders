local spaceship = {}
local texture = love.graphics.newImage('assets/sprite-spaceship.png')

function spaceship.load()
	spaceship.velocity = 200
	spaceship.frame = 0
	spaceship.x = 400
	spaceship.y = 540
end

function spaceship.update(dt)

	direction = 0
	spaceship.frame = 0
	if love.keyboard.isDown("left") then
        direction = -1
        spaceship.frame = 1
    elseif love.keyboard.isDown("right") then
        direction = 1
        spaceship.frame = 2
    end

    spaceship.x = spaceship.x + spaceship.velocity * dt * direction

end

function spaceship.draw(dt)

	quad = love.graphics.newQuad(spaceship.frame * 43, 0, 43, 45, texture:getWidth(), texture:getHeight())
	love.graphics.draw(texture, quad, spaceship.x, spaceship.y)

end

return spaceship