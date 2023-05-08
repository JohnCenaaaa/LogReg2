package com.example.logreg2

import android.content.Intent
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.logreg2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var LogRegbinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogRegbinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val LogRegImageChange : ConstraintLayout = LogRegbinding.LogRegLayout
        val LogRegDrink : ImageView = LogRegbinding.LogRegDrink
        val LogRegExercise : ImageView = LogRegbinding.LogRegExercise
        val LogRegSleep : ImageView = LogRegbinding.LogRegSleep
        val LogRegTextChange1 : TextView = LogRegbinding.LogRegTextChange
        val LogRegTextChange2 : TextView = LogRegbinding.LogRegTextChange2
        val LogRegCreate : Button = LogRegbinding.LogRegCreateButton
        val LogRegLogin : Button = LogRegbinding.LogRegLoginButton
        val LogRegChangeDot1 : View = LogRegbinding.LogRegDot1
        val LogRegChangeDot2 : View = LogRegbinding.LogRegDot2
        val LogRegChangeDot3 : View = LogRegbinding.LogRegDot3
        val LogRegimageArray = intArrayOf(R.drawable.drink__2_,
            R.drawable.exercise__1_, R.drawable.sleep__1_)
        var imageIndex = 0
        val wordMap = mapOf(
            R.drawable.drink__2_ to "Drink Is A Must",
            R.drawable.exercise__1_ to "Move More Gain More",
            R.drawable.sleep__1_ to "You Need Rest"
        )
        val wordMap2 = mapOf(
            R.drawable.drink__2_ to "Constantly monitoring one's own water intake is " +
                    "crucial for maintaining proper hydration and promoting optimal bodily functions.",
            R.drawable.exercise__1_ to "Regular physical activity is essential for " +
                    "maintaining good health and should be incorporated into one's routine",
            R.drawable.sleep__1_ to "Obtaining adequate sleep is critical for maintaining " +
                    "optimal physical and mental health."
        )
        fun updateViews() {
            when (imageIndex) {
                0 -> {
                    LogRegDrink.visibility = View.VISIBLE
                    LogRegExercise.visibility = View.INVISIBLE
                    LogRegSleep.visibility = View.INVISIBLE
                    LogRegTextChange1.text = wordMap[R.drawable.drink__2_]
                    LogRegTextChange2.text = wordMap2[R.drawable.drink__2_]
                    LogRegChangeDot1.setBackgroundColor(Color.LTGRAY)
                    LogRegChangeDot2.setBackgroundColor(Color.BLACK)
                    LogRegChangeDot3.setBackgroundColor(Color.BLACK)
                }
                1 -> {
                    LogRegDrink.visibility = View.INVISIBLE
                    LogRegExercise.visibility = View.VISIBLE
                    LogRegSleep.visibility = View.INVISIBLE
                    LogRegTextChange1.text = wordMap[R.drawable.exercise__1_]
                    LogRegTextChange2.text = wordMap2[R.drawable.exercise__1_]
                    LogRegChangeDot1.setBackgroundColor(Color.BLACK)
                    LogRegChangeDot2.setBackgroundColor(Color.LTGRAY)
                    LogRegChangeDot3.setBackgroundColor(Color.BLACK)
                }
                2 -> {
                    LogRegDrink.visibility = View.INVISIBLE
                    LogRegExercise.visibility = View.INVISIBLE
                    LogRegSleep.visibility = View.VISIBLE
                    LogRegTextChange1.text = wordMap[R.drawable.sleep__1_]
                    LogRegTextChange2.text = wordMap2[R.drawable.sleep__1_]
                    LogRegChangeDot1.setBackgroundColor(Color.BLACK)
                    LogRegChangeDot2.setBackgroundColor(Color.BLACK)
                    LogRegChangeDot3.setBackgroundColor(Color.LTGRAY)
                }
            }
        }
        LogRegImageChange.setOnClickListener {
            imageIndex = (imageIndex + 1) % LogRegimageArray.size
            val imageResource = LogRegimageArray[imageIndex]
            updateViews()
        }
        LogRegCreate.setOnClickListener {
            val LogRegSignUp = Intent(this,Next::class.java)
            startActivity(LogRegSignUp)
        }
        LogRegLogin.setOnClickListener {
            val LogRegLogIn = Intent(this,Next::class.java)
            startActivity(LogRegLogIn)
        }
    }
}