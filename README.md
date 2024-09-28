# 2d-game-Java

This repo houses the source code to my first ever Java game.

This game is an opportunity for me to both learn Java and build an idea I had for a game that is inspired by a game I once played in an arcade.

## Game I'm inspired by (with some twists)

The game in question is a interesting little game called [Deathball](https://deathball.cab/).

The idea is simple.

* Two wizards
* One ball
* Put the ball in the opposing wizards goal

Do this 3 times and you win.

Cool concept and very easy to learn.

However, I wanted more. And so my idea was hatched.

## My Idea

My game will be similar. Two characters each with a goal that you must put the ball into to score.

However, I want different characters with different abilities, such as Teleportation, Speed boost, etc.

Different abilities gives the user the ability to play according to their playstyle (or not if they choose).

Before each match, You'll also be given a chance to pick from the many character options available while seeing what character the opponent is selecting, further giving the user strategizing opportunities, such as countering the opponents ability with your characters.

## Things I've Implemented so far...

So far, This is what I've done:
* Created game panel and window to draw images to the screen, as well as any other essential parts, such as setting framerate, creating game thread, etc.
* Drawn and displayed basic character:
  * Characted can be moved about the screen
  * Character has own attributes such as, location and speed
  * Character moves to opposite side of screen when exiting screen bounds
* Created Tile Class and Tile manager that allows me to display different tiles to the screen
* Setup Collision between player and tiles using Rectangle.getBounds()

## Things To Work on...

Some things I need to/want to add:
* Double-Buffer Strategy (Next feature to add)
* Create new tiles for map design
* Implement friction and inertia
* Create character design and draw to screen, including different animations, such as, idling, running, jumping, etc.
And so much more...