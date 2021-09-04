package com.test.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {
    fun getRandomLottonumbers(): MutableList<Int> {
        //무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        //반복문(6번반복)
        for (i in 1..6) {
            //랜덤한 번호를 임시로 저장할 변수를 생성(변수 초기화)
            var number = 0
            do {
                //랜덤한 번호를 추출해 number 변수에 저장
                number = getRandomLottonumber()
            }while (lottoNumbers.contains(number))
            //이미 뽑은 리스트에 없는 번호가 나올때까지 반복했으므로 중복이 없는 상태
            //추출된 번호를 뽑은 리스트에 추가
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    fun getRandomLottonumber(): Int{
    //0~45까지 무작위 수를 생성
        return Random().nextInt(45)+1
    }

    fun getShuffleLottoNumbers(): MutableList<Int> {
//1~45번에 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()
//1~45번까지 for문을 돌면서 리스트에 로또 번호 저장
        for (number in 1..45) {
            list.add(number)
        }

//리스트를 무작위로 섞는다.
        list.shuffle()

//리스트를 앞에서부터 순서대로 6개를 반환한다.
        return list.subList(0,6)
    }

//입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환한다.
    fun getLottoNumbersFromHash(name: String): MutableList<Int>{
    //1~45번에 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        for(number in 1..45){
            list.add(number)
        }
//SimpleDateFormat은 날짜의 시간값을 포맷화된 텍스트 형태로 바꿔주는 클래스
//현재Date의 "yyyy-MM-dd"문자열과 이름 문자열을 합친다.
    val targetString = SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).format(Date())+name

//리스트를 무작위로 섞는다. 이때 섞는 기준으로 Random(SEED)를 사용한다.
//SEED값은 전달받은 이름의 해시코드를 사용한다.
    list.shuffle(Random(name.hashCode().toLong()))

//리스트를 앞에서부터 순서대로 6개 반환
    return list.subList(0,6)
    }
}