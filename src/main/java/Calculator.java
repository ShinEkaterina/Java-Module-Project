import java.util.Scanner;

public class Calculator {
    int peopleNumber;
    double sum;
    String productList;

    Calculator(int peopleNumber){
        this.peopleNumber = peopleNumber;
        this.sum = 0;
        this.productList = "";
        System.out.println("Create calculatoe with " + peopleNumber);

    }

    void addProduct(Product product){
        this.sum = this.sum + product.price;
        this.productList = this.productList.concat(product.name + "\n");
        System.out.println("Product " + product.name + " with price = " + product.price + " successfully added");
    }

    void printProductList(){
        System.out.println(this.productList);

    }

}
