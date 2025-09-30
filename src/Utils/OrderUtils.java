package Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderUtils extends MysqlUtils {

        public OrderUtils() {
            this.getConnection();
        }

    /* ���һ������ ����ΪList����*/
    public  boolean InsertOrder(List<Object> params)
    {

        String sql="INSERT INTO `airlineticket`.`order` VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
        try {
            this.updateByPreparedStatement(sql, params);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

        //��ѯȫ������
        public List<Map<String, Object>> SelectAllOrder()
        {
            String sql ="SELECT * FROM airlineticket.order";
            List< Map<String,Object> >  list = new ArrayList<  Map<String,Object>>();

            try {
                list =this.findModeResult(sql, null);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            return list;

        }

        //��ѯ�û�����
    public List<Map<String, Object>> SelectAllOrderByuser(List<Object>params)
    {
        String sql ="SELECT * FROM airlineticket.order  WHERE `user`=?";
        List< Map<String,Object> >  list = new ArrayList<  Map<String,Object>>();

        try {
            list =this.findModeResult(sql, params);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }


    //ģ����ѯ����  attribute���� parasΪ����
    public List<Map<String,Object>> Select_Where_A_like_B(String attribute,List<Object> paras)
    {            // like '%?%'
        String sql="SELECT * FROM airlineticket.order where "+attribute+" like ?";
        List< Map<String,Object> >  list = new ArrayList<  Map<String,Object>>();
        try{
            list=this.findModeResult(sql, paras);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return  list;
    }

    //ɾ������
    public boolean DeleteOrderById(List<Object>params)
    {
        String sql="DELETE FROM `airlineticket`.`order` WHERE `orderid`=?";
        try {
            this.updateByPreparedStatement(sql, params);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }


    /* ���¶�����Ϣͨ��ID*/
    public boolean UpDate_A_By_ID (String attr ,List <Object> params)
    {

        String sql="UPDATE `airlineticket`.`order` SET "+ attr +"= ? WHERE `orderid`=?";
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
