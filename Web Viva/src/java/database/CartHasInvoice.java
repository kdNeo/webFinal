package database;
// Generated Jul 29, 2020 4:17:48 PM by Hibernate Tools 4.3.1



/**
 * CartHasInvoice generated by hbm2java
 */
public class CartHasInvoice  implements java.io.Serializable {


     private Integer cartHasInvoiceid;
     private Cart cart;
     private Invoice invoice;

    public CartHasInvoice() {
    }

    public CartHasInvoice(Cart cart, Invoice invoice) {
       this.cart = cart;
       this.invoice = invoice;
    }
   
    public Integer getCartHasInvoiceid() {
        return this.cartHasInvoiceid;
    }
    
    public void setCartHasInvoiceid(Integer cartHasInvoiceid) {
        this.cartHasInvoiceid = cartHasInvoiceid;
    }
    public Cart getCart() {
        return this.cart;
    }
    
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public Invoice getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }




}


