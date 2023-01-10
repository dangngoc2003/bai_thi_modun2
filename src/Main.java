import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ProductManager productManager=new ProductManager();

        do {
            boolean check=true;
            int choice=0;
            while (check)
                try {
                    System.out.println("1.Show list product :");
                    System.out.println("2.Add product :");
                    System.out.println("3.Update product :");
                    System.out.println("4.Delete product :");
                    System.out.println("5.Sort prices from high to low :");
                    System.out.println("6.Display product max price :");
                    System.out.println("7.Read to file CSV :");
                    System.out.println("8.Write to file CSV :");
                    System.out.println("0.Exit");
                    System.out.println("Enter choice :");
                    choice=Integer.parseInt(scanner.nextLine());
                    check=false;
                }catch (InputMismatchException | NumberFormatException exception) {
                    System.out.println("Wrong format. Please re-enter");
                }
            switch (choice){
                case 1:
                    productManager.showProduct();
                    break;
                case 2:
                    productManager.save(scanner);
                    break;
                case 3:
                    productManager.update(scanner);
                    break;
                case 4:
                    productManager.deleteProduct(scanner);
                    break;
                case 5:
                    productManager.sortProduct();
                    break;
                case 6:
                    productManager.searchPriceMax();
                    break;
                case 7:
                    productManager.read(productManager.path);
                    break;
                case 8:
                    productManager.writeCsv(productManager.listProduct, productManager.path);
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true);
    }
}