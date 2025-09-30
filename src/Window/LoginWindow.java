package Window;

import Utils.UserUtils;
import com.jfoenix.controls.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.*;


public class LoginWindow extends Application {


    // @FXML
    private JFXButton Button_login;
    private JFXButton Button_regist;
    private JFXButton Button_fpw;
 //   private JFXRadioButton ra1;
    private JFXToggleButton ra2;
    private JFXToggleButton ra1;

  //  private JFXRadioButton ra2;
    private JFXTextField userTextField;
    private JFXPasswordField pwBox;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        primaryStage.setTitle("��ƱԤ��ϵͳ");
        System.out.println("DPI"+Toolkit.getDefaultToolkit().getScreenResolution());
        primaryStage.setScene(new Scene(root, 340, 300));
        primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.show();

        Button_login=(JFXButton) root.lookup("#Button_login");
        Button_regist=(JFXButton) root.lookup("#Button_regist");
        Button_fpw=(JFXButton) root.lookup("#Button_fpw");
        userTextField=(JFXTextField)root.lookup("#tf_username");
        pwBox=(JFXPasswordField)root.lookup("#tf_password");
        ra2=(JFXToggleButton)root.lookup("#user");
        ra1=(JFXToggleButton)root.lookup("#admin");

    /*
       ra2=(JFXRadioButton)root.lookup("#ra_user");     //ra1
        ra1=(JFXRadioButton)root.lookup("#ra_admin");   //ra2
       ToggleGroup gp = new ToggleGroup();
        ra1.setToggleGroup(gp);
        ra2.setToggleGroup(gp);
        ra2.setSelected(true);
*/
        ToggleGroup gp = new ToggleGroup();
        ra2.setToggleGroup(gp);
        ra1.setToggleGroup(gp);
        ra2.setSelected(true);


        Button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                UserUtils dl = new UserUtils();
                if(ra1.isSelected()){
                    try {
                        switch (dl.isexst_admin(userTextField.getText(), pwBox.getText())) {
                            case 0:
                                Alert cw1 = new Alert(Alert.AlertType.ERROR,"���˺�û��ע��");
                                cw1.showAndWait();
                                break;
                            case 1:
                                Alert cw2 = new Alert(Alert.AlertType.ERROR,"�������");
                                cw2.showAndWait();
                                break;
                            case 2:
                                //��½�ɹ�
                                ManagerWindow managerWindow = new ManagerWindow();
                                primaryStage.hide();
                                break;
                        }
                    } catch (Exception e) {
                    }

                }
                else {
                    //    dl.getConnection();
                    try {
                        switch (dl.isexst_user(userTextField.getText(), pwBox.getText())) {
                            case 0:
                                Alert cw1 = new Alert(Alert.AlertType.ERROR,"���˺�û��ע��");
                                cw1.showAndWait();
                                break;
                            case 1:
                                Alert cw2 = new Alert(Alert.AlertType.ERROR,"�������");
                                cw2.showAndWait();
                                break;
                            case 2:
                                //��½�ɹ�
                                UserWindow userWindow=new UserWindow(userTextField.getText());
                                primaryStage.hide();
                                 System.out.println("��½�ɹ�");
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Button_regist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RegistWindow re = new RegistWindow();
                re.Init_Bre();

            }
        });


        Button_fpw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                findpassW fpw = new findpassW();
            }
        });


    }


    public static void main(String[] args) {
        launch(args);
    }
}
