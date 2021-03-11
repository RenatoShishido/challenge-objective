package com.jogo.gourmet;

public class Jogo {

	private No root;

	public Jogo(String pergunta, String prato_dir, String prato_esq) {
		No dir = new No(prato_dir, null, null);
		No esq = new No(prato_esq, null, null);
		root = new No(pergunta, dir, esq);
		dir.setAnterior(root);
		esq.setAnterior(root);
	}

	public No getRoot() {
		return this.root;
	}

	public void inserir(String pergunta, String prato, No no_prato_atual) {
		No novo_prato = new No(prato, null, null);
		No nova_pergunta = new No(pergunta, novo_prato, no_prato_atual);
		No pergunta_anterior = no_prato_atual.getAnterior();

		setPerguntaNova(no_prato_atual, pergunta_anterior, nova_pergunta);
		setAnterior(no_prato_atual, pergunta_anterior, nova_pergunta, novo_prato);
	}

	public void setPerguntaNova(No prato_atual, No pergunta_anterior, No nova_pergunta) {
		if (prato_atual == pergunta_anterior.getDir()) {
			pergunta_anterior.setDir(nova_pergunta);
		} else {
			pergunta_anterior.setEsq(nova_pergunta);
		}
	}

	public void setAnterior(No prato_atual, No pergunta_anterior, No nova_pergunta, No novo_prato) {
		nova_pergunta.setAnterior(pergunta_anterior);
		novo_prato.setAnterior(nova_pergunta);
		prato_atual.setAnterior(nova_pergunta);
	}
}
