
local background = require "objects.background"
local chicken = require "objects.chicken"
local spaceship = require "objects.spaceship"
local shot = require "objects.shot"
local colisionUtil = require "util.colision"

function love.load()
	background.load()
	spaceship.load()
	shot.load()
	chicken.load()
	chicken.loadChickenChalengeLevel();

	colidi = false
	match = {}
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

	checkShotColisionsOnChickens(dt)
end

function checkShotColisionsOnChickens(dt)

	remShot = {}

	for shotIndex,currentShot in ipairs(shot.shots) do

		for chickenIndex, currentChicken in ipairs(chicken.chickens) do

			if colisionUtil.isBoxColision(currentShot, currentChicken) then
				table.remove(shot.shots, shotIndex)
				currentChicken.lives = currentChicken.lives - currentShot.damage

				table.remove(shot.shots, shotIndex)
				goto nextShot
			end

		end

		::nextShot::
	end

end

function table.val_to_str ( v )
  if "string" == type( v ) then
    v = string.gsub( v, "\n", "\\n" )
    if string.match( string.gsub(v,"[^'\"]",""), '^"+$' ) then
      return "'" .. v .. "'"
    end
    return '"' .. string.gsub(v,'"', '\\"' ) .. '"'
  else
    return "table" == type( v ) and table.tostring( v ) or
      tostring( v )
  end
end

function table.key_to_str ( k )
  if "string" == type( k ) and string.match( k, "^[_%a][_%a%d]*$" ) then
    return k
  else
    return "[" .. table.val_to_str( k ) .. "]"
  end
end

function table.tostring( tbl )
  local result, done = {}, {}
  for k, v in ipairs( tbl ) do
    table.insert( result, table.val_to_str( v ) )
    done[ k ] = true
  end
  for k, v in pairs( tbl ) do
    if not done[ k ] then
      table.insert( result,
        table.key_to_str( k ) .. "=" .. table.val_to_str( v ) )
    end
  end
  return "{" .. table.concat( result, "," ) .. "}"
end
