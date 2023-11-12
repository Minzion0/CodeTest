package 프로그래머스.스터디코테.lv1;
import java.util.*;
/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
public class Completion {
    /**
     *
     * @param participant 참가자
     * @param completion 완주자
     * @return 미완주자
     */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // Arrays.sort를 이용하여 순서 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
            // 반복문을 이용해서 완주자 명단과 참여자 명단 비교
        for(int i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                // 참여자 명단에는 있지만 완주자 영단에 없으면 return
                answer=participant[i];
               return answer;
            }
        }
        // 완주자 명단 기준으로 확인시 안끝나면 참여자명단 멘끝의 인원을 리턴
        answer=participant[participant.length-1];
        return answer;
    }

    public static void main(String[] args) {
        String[] a={"leo", "kiki", "eden"};
        String[] b={"eden", "kiki"};

        String solution = solution(a, b);
        System.out.println("solution = " + solution);
    }
}
