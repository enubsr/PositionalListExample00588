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
//        LinkedPositionalList<String> strPos =
//                new LinkedPositionalList<>();
//        
//        Position pd = strPos.addFirst("position 1");
//        System.out.println(strPos.first().getElement());
//        Position q = strPos.addBefore(pd, "before position 1");
//        System.out.println(strPos.before(pd).getElement());
//        Position y = strPos.addAfter(q, "after position 1");
//        System.out.println(strPos.after(y).getElement());
//        String tempStr = strPos.remove(pd);
//        System.out.println(pd.getElement());

        LinkedPositionalList<Product> productsList =
                new LinkedPositionalList<>();
        
        Position mineralWaterPosition = productsList.addFirst(
                new Product(
                        "Mineral Water (500ml)",
                        10.00
                )
        );
        
        System.out.println(productsList.first().getElement().getDescription());
        
        Position cokeSaktoPosition = productsList.addAfter(
                mineralWaterPosition,
                new Product(
                        "Coke Sakto",
                        20.00
                )
        );
        
        System.out.println(((Product)productsList.after(mineralWaterPosition)
                .getElement()).getDescription());
    }
    
}
