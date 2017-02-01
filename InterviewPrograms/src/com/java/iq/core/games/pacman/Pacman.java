package com.java.iq.core.games.pacman;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Pacman extends JFrame {

	private static final long serialVersionUID = 144551441355L;

	public Pacman() {
		initUI();
	}

	private void initUI() {

		add(new Board());
		setTitle("Pacman");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(380, 420);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Pacman ex = new Pacman();
            ex.setVisible(true);
        });
    }
}