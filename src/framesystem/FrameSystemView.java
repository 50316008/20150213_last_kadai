package framesystem;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import lib.MySQL;


public class FrameSystemView extends Frame implements ActionListener,WindowListener,KeyListener{
	
	/*private TextField text1 = new TextField("", 10);
	private TextField text2 = new TextField("", 10);
	private TextField text3 = new TextField("", 10);
	private TextField text4 = new TextField("", 10);
	private double data[][] = new double[3][11];*/
	private Button button1 = new Button("表示");
	CardLayout cardlayout;
	Panel panel;
	Panel buttonpanel;
	
	public FrameSystemView(FrameSystemController controller){
		
		panel=new Panel();
		buttonpanel=new Panel();
		addWindowListener(this);
		setTitle("Tokyo_Temperature");
		cardlayout=new CardLayout();
		setLayout(cardlayout);
		buttonpanel.add(button1,BorderLayout.CENTER);
		add(buttonpanel);
        add(panel);
        button1.addActionListener(this);
    	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//if(e.getSource()==button1){
			
		    

			
			int month,i=0;
			double max,average,min;
			ResultSet rs;
			lib.MySQL mysql = new lib.MySQL();
			rs=mysql.selectAll();
			/*try{
				while(rs.next()){
					month = rs.getInt("month");
		            max = rs.getDouble("max");
		            average = rs.getDouble("average");
		            min = rs.getDouble("min");
		            data[0][i]=month;
					data[1][i]=max;
		            data[2][i]=average;
		            data[3][i]=min;
		            System.out.println("月：" + month);
		            System.out.println("最高気温：" + max);
		            System.out.println("平均気温：" + average);
		            System.out.println("最低気温：" + min);
		            i++;
				}
			}catch(SQLException et){}*/
			DefaultCategoryDataset data =new DefaultCategoryDataset();
			try{
				while(rs.next()){
		            month = rs.getInt("month");
		            max = rs.getDouble("max");
		            average = rs.getDouble("average");
		            min = rs.getDouble("min");
		            //System.out.println("月：" + month);
		            //System.out.println("最高気温：" + max);
		            //System.out.println("平均気温：" + average);
		            //System.out.println("最低気温：" + min);
		            data.addValue(max,"max",month+"");//なぜこの形をとるのか…
		            data.addValue(average,"average",month+"");
		            data.addValue(min,"min",month+"");
		            panel.add(new Label("月:"+month));
		            panel.add(new Label("最高気温:"+max));
		            panel.add(new Label("平均気温:"+average));
		            panel.add(new Label("最低気温:"+min));
				}
				}catch (SQLException et){}
			JFreeChart chart = 
				      ChartFactory.createLineChart("tokyo_temperature",
				                                   "month",
				                                   "temperature",
				                                   data,
				                                   PlotOrientation.VERTICAL,
				                                   true,
				                                   false,
				                                   false);
				    ChartPanel cpanel = new ChartPanel(chart);
				    /*panel.add(new Label("月"));
		            panel.add(text1);
		            int val1 = Integer.parseInt(text1.getText());
		            panel.add(new Label("最高気温"));
					//text2.setText(String.valueOf(data1[val1]));
		            panel.add(text2);
		            panel.add(new Label("平均気温"));
					//text3.setText(String.valueOf(data2[val1]));
		            panel.add(text3);
		            panel.add(new Label("最低気温"));
					//text4.setText(String.valueOf(data3[val1]));
		            panel.add(text4);
				    */
		            panel.add(cpanel);
				    cardlayout.next(this);
				    

				}
		}		
//}

	
	
	

