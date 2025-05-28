package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class test01 {
	
    public static Map<String, Double> calculateScores(int korean, int english, int math) {
        Map<String, Double> scoreResults = new HashMap<>();
        double total = korean + english + math;
        double average = total / 3.0; // 실수형 나눗셈
        scoreResults.put("total", total);
        scoreResults.put("average", average);
        return scoreResults;
    }

    public static String determineGrade(double averageScore) {
        if (averageScore >= 90) {
            return "A";
        } else if (averageScore >= 80) {
            return "B";
        } else if (averageScore >= 70) {
            return "C";
        } else if (averageScore >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static int getValidScoreInput(Scanner scanner, String subjectName) {
        int score;
        while (true) {
            try {
                System.out.print(subjectName + " 점수: ");
                score = scanner.nextInt();
                if (score >= 0 && score <= 100) {
                    break;
                } else {
                    System.out.println("점수는 0점에서 100점 사이로 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.next(); 
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, Object>> studentRecords = new ArrayList<>(); 

        int numStudents = 0;
        while (true) {
            try {
                System.out.print("학생 수를 입력하세요: ");
                numStudents = scanner.nextInt();
                if (numStudents > 0) {
                    break;
                } else {
                    System.out.println("학생 수는 1명 이상이어야 합니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.next(); 
            }
        }
        scanner.nextLine(); 

       
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- " + (i + 1) + "번째 학생 정보 입력 ---");
            System.out.print((i + 1) + "번째 학생 이름: "); 
            String name = scanner.nextLine();

            int koreanScore = getValidScoreInput(scanner, "국어");
            int englishScore = getValidScoreInput(scanner, "영어");
            int mathScore = getValidScoreInput(scanner, "수학");
            scanner.nextLine(); 

           
            Map<String, Double> scores = calculateScores(koreanScore, englishScore, mathScore);
            double totalScore = scores.get("total");
            double averageScore = scores.get("average");

         
            String grade = determineGrade(averageScore);

            Map<String, Object> record = new HashMap<>();
            record.put("name", name);
            
            record.put("total", (int)totalScore); 
            record.put("average", averageScore);
            record.put("grade", grade);
            studentRecords.add(record);
        }

      
        System.out.println("\n--- 결과 출력 ---");
        for (Map<String, Object> record : studentRecords) {
            System.out.printf("이름: %s, 총점: %d, 평균: %.1f, 등급: %s\n",
                    record.get("name"),
                    record.get("total"),
                    record.get("average"),
                    record.get("grade"));
        }

        scanner.close(); 
    }
	
	
	
	

}
