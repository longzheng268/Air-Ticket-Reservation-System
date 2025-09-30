package Utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlUtils {
       /*  ���ݿ�������Ϣ */
          //private static  final String DRIVER="com.mysql.jdbc.Driver";
          private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
          //? ����ָ�������ʽ���Ҳ�ʹ��ssl
          private static  final String URL="jdbc:mysql://���ݿ��ַ:���ݿ�˿�/Air-Ticket-Reservation-System?useUnicode=true&characterEncoding=utf-8&useSSL=false";
          private static  final String USERNAME="Air-Ticket-Reservation-System";
          private static  final String PASSWORD="Air-Ticket-Reservation-System";

          private Connection connection;
          private PreparedStatement preparedStatement;
          private ResultSet resultSet;

          public MysqlUtils(){
              try{
                  //ע��JDBC����
                  Class.forName(DRIVER);
              }
                 catch (Exception e){
                   e.printStackTrace();
                 }
          }
          //��ȡ����
        public void getConnection(){
              try{
                  connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
              }
              catch (SQLException e){
                e.printStackTrace();
              }
        }
          //�ر�����
        public void closeConnection(){
              try{
              connection.close();}
              catch (SQLException e){
                  e.printStackTrace();
              }
        }

        /*  ʵ������ɾ����*/
    public boolean updateByPreparedStatement(String sql, List<Object>params)throws SQLException{
        boolean flag = false;
        int result = -1;
        preparedStatement = connection.prepareStatement(sql);
        int index = 1;
        if(params != null && !params.isEmpty()){
            for(int i=0; i<params.size(); i++){
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        result = preparedStatement.executeUpdate();  //������Ӱ�������
        flag = result > 0 ? true : false;
        return flag;
    }




       /*��ѯ������¼*/
    public List<Map<String, Object>> findModeResult(String sql, List<Object> params) throws SQLException{
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if(params != null && !params.isEmpty()){
            for(int i = 0; i<params.size(); i++){
                preparedStatement.setObject(index++, params.get(i));  //����SQL��?
            }
        }
        resultSet = preparedStatement.executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();      //��ȡResultSet�ж�����

        while(resultSet.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            for(int i=0; i<cols_len; i++){                    //��һ����¼װ��list
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = resultSet.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }
}
