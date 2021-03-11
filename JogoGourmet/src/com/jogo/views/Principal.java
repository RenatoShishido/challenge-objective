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

	private static Object[] options = { "Sim", "Nao" };

	public static void main(String[] args) {
		jogo = new Jogo("massa", "Lasanha", "Bolo de Chocolate");

		JLabel label = new JLabel("Pense em um prato que gosta");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(300, 40));
		label.setFont(new Font("Serif", Font.BOLD, 12));

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pergunta(jogo.getRoot());

			}
		});

		JFrame janela = new JFrame("Jogo Gourmet");
		Painel meuPainel = new Painel();
		meuPainel.add(label);
		meuPainel.add(button);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.add(meuPainel);
		janela.setSize(300, 130);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	public static void pergunta(No no) {
		int showConfirmDialog = painelJogo("O prato que você pensou é " + no.getItem() + "?", "Confirm");

		if (no.getDir() == no.getEsq()) {
			if (showConfirmDialog == 0) {
				painelJogo("Acertei de novo!", "Jogo Gourmet");
			} else {
				String prato = painelJogoInput("Qual prato você pensou?", "Desisto");
				String pergunta = painelJogoInput(prato + " é __________ mas " + no.getItem() + " não.", "Desisto");
				jogo.inserir(pergunta, prato, no);

			}

		} else {
			if (showConfirmDialog == 0) {
				pergunta(no.getDir());
			} else {
				pergunta(no.getEsq());
			}
		}
	}

	public static int painelJogo(String texto, String titulo) {
		JLabel label = new JLabel(texto);
		int showConfirmDialog = 0;

		if (texto.equals("Acertei de novo!")) {
			JOptionPane.showMessageDialog(frame, label, titulo, JOptionPane.INFORMATION_MESSAGE);

		} else {
			showConfirmDialog = JOptionPane.showOptionDialog(frame, label, titulo, JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}

		return showConfirmDialog;
	}

	public static String painelJogoInput(String texto, String titulo) {
		JLabel label = new JLabel(texto);
		String showConfirmDialog = JOptionPane.showInputDialog(frame, label, titulo, JOptionPane.QUESTION_MESSAGE);
		return showConfirmDialog;
	}

}
