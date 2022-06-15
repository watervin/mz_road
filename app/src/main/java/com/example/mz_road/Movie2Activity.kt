package com.example.mz_road

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_choice_main.*
import kotlinx.android.synthetic.main.activity_movie2.*
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class Movie2Activity : AppCompatActivity() {

    var final_result : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie2)

        final_result = intent.getStringExtra("final_result").toString()

        // 크롤링 시작
        btnStart.setOnClickListener {
            // 리사이클러 뷰 매니저 설정
            listView.layoutManager = LinearLayoutManager(this)

            doTask("https://movie.naver.com/movie/running/current.naver?view=list&tab=normal&order=likeCount")
            btnStart.setVisibility(View.INVISIBLE)

        }

        btn_map2.setOnClickListener {

            val intent = Intent(this, KakaoMap::class.java)
            intent.putExtra("final_result",final_result).toString()
            startActivity(intent)

        }


    }

    // 크롤링 하기
    fun doTask(url : String) {
        var documentTitle : String = ""
        var itemList : ArrayList<MovieItem> = arrayListOf() //MovieItem 배열

        Single.fromCallable {
            try {
                // 사이트에 접속해서 HTML 문서 가져오기
                val doc = Jsoup.connect(url).get()

                // HTML 파싱해서 데이터 추출하기
                // ul.lst_detail_t1아래의 li 태그만 가져오기
                val elements : Elements = doc.select("ul.lst_detail_t1 li")
                // (여러개의) elements 처리
                run elemLoop@{
                    elements.forEachIndexed{ index, elem ->
                        // elem은 하나의 li를 전달해줌
                        var title = elem.select("dt.tit a").text()
                        var num = elem.select("dl.info_star div.star_t1 span.num").text()
                        var num2 = elem.select("span.num2").text()
                        var reserve = elem.select("dl.info_exp div.star_t1 span.num").text()
                        var poster = elem.select("div.thumb a img").attr("src")

                        // MovieItem 아이템 생성 후 추가
                        var item = MovieItem(title, num, num2, reserve, poster)
                        itemList.add(item)

                        // 10개만 가져오기
                        if (index == 9) return@elemLoop
                    }
                }

                // 올바르게 HTMl 문서 가져왔다면 title로 바꾸기
                documentTitle = doc.title()
            } catch (e : Exception) {e.printStackTrace()}

            return@fromCallable documentTitle   // subscribe 호출
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                // documentTitle 응답 성공 시
                { text ->
                    // 리사이클러뷰에 아이템 연결
                    listView.adapter = MovieAdapter(itemList)
                },
                // documentTitle 응답 오류 시
                { it.printStackTrace() })
    }
}