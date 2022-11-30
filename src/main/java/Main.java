import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personNumber = getPersonNumber();
        double sumToPay;

        // Создается калькулятор
        Calculator calculator = new Calculator(personNumber);
        // Пользователь вводит наименование и стоимость товара для подсчета
        boolean stopEnterProduct = false;
        boolean stopEnterPrice = false;
        while (!stopEnterProduct){
            System.out.println("Введите название товара");
            if (scanner.hasNextLine()){
                String productName = scanner.nextLine();
                if(productName.equalsIgnoreCase("завершить")){
                    stopEnterProduct = true;
                } else {
                    // Пользователь вводит стоимость товара для подсчета
                    while (!stopEnterPrice){
                        System.out.println("Введите стоимость товара в рублях");
                        if(scanner.hasNextDouble()){
                            double productPrice = scanner.nextDouble();
                            if (productPrice < 0){
                                System.out.println("Некорректное значение");
                                continue;
                            }
                            Product product = new Product(productName, productPrice);
                            calculator.addProduct(product);
                            scanner.nextLine();
                            stopEnterPrice = true;
                        } else {
                            if (scanner.nextLine().equalsIgnoreCase("завершить")) {
                                stopEnterPrice = true;
                            } else{
                                System.out.println("Некорректное значение");
                            }

                        }
                    }
                }
            }
        }
        System.out.println("Добавленные товары:");
        calculator.printProductList();

        sumToPay = calculator.calculateSumToPay();

         if (Math.floor(sumToPay) == 1)
           System.out.println(String.format("Каждый должен заплатить по %.2f рубль",sumToPay));
       else if (Math.floor(sumToPay) == 2 || Math.floor(sumToPay) == 3 || Math.floor(sumToPay) == 4)
            System.out.println(String.format("Каждый должен заплатить по %.2f рубля",sumToPay));
        else
            System.out.println(String.format("Каждый должен заплатить по %.2f рублей",sumToPay));
    }

    public static int getPersonNumber(){
        // Запрашиваем у пользователя количество человек, на которых нужно разделить счет
        Scanner scanner = new Scanner(System.in);
        int personNumber;
        while (true){
            System.out.println("На скольких человек нужно разделить счет?");
            if(scanner.hasNextInt()){
                personNumber = scanner.nextInt();
                if (personNumber == 1){
                    System.out.println("Нет смысла что то считать и делить");
                }
                else if (personNumber < 1){
                    System.out.println("Некорректное значение для подсчета");
                }
                else {
                    return personNumber;
                }
            } else{
                System.out.println("Некорректное значение для подсчета");
                scanner.nextLine();
            }

        }
    }
}
