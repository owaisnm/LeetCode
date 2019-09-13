/*class Chess {

	private static int HEIGHT = 7;
	private static int WIDTH = 7;

	private Square[][] squares;
	private Player whitePlayer;
	private Player blackPlayer;

	private Player currentPlayer;

	public Chess() {
		init();
		setSquareListeners();
	}

	private void setSquareListeners() {
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				squares[i][j].view.setOnClickListener(view -> {
					onSquareClick(i, j);
				})
			}
		}
	}

	private void onSquareClick(int x, int y) {
		if(first == null) {
			if(squares[x][y].piece != null && validFirstClick(x, y) {
				first = squares[x][y]
			}
		} else {
			Square second = squares[x][y];

			if(second.piece != null) {
				if(first.piece.canMove(x, y)) {
					move(first, second);
					switchPlayers();
				}
			}
		}

		if(didPlayerWin()) {
			showDialog(GAME_OVER;
			init();
		} else if(isGameDrawn) {
			showDialog(GAME_DRAWN);
			init();
		}
	}

	private boolean validFirstClick(int x, int y) {
		switch(currentPlayer.color) {
			case WHITE:
				return squares[x][y].piece.color == WHITE);
			case BLACK:
				return squares[x][y].piece.color == BLACK;
		}
	}

	private void switchPlayers() {
		switch(currentPlayer.color) {
			case WHITE:
				currentPlayer = blackPlayer;
				break;
			case BLACK:
				currentPlayer = whitePlayer;
				break;
		}
	}

	private void move(Square first, Square second) {
		// todo: check that first can move to second square and take the opponents piece if it exists there
	}

	private void switchTo(Color color)  {
		// switch control of the game to only listen to clicks from the player defined by param: color
	}

	private boolean isGameDrawn() {
		//todo
	}

	private boolean didPlayerWin() {
		//todo
	}

	private void init() {
		squares = new Square[WIDTH][HEIGHT];
		whitePlayer = new Player(Color.WHITE, true);
		blackPlayer = new Player(Color.BLACK, false);
		currentPlayer = whitePlayer;
		square[0][0].piece = new Pawn(Color.WHITE);
		square[0][1].piece = new Pawn(Color.WHITE);
		///...todo continue initializing squares with pieces
		square[7][7].piece = new Rook(Color.BLACK);
	}

	class Player {
		Color color;
		//todo name, id, ranking, etc. 

		public Player(Color color) {
			this.color = color;
		}
	}


	class Square {
		int x;
		int y;
		Piece piece;
		View view;
	}

	class Player {
		Color color;
	}

	class Piece {
		Color color;

		public Piece(Color color) {
			this.color = color;
		}
	}

	class Rook extends Piece {
		@Override 
		protected boolean canMove(int x, int y) {
			//todo
		}	
	}

	class Bishop extends Piece {
		@Override 
		protected boolean canMove(int x, int y) {
			//todo
		}
	}

	class Knight extends Piece {
		@Override 
		protected boolean canMove(int x, int y) {
			
		}
	}

	class Queen extends Piece {
		@Override 
		protected boolean canMove(int x, int y) {
			//todo
		}
	}

	class King extends Piece {
		@Override 
		protected boolean canMove(int x, int y) {
			//todo
		}
	}

	abstract class Pawn extends Piece {
		protected boolean canMove(int x, int y);
	}

	enum Color {
		WHITE, BLACK
	}


}*/