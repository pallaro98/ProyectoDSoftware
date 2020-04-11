package game;

import javax.swing.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener{
	static Formulario selectlevelview;
	static Formulario selecttimeview;
	static Formulario gameview;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonbasic, botonmedium, botonadvanced, botonadd, botonskip, boton100h, boton200h, boton300h;
	private JLabel programlabel ;

	public Formulario() {
        setLayout(null);
        botonbasic=new JButton("Basic");
        botonbasic.setBounds(10,100,90,30);
        add(botonbasic);
        botonbasic.addActionListener(this);
        botonmedium=new JButton("Medium");
        botonmedium.setBounds(110,100,90,30);
        add(botonmedium);
        botonmedium.addActionListener(this);
        botonadvanced=new JButton("Advanced");
        botonadvanced.setBounds(210,100,90,30);
        add(botonadvanced);
        botonadvanced.addActionListener(this);        	
    }
    
	public Formulario(int i) {
        setLayout(null);
        boton100h=new JButton("100");
        boton100h.setBounds(10,100,90,30);
        add(boton100h);
        boton100h.addActionListener(this);
        boton200h=new JButton("200");
        boton200h.setBounds(110,100,90,30);
        add(boton200h);
        boton200h.addActionListener(this);
        boton300h=new JButton("300");
        boton300h.setBounds(210,100,90,30);
        add(boton300h);
        boton300h.addActionListener(this);        	
    }
    
    public Formulario(String s) {
        setLayout(null);
        botonadd=new JButton("Add");
        botonadd.setBounds(10,100,90,30);
        add(botonadd);
        botonadd.addActionListener(this);
        
        botonskip=new JButton("Skip");
        botonskip.setBounds(210,100,90,30);
        add(botonskip);
        botonskip.addActionListener(this);     
        
        programlabel =new JLabel();
        programlabel.setText(s);
        programlabel.setBounds(110,20,90,30);
        add(programlabel);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==botonbasic) {
            openSelectTime("Basic");

        }
        if (e.getSource()==botonmedium) {
        	openSelectTime("Medium");

        }
        if (e.getSource()==botonadvanced) {
        	openSelectTime("Advanced");
        }
        
        if (e.getSource()==boton100h) {
            openGame("", 100);

        } 
        if (e.getSource()==boton200h) {
            openGame("", 200);

        }
        if (e.getSource()==boton300h) {
            openGame("", 300);
        }
        if (e.getSource()==botonadd) {
            
        } 
        if (e.getSource()==botonskip) {
            
        }       
    }
    
    public void openSelectTime(String s) {
    	selectlevelview.setVisible(false);
    	gameview = new Formulario(s);
    	gameview.setBounds(0,0,350,200);
    	gameview.setVisible(true);
    	gameview.setTitle(s);
    }
    
    public void openGame(String s, int i) {
    	selecttimeview.setVisible(false);
    	gameview = new Formulario(i);
    	gameview.setBounds(0,0,350,200);
    	gameview.setVisible(true);
    	gameview.setTitle(s + i);
    }
    
    
    
    public static void main4(String[] ar){
    	selectlevelview = new Formulario();
    	selectlevelview.setBounds(0,0,350,200);
    	selectlevelview.setVisible(true);
    }
}