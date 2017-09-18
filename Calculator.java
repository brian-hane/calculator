import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
/**
 * Calculator class handles all calculations, user interface for input/output
 * @author Brian Hane
 * 
 */
public class Calculator extends JFrame  {
	private static final int WIDTH =300;
	private static final int HEIGHT = 400;
	private static final int NUM_DIGITS=30;
	private double result =0.0;
	private JTextField inputTextField;
	private JTextField resultTextField;
	private char operation;
	private JButton oneNum = new JButton("1");
	private JButton twoNum = new JButton("2");
	private JButton threeNum = new JButton("3");
	private JButton fourNum = new JButton("4");
	private JButton fiveNum = new JButton("5");
	private JButton sixNum = new JButton("6");
	private JButton sevenNum = new JButton("7");
	private JButton eightNum = new JButton("8");
	private JButton nineNum = new JButton("9");
	private JButton zeroNum = new JButton("0");
	
	private JButton add = new JButton("+");
	private JButton subtract = new JButton("-");
	private JButton divide = new JButton("/");
	private JButton multiply = new JButton("*");
	private JButton clear = new JButton("C");
	private JButton equals = new JButton("=");
	private JButton emptyFirst = new JButton();
	private JButton emptySecond = new JButton();
	private JButton emptyThird = new JButton();
	private JButton emptyFourth = new JButton();

	/**
	 * Constructor lays out the calculator interface, and registers listeners
	 * @author Brian Hane
	 * 
	 */
	public Calculator(){
		layout();
		listeners();
		}
	/**
	 * lays out user interface
	 * @author Brian Hane
	 */
	public void layout(){
		JFrame frame = new JFrame("Calculator");
		JPanel textPanel = new JPanel(); 
		JPanel buttons = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inputTextField = new JTextField(NUM_DIGITS);
		resultTextField = new JTextField(NUM_DIGITS);

		textPanel.setPreferredSize(new Dimension(WIDTH, 150));
		textPanel.setLayout(new GridLayout(2,1));
		textPanel.add(inputTextField);
		textPanel.add(resultTextField);
	
		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		buttons.setLayout (new GridLayout(4,5));
		//first row
		buttons.add(sevenNum);
		buttons.add(eightNum);
		buttons.add(nineNum);
		buttons.add(divide);
		buttons.add(clear);
		
		//second row
		buttons.add(fourNum);
		buttons.add(fiveNum);
		buttons.add(sixNum);
		buttons.add(multiply);
		buttons.add(emptyFirst);
		//third row
		buttons.add(oneNum);
		buttons.add(twoNum);
		buttons.add(threeNum);
		buttons.add(subtract);
		buttons.add(emptySecond);
		
		//fourth row
		buttons.add(emptyThird);
		buttons.add(zeroNum);
		buttons.add(emptyFourth);
		buttons.add(add);
		buttons.add(equals);

		frame.add(textPanel, BorderLayout.NORTH);
		frame.add(buttons, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//frame.repaint();
	}
	/**
	 * Registers listeners
	 * @author Brian Hane
	 */
	public void listeners(){
		
		zeroNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"0".toString());
			}
		});
		oneNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"1".toString());
			}
		});
		twoNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"2".toString());
			}
		});
		threeNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"3".toString());
			}
		});
		fourNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"4".toString());
			}
		});
		fiveNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"5".toString());
			}
		});
		sixNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"6".toString());
			}
		});
		sevenNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"7".toString());
			}
		});
		eightNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"8".toString());
			}
		});
		nineNum.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"9".toString());
			}
		});
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"+".toString());
				operation = '+';
			}	
		});
		subtract.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"-".toString());
				operation = '-';
			}	
		});
		divide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"/".toString());
				operation = '/';
			}	
		});
		multiply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				inputTextField.setText(inputTextField.getText()+"*".toString());
				operation = '*';
			}	
		});
		equals.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				String left;
				String right;
				try{
					left = inputTextField.getText().substring(0,inputTextField.getText().indexOf(operation +""));
					right = inputTextField.getText().substring(inputTextField.getText().indexOf(operation + "")+1, inputTextField.getText().length());
					switch(operation){
						case'+':
							result = (Double.parseDouble(left)+ Double.parseDouble(right));
							resultTextField.setText(Double.toString(result));
							break;
						case'-':
							result = (Double.parseDouble(left)- Double.parseDouble(right));
							resultTextField.setText(Double.toString(result));
							break;
						case'*':
							result = (Double.parseDouble(left)* Double.parseDouble(right));
							resultTextField.setText(Double.toString(result));
							break;
						case'/':
							if (Double.parseDouble(right)!=0){
								result = (Double.parseDouble(left)/ Double.parseDouble(right));
								resultTextField.setText(Double.toString(result));
							}
							break;
						default:
							break;
					}
				}catch (Exception e){
				}
			}
		});
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent x){
				resultTextField.setText("");
				inputTextField.setText("");
			}
		});
	}
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}
