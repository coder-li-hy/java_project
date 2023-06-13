import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args)  {
        showMain();
    }

    public static void showMain() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
//        JFrame frame1=new JFrame("加载项目中");
//        frame1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        frame1.setSize(400,100);
//        frame1.setLocationRelativeTo(null);
//        frame1.setLayout(null);
//        JProgressBar bar=new JProgressBar();
//        bar.setBounds(frame1.getX()/2, frame1.getY()/2,300,10);
//        bar.setMaximum(1000000);
//        frame1.add(bar);
//        frame1.setVisible(true);
//        new Thread(() -> {
//            for (int i = 0; i < 1000000; i++) {
//                bar.setValue(i);
//                bar.repaint();
//            }
//        }).start();
//        frame1.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                if (bar.getValue() == 999999) {
//                    frame1.dispose();
//                }
//            }
//        });

        JFrame frame = new JFrame();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,650);
        frame.setLocationRelativeTo(null);//设置全屏网页
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        //设置对话框
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int value=JOptionPane.showConfirmDialog(frame, "你尊滴要退出吗？", "确认窗口", JOptionPane.YES_NO_OPTION);
                if (value == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
        // JSplitPane splitPane=new
//        frame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getX()+" "+e.getY());
//            }
//        });

        JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,null,null);//总
        frame.add(splitPane1);
        JSplitPane splitPane2=new JSplitPane();//左分
        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane1.setLeftComponent(splitPane2);
        splitPane1.setDividerLocation(900);
        splitPane2.setDividerLocation(400);
        splitPane1.setEnabled(false);
        splitPane1.setOneTouchExpandable(true);
        //登录模块
        JPanel panel=new JPanel(new BorderLayout());
        splitPane1.setRightComponent(panel);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        BufferedImage img=null;
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX()+" "+e.getY());
            }
        });
        JLabel label = new JLabel("用户名:");
        label.setBounds(5, 200, 50, 30);
        JTextField textField=new JTextField();
        textField.setBounds(50, 200, 200, 30);
        JPasswordField textField1 = new JPasswordField();
        textField1.setBounds(50,300,200,30);
        JLabel label1 = new JLabel("密码:");
        label1.setBounds(5,300,200,30);
        JButton button = new JButton("登录");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=textField.getText();
                String p=textField1.getText();
                System.out.println(s+p);
            }
        });
        button.setBounds(45, 435, 60, 40);
        JButton button1 = new JButton("重置密码");
        button1.setBounds(190,435,80,40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("重置密码");
            }
        });
        try {
            img = ImageIO.read(new File("C:\\程序\\java\\log in system\\lib\\980.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel piclabel1 = new JLabel(new ImageIcon(img));
        piclabel1.setBounds(0,0,panel.getWidth(),panel.getHeight());
        panel.add(label,0);
        panel.add(textField,1);
        panel.add(textField1,2);
        panel.add(label1,3);
        panel.add(button, 4);
        panel.add(button1,5);
        panel.add(piclabel1,6);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("图片1", new JPanel());
        tabbedPane.addTab("图片2",new JPanel());
        splitPane2.setTopComponent(tabbedPane);
        JScrollPane jScrollPane = new JScrollPane();
        String[]strings={"aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk"};
        JList list = new JList(strings);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(e.getFirstIndex());
            }
        });

        jScrollPane.setViewportView(list);
        splitPane2.setBottomComponent(jScrollPane);
        splitPane1.setRightComponent(panel);
        frame.setVisible(true);
    }
}