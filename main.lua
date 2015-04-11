
local background = require "objects.background"
local chicken = require "objects.chicken"

function love.load()
	background.load()
	chicken.load()
end

function love.draw()
	background.draw()
	chicken.draw()
end

function love.update(dt)
	background.update(dt)
	chicken.update(dt)
end
