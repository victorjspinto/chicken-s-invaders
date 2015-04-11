
local background = require "objects.background"
local chicken = require "objects.chicken"
local spaceship = require "objects.spaceship"

function love.load()
	background.load()
	spaceship.load()
	chicken.load()
	chicken.loadChickenChalengeLevel();
end

function love.draw()
	background.draw()
	spaceship.draw()
	chicken.draw()
end

function love.update(dt)
	background.update(dt)
	spaceship.update(dt)
	chicken.update(dt)
end
