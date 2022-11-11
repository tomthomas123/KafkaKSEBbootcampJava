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
        while (true) {
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

            switch (choice) {
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

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "INSERT INTO `consumer`(`consumer_name`, `consumer_place`, `consumer_phone`, `consumer_id`, `consumer_email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, name);
                        stmt.setString(2, address);
                        stmt.setString(3, phone);
                        stmt.setInt(4, custCode);
                        stmt.setString(5, email);
                        stmt.executeUpdate();
                        System.out.println("added successfully");

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;


                case 2:
                    System.out.println("Search Consumer selected");
                    System.out.println("Enter the Consumer Code,Name,Phone to search: ");
                    phone = sc.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "SELECT `consumer_name`, `consumer_place`, `consumer_phone`, `consumer_id`, `consumer_email` FROM `consumer` WHERE `consumer_id` ='" + phone + "'  OR `consumer_name`='" + phone + "' OR`consumer_phone`='" + phone + "'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            name = rs.getString("consumer_name");
                            address = rs.getString("consumer_place");
                            phone = rs.getString("consumer_phone");
                            custCode = rs.getInt("consumer_id");
                            email = rs.getString("consumer_email");
                            System.out.println("name = " + name);
                            System.out.println("address = " + address);
                            System.out.println("phone number = " + phone);
                            System.out.println("customer code = " + custCode);
                            System.out.println("Email id = " + email + '\n');
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Delete Consumer");

                    System.out.println("Enter the consumer code to delete: ");
                    custCode = sc.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `consumer` WHERE `consumer_id` = " + custCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Consumer Data deleted successfully.");
                    } catch (Exception e) {
                        System.out.println(e);
                    }


                    break;

                case 4:
                    System.out.println("Update Consumer");
                    System.out.println("Enter the consumer id : ");
                    custCode = sc.nextInt();
                    System.out.println("Enter the consumer name : ");
                    name = sc.next();
                    System.out.println("Enter the consumer address : ");
                    address = sc.next();
                    System.out.println("Enter the consumer phone : ");
                    phone = sc.next();
                    System.out.println("Enter the consumer email : ");
                    email = sc.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "UPDATE `consumer` SET `consumer_name`='" + name + "',`consumer_place`='" + address + "',`consumer_phone`='" + phone + "',`consumer_id`='" + custCode + "',`consumer_email`='" + email + "' WHERE `consumer_id`='" + custCode + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");

                    } catch (Exception e) {
                        System.out.println(e);
                    }


                    break;
                case 5:
                    System.out.println("View all Consumers selected");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "SELECT  `consumer_name`, `consumer_place`, `consumer_phone`,`consumer_id`, `consumer_email` FROM `consumer`  ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            name = rs.getString("consumer_name");
                            address = rs.getString("consumer_place");
                            phone = rs.getString("consumer_phone");
                            custCode = rs.getInt("consumer_id");
                            email = rs.getString("consumer_email");
                            System.out.println("name = " + name);
                            System.out.println("address = " + address);
                            System.out.println("phone number = " + phone);
                            System.out.println("customer code = " + custCode);
                            System.out.println("Email id = " + email + '\n');
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;


                case 6:
                    System.out.println("Generate Bill selected");

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

