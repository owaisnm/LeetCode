/*class SnakeGame implements KeyListener.Callback {

	boolean[][] tiles;
	Snake snake;
	Direction newDirection;
	Random random;
	int[] snakeFood;

	SnakeGame() {
		random = new Random();
		tiles = new boolean[][];

		// initial snake nodes can be in the middle of the screen, in right direction
		int startingHeight = Constraints.HEIGHT/2;
		snake = new Snake(Direction.RIGHT, new int[] {new int[] {0, startingHeight}, new int[] {1, startingHeight}, new int[]{2, startingHeight}, new int[]{3, startingHeight});

		generateSnakeFood();
		startGame();
	}

	void startGame() {
		// schedule calling update() every 1 second 
		scheduleUpdate();
		// start listening for key presses to know if user has clicked UP, DOWN, RIGHT, OR LEFT keys
		startKeyboardListener();
	}

	void stopGame() {
		cancelUpdate();
		showEndDialog();
	}

	void update() {
		if(newDirection != null) {
			snake.changeDirection();
			newDirection = null;
		}

		if(isSnakeFoodNext()) {
			snake.eatFood(snakeFood);
			if(snake.isSnakeAtMax) {
				stopGame();
			}
		} else if(!snake.move() || snake.isSnakeAtMax()) {
			stopGame();
		}
	}


	// add node snake needs to eat
	void generateSnakeFood() {
		do {
			freeNode[0] = random.nextInt(0, Constraints.WIDTH);
			freeNode[1] = random.nextInt(0, Constraints.HEIGHT);
		} while(tiles[freeNode[0]][freeNode[1]]);
	}

	boolean isSnakeFoodNext() {
		// check to see if the next tile exists
		// check to see if it is the same one that has snake food in it
	}

	void scheduleUpdate() {}
	void startKeyboardListener() {}
	void cancelUpdate() {}
	void showEndDialog(){}

	class Constraints {
		int WIDTH = 30;
		int HEIGHT = 30;
		int MAX = 30;
	}

	class Snake {
		List<int[]> nodes;
		Direction direction;

		Snake(Direction direction, int[][] nodes) {
			this.direction = direction;
			for(int[] node: nodes ) {
				nodes.add(node);
			}
		}

		boolean changeDirection(Direction newDirection) {
			// if new direction is equal to or opposite the  old direction, don't allow the change
			// otherwise allow it 
		}

		void canMove(int[][] tiles) {
			return nextTileExists() && nextTileIsNotSnakeNode();
		}

		boolean move() {
			if(canMove()) {
				performMove();
				return true;
			}
			return false;
		}

		void performMove() {
			// remove the last node from the list
			// create a new int array with 0th index equal to x and y values of next tile based on the direction
			// append this new node to the front of the list
		}

		void eatFood(int[] node) {
			// add this node to the front of the snake
			snake.add(0, node);
		}

		boolean nextTileExists() {}
		boolean nextTileIsNotSnakeNode() {}

		boolean isSnakeAtMax() {
			return snake.nodes.size() == Constraints.MAX;
		}
	}

	enum Direction {
		UP, DOWN, RIGHT, LEFT;
	}

	@Override 
	void onKeyPressed(int key) {
		// if key matches up, down, etc. set it to newDirection
		// otherwise ignore
	}

}*/