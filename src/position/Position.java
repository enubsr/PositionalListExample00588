/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package position;

/**
 *
 * @author Enubs
 * @param <E>
 */
public interface Position<E> {
    E getElement() throws IllegalStateException;
}
