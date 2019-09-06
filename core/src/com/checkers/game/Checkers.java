package com.checkers.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Checkers extends ApplicationAdapter {
	private AssetManager manager;
	private FileHandleResolver resolver;
	private ArrayList<Texture> redPieces;
	private ArrayList<Texture> whitePieces;
	private TiledMap board;
	private TiledMapTileSet tileSet;
	private OrthographicCamera camera;
	private TiledMapRenderer renderer;

    @Override
    public void create() {
    	camera = new OrthographicCamera();
    	camera.setToOrtho(false, 8, 8);
    	camera.update();
    	
    	manager = new AssetManager();
    	loadAssets();
    	
    	board = manager.get("board.tmx");
    	tileSet = board.getTileSets().getTileSet(0);
    	renderer = new OrthogonalTiledMapRenderer(board, 1 / 64f);
//    	//Find out how to render pieces as just other tiles
//    	TiledMapTileLayer boardLayer = (TiledMapTileLayer) board.getLayers().get(0);
//    	TiledMapTileLayer pieceLayer = (TiledMapTileLayer) board.getLayers().get(1);
//    	for(int x = 1; x < 8; x++) {
//    		for(int y = 1; y < 8; y++) {
//    			if(boardLayer.getCell(x, y).getTile().getId() == 1) {
//    				if(y <= 3) {
//						pieceLayer.getCell(x, y).setTile(tileSet.getTile(2)); //Gives null pointer for some reason
//	    			} else if(y >= 6) {
//						pieceLayer.getCell(x, y).setTile(tileSet.getTile(3));
//    				}
//    			}
//			}
//		}
	}
    	

    @Override
    public void render() {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
    	Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	camera.update();
    	renderer.setView(camera);
    	int[] bg = {1};
    	int[] fg = {0};
    	renderer.render(bg);
    	renderer.render(fg);
    	
    }
    
    private void loadAssets() {
    	manager.load("red.png", Texture.class);
    	manager.load("white.png", Texture.class);
    	manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
    	manager.load("board.tmx", TiledMap.class);
    	manager.finishLoading();
    }
}