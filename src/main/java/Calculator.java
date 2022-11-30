
public class Calculator {
    private int peopleNumber;
    private double sum;
    private String productList = "";

    public Calculator(int peopleNumber){
        this.peopleNumber = peopleNumber;
    }

    public void addProduct(Product product){
        this.sum = this.sum + product.getPrice();
        this.productList = this.productList.concat(product.getName() + "\n");
        System.out.println("Товар " + product.getName() + " на сумму = " + product.getPrice() + " успешно добавлен");
    }

    public void printProductList(){
        System.out.println(this.productList);
    }

    public double calculateSumToPay(){
        return sum / peopleNumber;
    }

}
