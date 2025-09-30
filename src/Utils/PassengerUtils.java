package Utils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PassengerUtils extends MysqlUtils {

    public PassengerUtils() {
        this.getConnection();
    }

    // ��ѯ�û���ȫ���˻���
     public List<Map<String,Object>> SelectAllPsg(String user)
     {
         String sql="SELECT * FROM airlineticket.passenger where user='"+user+"'";
         List< Map<String,Object> >  list = new ArrayList<  Map<String,Object>>();

         try {
             list =this.findModeResult(sql, null);
         }
         catch (SQLException e){
             e.printStackTrace();
         }
         return list;
     }

    /* ���һ���˻��� ����ΪList����*/
    public  boolean InsertPsg(List<Object> params)
    {

        String sql="INSERT INTO `airlineticket`.`passenger` VALUES (?, ?, ?)";
        try {
            this.updateByPreparedStatement(sql, params);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }



    /*  ɾ��һ���˻��� ͨ��ID */
    public boolean DeletePsgById(List<Object>params)
    {
        String sql="DELETE FROM `airlineticket`.`passenger` WHERE `id`=?";
        try {
            this.updateByPreparedStatement(sql, params);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean UpDate_A_By_ID (String attr ,List <Object> params)
    {

        String sql="UPDATE `airlineticket`.`passenger` SET "+ attr +"= ? WHERE `id`=?";
        try {
            this.updateByPreparedStatement(sql, params);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
