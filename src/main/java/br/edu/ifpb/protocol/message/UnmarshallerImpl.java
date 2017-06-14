/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.protocol.message;

import java.util.Arrays;

/**
 *
 * @author miolivc
 */
public class UnmarshallerImpl implements Unmarshaller {
    private byte[] frame;

    @Override
    public int lenght() {
        int first = frame[0];
        int second = frame[1];
        
        int multp = (first & 0x3);
        int tam = second;
        
        return (multp * 256) + tam + 1;
    }

    @Override
    public boolean hasNext() {
        if(frame == null) {
            throw new RuntimeException("Defina o frame antes de solicitar a continuidade");
        }
        byte f = frame[0];
        return ((f & 0x4) == 0x4);
    }

    @Override
    public String message() {
        if(frame == null) {
            throw new RuntimeException("Defina o frame antes de solicitar a mensagem");
        }
        
        int lenght = lenght();
        byte[] message = Arrays.copyOfRange(frame, 2, lenght + 2);
    
        return new String(message);
    }

    @Override
    public void frame(byte[] value) {
        frame = value;
    }
    
}
