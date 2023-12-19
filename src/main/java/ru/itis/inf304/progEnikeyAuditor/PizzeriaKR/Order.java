package ru.itis.inf304.progEnikeyAuditor.PizzeriaKR;

public class Order {
    private Client client;
    private Cook cook;
    private Pizza pizza;
    private String time;
    private Integer orderNumber;
    private OrderStatus orderStatus;
    public Order(Client client, Cook cook, Pizza pizza, String time, Integer orderNumber, OrderStatus orderStatus) {
        this.client = client;
        this.cook = cook;
        this.pizza = pizza;
        this.time = time;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client = " + client.getName() +
                ", cook = " + cook.getName() +
                ", pizza = " + pizza +
                ", time = '" + time + '\'' +
                ", orderNumber = " + orderNumber +
                ", orderStatus = " + orderStatus +
                '}';
    }
}
