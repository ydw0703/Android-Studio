package com.test.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random
import com.bumptech.glide.Glide


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).load(R.drawable.main_random_image).into(findViewById<ImageView>(R.id.imageview11))
        Glide.with(this).load(R.drawable.main_constellation_image).into(findViewById<ImageView>(R.id.imageview12))
        Glide.with(this).load(R.drawable.main_name_image).into(findViewById<ImageView>(R.id.imageview13))



        //랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        findViewById<View>(R.id.randomCard).setOnClickListener {
            //ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
            startActivity(intent)
        }
        //별자리로 번호 생성 카드의 클릭 이벤트 리스너
        findViewById<View>(R.id.constellationCard).setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }
        //이름으로 번호 생성 카드의 클리 이벤트 리스너
        findViewById<View>(R.id.nameCard).setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))

        }
    }
}