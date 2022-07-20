package com.revhash.revhash;

import java.util.Random;

public class Revhash {
    
    private String hash;
    private String password;
    private String direction;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isEncrypt(){
        return direction.equals("encrypt");
    }

    public boolean isDecrypt(){
        return direction.equals("decrypt");
    }

    String[] randomWords = {"tom", "jack", "fred", "earth", "answer", "pizzazz", "included"};

    public void revHashEncrypt() {

        String orignalString = getHash();

        Random ran = new Random();
        int wordPos = ran.nextInt(6);

        String randWord = randomWords[wordPos];
        
        StringBuilder hashreverser = new StringBuilder();
        hashreverser.append(orignalString);
        hashreverser.reverse();
        hashreverser.replace(randWord.length(), randWord.length()+1, randWord.substring(0, 1));

        String password = randWord + orignalString.charAt((orignalString.length()-randWord.length())-1);
        
        setHash(hashreverser.toString());
        setPassword(password);        
    }

    public void revHashDecrypt() {

        String encryptedHash = getHash(); 
        String password = getPassword();

        StringBuilder hashDecrypter = new StringBuilder();
        hashDecrypter.append(encryptedHash);
        hashDecrypter.replace(password.length()-1, password.length(), password.substring(password.length()-1, password.length()));
        hashDecrypter.reverse();

        setHash(hashDecrypter.toString());
    }

}


