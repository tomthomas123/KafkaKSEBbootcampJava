import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
                    System.out.println("Selected bill generation");
                    GregorianCalendar date = new GregorianCalendar();
                    int cMonth = date.get(Calendar.MONTH);
                    int cYear = date.get(Calendar.YEAR);
                    cMonth = cMonth+1;
                    System.out.println("Current month is  " + cMonth);
                    System.out.println("Current year is  " + cYear);
                    System.out.println("Bill Generated succesfully");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `bill` WHERE `month`= '" + cMonth + "'AND `year`= '" + cYear + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        String sql1 = "SELECT `id` FROM `consumer` ";
                        Statement stmt1 = con.createStatement();
                        ResultSet rs = stmt1.executeQuery(sql1);
                        while (rs.next())
                        {
                            int id = rs.getInt("id");
                            String sql2 = "select SUM(`unit`) from usages where month(date) = '"+cMonth+"' AND year(date) = '"+cYear+"' AND `user_id` ='"+id+"'";
                            Statement stmt2 = con.createStatement();
                            ResultSet rs1 = stmt2.executeQuery(sql2);
                            while (rs1.next())
                            {
                                int add = rs1.getInt("SUM(`unit`)");
                                int status = 0;
                                int totalBill = add * 5;
                                int min = 10000;
                                int max = 99999;
                                int invoice = (int)(Math.random() * (max - min + 1) + min);
                                String sql3 = "INSERT INTO `bill`(`consumer_id`, `month`, `year`, `bill`, `paid_status`, `billdate`, `total_units`, `duedate`, `invoice`) VALUES (?,?,?,?,?,now(),?,now()+ interval 14 day,?)";
                                PreparedStatement stmt3 = con.prepareStatement(sql3);
                                stmt3.setInt(1, id);
                                stmt3.setInt(2, cMonth);
                                stmt3.setInt(3, cYear);
                                stmt3.setInt(4, totalBill);
                                stmt3.setInt(5, 0);
                                stmt3.setInt(6, add);
                                stmt3.setInt(7,invoice );
                                stmt3.executeUpdate();
                            }
                        }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                                    case 7:
                                        System.out.println("View Bill");

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "SELECT  b.`consumer_id`, b.`month`, b.`year`, b.`bill`, b.`paid_status`, b.`billdate`, b.`total_units`, b.`duedate`, b.`invoice`,c.consumer_id,c.consumer_name FROM `bill` b JOIN consumer c ON b.consumer_id=c.id";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerId = rs.getString("consumer_id");
                            String getMonth= rs.getString("month");
                            String getYear = rs.getString("year");
                            String getBill = rs.getString("bill");
                            String getPaidStatus = rs.getString("paid_status");
                            String getbilldate = rs.getString("billdate");
                            String getTotalUnit = rs.getString("total_units");
                            String getDueDate = rs.getString("duedate");
                            String getInvoice = rs.getString("invoice");
                            String getConsumerCode = rs.getString("consumer_id");
                            String getConsumerName = rs.getString("consumer_name");
                            System.out.println("Consumer Id="+getConsumerId);
                            System.out.println("Month="+getMonth);
                            System.out.println("Year="+getYear);
                            System.out.println("Bill ="+getBill);
                            System.out.println("PaidStatus ="+getPaidStatus);
                            System.out.println("Bill Date ="+getbilldate);
                            System.out.println("Total Unit ="+getTotalUnit);
                            System.out.println("Due Date ="+getDueDate);
                            System.out.println("Invoice ="+getInvoice);
                            System.out.println("Consumer Code ="+getConsumerCode);
                            System.out.println("Consumer Name="+getConsumerName+"\n");
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                                        break;
                                    case 8:
                                        System.out.println("Top two high bill paying consumers");

                                        try{
                                            Class.forName("com.mysql.jdbc.Driver");
                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                                            String sql = "SELECT c.consumer_name,c.consumer_place,b.`total_units`, b.`bill` FROM bill b JOIN consumer c ON b.consumer_id = c.id GROUP BY `bill` ORDER BY `bill` DESC LIMIT 2";
                                            Statement stmt = con.createStatement();
                                            ResultSet rs = stmt.executeQuery(sql);
                                            while (rs.next()){
                                                String getConsumerName = rs.getString("consumer_name");
                                                String getConsumerAddress = rs.getString("consumer_place");
                                                String getTotalUnit= rs.getString("total_units");
                                                String getBill = rs.getString("bill");


                                                System.out.println("Consumer Name="+getConsumerName);
                                                System.out.println("Consumer Address="+getConsumerAddress);
                                                System.out.println("Total Unit="+getTotalUnit);
                                                System.out.println("Amount  ="+getBill+"\n");


                                            }

                                        }
                                        catch (Exception e){
                                            System.out.println(e);
                                        }




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

