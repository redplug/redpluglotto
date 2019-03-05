package com.redplug.redlotto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.redplug.redlotto.LottoNumberMaker.getLottoNumbersFromHash
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)



        // 번호 생성 버튼의 클릭이벤트 리스너 설정
        goButton.setOnClickListener {
            // 입력된 이름이 없으면 토스트 메세지 출력 후 리턴
            if(TextUtils.isEmpty(editText.text.toString())) return@setOnClickListener

            // ResultActivity 를 시작하는 인텐트를 만들고 startActivity 로 실행
            val intent = Intent(this, ResultActivity::class.java)

            // intent 의 결과 데이터를 전달한다.
            // int 의 리스트를 전달하므로 putIntegerArrayListExtra를 사용한다.
            // 전달하는 리스트는 이름의 해시코드로 생성한 로또 번호
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString())))

            // 입력받은 이름을 추가로 전달한다.
            intent.putExtra("name", editText.text.toString())

            startActivity(intent)
        }

        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener{
            // 액티비티 종료
            finish()
        }
//        Toast.makeText(applicationContext, "NameActivity 입니다.", Toast.LENGTH_LONG).show()
    }
}
