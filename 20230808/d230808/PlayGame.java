package d230808;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		String[] skills = {"몸통박치기", "할퀴기", "울부짖기", "하이드로펌프", "물대포", "파도타기", "불대문자", "니트로차지", "솔라빔", "풀베기"};
		int[] skillPower = {60, 50, 20, 100, 90, 90, 120, 70, 110, 80};
		String[][] skillType = {{"물", "불", "풀"}, {"불", "풀"}, {"물", "불", "풀"}, {"물"}, {"물"}, {"물"}, {"불"}, {"불"}, {"풀"}, {"풀"}};
		
		String[] pks = {"꼬북이", "파이리", "이상해씨", "뚜벅초", "고라파덕", "가디"};
		String[] pkType = {"물", "불", "풀", "풀", "물", "불"};
		// pkStat의 내부 배열은 {hp, power, speed}
		int[][] pkStat = {{250, 90, 90}, {150, 120, 90}, {200, 100, 90}, {150, 80, 80}, {160, 80, 80}, {150, 90, 100}};
		
		
		PokemonArchive pa = new PokemonArchive(pkStat, pkType, pks, skills, skillPower, skillType);
		PokemonCenter pc = new PokemonCenter(pa);
		
		// 파이리, 꼬북이, 이상해씨 중에서 한마리를 랜덤하게 얻음
		String pkName = pc.pkName[random.nextInt(3)];
		System.out.println("파이리, 꼬북이, 이상해씨중 플레이어의 포켓몬을 뽑습니다.");
		System.out.println(pkName + "의 이름을 입력해주세요");
		
		String pkNname = scanner.next();
		System.out.println(pkNname + "의 상태입니다.");
		
		pc.setStat(pkName);
		pc.setSkill(pkName);
		
		
		
		
		
		scanner.close();
	}
}
