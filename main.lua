
local background = require "objects.background"

function love.load()
	background.load()
end

function love.draw()
	background.draw()
end

function love.update(dt)
	background.update(dt)
	
end
