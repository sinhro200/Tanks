package com.example.tanks.Scenes;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class MyMenuScene extends Scene {

    public MyMenuScene(double width, double height, ReadyListener beginReadyListener) {
        super(new Pane(),width,height);

        MenuItem startItem = new MenuItem("Запуск");
        MenuItem settingsItem = new MenuItem("Настройки");
        MenuItem exitItem = new MenuItem("Выход");

        startItem.setOnMouseClicked(event ->
                beginReadyListener.onReady()
        );
        settingsItem.setOnMouseClicked(event -> {

        });
        exitItem.setOnMouseClicked(event->
                System.exit(0)
        );

        SubMenu mainMenu = new SubMenu(startItem,settingsItem,exitItem);

        MenuBox menuBox = new MenuBox(mainMenu);

        this.setRoot(menuBox);
    }






    private static class MenuItem extends StackPane {
        Text info;
        public MenuItem(String name,String value) {
            Rectangle bg = new Rectangle(200, 20, Color.BLACK);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            text.setTranslateX(10.0);

            info = new Text(value);
            info.setFill(Color.YELLOW);
            info.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
            info.setTextAlignment(TextAlignment.RIGHT);
            info.setWrappingWidth(50.0);
            info.setTranslateX(140.0);


            setAlignment(Pos.CENTER_LEFT);
            getChildren().addAll(bg, text,info);
            FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
            setOnMouseEntered(event -> {
                st.setFromValue(Color.BLACK);
                st.setToValue(Color.FORESTGREEN);
                st.setCycleCount(Animation.INDEFINITE);
                st.setAutoReverse(true);
                st.play();
            });
            setOnMouseExited(event -> {
                st.stop();
                bg.setFill(Color.BLACK);
            });
        }

        public void setInfo(String str){
            info.setText(str);
        }
        public void setInfo(int str){
            info.setText(Integer.toString(str));
        }
        public void setInfo(double str){
            info.setText(Double.toString(str));
        }
        public MenuItem(String name) {
            Rectangle bg = new Rectangle(200, 20, Color.BLACK);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
            FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
            setOnMouseEntered(event -> {
                st.setFromValue(Color.BLACK);
                st.setToValue(Color.FORESTGREEN);
                st.setCycleCount(Animation.INDEFINITE);
                st.setAutoReverse(true);
                st.play();
            });
            setOnMouseExited(event -> {
                st.stop();
                bg.setFill(Color.BLACK);
            });
        }
    }

    private static class MenuBox extends Pane {
        static SubMenu subMenu;

        public MenuBox(SubMenu subMenu) {
            MenuBox.subMenu = subMenu;

            Rectangle bg = new Rectangle(1920, 1080, Color.LIGHTSLATEGREY);
            bg.setOpacity(0.4);
            getChildren().addAll(bg, subMenu);
        }

        public void setSubMenu(SubMenu subMenu) {
            getChildren().remove(MenuBox.subMenu.getChildren());
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);
        }
        public SubMenu getSubMenu(){
            return subMenu;
        }
    }

    private static class SubMenu extends VBox {
        public SubMenu(MenuItem... items) {
            setSpacing(15);
            setTranslateY(40);
            setTranslateX(50);
            for (MenuItem item : items) {
                getChildren().addAll(item);
            }
        }
    }
}
