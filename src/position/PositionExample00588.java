/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package position;

/**
 *
 * @author Enubs
 */
public class PositionExample00588 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedPositionalList<String> strPos =
                new LinkedPositionalList<>();
        
        Position p1 = strPos.addFirst("position 1");
        System.out.println(strPos.first().getElement());
        Position p2 = strPos.addBefore(p1, "before position 1");
        System.out.println(strPos.before(p1).getElement());
        Position p3 = strPos.addAfter(p1, "after position 1");
        System.out.println(strPos.after(p1).getElement());
    }
    
}
