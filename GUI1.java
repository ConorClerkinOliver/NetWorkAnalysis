import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class GUI1
{

  private JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;

  public static void main (String[]args)
  {
    EventQueue.invokeLater (new Runnable ()
			    {
			    public void run ()
			    {
			    try
			    {
			    GUI1 window = new GUI1 ();
			    window.frame.
			    setVisible (true);} catch (Exception e)
			    {
			    e.printStackTrace ();}
			    }
			    });
  }

  public GUI1 ()
  {
    initialize ();
  }
  private void initialize ()
  {
    frame = new JFrame ();
    frame.setBounds (100, 100, 945, 302);
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane ().setLayout (null);

    final JButton btnAddInteraction = new JButton ("Add Interaction ");
    btnAddInteraction.setBounds (12, 79, 154, 25);
    btnAddInteraction.addActionListener (new ActionListener ()
					 {
					 public void
					 actionPerformed (ActionEvent arg0)
					 {
					 }
					 });
    frame.getContentPane ().add (btnAddInteraction);

    final JButton btnNodeDegree = new JButton ("Node degree");
    btnNodeDegree.setBounds (212, 79, 185, 25);
    btnNodeDegree.addActionListener (new ActionListener ()
				     {
				     public void actionPerformed (ActionEvent
								  arg0)
				     {
				     }
				     });
    frame.getContentPane ().add (btnNodeDegree);

    final JButton btnAverageDegree = new JButton ("Average Degree");
    btnAverageDegree.setBounds (212, 150, 185, 25);
    btnAverageDegree.addActionListener (new ActionListener ()
					{
					public void
					actionPerformed (ActionEvent arg0)
					{
					}
					});
    frame.getContentPane ().add (btnAverageDegree);


    final JButton btnDegreeDistribution = new JButton ("Degree distribution");
    btnDegreeDistribution.setBounds (212, 116, 186, 25);
    btnDegreeDistribution.addActionListener (new ActionListener ()
					     {
					     public void
					     actionPerformed (ActionEvent
							      arg0)
					     {
					     }
					     });
    frame.getContentPane ().add (btnDegreeDistribution);

    textField_1 = new JTextField ();
    textField_1.setBounds (12, 117, 154, 21);
    frame.getContentPane ().add (textField_1);
    textField_1.setColumns (10);

    textField_2 = new JTextField ();
    textField_2.setBounds (12, 150, 154, 25);
    frame.getContentPane ().add (textField_2);
    textField_2.setColumns (10);

    JLabel lblInputNetworkFile = new JLabel ("Input network file ");
    lblInputNetworkFile.setBounds (12, 22, 154, 15);
    frame.getContentPane ().add (lblInputNetworkFile);

    textField = new JTextField ();
    textField.setBounds (12, 42, 154, 19);
    frame.getContentPane ().add (textField);
    textField.setColumns (10);

    final JButton HUBButton_1 = new JButton ("HUBS");
    HUBButton_1.addActionListener (new ActionListener ()
				   {
				   public void actionPerformed (ActionEvent
								arg0)
				   {
				   }
				   });
    HUBButton_1.setBounds (216, 39, 181, 25);
    frame.getContentPane ().add (HUBButton_1);

    textField.addActionListener (new ActionListener ()
				 {
				 @Override
				 public void actionPerformed (ActionEvent
							      event)
				 {
				 System.out.println ("The entered text is: " +
						     textField.getText ());
				 final String content = textField.getText ();
				 btnAverageDegree.addActionListener (new
								     ActionListener
								     ()
								     {
								     public
								     void
								     actionPerformed
								     (ActionEvent
								      arg0)
								     {
								     Network
								     net1 =
								     null; try
								     {
								     net1 =
								     new
								     Network
								     (content);}
								     catch
								     (IOException
								      e)
								     {
								     e.printStackTrace
								     ();}
								     double x
								     =
								     net1.AverageDegree
								     ();
								     JOptionPane.
								     showMessageDialog
								     (btnAverageDegree,
								      x);}
								     });
				 HUBButton_1.
				 addActionListener (new ActionListener ()
						    {
						    public void
						    actionPerformed
						    (ActionEvent arg0)
						    {
						    Network net1 = null; try
						    {
						    net1 =
						    new Network (content);}
						    catch (IOException e)
						    {
						    e.printStackTrace ();}
						    ArrayList x =
						    net1.Hubs ();
						    JOptionPane.
						    showMessageDialog
						    (HUBButton_1, x);}
						    });
				 btnDegreeDistribution.
				 addActionListener (new ActionListener ()
						    {
						    public
						    void
						    actionPerformed
						    (ActionEvent arg0)
						    {
						    Network net1 = null; try
						    {
						    net1
						    = new Network (content);}
						    catch (IOException e)
						    {
						    e.printStackTrace ();}
						    HashMap
						    x =
						    net1.DegreeDistribution
						    ();
						    Object[][] arr = new Object[x.size()][2];
						    Set entries = x.entrySet();
						    Iterator entriesIterator = entries.iterator();

						    int i = 0;
						    while(entriesIterator.hasNext()){

						        Map.Entry mapping = (Map.Entry) entriesIterator.next();

						        arr[i][0] = mapping.getKey();
						        arr[i][1] = mapping.getValue();

						        i++;
						    }
						    final JFrame frame=new JFrame("Degree distribution");
						    String []columns={"Node","Degree"};
						    JTable table = new JTable(arr, columns);
					        JScrollPane scrollPane = new JScrollPane(table);
					        table.setFillsViewportHeight(true);
					 
					        JLabel lblHeading = new JLabel("Degree distribution");

					 
					        frame.getContentPane().setLayout(new BorderLayout());
					 
					        frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
					        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
					 
					        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        frame.setSize(550, 200);
					        frame.setVisible(true);
						    }
						    });
				 textField_1.
				 addActionListener (new ActionListener ()
						    {
						    @Override
						    public void
						    actionPerformed
						    (ActionEvent event)
						    {
						    System.out.println
						    ("The entered text is: "
						     +
						     textField_1.getText ());
						    final String
						    Node1 =
						    textField_1.getText ();
						    textField_2.
						    addActionListener (new
								       ActionListener
								       ()
								       {
								       public
								       void
								       actionPerformed
								       (ActionEvent
									arg0)
								       {
								       System.
								       out.
								       println
								       ("The entered text is: "
									+
									textField_2.
									getText
									());
								       final
								       String
								       Node2 =
								       textField_2.
								       getText
								       ();
								       btnAddInteraction.
								       addActionListener
								       (new
									ActionListener
									()
									{
									public
									void
									actionPerformed
									(ActionEvent
									 arg0)
									{
									try
									(FileWriter
									 fw =
									 new
									 FileWriter
									 (content,
									  true);
									 BufferedWriter
									 bw =
									 new
									 BufferedWriter
									 (fw);
									 PrintWriter
									 out =
									 new
									 PrintWriter
									 (bw))
									{
									List <
									String
									>
									myList
									=
									new
									ArrayList
									<
									String
									> ();
									myList.
									add
									(Node1);
									myList.
									add
									(Node2);
									Collections.
									sort
									(myList);
									out.
									println
									(myList.
									 get
									 (0) +
									 " " +
									 myList.
									 get
									 (1));}
									catch
									(IOException
									 e)
									{
									}
									}
									});}});}});
									btnNodeDegree.
									addActionListener
									(new
									 ActionListener
									 ()
									 {
									 public
									 void
									 actionPerformed
									 (ActionEvent
									  arg0)
									 {
									 Network
									 net1
									 =
									 null;
									 try
									 {
									 net1
									 =
									 new
									 Network
									 (content);}
									 catch
									 (IOException
									  e)
									 {
									 e.printStackTrace
									 ();}
									final String NodeDegreeQuery =
									textField_1.getText ();
									Node
									 Query
									 =
									 new
									 Node
									 (NodeDegreeQuery);
									 int x
									 =
									 net1.NodeDegree(Query);
									 System.out.print(x);
									 JOptionPane.
									 showMessageDialog
									 (btnNodeDegree,
									  x);
									 }});
									}
									});}
						    };

