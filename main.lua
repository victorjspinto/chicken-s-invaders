
local background = require "objects.background"
local chicken = require "objects.chicken"
local spaceship = require "objects.spaceship"
local shot = require "objects.shot"

function love.load()
	background.load()
	spaceship.load()
	shot.load()
	chicken.load()
	chicken.loadChickenChalengeLevel();
end

function love.draw()
	background.draw()
	spaceship.draw()
	shot.draw()
	chicken.draw()
end

function love.update(dt)
	background.update(dt)
	spaceship.update(dt)
	shot.update(dt)
	chicken.update(dt)
end
