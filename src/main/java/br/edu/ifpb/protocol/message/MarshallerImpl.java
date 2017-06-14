/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.protocol.message;

import java.nio.ByteBuffer;
import java.util.Iterator;

/**
 *
 * @author miolivc
 */
public class MarshallerImpl implements Marshaller {
    private byte first = 0x0;
    private byte second = 0x0;
    private byte[] message = new byte[1024];
    
    @Override
    public Marshaller lenght(int value) {
        if (value > 1024) {
            throw  new RuntimeException("O tamanho da mensagem neste frame nao pode ser superior a 1024 bytes");
        }
        int multp;
        
        int left = (value % 256);
        if (left == 0){
            multp = (value / 256) - 1;
        } else {
            multp = (value / 256);
        }
        
        first = (byte) (first | multp);
        
        second = (byte) (value - (multp * 256) - 1);
       
        return this;
    }

    @Override
    public Marshaller hasNext(boolean value) {
        if (value) {
            first = (byte) (first | 0x4);
        } else {
            first = (byte) (first & 0x3);
        }
        return this;
    }

    @Override
    public Marshaller message(String value) {
        if (value.length() > 1024) {
            throw  new RuntimeException("O tamanho da mensagem neste frame nao pode ser superior a 1024 bytes");
        }
        message = value.getBytes();
        return this;
    }

    @Override
    public byte[] build() {
        ByteBuffer buffer = ByteBuffer.allocate(message.length + 2);
        buffer.put(first);
        buffer.put(second);
        buffer.put(message);
        return buffer.array();
    }
    
}
