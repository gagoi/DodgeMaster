package fr.gagoi.game.core;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Launcher extends JFrame {
	private static final long serialVersionUID = 8646015088989398740L;

	private JButton startButton;
	private JLabel bulletSpawnrateLabel, bombSpawnrateLabel, bulletSizeLabel, bulletSpeedLabel, playerSpeedLabel,
			playerSizeLabel, bulletPerWaveLabel, bombPerWaveLabel, bombMaxTimeLabel, bombSizeLabel;
	private JTextField bulletSpawnrateTf, bombSpawnrateTf, bulletSizeTf, bulletSpeedTf, playerSpeedTf, playerSizeTf,
			bulletPerWaveTf, bombPerWaveTf, bombMaxTimeTf, bombSizeTf;

	public Launcher() {
		setTitle("Launcher");
		setResizable(false);
		setSize(new Dimension(500, 300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(11, 2));
		init();
		setVisible(true);
	}

	private void init() {
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});

		bulletSpawnrateLabel = new JLabel("Bullet's spawnrate (Higher is easier):");
		bulletSpawnrateTf = new JTextField();
		bulletSpawnrateTf.setText("" + 30);

		bombSpawnrateLabel = new JLabel("Bomb's spawnrate (Higher is easier):");
		bombSpawnrateTf = new JTextField();
		bombSpawnrateTf.setText("" + 60);

		bulletSizeLabel = new JLabel("Bullet's size (Pixel):");
		bulletSizeTf = new JTextField();
		bulletSizeTf.setText("" + 5);

		bulletSpeedLabel = new JLabel("Bullet's speed (Higher is easier):");
		bulletSpeedTf = new JTextField();
		bulletSpeedTf.setText("" + 1.9f);

		bulletPerWaveLabel = new JLabel("Bullet(s) per wave:");
		bulletPerWaveTf = new JTextField();
		bulletPerWaveTf.setText("" + 8);

		bombPerWaveLabel = new JLabel("Bomb(s) per wave:");
		bombPerWaveTf = new JTextField();
		bombPerWaveTf.setText("" + 4);

		playerSizeLabel = new JLabel("Player's size  (Pixel) :");
		playerSizeTf = new JTextField();
		playerSizeTf.setText("" + 10);

		playerSpeedLabel = new JLabel("Player's speed (Higher is easier):");
		playerSpeedTf = new JTextField();
		playerSpeedTf.setText("" + 4);

		bombMaxTimeLabel = new JLabel("Bomb max time (Higher is easier):");
		bombMaxTimeTf = new JTextField();
		bombMaxTimeTf.setText("" + 150);
		
		bombSizeLabel = new JLabel("Bomb size (Pixel):");
		bombSizeTf = new JTextField();
		bombSizeTf.setText("" + 30);

		add(playerSizeLabel);
		add(playerSizeTf);

		add(playerSpeedLabel);
		add(playerSpeedTf);

		add(bulletSpeedLabel);
		add(bulletSpeedTf);

		add(bulletSizeLabel);
		add(bulletSizeTf);

		add(bulletSpawnrateLabel);
		add(bulletSpawnrateTf);

		add(bulletPerWaveLabel);
		add(bulletPerWaveTf);

		add(bombMaxTimeLabel);
		add(bombMaxTimeTf);
		
		add(bombSizeLabel);
		add(bombSizeTf);
		
		add(bombSpawnrateLabel);
		add(bombSpawnrateTf);

		add(bombPerWaveLabel);
		add(bombPerWaveTf);

		add(startButton);
	}

	private void startGame() {
		int bulletSpawnrate = Integer.parseInt(bulletSpawnrateTf.getText());
		int bombMaxTime = Integer.parseInt(bombMaxTimeTf.getText());
		int bombSpawnrate = Integer.parseInt(bombSpawnrateTf.getText());
		int bulletSize = Integer.parseInt(bulletSizeTf.getText());
		int playerSize = Integer.parseInt(playerSizeTf.getText());
		int bulletPerWave = Integer.parseInt(bulletPerWaveTf.getText());
		int bombPerWave = Integer.parseInt(bombPerWaveTf.getText());
		int bombSize = Integer.parseInt(bombSizeTf.getText());
		float bulletSpeed = Float.parseFloat(bulletSpeedTf.getText());
		float playerSpeed = Float.parseFloat(playerSpeedTf.getText());
		new Thread(new Game(bulletSpawnrate, bombSpawnrate, playerSize, bulletSize, bulletPerWave, bombPerWave,
				bombMaxTime, bombSize, playerSpeed, bulletSpeed)).start();
		dispose();
	}

	public static void main(String args[]) {
		new Launcher();
	}
}
