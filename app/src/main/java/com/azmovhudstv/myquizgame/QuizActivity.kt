package com.azmovhudstv.myquizgame

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.musfickjamil.snackify.Snackify
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCurrentPosition: Int = 1
    var score1 =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        mQuestionList = Constants.getQuestion()
        setQuestion()


    }

     fun setQuestion() {
         val question = mQuestionList!![mCurrentPosition - 1]

         defaultOptionsView()
         if (mCurrentPosition == mQuestionList!!.size) {
             btn_submit.text = "Finish"
         } else {
             btn_submit.text = "Submit"
         }


         tv_question.text = question.question
         tv_option_one.text = question.variant1
         tv_option_two.text = question.variant2
         tv_option_three.text = question.variant3
         tv_option_four.text = question.variant4
     }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#FFFFFF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.text_bg
            )
        }

    }

     fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "Siz Barcha Testlarni Yechib bo`ldingiz ! Kutin... Qaytadan Yuklanmoqda...", Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.togriJavob != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.correct_option_border_bg,score1)
                        Snackify.error(findViewById(android.R.id.content), "Noto`gri !", Snackify.LENGTH_SHORT).show()
                        btn_submit.text="Keyingisi "

                    }else {
                        answerView(question.togriJavob, R.drawable.correct_option_border_bg,score1++)
                        textView.text = "Your Scroe:$score1"
                        Snackify.success(findViewById(android.R.id.content), "Tog`ri  !", Snackify.LENGTH_LONG).show()
                        btn_submit.text="Keyingisi "
                    }
                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit.text = "Finish"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.text_bg
        )
    }

    private fun answerView(answer: Int, drawableView: Int,count:Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
    }
