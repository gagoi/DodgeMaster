package fr.gagoi.game.core;

import java.util.Vector;

import fr.gagoi.game.core.entities.Bomb;
import fr.gagoi.game.core.entities.Bullet;
import fr.gagoi.game.core.entities.Healer;
import fr.gagoi.game.core.entities.Player;
import fr.gagoi.game.core.graphics.Display;

public class Game implements Runnable {

	private Display display;

	public static Vector<Bullet> bullets = new Vector<Bullet>();
	public static Vector<Bomb> bombs = new Vector<Bomb>();
	public static Vector<Healer> healers = new Vector<Healer>();
	public static Player p = new Player();

	public static int bulletSpawnrate, bombSpawnrate, playerSize, bulletSize, bulletPerWave, bombPerWave, bombMaxTime,
			bombSize, survivalScore, healerMaxTime, healerSpawnrate, healerSize, healerPerWave, healerPower;
	public static float bulletSpeed, playerSpeed;
	public static int timeInSec;
	public static boolean running = true;

	public Game(int bulletSpawnrate, int bombSpawnrate, int playerSize, int bulletSize, int bulletPerWave,
			int bombPerWave, int bombMaxTime, int bombSize, int survivalScore, int healerMaxTime, int healerPerWave,
			int healerSize, int healerSpawnrate, int healerPower, float playerSpeed, float bulletSpeed) {
		display = new Display();
		Game.bulletSpawnrate = bulletSpawnrate;
		Game.playerSize = playerSize;
		Game.playerSpeed = playerSpeed;
		Game.bulletSize = bulletSize;
		Game.bulletSpeed = bulletSpeed;
		Game.bulletPerWave = bulletPerWave;
		Game.bombSpawnrate = bombSpawnrate;
		Game.bombMaxTime = bombMaxTime;
		Game.bombSize = bombSize;
		Game.survivalScore = survivalScore;
		Game.healerMaxTime = healerMaxTime;
		Game.healerPerWave = healerPerWave;
		Game.healerSize = healerSize;
		Game.healerSpawnrate = healerSpawnrate;
		Game.healerPower = healerPower;
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		int i = 0, k = 0, y = 0, t = 0, l = 0;
		while (running) {
			long currentTime = System.currentTimeMillis();
			if (currentTime >= startTime + 1000 / 120) {
				if (t >= 240) {
					timeInSec++;
					t = 0;
				}
				t++;
				if (y == 0) {
					display.render();
					startTime = System.currentTimeMillis();
					p.update();
					for (int j = 0; j < bullets.size(); j++) {
						Bullet b = bullets.elementAt(j);
						b.update();
						if (!b.isAlive())
							bullets.remove(j);
					}
					for (int j = 0; j < bombs.size(); j++) {
						Bomb b = bombs.elementAt(j);
						b.update();
						if (!b.isAlive())
							bombs.remove(j);
					}
					for (int j = 0; j < healers.size(); j++) {
						Healer h = healers.elementAt(j);
						h.update();
						if (!h.isAlive())
							healers.remove(j);
					}
					y = 1;
				} else {
					y = 0;
				}

				if (i == bulletSpawnrate) {
					for (int j = 0; j <= bulletPerWave; j++)
						bullets.addElement(new Bullet());
					i = 0;
				}
				i++;

				if (k == bombSpawnrate) {
					for (int j = 0; j <= bombPerWave; j++)
						bombs.addElement(new Bomb());
					k = 0;
				}
				k++;
				if (l == healerSpawnrate) {
					for (int j = 0; j <= healerPerWave; j++)
						healers.addElement(new Healer());
					l = 0;
				}
				l++;
			}

			if (survivalScore > 0 && survivalScore <= p.getScore()) {
				running = false;
				Game.p.increaseScore(1);
				display.drawFinalScreen();
			}

		}
	}
}
