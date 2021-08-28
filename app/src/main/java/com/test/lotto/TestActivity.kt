package com.test.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
//        Viewid를 찾아서( id가 button) setonClickListner 함수를 동작
        findViewById<View>(R.id.button).setOnClickListener {
//            MainActivity를 시작하는 Intent 생성, class 명 :: class.확장자
            val intent = Intent(this@TestActivity,MainActivity::class.java)
//            intent를 사용하여 Activity 시작.
            startActivity(intent)
        }
    }


//    xml에서 참조할 수 있게 메소드를 정의함.

    fun goConstellation(view: View) {
        val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
//        별도 이벤트 설정 x .xml 파일에서 이벤트 리스너가 될 수 있는 함수를 연결한 것.
    }
}