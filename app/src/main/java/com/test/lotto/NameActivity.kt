package com.test.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.test.lotto.databinding.ActivityMainBinding
import com.test.lotto.databinding.ActivityNameBinding
import java.text.SimpleDateFormat
import java.util.*

class NameActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding : ActivityNameBinding ? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.name_wirte).into(findViewById<ImageView>(R.id.imageView22))

        binding.goButton.setOnClickListener {

            if(TextUtils.isEmpty(binding.editText.text.toString())) {
                Toast.makeText(applicationContext,"이름을 입력하세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this,ResultActivity::class.java)
            //intent의 결과 데이터를 전달
            //int의 리스트를 전달하므로 putIntegerArrayListExtra 실행.
            //전달하는 리스트는 이름의 해시코드로 생성한 로또 번호

            intent.putIntegerArrayListExtra("result",ArrayList(LottoNumberMaker.getLottoNumbersFromHash(binding.editText.text.toString())))
            startActivity(intent)
            //입력받은 이름을 추가로 전달한다.
            intent.putExtra("name",binding.editText.text.toString())
            startActivity(intent)
        }

        //뒤로가기 버튼의 클릭이벤트 리스너 설정
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() { // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}