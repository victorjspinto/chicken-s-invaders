local colision = {}

function colision.isBoxColision(box1, box2) 

	return 	box1.position.x < box2.position.x + box2.size.x and
			box1.position.x + box1.size.x > box2.position.x and
			box1.position.y < box2.position.y + box2.size.y and
			box1.size.y + box1.position.y > box2.position.y

end

return colision