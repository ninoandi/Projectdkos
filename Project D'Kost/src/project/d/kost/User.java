package project.d.kost;

public class User {
    public static String nama;
    public static int id;
    
    public static void setNama(String nama){
        User.nama = nama;
    }
    
    public static void setId(int id){
        User.id = id;
    }
    
    public static String getNama(){
        return nama;
    }
    
    public  static int getId(){
        return id;
    }
}