package birds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.EBullet;
import main.Player;
import mainGUI.SystemData;

public abstract class EnemyEntity {
	
	public int eID; // 각 적 식별 아이디
	public String name; // 적 이름
	public int xspeed; // x축 스피드
	public int yspeed; // y축 스피드
	
	public int dmg; // 데미지
	public double maxHP; // 최대 HP
	public int def; // 정의
 	
	public int scoreValue;
	public int misc; // 기타 요소 활성화?
	public int sizex; // x 값 크기
	public int sizey; // y 값 크기
	
	// Misc
	public int targetRange;		// Target player only if > 0 <<>> 목표범위
	public int targetPriority;		// Bot target only if > 0 <<>> 목표우선순위
	public int zigFactor;			// Zig only if > 0  
	public int healthDrop;			// Only drop health if > 0 <<>> 건강 드롭?
	
	// Drops
	public int droprate; // 드롭률
	public int dropMinAmount; // 최소 금액 드롭
	public int dropAmount; // 드롭 금액
	
	
	// Undefined Data
	public int xpos;
	public int ypos;
	public Rectangle hitbox; // 히트박스
	public double hp; // 피
	public Player playerTarget = null;
	public String description; // 스킬
	
	public ArrayList<EBullet> bullets  = new ArrayList<EBullet>();
	public int power; // 데미지
	public boolean piercing; // 관통?
	
	public EnemyEntity(int eID, String name, int xspeed, int yspeed, int dmg, int hp,
			int def, int scoreValue, int misc, int xsize, int ysize,
			int targetRange, int targetPriority, int zigFactor, int healthDrop,
			int droprate, int dropMinAmount, int dropAmount) {
		this.eID = eID;
		this.name = name;
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		this.dmg = dmg;
		this.maxHP = hp;
		this.def = def;
		this.scoreValue = scoreValue;
		this.misc = misc;
		this.sizex = xsize;
		this.sizey = ysize;
		this.targetRange = targetRange;
		this.targetPriority = targetPriority;
		this.zigFactor = zigFactor;
		this.healthDrop = healthDrop;
		this.droprate = droprate;
		this.dropMinAmount = dropMinAmount;
		this.dropAmount = dropAmount;
		this.hp = maxHP;
	}
	
	public EnemyEntity(EnemyEntity b){
		this.eID = b.eID;
		this.name = b.name;
		this.xspeed = b.xspeed;
		this.yspeed = b.yspeed;
		this.dmg = b.dmg;
		this.maxHP = b.hp;
		this.def = b.def;
		this.scoreValue = b.scoreValue;
		this.misc = b.misc;
		this.sizex = b.sizex;
		this.sizey = b.sizey;
		this.targetRange = b.targetRange;
		this.targetPriority = b.targetPriority;
		this.zigFactor = b.zigFactor;
		this.healthDrop = b.healthDrop;
		this.droprate = b.droprate;
		this.dropMinAmount = b.dropMinAmount;
		this.dropAmount = b.dropAmount;
		this.hp = b.maxHP;
	}


	public void setDescription(String desc){
		this.description = desc;
	}
	
	public abstract void setSpawn(int x, int y);
	public abstract void update();
	public abstract void move();
	public abstract void draw(Graphics g);
		
	public void loseHealth(double rawDamage){
		double damageRecieved = rawDamage - (rawDamage * def) / 100; // 받은 데미지
		if(hp - damageRecieved > 0)	hp -= damageRecieved;
		else hp = 0;
	}
	
	public boolean isDead(){
		return (hp <= 0);
	}
	
	public String toString(){
		return this.name;
	}

}
