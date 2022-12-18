package me.noitcereon.exceptions;

public class InvalidGiftPairingException extends Exception{
    public InvalidGiftPairingException(){
        super();
    }
    public InvalidGiftPairingException(String message){
        super(message);
    }

}
