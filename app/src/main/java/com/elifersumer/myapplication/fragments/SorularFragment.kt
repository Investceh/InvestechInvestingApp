package com.elifersumer.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.elifersumer.myapplication.R

class SorularFragment : Fragment() {

    lateinit var soru1: TextView

    lateinit var radio_group1: RadioGroup

    lateinit var soru1_sık1: RadioButton
    lateinit var soru1_sık2: RadioButton
    lateinit var soru1_sık3: RadioButton
    lateinit var soru1_sık4: RadioButton
    lateinit var soru1_sık5: RadioButton


    lateinit var soru2: TextView

    lateinit var radio_group2: RadioGroup

    lateinit var soru2_sık1: RadioButton
    lateinit var soru2_sık2: RadioButton
    lateinit var soru2_sık3: RadioButton
    lateinit var soru2_sık4: RadioButton
    lateinit var soru2_sık5: RadioButton


    lateinit var soru3: TextView

    lateinit var radio_group3: RadioGroup

    lateinit var soru3_sık1: RadioButton
    lateinit var soru3_sık2: RadioButton
    lateinit var soru3_sık3: RadioButton
    lateinit var soru3_sık4: RadioButton
    lateinit var soru3_sık5: RadioButton

    lateinit var soru4: TextView

    lateinit var radio_group4: RadioGroup

    lateinit var soru4_sık1: RadioButton
    lateinit var soru4_sık2: RadioButton
    lateinit var soru4_sık3: RadioButton
    lateinit var soru4_sık4: RadioButton


    lateinit var soru5: TextView

    lateinit var radio_group5: RadioGroup

    lateinit var soru5_sık1: RadioButton
    lateinit var soru5_sık2: RadioButton
    lateinit var soru5_sık3: RadioButton
    lateinit var soru5_sık4: RadioButton
    lateinit var soru5_sık5: RadioButton


    lateinit var soru6: TextView

    lateinit var radio_group6: RadioGroup

    lateinit var soru6_sık1: RadioButton
    lateinit var soru6_sık2: RadioButton
    lateinit var soru6_sık3: RadioButton
    lateinit var soru6_sık4: RadioButton
    lateinit var soru6_sık5: RadioButton


    lateinit var soru7: TextView

    lateinit var radio_group7: RadioGroup

    lateinit var soru7_sık1: RadioButton
    lateinit var soru7_sık2: RadioButton
    lateinit var soru7_sık3: RadioButton
    lateinit var soru7_sık4: RadioButton
    lateinit var soru7_sık5: RadioButton

    lateinit var soru8: TextView

    lateinit var radio_group8: RadioGroup

    lateinit var soru8_sık1: RadioButton
    lateinit var soru8_sık2: RadioButton
    lateinit var soru8_sık3: RadioButton
    lateinit var soru8_sık4: RadioButton
    lateinit var soru8_sık5: RadioButton

    lateinit var btn_bitir: Button

    lateinit var lalala: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sorular, container, false)
        lalala = view.findViewById(R.id.lalala) as TextView

        soru1 = view.findViewById(R.id.soru1) as TextView
        soru1.text = "Yatırımlarınızın ana amacı nedir ?"

        radio_group1 = view.findViewById(R.id.radio_group1) as RadioGroup

        soru1_sık1 = view.findViewById(R.id.soru1_sık1) as RadioButton
        soru1_sık1.text = "Herhangi bir yatırım aracım yok"
        soru1_sık2 = view.findViewById(R.id.soru1_sık2) as RadioButton
        soru1_sık2.text = "Varlıklarımın değerini korumak"
        soru1_sık3 = view.findViewById(R.id.soru1_sık3) as RadioButton
        soru1_sık3.text = "Eğitim fonu oluşturmak"
        soru1_sık4 = view.findViewById(R.id.soru1_sık4) as RadioButton
        soru1_sık4.text = "Finansal varlığı artırmak"
        soru1_sık5 = view.findViewById(R.id.soru1_sık5) as RadioButton
        soru1_sık5.text = "Anaparayı katlamak"

        soru2 = view.findViewById(R.id.soru2) as TextView
        soru2.text = "Hangi yatırım aracını tercih edersiniz ?"

        radio_group2 = view.findViewById(R.id.radio_group2) as RadioGroup

        soru2_sık1 = view.findViewById(R.id.soru2_sık1) as RadioButton
        soru2_sık1.text = "Nakit"
        soru2_sık2 = view.findViewById(R.id.soru2_sık2) as RadioButton
        soru2_sık2.text = "Döviz"

        soru2_sık3 = view.findViewById(R.id.soru2_sık3) as RadioButton
        soru2_sık3.text = "Yatırım Fonu"

        soru2_sık4 = view.findViewById(R.id.soru2_sık4) as RadioButton
        soru2_sık4.text = "Kripto Paralar"

        soru2_sık5 = view.findViewById(R.id.soru2_sık5) as RadioButton
        soru2_sık5.text = "Türevler"


        soru3 = view.findViewById(R.id.soru3) as TextView

        soru3 = view.findViewById(R.id.soru3) as TextView
        soru3.text = "Güvendiğiniz bir yatırımınız değer kaybederse tutumunuz ne olur ?"

        radio_group3 = view.findViewById(R.id.radio_group3) as RadioGroup

        soru3_sık1 = view.findViewById(R.id.soru3_sık1) as RadioButton
        soru3_sık1.text = "Pişman olur, hemen yatırımdan çıkarım"
        soru3_sık2 = view.findViewById(R.id.soru3_sık2) as RadioButton
        soru3_sık2.text = "Bir süre takip eder, düşüş trendi devam ederse yatırımdan çıkarım"

        soru3_sık3 = view.findViewById(R.id.soru3_sık3) as RadioButton
        soru3_sık3.text = "Anaparanın yarısını çeker, yarısını tutarım"

        soru3_sık4 = view.findViewById(R.id.soru3_sık4) as RadioButton
        soru3_sık4.text = "Değer kazanmasını beklerim"

        soru3_sık5 = view.findViewById(R.id.soru3_sık5) as RadioButton
        soru3_sık5.text = "Kaybımı kompanse etmek için düşük fiyattan tekrar yatırım yaparım"


        soru4 = view.findViewById(R.id.soru4) as TextView
        soru4.text = "Borçlanarak yatırım yapma fikrine nasıl yaklaşırsınız ?"

        radio_group4 = view.findViewById(R.id.radio_group4) as RadioGroup

        soru4_sık1 = view.findViewById(R.id.soru4_sık1) as RadioButton
        soru4_sık1.text = "Asla yapmam"
        soru4_sık2 = view.findViewById(R.id.soru4_sık2) as RadioButton
        soru4_sık2.text = "Muhtemelen yapmam"
        soru4_sık3 = view.findViewById(R.id.soru4_sık3) as RadioButton
        soru4_sık3.text = "Yüksek kazanç beklersem yapabilirim"
        soru4_sık4 = view.findViewById(R.id.soru4_sık4) as RadioButton
        soru4_sık4.text = "Riske bakmaksızın yaparım"




        soru5 = view.findViewById(R.id.soru5) as TextView
        soru5.text = "Hobilerinize en uygun aktivite hangisidir ?"

        radio_group5 = view.findViewById(R.id.radio_group5) as RadioGroup

        soru5_sık1 = view.findViewById(R.id.soru5_sık1) as RadioButton
        soru5_sık1.text = "Yüzme"
        soru5_sık2 = view.findViewById(R.id.soru5_sık2) as RadioButton
        soru5_sık2.text = "Futbol oynamak"

        soru5_sık3 = view.findViewById(R.id.soru5_sık3) as RadioButton
        soru5_sık3.text = "Bisiklet sürmek"

        soru5_sık4 = view.findViewById(R.id.soru5_sık4) as RadioButton
        soru5_sık4.text = "Tırmanış"

        soru5_sık5 = view.findViewById(R.id.soru5_sık5) as RadioButton
        soru5_sık5.text = "Bungee Jumping"



        soru6 = view.findViewById(R.id.soru6) as TextView
        soru6.text = "Yıllık gelirinizin yüzde kaçını yatırımlarınızda kullanırsınız ?"

        radio_group6 = view.findViewById(R.id.radio_group6) as RadioGroup

        soru6_sık1 = view.findViewById(R.id.soru6_sık1) as RadioButton
        soru6_sık1.text = "0-10%"
        soru6_sık2 = view.findViewById(R.id.soru6_sık2) as RadioButton
        soru6_sık2.text = "10-15%"

        soru6_sık3 = view.findViewById(R.id.soru6_sık3) as RadioButton
        soru6_sık3.text = "15-20%"
        soru6_sık4 = view.findViewById(R.id.soru6_sık4) as RadioButton
        soru6_sık4.text = "20-25%"
        soru6_sık5 = view.findViewById(R.id.soru6_sık5) as RadioButton
        soru6_sık5.text = "+25%"



        soru7 = view.findViewById(R.id.soru7) as TextView
        soru7.text = "Yatırımınızdan elde edilen getiriyi hangi vadede kullanmak istersiniz ?"

        radio_group7 = view.findViewById(R.id.radio_group7) as RadioGroup

        soru7_sık1 = view.findViewById(R.id.soru7_sık1) as RadioButton
        soru7_sık1.text = "10+ yıl"

        soru7_sık2 = view.findViewById(R.id.soru7_sık2) as RadioButton
        soru7_sık2.text = "7-10 yıl"

        soru7_sık3 = view.findViewById(R.id.soru7_sık3) as RadioButton
        soru7_sık3.text = "4-7 yıl"

        soru7_sık4 = view.findViewById(R.id.soru7_sık4) as RadioButton
        soru7_sık4.text = "1-4 yıl"

        soru7_sık5 = view.findViewById(R.id.soru7_sık5) as RadioButton
        soru7_sık5.text = "0-1 yıl"



        soru8 = view.findViewById(R.id.soru8) as TextView
        soru8.text = "Hangi hisse senedine yatırım yapmayı tercih edersiniz ?"

        radio_group8 = view.findViewById(R.id.radio_group8) as RadioGroup

        soru8_sık1 = view.findViewById(R.id.soru8_sık1) as RadioButton
        soru8_sık1.text = "Yatırımcılarına düzenli kar payı ödeyen köklü bir şirket"

        soru8_sık2 = view.findViewById(R.id.soru8_sık2) as RadioButton
        soru8_sık2.text = "Büyüme potansiyeli olan tanınmış bir şirket"

        soru8_sık3 = view.findViewById(R.id.soru8_sık3) as RadioButton
        soru8_sık3.text = "Yeni halka arz edilmiş bir şirket"

        soru8_sık4 = view.findViewById(R.id.soru8_sık4) as RadioButton
        soru8_sık4.text = "Yeni kurulan bir start-up"

        soru8_sık5 = view.findViewById(R.id.soru8_sık5) as RadioButton
        soru8_sık5.text = "Yakın zamanda finansal kriz yaşamış bir şirket"

        btn_bitir = view.findViewById(R.id.btn_bitir) as Button

        radio_group1.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)
            when(i){
                R.id.soru1_sık1 -> {
                    soru1_sık1.setBackground(drawable_selected)
                    soru1_sık2.setBackground(drawable)
                    soru1_sık3.setBackground(drawable)
                    soru1_sık4.setBackground(drawable)
                    soru1_sık5.setBackground(drawable)
                }

                R.id.soru1_sık2 -> {
                    soru1_sık1.setBackground(drawable)
                    soru1_sık2.setBackground(drawable_selected)
                    soru1_sık3.setBackground(drawable)
                    soru1_sık4.setBackground(drawable)
                    soru1_sık5.setBackground(drawable)
                }
                R.id.soru1_sık3 -> {
                    soru1_sık1.setBackground(drawable)
                    soru1_sık2.setBackground(drawable)
                    soru1_sık3.setBackground(drawable_selected)
                    soru1_sık4.setBackground(drawable)
                    soru1_sık5.setBackground(drawable)
                }
                R.id.soru1_sık4 -> {
                    soru1_sık1.setBackground(drawable)
                    soru1_sık2.setBackground(drawable)
                    soru1_sık3.setBackground(drawable)
                    soru1_sık4.setBackground(drawable_selected)
                    soru1_sık5.setBackground(drawable)
                }
                R.id.soru1_sık5 -> {
                    soru1_sık1.setBackground(drawable)
                    soru1_sık2.setBackground(drawable)
                    soru1_sık3.setBackground(drawable)
                    soru1_sık4.setBackground(drawable)
                    soru1_sık5.setBackground(drawable_selected)
                }
            }
        })



        radio_group2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru2_sık1 -> {
                    soru2_sık1.setBackground(drawable_selected)
                    soru2_sık2.setBackground(drawable)
                    soru2_sık3.setBackground(drawable)
                    soru2_sık4.setBackground(drawable)
                    soru2_sık5.setBackground(drawable)
                }
                R.id.soru2_sık2 -> {
                    soru2_sık1.setBackground(drawable)
                    soru2_sık2.setBackground(drawable_selected)
                    soru2_sık3.setBackground(drawable)
                    soru2_sık4.setBackground(drawable)
                    soru2_sık5.setBackground(drawable)
                }
                R.id.soru2_sık3 -> {
                    soru2_sık1.setBackground(drawable)
                    soru2_sık2.setBackground(drawable)
                    soru2_sık3.setBackground(drawable_selected)
                    soru2_sık4.setBackground(drawable)
                    soru2_sık5.setBackground(drawable)
                }
                R.id.soru2_sık4 -> {
                    soru2_sık1.setBackground(drawable)
                    soru2_sık2.setBackground(drawable)
                    soru2_sık3.setBackground(drawable)
                    soru2_sık4.setBackground(drawable_selected)
                    soru2_sık5.setBackground(drawable)
                }
                R.id.soru2_sık5 -> {
                    soru2_sık1.setBackground(drawable)
                    soru2_sık2.setBackground(drawable)
                    soru2_sık3.setBackground(drawable)
                    soru2_sık4.setBackground(drawable)
                    soru2_sık5.setBackground(drawable_selected)
                }
            }
        })


        radio_group3.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru3_sık1 -> {
                    soru3_sık1.setBackground(drawable_selected)
                    soru3_sık2.setBackground(drawable)
                    soru3_sık3.setBackground(drawable)
                    soru3_sık4.setBackground(drawable)
                    soru3_sık5.setBackground(drawable)
                }
                R.id.soru3_sık2 -> {
                    soru3_sık1.setBackground(drawable)
                    soru3_sık2.setBackground(drawable_selected)
                    soru3_sık3.setBackground(drawable)
                    soru3_sık4.setBackground(drawable)
                    soru3_sık5.setBackground(drawable)
                }
                R.id.soru3_sık3 -> {
                    soru3_sık1.setBackground(drawable)
                    soru3_sık2.setBackground(drawable)
                    soru3_sık3.setBackground(drawable_selected)
                    soru3_sık4.setBackground(drawable)
                    soru3_sık5.setBackground(drawable)
                }
                R.id.soru3_sık4 -> {
                    soru3_sık1.setBackground(drawable)
                    soru3_sık2.setBackground(drawable)
                    soru3_sık3.setBackground(drawable)
                    soru3_sık4.setBackground(drawable_selected)
                    soru3_sık5.setBackground(drawable)
                }
                R.id.soru3_sık5 -> {
                    soru3_sık1.setBackground(drawable)
                    soru3_sık2.setBackground(drawable)
                    soru3_sık3.setBackground(drawable)
                    soru3_sık4.setBackground(drawable)
                    soru3_sık5.setBackground(drawable_selected)
                }
            }
        })


        radio_group4.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru4_sık1 -> {
                    soru4_sık1.setBackground(drawable_selected)
                    soru4_sık2.setBackground(drawable)
                    soru4_sık3.setBackground(drawable)
                    soru4_sık4.setBackground(drawable)
                }
                R.id.soru4_sık2 -> {
                    soru4_sık1.setBackground(drawable)
                    soru4_sık2.setBackground(drawable_selected)
                    soru4_sık3.setBackground(drawable)
                    soru4_sık4.setBackground(drawable)
                }
                R.id.soru4_sık3 -> {
                    soru4_sık1.setBackground(drawable)
                    soru4_sık2.setBackground(drawable)
                    soru4_sık3.setBackground(drawable_selected)
                    soru4_sık4.setBackground(drawable)
                }
                R.id.soru4_sık4 -> {
                    soru4_sık1.setBackground(drawable)
                    soru4_sık2.setBackground(drawable)
                    soru4_sık3.setBackground(drawable)
                    soru4_sık4.setBackground(drawable_selected)
                }
            }
        })



        radio_group5.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru5_sık1 -> {
                    soru5_sık1.setBackground(drawable_selected)
                    soru5_sık2.setBackground(drawable)
                    soru5_sık3.setBackground(drawable)
                    soru5_sık4.setBackground(drawable)
                    soru5_sık5.setBackground(drawable)
                }
                R.id.soru5_sık2 -> {
                    soru5_sık1.setBackground(drawable)
                    soru5_sık2.setBackground(drawable_selected)
                    soru5_sık3.setBackground(drawable)
                    soru5_sık4.setBackground(drawable)
                    soru5_sık5.setBackground(drawable)
                }
                R.id.soru5_sık3 -> {
                    soru5_sık1.setBackground(drawable)
                    soru5_sık2.setBackground(drawable)
                    soru5_sık3.setBackground(drawable_selected)
                    soru5_sık4.setBackground(drawable)
                    soru5_sık5.setBackground(drawable)
                }
                R.id.soru5_sık4 -> {
                    soru5_sık1.setBackground(drawable)
                    soru5_sık2.setBackground(drawable)
                    soru5_sık3.setBackground(drawable)
                    soru5_sık4.setBackground(drawable_selected)
                    soru5_sık5.setBackground(drawable)
                }
                R.id.soru5_sık5 -> {
                    soru5_sık1.setBackground(drawable)
                    soru5_sık2.setBackground(drawable)
                    soru5_sık3.setBackground(drawable)
                    soru5_sık4.setBackground(drawable)
                    soru5_sık5.setBackground(drawable_selected)
                }
            }
        })


        radio_group6.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru6_sık1 -> {
                    soru6_sık1.setBackground(drawable_selected)
                    soru6_sık2.setBackground(drawable)
                    soru6_sık3.setBackground(drawable)
                    soru6_sık4.setBackground(drawable)
                    soru6_sık5.setBackground(drawable)
                }
                R.id.soru6_sık2 -> {
                    soru6_sık1.setBackground(drawable)
                    soru6_sık2.setBackground(drawable_selected)
                    soru6_sık3.setBackground(drawable)
                    soru6_sık4.setBackground(drawable)
                    soru6_sık5.setBackground(drawable)
                }
                R.id.soru6_sık3 -> {
                    soru6_sık1.setBackground(drawable)
                    soru6_sık2.setBackground(drawable)
                    soru6_sık3.setBackground(drawable_selected)
                    soru6_sık4.setBackground(drawable)
                    soru6_sık5.setBackground(drawable)
                }
                R.id.soru6_sık4 -> {
                    soru6_sık1.setBackground(drawable)
                    soru6_sık2.setBackground(drawable)
                    soru6_sık3.setBackground(drawable)
                    soru6_sık4.setBackground(drawable_selected)
                    soru6_sık5.setBackground(drawable)
                }
                R.id.soru6_sık5 -> {
                    soru6_sık1.setBackground(drawable)
                    soru6_sık2.setBackground(drawable)
                    soru6_sık3.setBackground(drawable)
                    soru6_sık4.setBackground(drawable)
                    soru6_sık5.setBackground(drawable_selected)
                }
            }
        })



        radio_group7.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru7_sık1 -> {
                    soru7_sık1.setBackground(drawable_selected)
                    soru7_sık2.setBackground(drawable)
                    soru7_sık3.setBackground(drawable)
                    soru7_sık4.setBackground(drawable)
                    soru7_sık5.setBackground(drawable)
                }
                R.id.soru7_sık2 -> {
                    soru7_sık1.setBackground(drawable)
                    soru7_sık2.setBackground(drawable_selected)
                    soru7_sık3.setBackground(drawable)
                    soru7_sık4.setBackground(drawable)
                    soru7_sık5.setBackground(drawable)
                }
                R.id.soru7_sık3 -> {
                    soru7_sık1.setBackground(drawable)
                    soru7_sık2.setBackground(drawable)
                    soru7_sık3.setBackground(drawable_selected)
                    soru7_sık4.setBackground(drawable)
                    soru7_sık5.setBackground(drawable)
                }
                R.id.soru7_sık4 -> {
                    soru7_sık1.setBackground(drawable)
                    soru7_sık2.setBackground(drawable)
                    soru7_sık3.setBackground(drawable)
                    soru7_sık4.setBackground(drawable_selected)
                    soru7_sık5.setBackground(drawable)
                }
                R.id.soru7_sık5 -> {
                    soru7_sık1.setBackground(drawable)
                    soru7_sık2.setBackground(drawable)
                    soru7_sık3.setBackground(drawable)
                    soru7_sık4.setBackground(drawable)
                    soru7_sık5.setBackground(drawable_selected)
                }
            }
        })



        radio_group8.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->

            val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg7, null)
            val drawable_selected: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg8, null)

            when(i){
                R.id.soru8_sık1 -> {
                    soru8_sık1.setBackground(drawable_selected)
                    soru8_sık2.setBackground(drawable)
                    soru8_sık3.setBackground(drawable)
                    soru8_sık4.setBackground(drawable)
                    soru8_sık5.setBackground(drawable)
                }
                R.id.soru8_sık2 -> {
                    soru8_sık1.setBackground(drawable)
                    soru8_sık2.setBackground(drawable_selected)
                    soru8_sık3.setBackground(drawable)
                    soru8_sık4.setBackground(drawable)
                    soru8_sık5.setBackground(drawable)
                }
                R.id.soru8_sık3 -> {
                    soru8_sık1.setBackground(drawable)
                    soru8_sık2.setBackground(drawable)
                    soru8_sık3.setBackground(drawable_selected)
                    soru8_sık4.setBackground(drawable)
                    soru8_sık5.setBackground(drawable)
                }
                R.id.soru8_sık4 -> {
                    soru8_sık1.setBackground(drawable)
                    soru8_sık2.setBackground(drawable)
                    soru8_sık3.setBackground(drawable)
                    soru8_sık4.setBackground(drawable_selected)
                    soru8_sık5.setBackground(drawable)
                }
                R.id.soru8_sık5 -> {
                    soru8_sık1.setBackground(drawable)
                    soru8_sık2.setBackground(drawable)
                    soru8_sık3.setBackground(drawable)
                    soru8_sık4.setBackground(drawable)
                    soru8_sık5.setBackground(drawable_selected)
                }
            }
        })


        btn_bitir.setOnClickListener(View.OnClickListener {
            var kullanıcı_profili: String = ""

            val rg1 = radio_group1.checkedRadioButtonId
            val rg2 = radio_group2.checkedRadioButtonId
            val rg3 = radio_group3.checkedRadioButtonId
            val rg4 = radio_group4.checkedRadioButtonId
            val rg5 = radio_group5.checkedRadioButtonId
            val rg6 = radio_group6.checkedRadioButtonId
            val rg7 = radio_group7.checkedRadioButtonId
            val rg8 = radio_group8.checkedRadioButtonId

            if(rg1 == -1 || rg2 == -1 || rg3 == -1 || rg4 == -1 || rg5 == -1 || rg6 == -1 || rg7 == -1 || rg8 == -1){
                Toast.makeText(this@SorularFragment.requireActivity(),"Lütfen tüm soruları cevaplayınız", Toast.LENGTH_SHORT).show()
            }else{

                var secilen_button1 = radio_group1.checkedRadioButtonId
                var secilen1_string = resources.getResourceEntryName(secilen_button1)

                var secilen_button2 = radio_group2.checkedRadioButtonId
                var secilen2_string = resources.getResourceEntryName(secilen_button2)

                var secilen_button3 = radio_group3.checkedRadioButtonId
                var secilen3_string = resources.getResourceEntryName(secilen_button3)

                var secilen_button4 = radio_group4.checkedRadioButtonId
                var secilen4_string = resources.getResourceEntryName(secilen_button4)

                var secilen_button5 = radio_group5.checkedRadioButtonId
                var secilen5_string = resources.getResourceEntryName(secilen_button5)

                var secilen_button6 = radio_group6.checkedRadioButtonId
                var secilen6_string = resources.getResourceEntryName(secilen_button6)

                var secilen_button7 = radio_group7.checkedRadioButtonId
                var secilen7_string = resources.getResourceEntryName(secilen_button7)

                var secilen_button8 = radio_group8.checkedRadioButtonId
                var secilen8_string = resources.getResourceEntryName(secilen_button8)

                var secilen_sıklar = ArrayList<String>()
                secilen_sıklar.add(secilen1_string)
                secilen_sıklar.add(secilen2_string)
                secilen_sıklar.add(secilen3_string)
                secilen_sıklar.add(secilen4_string)
                secilen_sıklar.add(secilen5_string)
                secilen_sıklar.add(secilen6_string)
                secilen_sıklar.add(secilen7_string)
                secilen_sıklar.add(secilen8_string)


                var sıklar_degerler = HashMap<String, Double>()
                sıklar_degerler[""]

                sıklar_degerler["soru1_sık1"] = 2.5
                sıklar_degerler["soru1_sık2"] = 5.0
                sıklar_degerler["soru1_sık3"] = 7.5
                sıklar_degerler["soru1_sık4"] = 10.0
                sıklar_degerler["soru1_sık5"] = 12.5

                sıklar_degerler["soru2_sık1"] = 2.5
                sıklar_degerler["soru2_sık2"] = 5.0
                sıklar_degerler["soru2_sık3"] = 7.5
                sıklar_degerler["soru2_sık4"] = 10.0
                sıklar_degerler["soru2_sık5"] = 12.5

                sıklar_degerler["soru3_sık1"] = 2.5
                sıklar_degerler["soru3_sık2"] = 5.0
                sıklar_degerler["soru3_sık3"] = 7.5
                sıklar_degerler["soru3_sık4"] = 10.0
                sıklar_degerler["soru3_sık5"] = 12.5

                sıklar_degerler["soru4_sık1"] = 3.125
                sıklar_degerler["soru4_sık2"] = 6.25
                sıklar_degerler["soru4_sık3"] = 9.375
                sıklar_degerler["soru4_sık4"] = 12.5
                sıklar_degerler["soru4_sık5"] = 0.0

                sıklar_degerler["soru5_sık1"] = 2.5
                sıklar_degerler["soru5_sık2"] = 5.0
                sıklar_degerler["soru5_sık3"] = 7.5
                sıklar_degerler["soru5_sık4"] = 10.0
                sıklar_degerler["soru5_sık5"] = 12.5

                sıklar_degerler["soru6_sık1"] = 2.5
                sıklar_degerler["soru6_sık2"] = 5.0
                sıklar_degerler["soru6_sık3"] = 7.5
                sıklar_degerler["soru6_sık4"] = 10.0
                sıklar_degerler["soru6_sık5"] = 12.5

                sıklar_degerler["soru7_sık1"] = 2.0
                sıklar_degerler["soru7_sık2"] = 5.0
                sıklar_degerler["soru7_sık3"] = 7.5
                sıklar_degerler["soru7_sık4"] = 10.0
                sıklar_degerler["soru7_sık5"] = 12.5

                sıklar_degerler["soru8_sık1"] = 2.0
                sıklar_degerler["soru8_sık2"] = 5.0
                sıklar_degerler["soru8_sık3"] = 7.5
                sıklar_degerler["soru8_sık4"] = 10.0
                sıklar_degerler["soru8_sık5"] = 12.5


                var toplam_deger = 0.0
                for (i in secilen_sıklar){
                    toplam_deger += sıklar_degerler[i]!!
                }


                if(toplam_deger >= 0.0 && toplam_deger <= 40.0){
                    kullanıcı_profili = "RiskSevmez"
                }else if(toplam_deger >= 40.1 && toplam_deger <= 60.0){
                    kullanıcı_profili = "Temkinli"
                }else if(toplam_deger >= 60.1 && toplam_deger <= 80.0){
                    kullanıcı_profili = "RiskSever"
                }else if(toplam_deger >= 80.1 && toplam_deger <= 100.0){
                    kullanıcı_profili = "Agresif"
                }
                var navController: NavController? = null
                navController = Navigation.findNavController(view)
                navController!!.navigate(R.id.action_sorularFragment_to_roboAdvisor)

            }


        })

        return view
    }

}