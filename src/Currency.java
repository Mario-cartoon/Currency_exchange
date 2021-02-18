import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Currency extends JFrame implements ActionListener {
    JButton button;
    JComboBox box_1;
    JComboBox box_2;
    JTextField text_1;
    JLabel text_2;
    String[] items = {"RUB", "USD", "UAH"};

    public Currency() {
        super("Конвектор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(420, 260);

        /**Создание текстового поля для ввода значения **/
        text_1 = new JTextField();
        text_1.setBounds(40, 30, 200, 30);
        text_1.setText("1");
        text_1.setBorder(BorderFactory.createLineBorder(Color.gray));
        text_1.addActionListener(this);
        add(text_1);

        /**Создание текстового поля для вывода значения **/
        text_2 = new JLabel();
        text_2.setBounds(40, 70, 200, 30);
        text_2.setText("1");
        text_2.setOpaque(true);
        text_2.setBorder(BorderFactory.createLineBorder(Color.gray));
        text_2.setBackground(Color.WHITE);
        add(text_2);

        /**Создание списка  переводимой валюты **/
         box_1 = new JComboBox(items);
        box_1.setBounds(260, 30, 100, 30);
        box_1.addActionListener(this);
        add(box_1);

        /**Создание списка для выбора переводимой волюты **/
         box_2 = new JComboBox(items);
        box_2.setBounds(260, 70, 100, 30);
        add(box_2);
        box_2.addActionListener(this);

        /**Создание кнопки для очистки поля **/
        button = new JButton("Очистить поля");
        button.setBounds(100, 110, 200, 30);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBackground(Color.LIGHT_GRAY);
        add(button);

        /**Создание текстового поля**/
        JLabel label =new JLabel();
        label.setFont(new Font("Font1",Font.ITALIC,10));//шрифт
        label.setText("<html> Внимание! Колличиство чисел после запятой так много не потому"+
                " что я не знаю как форматировать, а потому что каждая копеечка важна!</html> ");
        label.setBounds(70,130,280,80);
        add(label);

        setLayout(null);//отключить компоновщик контейнера
        setVisible(true);//делаем окно видимым
    }

    public static void main(String[] args) {
        new Currency();//создаем новый обьект класса Currency
    }
    /**Переопредеояем метод actionPerformed **/
    @Override
    public void actionPerformed(ActionEvent e) {
        double n ,k;//временные переменные для подсчета волют
        if (e.getSource() == box_1||e.getSource()==text_1 ||e.getSource()==box_2  ) {//если событие произошло с полями или списками то событие обрабатывается
            n = Double.valueOf(text_1.getText());//получаем занчение с поля и изминяем тип на вещественный
                if(box_1.getSelectedIndex()==box_2.getSelectedIndex()){
                    k =n;
                    text_2.setText(String.valueOf(k));
                }else if (box_1.getSelectedIndex()!=box_2.getSelectedIndex()){
                    if (box_1.getSelectedIndex()==0&& box_2.getSelectedIndex()==1){
                        k =n*73.6;
                        text_2.setText(String.valueOf(k));
                    }
                    else if(box_1.getSelectedIndex()==0&& box_2.getSelectedIndex()==2){
                        k =n*2.67;//2.67
                        text_2.setText(String.valueOf(k));
                    }else if(box_1.getSelectedIndex()==1&& box_2.getSelectedIndex()==0){
                        k =n*73.6;
                        text_2.setText(String.valueOf(k));
                    }else if(box_1.getSelectedIndex()==1&& box_2.getSelectedIndex()==2){
                        k =n*28.46;
                        text_2.setText(String.valueOf(k));
                    }else if(box_1.getSelectedIndex()==2&& box_2.getSelectedIndex()==0){
                        k =n*2.65;
                        text_2.setText(String.valueOf(k));
                    }else if(box_1.getSelectedIndex()==2&& box_2.getSelectedIndex()==1){
                        k =n*0.38;
                        text_2.setText(String.valueOf(k));
                    }

            }
        }
        else if (e.getSource() == button){//очистка поля
            text_1.setText("");
            text_2.setText("");
        }
    }
}
