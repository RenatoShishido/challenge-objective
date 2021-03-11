package com.jogo.gourmet;

public class No {
	
	private String item;
	private No dir;
	private No esq;
	private No anterior;
	
	
	public No(String item, No dir, No esq) {
		this.item = item;
		this.dir = dir;
		this.esq = esq;
	}


	public No getAnterior() {
		return anterior;
	}


	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public No getDir() {
		return dir;
	}


	public void setDir(No dir) {
		this.dir = dir;
	}


	public No getEsq() {
		return esq;
	}


	public void setEsq(No esq) {
		this.esq = esq;
	}

}
