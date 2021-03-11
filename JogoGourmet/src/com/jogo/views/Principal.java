package com.jogo.views;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.jogo.gourmet.Jogo;
import com.jogo.gourmet.No;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal {
	
	private static JFrame frame = new JFrame("Jogo Gourmet");
	
	private static Jogo jogo;
	
	public static void main(String[] args)
	  {
		  jogo = new Jogo("massa", "lasanha", "bolo");
	      JLabel label = new JLabel("Pense em um prato que gosta");
	      JButton button = new JButton("OK");
	      button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pergunta(jogo.getRoot());
				
				}
			});
		  label.setHorizontalAlignment(SwingConstants.CENTER);
		  label.setPreferredSize(new Dimension(300,70));
		  label.setFont(new Font("Sans Serif", Font.BOLD, 16));
	
		  JFrame janela = new JFrame("Jogo Gourmet");
		  Painel meuPainel = new Painel();
		  meuPainel.add(label);
		  meuPainel.add(button);
		  janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		  janela.add(meuPainel);
		  janela.setSize(300,200);
		  janela.setLocationRelativeTo(null);
		  janela.setVisible(true);
	  }
	  
	  public static int painelJogo(String texto) {
		  JLabel label = new JLabel(texto);
		  int showConfirmDialog = JOptionPane.showConfirmDialog(frame,
			        label,
			        "Jogo Gourmet", 
			        JOptionPane.YES_NO_OPTION);
		  return showConfirmDialog;
	  }
	  
	  public static String painelJogoInput(String texto) {
		  JLabel label = new JLabel(texto);
		  String showConfirmDialog = JOptionPane.showInputDialog(frame,
			        label,
			        "Jogo Gourmet", 
			        JOptionPane.YES_NO_OPTION);
		  return showConfirmDialog;
	  }
	  
	  public static void pergunta(No no) {
		  int showConfirmDialog = painelJogo("O prato que voce pensou e " + no.getItem());
		  
		  if(no.getDir() == no.getEsq()) {
			  if(showConfirmDialog == 0) {
				  painelJogo("Acertei de novo!");
			  }else {
				 String prato = painelJogoInput("Qual prato voce pensou?");
				 String pergunta = painelJogoInput(prato + " e __________ mas " + no.getItem() + " nao.");
				 jogo.inserir(pergunta, prato, no);
				 
			  }  
			   
		  } else {
			  if(showConfirmDialog == 0) {
				 pergunta(no.getDir());
			  }else {
				  pergunta(no.getEsq());
			  } 			  
		  }
	  	}
}
