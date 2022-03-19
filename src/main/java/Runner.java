import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Runner {
    public static void main(String[] args) {
        try{
            //Öncelikle sürücüye ihtiyacım var
            Driver.class.forName("org.postgresql.Driver");
            //Sürücüyü Yöneterek bir bağlantı oluşturmasını sağlamalıyız.
            //nereye bağlanacaksın=URL
            //kim bağlanıyor=user
            //parolası nedir=password
            //URL= Bağlantı için gerekli bilgiler= ip adresi,post no,database adı
            String URL = "jdbc:postgresql://localhost:5432/SatisDB";
            String user = "postgres";
            String password = "root";
            Connection connection=DriverManager.getConnection(URL,user,password);

            //Driver a bir şey yapması için emir verelim.
            String SQL="insert into tblmusteri(ad,soyad) values('Kenan','KESİK')";
            PreparedStatement pst =connection.prepareCall(SQL);
            //Verilen emrin uygulanması için işlem yapılır.
            pst.executeUpdate();
            //Emrin veri tabanına uygulanmasını onaylıyoruz
            //connection.commit();
            //açmış olduğumuz bağlantıyı kapatıyoruz.
            connection.close();
        }catch (Exception exception){
            System.out.println("Hata..: "+ exception);
        }

    }
}
