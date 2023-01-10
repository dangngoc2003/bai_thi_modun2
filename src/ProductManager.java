import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
List<Product> listProduct=new ArrayList<>();
String path="C:\\Users\\Admin\\IdeaProjects\\thimodun2\\src\\Product.csv";

public Product creatProduct(Scanner scanner){
    boolean check=true;
    System.out.println("Enter code  product :");
    String code=scanner.nextLine();
    System.out.println("Enter name  product");
    String name =scanner.nextLine();
    double price=0;
    while (check){
        try {
            System.out.println("Enter price  product :");
             price=Double.parseDouble(scanner.nextLine());
            check=false;
        }catch (InputMismatchException | NumberFormatException exception){
            System.out.println("Wrong format. Please re-enter");
        }
    }
        check=true;
    int quantity=0;
    while (check) {
        try {
            System.out.println("Enter quantity  product :");
             quantity = Integer.parseInt(scanner.nextLine());
            check = false;
        } catch (InputMismatchException | NumberFormatException exception) {
            System.out.println("Wrong format. Please re-enter");
        }
    }
    System.out.println("Enter description product :");
    String description=scanner.nextLine();
    return new Product(code,name,price,quantity,description);
}
public void save(Scanner scanner){
    listProduct.add(creatProduct(scanner));
    System.out.println("Successfully added product !!!");
}
public Product findByCode(String code){
    boolean check=true;
    while (check){
    for (Product temp:listProduct) {
        if (temp.getCode().equals(code)){
            check=false;
            temp.display();
            return temp;
        }else {
            System.out.println("The corresponding code could not be found");
            System.out.println("Please re-enter !");
        }
    }
    }return null;
}
public void update(Scanner scanner){
    boolean check=true;
    System.out.println("Enter the code you want to edit :");
    String code=scanner.nextLine();
    Product product=findByCode(code);
    if (product!=null){
        System.out.println("Enter code want to replace ");
        String code1=scanner.nextLine();
            product.setCode(code1);
        System.out.println("Enter name product want to replace :");
        String name =scanner.nextLine();
        product.setName(name);
        double price=0;
        while (check){
            try {
                System.out.println("Enter price product want to replace :");
                price=Double.parseDouble(scanner.nextLine());
                check=false;
            } catch (InputMismatchException | NumberFormatException exception) {
                System.out.println("Wrong format. Please re-enter");
            }
        }
        product.setPrice(price);
        int quantity=0;
        check=true;
        while (check){
            try {
                System.out.println("Enter quantity product want replace :");
                 quantity =Integer.parseInt(scanner.nextLine());
                check=false;
            }catch (InputMismatchException | NumberFormatException exception) {
                System.out.println("Wrong format. Please re-enter");
            }
        }
        product.setQuantity(quantity);
        System.out.println("Enter description want to replace :");
        String description=scanner.nextLine();
        product.setDescription(description);
        System.out.println("Product.csv repaired successfully !!!");
        title();
        product.display();
    }
}
public void deleteProduct(Scanner scanner){
    System.out.println("Enter code want delete");
    String code=scanner.nextLine();
    Product product=findByCode(code);
    listProduct.remove(product);
}
 public void sortProduct(){
     listProduct.sort(new Product());
     showProduct();

 }
    public void searchPriceMax(){
    double maxPrice =listProduct.get(0).getPrice();
        for (Product product : listProduct) {
            if (maxPrice < product.getPrice()) {
                maxPrice = product.getPrice();
            }
        }
        for (Product temp: listProduct) {
            if (temp.getPrice()==maxPrice){
                temp.display();
            }
        }
    }
public void showProduct(){
    if (!listProduct.isEmpty()){
        title();
    for (Product temp:listProduct) {
        temp.display();
    }
    }else {
        System.out.println("List product is empty !!!");
    }
}
public void title(){
    System.out.printf("%-15s%-15s%-15s%-30s%s",
            "code", "name", "price", "quantity", "description" + "\n");
}

    public void writeCsv(List<Product> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Product product : list) {
                bw.write(product.toString());
                bw.newLine();

            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Product> read(String path){
       List<Product> listProduct = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line=br.readLine())!=null){
                String [] txt = line.split(";");
                String code = txt[1];
                String name = txt[1];
                double price = Double.parseDouble(txt[2]);
                int quantity = Integer.parseInt(txt[3]);
                String description = txt[4];
                listProduct.add(new Product(code,name,price,quantity,description));
            }
            br.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listProduct;
    }

}
