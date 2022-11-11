import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.time.Month;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KsebAdmin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("select option");
            System.out.println("1.add");
            System.out.println("2.search");
            System.out.println("3.delete");
            System.out.println("4.update");
            System.out.println("5.view all");
            System.out.println("6.generate bill");
            System.out.println("7.view all bill");
            System.out.println("8.top 2 bill");
            System.out.println("9.exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Add Consumer selected");

                    System.out.println("Enter Consumer Name: ");
                    String name = sc.next();

                    System.out.println("Enter Consumer Address: ");
                    String address = sc.next();

                    System.out.println("Enter Consumer Phone: ");
                    String phone = sc.next();

                    System.out.println("Enter the consumer code: ");
                    int custCode = sc.nextInt();

                    System.out.println("Enter Consumer Email Id: ");
                    String email = sc.next();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "INSERT INTO `consumer`(`consumer_name`, `consumer_place`, `consumer_phone`, `consumer_id`, `consumer_email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,address);
                        stmt.setString(3,phone);
                        stmt.setInt(4,custCode);
                        stmt.setString(5,email);
                        stmt.executeUpdate();
                        System.out.println("added successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;



                case 2:
                    System.out.println("Search Consumer");

                    break;
                case 3:
                    System.out.println("Delete Consumer");


                    break;
                case 4:
                    System.out.println("Update Consumer");


                    break;
                case 5:
                    System.out.println("View all Consumers");


                    break;
                case 6:
                    System.out.println("Generate Bill");

                    break;
                case 7:
                    System.out.println("View Bill");

                    break;
                case 8:
                    System.out.println("Top two high bill paying consumers");

                    break;
                case 9:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice");


            }
        }
    }
}