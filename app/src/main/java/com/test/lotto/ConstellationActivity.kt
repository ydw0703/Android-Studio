package com.test.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import java.time.Month
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList


class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val textView = findViewById<TextView>(R.id.constellationTextView)
                //로또 번호 확인 버튼의 클릭이벤트 리스너 설정
        findViewById<View>(R.id.goResultButton).setOnClickListener{
            //ResultActivity를 실행하는 Intent생성
            val intent = Intent(this, ResultActivity::class.java)
            //intent의 결과 데이터를 전달한다.
            // int의 리스트를 전달하므로 PutIntergerArrayListExtra를 사용.
            //전달하는 리스트는 별자리의 해시코드로 생성한 로또 번호
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(makeConstellationString(datePicker.month, datePicker.dayOfMonth))))
            //별자리를 추가로 전달한다.
            intent.putExtra("constellation",makeConstellationString(datePicker.month,datePicker.dayOfMonth))
            startActivity(intent)
        }
        //현재 DatePicker의 월, 일 정보로 별자리 텍스트 변경
        textView.text = makeConstellationString(datePicker.month,datePicker.dayOfMonth)
        //DatePicker의 날짜가 변화하면 별자리를 보여주는 텍스트뷰로 변경
//        datePicker를 초기화할 때, 연,월,일,오브젝트 두 개를 파라미터로 받아오고, 오브젝트 두개의 파라미터를 상수 캘린더뷰로 넘겨준다.
//        오브젝트 두 개의 기능은 한 개는 onDateChanged; 연,월,일을 파라미터로 받고 기능은 메이크콘스텔레이션 함수를 실행하여 텍스트뷰로 넘겨주는것
//        나머지 한 개는 onSelectedDayChanged; 캘린더뷰,인트 세개를 파라미터로 받고 todo 메서드를 실행하는 것.
        val calender = Calendar.getInstance()
        datePicker.init(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH),
            object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener {

                override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                    //변경된 시점의 DatePicker의 월,일 정보로 별자리 텍스트 변경
                    //onDateChanged의 파라미터 monthOfYear,dayOfMonth로도 밑에 텍스트뷰 파라미터로 넘겨보기.
                    textView.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
                }

                override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
                    TODO("Not yet implemented")
                }
            })
    }
    fun makeConstellationString(month: Int, day: Int): String {
//        전달받은 월 정보와 일 정보 기반 정수형태의 값 생성.
//    01.05 = 15, 11.01 = 1101
        val target = "${month + 1}${String.format("%02d",day)}".toInt()

        when (target) {
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }
}