/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.protocol.message;

/**
 *
 * @author miolivc
 */
public class Main {
    
    public static void main(String[] args) {
        
        String message = "Uma mensagem ai cara!";
        
        Marshaller marshaller = new MarshallerImpl();
        Unmarshaller unmarshaller = new UnmarshallerImpl();
        
        byte[] frame = marshaller.lenght(message.length())
                .hasNext(false)
                .message(message)
                .build();
        
        unmarshaller.frame(frame);
        System.out.println("Continuidade: " + unmarshaller.hasNext());
        System.out.println("Tamanho da mensagem: " + unmarshaller.lenght());
        System.out.println("Mensagem: " + unmarshaller.message());
          
    }
    
}
