import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab_11_Task_1 {
    JFrame frame;
    JPanel panel;
    JLabel name,roll,batch,section,gender,qualification,address,country;
    JTextField t1,t2,t3,t4;
    JTextArea textArea;
    JCheckBox c1,c2,c3,c4;
    String[] countryList={"Pakistan","India","Australia","England","Sri Lanka","Bangladesh","New Zealand"};
    JComboBox comboBox=new JComboBox<>(countryList);
    JRadioButton r1,r2;
    JButton b1,b2;
    ButtonGroup buttonGroup1,buttonGroup2;
    JSONObject jsonObject=new JSONObject();

    Lab_11_Task_1()
    {
        frame=new JFrame("Student Registration");
        panel=new JPanel();
        name=new JLabel("Name: ");
        roll=new JLabel("Roll Number: ");
        batch=new JLabel("Batch: ");
        section=new JLabel("Section: ");
        gender=new JLabel("Gender: ");
        qualification=new JLabel("Qualification");
        address=new JLabel("Address");
        country=new JLabel("Country");
        c1=new JCheckBox("Matric");
        c2=new JCheckBox("Intermediate");
        c3=new JCheckBox("Graduate");
        c4=new JCheckBox("Post Graduate");
        buttonGroup1=new ButtonGroup();
        buttonGroup2=new ButtonGroup();
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        textArea=new JTextArea();
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        b1=new JButton("Save");
        b2=new JButton("Print");
        panel.setLayout(null);
        frame.setSize(700,700);
        panel.setSize(700,700);
        panel.setBackground(Color.yellow);
        name.setBounds(50,50,100,50);
        roll.setBounds(50,100,100,50);
        batch.setBounds(50,150,100,50);
        section.setBounds(50,200,100,50);
        gender.setBounds(50,250,100,50);
        qualification.setBounds(50,300,100,50);
        address.setBounds(50,400,100,50);
        country.setBounds(50,490,100,50);
        c1.setBounds(180,310,100,30);
        c2.setBounds(330,310,100,30);
        c3.setBounds(180,360,100,30);
        c4.setBounds(330,360,120,30);
        t1.setBounds(180,60,150,30);
        t2.setBounds(180,110,150,30);
        t3.setBounds(180,160,150,30);
        t4.setBounds(180,210,150,30);
        textArea.setBounds(180,400,220,75);
        comboBox.setBounds(180,500,200,30);
        comboBox.setEditable(false);
        r1.setBounds(180,260,70,30);
        r2.setBounds(280,260,70,30);
        b1.setBounds(50,600,70,30);
        b2.setBounds(320,600,70,30);
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
        buttonGroup2.add(c1);
        buttonGroup2.add(c2);
        buttonGroup2.add(c3);
        buttonGroup2.add(c4);
        panel.add(name);
        panel.add(roll);
        panel.add(batch);
        panel.add(section);
        panel.add(gender);
        panel.add(qualification);
        panel.add(address);
        panel.add(country);
        panel.add(c1);
        panel.add(c2);
        panel.add(c3);
        panel.add(c4);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(textArea);
        panel.add(comboBox);
        panel.add(r1);
        panel.add(r2);
        panel.add(b1);
        panel.add(b2);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });

    }
    public void saveData()
    {

        String gender;
        String qualification;
        if(c1.isSelected())qualification="Matric";
        else if(c2.isSelected())qualification="Intermediate";
        else if(c3.isSelected())qualification="Graduate";
        else qualification="Post Graduate";
        if(r1.isSelected())gender="Male";
        else gender="Female";
        String name=t1.getText();
        String rollNumber=t2.getText();
        String batch=t3.getText();
        String section=t4.getText();
//            String gender=buttonGroup1.getSelection().getActionCommand();
//            String qualification=buttonGroup2.getSelection().getActionCommand();
        String country=(String)comboBox.getSelectedItem();
        String address=textArea.getText();
        jsonObject.put("Name",name);
        jsonObject.put("RollNumber",rollNumber);
        jsonObject.put("Batch",batch);
        jsonObject.put("Section",section);
        jsonObject.put("Gender",gender);
        jsonObject.put("Qualification",qualification);
        jsonObject.put("Country",country);
        jsonObject.put("Address",address);
        try {
            FileWriter file=new FileWriter("MyFile.json");
            file.write(jsonObject.toJSONString());
            file.close();
            JOptionPane.showMessageDialog(null,"Data stored successfully.");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void showData()
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("MyFile.json"));
            JSONObject object = (JSONObject) obj;
            String name = (String) object.get("Name");
            String rollNumber = (String) object.get("RollNumber");
            String batch = (String) object.get("Batch");
            String section = (String) object.get("Section");
            String gender = (String) object.get("Gender");
            String qualification = (String) object.get("Qualification");
            String country = (String) object.get("Country");
            String address = (String) object.get("Address");
            frame.remove(panel);
            Panel panel1 = new Panel();
            panel1.setLayout(null);
            panel1.setBackground(Color.yellow);
            panel1.setSize(700, 700);
            JLabel l1, l2, l3, l4, l5, l6, l7, l8;
            l1 = new JLabel("Name : " + name);
            l2 = new JLabel("Roll #: " + rollNumber);
            l3 = new JLabel("Batch: " + batch);
            l4 = new JLabel("Section: " + section);
            l5 = new JLabel("Gender: " + gender);
            l6 = new JLabel("Qualification: " + qualification);
            l7 = new JLabel("Country: " + country);
            l8 = new JLabel("Address: " + address);
            l1.setBounds(10, 20, 200, 50);
            l2.setBounds(10, 70, 200, 50);
            l3.setBounds(10, 120, 200, 50);
            l4.setBounds(10, 170, 200, 50);
            l5.setBounds(10, 220, 200, 50);
            l6.setBounds(10, 270, 200, 50);
            l7.setBounds(10, 320, 200, 50);
            l8.setBounds(10, 370, 200, 50);
            panel1.add(l1);
            panel1.add(l2);
            panel1.add(l3);
            panel1.add(l4);
            panel1.add(l5);
            panel1.add(l6);
            panel1.add(l7);
            panel1.add(l8);
            frame.add(panel1);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public static void main(String[] args) {
        Lab_11_Task_1 gui=new Lab_11_Task_1();
    }

}