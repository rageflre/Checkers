package com.checkers.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class Checkers extends ApplicationAdapter {
	/*Asset variables*/
	private Texture boardImage;
	private Texture whitePieceImage;
	private Texture blackPieceImage;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle board;
	private Array<Rectangle> whitePieces;
	private Array<Rectangle> blackPieces;
	private Array<Rectangle> boardSquares;
	

	

    @Override
    public void create() {
    	// load images for board and pieces, board 512x512, pieces 64x64
    	boardImage = new Texture(Gdx.files.internal("board.png"));
    	//whitePieceImage = new Texture(Gdx.files.internal("whitePiece.png"));
    	//blackPieceImage = new Texture(Gdx.files.internal("blackPieces.png"));
    	
    	// create camera and SpriteBatch
    	camera = new OrthographicCamera();
    	camera.setToOrtho(false, 600, 600);
    	batch = new SpriteBatch();
    	
    	// create rectangle to represent the board
    	board = new Rectangle();
    	board.x = 600 / 2 - 512 / 2; // center board horizontally
    	board.y = 600 / 2 - 512 / 2; // center board vertically
    	board.width = 512;
    	board.height = 512;
    	
    	//#TODO: create board spaces
    	
    	//#TODO: create the piece arrays and set them to start positions
    	
    }

    @Override
    public void render() {
    	// clear the screen with grey
    	Gdx.gl20.glClearColor(0.2f, 0.2f, 0.2f, 1);
    	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	
    	// update camera matrices
    	camera.update();
    	
    	// render SpriteBatch relative to camera
    	batch.setProjectionMatrix(camera.combined);
    	
    	// begin new batch and draw the board and all pieces
    	batch.begin();
    	batch.draw(boardImage, board.x, board.y);
    	batch.end();
    }
    
    @Override
    public void dispose() {
    	// dispose of all resources
    	boardImage.dispose();
    }
}