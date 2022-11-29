
public class Calculator {
    int peopleNumber;
    double sum;
    String productList;

    Calculator(int peopleNumber){
        this.peopleNumber = peopleNumber;
        this.sum = 0;
        this.productList = "";
    }

    void addProduct(Product product){
        this.sum = this.sum + product.price;
        this.productList = this.productList.concat(product.name + "\n");
        System.out.println("Товар " + product.name + " на сумму = " + product.price + " успешно добавлен");
    }

    void printProductList(){
        System.out.println(this.productList);
    }

    double getSumToPay(){
        return this.sum / this.peopleNumber;
    }

}
