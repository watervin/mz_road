package com.example.mz_road

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_movie2.*
import org.jsoup.Jsoup
import org.jsoup.select.Elements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (var items : ArrayList<MovieItem>) : RecyclerView.Adapter<MovieAdapter.ViewHolder> () {
    //  movie_item.xml과 연결한 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(itemView)
    }

    // position번째 데이터와 xml 연결
    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    // 아이템 갯수 반환
    override fun getItemCount() = items.count()

    // 데이터와 xml 연결
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item : MovieItem) {
            itemView.title.text = item.title
            itemView.num.text = item.num +" 점"
            itemView.num2.text = item.num2
//            itemView.reserve.text = "예매율 : " + item.reserve + "%"
            // 이미지 url 읽어서 넣기
            Glide.with(itemView).load(item.poster).into(itemView.poster)
        }
    }
}