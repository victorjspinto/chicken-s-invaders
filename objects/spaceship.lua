local spaceship = {}
local texture = love.graphics.newImage('assets/sprite-spaceship.png')
local shot = require "objects.shot"

function spaceship.load()
	spaceship.velocity = 200
	spaceship.frame = 0
	spaceship.position = {
		x = 400,
		y = 540
	}
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

    spaceship.position.x = spaceship.position.x + spaceship.velocity * dt * direction

end

function love.keyreleased(key)
    if (key == " ") then
        shot.addShot({
        	x = spaceship.position.x,
        	y = spaceship.position.y
        })
    end
end 

function spaceship.draw()

	quad = love.graphics.newQuad(spaceship.frame * 43, 0, 43, 45, texture:getWidth(), texture:getHeight())
	love.graphics.draw(texture, quad, spaceship.position.x, spaceship.position.y)

end

return spaceship