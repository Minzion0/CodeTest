package 프로그래머스.스터디코테.lv1;

/**
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class Supo {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        // 수포자별 반복 패턴
        int[] su1= {1, 2, 3, 4, 5};
        int[] su2= {2, 1, 2, 3, 2, 4, 2, 5};
        int[] su3= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        //인덱스 값 저장
        int sui1=0,sui2=0,sui3=0;
        // 수포자별 정답 횟수 저장
        int[] rArray= {0,0,0};

        for(int i=0; i<answers.length;i++){
            int result = answers[i];

            if (result==su1[sui1]){
                rArray[0]=rArray[0]+1;
            }

            if (result==su2[sui2]){
                rArray[1]=rArray[1]+1;
            }

            if (result==su3[sui3]){
                rArray[2]=rArray[2]+1;
            }

            sui1++; sui2++; sui3++;

            //수포자별 패턴 반복용 인덱스값 초기화 실시
            if (sui1>su1.length-1){
                sui1=0;
            }

            if (sui2>su2.length-1){
                sui2=0;
            }

            if (sui3>su3.length-1){
                sui3=0;
            }


        }

        int max=0;
        // 수포자별 정답 횟수 확인 및 최대 정답수 확인
        for (int i : rArray) {
            if (max<=i){
                max=i;
            }

        }
        int[] temp=new int[0];
        // 최다 득점자 확인
        for (int i = 0; i < rArray.length; i++) {
            if (max==rArray[i]){
                temp= new int[answer.length+1];
                if (answer.length!=0){
                    for (int j = 0; j < answer.length; j++) {
                        temp[j]=answer[j];
                    }
                }

                temp[answer.length]=i+1;
            }


            answer=temp;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] a= {1,3,2,4,2};
        int[] solution = solution(a);

        System.out.println("solution = " + solution[0]);
    }
}
