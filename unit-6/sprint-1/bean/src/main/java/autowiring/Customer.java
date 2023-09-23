package autowiring;

public class Customer {
//	
//    private MyOrder order;
//
//    public void setOrder(MyOrder order) {
//        this.order = order;
//    }
//
//    public void displayOrder() {
//        System.out.println("Order details: " + order.getOrderDetails());
//    }
//    
    
    
    private MyOrder myOrder;

    public void setMyOrder(MyOrder myOrder) {
        this.myOrder = myOrder;
    }

    public void displayOrder() {
        System.out.println("Order details: " + myOrder.getOrderDetails());
    }

}

