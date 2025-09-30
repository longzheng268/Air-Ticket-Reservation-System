package Window;

import Utils.MysqlUtils;
import Utils.UserUtils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class findpassW {
    Parent root2;
    JFXButton fid5;

    JFXTextField fid1,fid4;
    JFXPasswordField fid2,fid3;

    Text fid6;
    Stage finfpwStage2=new Stage();

    public findpassW()
    {
        try{
            root2 = FXMLLoader.load(getClass().getResource("../fxml/fpw1.fxml"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Scene scene=new Scene(root2,300,360);
        finfpwStage2.setTitle("�һ�����");
        finfpwStage2.setScene(scene);
        finfpwStage2.initStyle(StageStyle.UTILITY);

        finfpwStage2.show();
        Init_findpw();

    }

    public void Init_findpw()
    {
        fid1 = (JFXTextField) root2.lookup("#fid1");
        fid4 = (JFXTextField) root2.lookup("#fid4");
        fid2 = (JFXPasswordField) root2.lookup("#fid2");
        fid3 = (JFXPasswordField) root2.lookup("#fid3");
        fid5 = (JFXButton) root2.lookup("#fid5");
        fid6 = (Text) root2.lookup("#fid6");

        fid5.setOnAction(event ->
        {

            UserUtils m_fp = new UserUtils();

            try{
                switch (m_fp.changepw(fid1.getText(),fid2.getText(),fid3.getText(),fid4.getText())){
                    case 0:
                       // System.out.print("0");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle(" ");
                        alert.setHeaderText("");
                        alert.setContentText("�һ�����ɹ�");

                        alert.showAndWait();
                        finfpwStage2.hide();
                        //�޸ĳɹ�
                        break;
                    case 1:
                        Alert fp1 = new Alert(Alert.AlertType.ERROR,"2�����벻ƥ��");
                        fp1.showAndWait();
                        break;
                    case 2:
                        Alert fp2 = new Alert(Alert.AlertType.ERROR,"���֤���벻ƥ��");
                        fp2.showAndWait();
                        break;
                    case 3:
                        Alert fp3 = new Alert(Alert.AlertType.ERROR,"���˺�û��ע��");
                        fp3.showAndWait();
                        System.out.print("3");
                        break;
                }
            }
            catch (Exception e){e.printStackTrace();}
        });

    }
}
