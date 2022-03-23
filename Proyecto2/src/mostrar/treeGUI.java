package mostrar;



import DesicionTree.ArbolD;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class treeGUI extends JFrame {
       	private JPanel contentPane;
        public ArbolD tree;
	public DrawTree drawer;
         
	
	/**
	 * Create the frame.
	 */
	public treeGUI(ArbolD tree) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1500, 900);
                
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		drawer = new DrawTree(tree);
		
		contentPane.add(drawer);
                this.setLayout(new BorderLayout());
               	setContentPane(contentPane);
		this.tree = tree;
		setVisible(true);
	}

}


