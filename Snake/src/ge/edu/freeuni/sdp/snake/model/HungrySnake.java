/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.model;

/**
 *
 * @author toka
 */
public class HungrySnake extends Snake{

    protected final int LEAST_LENGTH = 2;
    
    protected final int _moveLimit;
    protected int _moveCounter;

    
    public HungrySnake(Point head, int move_limit) {
        super(head);
        _moveCounter = 0;
        _moveLimit = move_limit;
    }
    
    @Override
    protected void moveTo(Point point) {
        if(++_moveCounter == _moveLimit){
            _moveCounter = 0;
            _length--;
        }
        if(_length <= 2){
            this.kill();
        }
        super.moveTo(point);
    }
    
    @Override
    public void interactWith(Being other){
        super.interactWith(other);
        _moveCounter = 0;
    }
        
    
}
