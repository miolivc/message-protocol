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
public interface Marshaller {
    Marshaller lenght(int value);
    Marshaller hasNext(boolean value);
    Marshaller message(String value);
    byte[] build();
}
