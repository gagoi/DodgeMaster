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
			playerSizeLabel, bulletPerWaveLabel, bombPerWaveLabel, bombMaxTimeLabel, bombSizeLabel, survivalScoreLabel,
			healerSpawnrateLabel, healerPerWaveLabel, healerMaxTimeLabel, healerSizeLabel, healerPowerLabel;
	private JTextField bulletSpawnrateTf, bombSpawnrateTf, bulletSizeTf, bulletSpeedTf, playerSpeedTf, playerSizeTf,
			bulletPerWaveTf, bombPerWaveTf, bombMaxTimeTf, bombSizeTf, survivalScoreTf, healerSpawnrateTf,
			healerPerWaveTf, healerMaxTimeTf, healerSizeTf, healerPowerTf;

	public Launcher() {
		setTitle("Launcher");
		setResizable(false);
		setSize(new Dimension(500, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(17, 2));
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
		bulletSpawnrateTf.setText("" + 200);

		bombSpawnrateLabel = new JLabel("Bomb's spawnrate (Higher is easier):");
		bombSpawnrateTf = new JTextField();
		bombSpawnrateTf.setText("" + 240);

		bulletSizeLabel = new JLabel("Bullet's size (Pixel):");
		bulletSizeTf = new JTextField();
		bulletSizeTf.setText("" + 15);

		bulletSpeedLabel = new JLabel("Bullet's speed (Higher is easier):");
		bulletSpeedTf = new JTextField();
		bulletSpeedTf.setText("" + 2.0f);

		bulletPerWaveLabel = new JLabel("Bullet(s) per wave:");
		bulletPerWaveTf = new JTextField();
		bulletPerWaveTf.setText("" + 12);

		bombPerWaveLabel = new JLabel("Bomb(s) per wave:");
		bombPerWaveTf = new JTextField();
		bombPerWaveTf.setText("" + 2);

		playerSizeLabel = new JLabel("Player's size  (Pixel) :");
		playerSizeTf = new JTextField();
		playerSizeTf.setText("" + 20);

		playerSpeedLabel = new JLabel("Player's speed (Higher is easier):");
		playerSpeedTf = new JTextField();
		playerSpeedTf.setText("" + 5);

		bombMaxTimeLabel = new JLabel("Bomb max time (Higher is easier):");
		bombMaxTimeTf = new JTextField();
		bombMaxTimeTf.setText("" + 150);

		bombSizeLabel = new JLabel("Bomb size (Pixel):");
		bombSizeTf = new JTextField();
		bombSizeTf.setText("" + 100);

		survivalScoreLabel = new JLabel("Survival score (-1 --> Infinite) :");
		survivalScoreTf = new JTextField();
		survivalScoreTf.setText("" + 10);

		healerMaxTimeLabel = new JLabel("Healer max time (Higher is easier):");
		healerMaxTimeTf = new JTextField();
		healerMaxTimeTf.setText("" + 250);

		healerSizeLabel = new JLabel("Healer size (Pixel):");
		healerSizeTf = new JTextField();
		healerSizeTf.setText("" + 10);

		healerPerWaveLabel = new JLabel("Healer(s) per wave:");
		healerPerWaveTf = new JTextField();
		healerPerWaveTf.setText("" + 1);

		healerSpawnrateLabel = new JLabel("Healer's spawnrate (Less is easier):");
		healerSpawnrateTf = new JTextField();
		healerSpawnrateTf.setText("" + 1000);

		healerPowerLabel = new JLabel("Healer's power (More is easier):");
		healerPowerTf = new JTextField();
		healerPowerTf.setText("" +1);

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

		add(healerMaxTimeLabel);
		add(healerMaxTimeTf);

		add(healerPowerLabel);
		add(healerPowerTf);

		add(healerSizeLabel);
		add(healerSizeTf);

		add(healerSpawnrateLabel);
		add(healerSpawnrateTf);

		add(healerPerWaveLabel);
		add(healerPerWaveTf);

		add(survivalScoreLabel);
		add(survivalScoreTf);

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
		int survivalScore = Integer.parseInt(survivalScoreTf.getText());
		int healerMaxTime = Integer.parseInt(healerMaxTimeTf.getText());
		int healerPerWave = Integer.parseInt(healerPerWaveTf.getText());
		int healerSize = Integer.parseInt(healerSizeTf.getText());
		int healerSpawnrate = Integer.parseInt(healerSpawnrateTf.getText());
		int healerPower = Integer.parseInt(healerPowerTf.getText());
		float bulletSpeed = Float.parseFloat(bulletSpeedTf.getText());
		float playerSpeed = Float.parseFloat(playerSpeedTf.getText());
		new Thread(new Game(bulletSpawnrate, bombSpawnrate, playerSize, bulletSize, bulletPerWave, bombPerWave,
				bombMaxTime, bombSize, survivalScore, healerMaxTime, healerPerWave, healerSize, healerSpawnrate,
				healerPower, playerSpeed, bulletSpeed)).start();
		dispose();
	}

	public static void main(String args[]) {
		new Launcher();
	}
}
