import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personNumber = getPersonNumber();

        // Создается калькулятор
        Calculator calculator = new Calculator(personNumber);
        // Пользователь вводит наименование и стоимость товара для подсчета
        while (true){
            System.out.println("Enter product name");
            if (scanner.hasNextLine()){
                String productName = scanner.nextLine();
                if(productName.equalsIgnoreCase("finish")){
                    break;
                } else {
                    // Пользователь вводит стоимость товара для подсчета
                    while (true){
                        System.out.println("Enter product price in rubles");
                        if(scanner.hasNextDouble()){
                            double productPrice = scanner.nextDouble();
                            Product product = new Product(productName, productPrice);
                            calculator.addProduct(product);
                            scanner.nextLine();
                            break;
                        } else {
                            if (scanner.nextLine().equalsIgnoreCase("finish")) {
                                break;
                            } else{
                                System.out.println("Price is incorrect");
                            }

                        }
                    }
                }
            }
        }
        System.out.println("List of products:");
        calculator.printProductList();
    }

    public static int getPersonNumber(){
        // Запрашиваем у пользователя количество человек, на которых нужно разделить счет
        Scanner scanner = new Scanner(System.in);
        int personNumber;
        while (true){
            System.out.println("Please enter number of people:");
            if(scanner.hasNextInt()){
                personNumber = scanner.nextInt();
                if (personNumber == 1){
                    System.out.println("There is no need to calculate");
                }
                else if (personNumber < 1){
                    System.out.println("Number of people is incorrect");
                }
                else {
                    System.out.println("Start calculating for " +personNumber +" people");
                  //  scanner.close();
                    return personNumber;
                }
            } else{
                System.out.println("Input is incorrect");
                scanner.nextLine();
            }

        }
    }
}
