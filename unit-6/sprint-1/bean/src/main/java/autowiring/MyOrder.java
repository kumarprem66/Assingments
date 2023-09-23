package autowiring;

public class MyOrder {
	
    private String orderDetails;

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderDetails() {
        return orderDetails;
    }
}


//package autowiring;
//
//public class Customer {
//	
//    private MyOrder myorder;
//
//    public void setOrder(MyOrder myorder) {
//        this.myorder = myorder;
//    }
//
//    public void displayOrder() {
//        System.out.println("Order details: " + myorder.getOrderDetails());
//    }
//}
//
//
//
//<bean id ="myorder" class="autowiring.MyOrder">
//	<property name="orderDetails" value="Sample Order"/>
//</bean>
//
//<bean id="customer" class="autowiring.Customer" autowire="byName"></bean>

