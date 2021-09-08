package com.elifersumer.myapplication.fragments

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
<<<<<<< HEAD
import com.elifersumer.myapplication.GetOrderList.Request.GetOrderListParameters
import com.elifersumer.myapplication.GetOrderList.Request.GetOrderListRequest
import com.elifersumer.myapplication.GetOrderList.Response.GetOrderListResponse
import com.elifersumer.myapplication.GetOrderList.Response.Order
import com.elifersumer.myapplication.RetroInstance
import com.elifersumer.myapplication.GetOrderList.Retrofit.RetroService
import com.elifersumer.myapplication.Header
import com.elifersumer.myapplication.R
=======
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifersumer.myapplication.*
import kotlinx.android.synthetic.main.fragment_bekleyen_emir.*
import kotlinx.android.synthetic.main.fragment_emirgiris.*
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.*
>>>>>>> erdi
import kotlinx.android.synthetic.main.fragment_gerceklesen_emir.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GerceklesenEmirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD

        val tmpNo= view?.findViewById(R.id.txt_tckn) as EditText

        val customerNo = tmpNo.toString().toInt()

        var instances: RetroInstance?=null

        var header = Header("c1c2a508fdf64c14a7b44edc9241c9cd","API","331eb5f529c74df2b800926b5f34b874","5252012362481156055")

        var getOrderListParameters= GetOrderListParameters(customerNo,0)

        //var listParameters=ArrayList<GetOrderListParameters>()

        //listParameters.add(getOrderListParameters)

        var getOrderListRequest= GetOrderListRequest(header,getOrderListParameters)

        val retrofit = instances!!.getRetroInstance().create(RetroService::class.java)

        var result : Call<GetOrderListResponse> = retrofit.GetPostValue(getOrderListRequest)

        var getOrderListResponse: GetOrderListResponse

        var waitingOrderList:List<Order>?=null

        result.enqueue(object : Callback<GetOrderListResponse?> {
            override fun onResponse(call: Call<GetOrderListResponse?>?, response: Response<GetOrderListResponse?>) {
                var data=response.body()!!.GetData()
                waitingOrderList=data?.WaitingOrders
            }

            override fun onFailure(call: Call<GetOrderListResponse?>?, t: Throwable?) {}
        })

        val drawable: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_green, null)
        val drawable2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_red, null)
        val drawable_al: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.alll, null)
        val drawable3: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg3, null)
        val drawable_al2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.al_2, null)
        val drawable_sat2: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.sat_2, null)

        val drawable4: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.bg1, null)
       // val drawable5: Drawable?= ResourcesCompat.getDrawable(resources,R.drawable.button_gradient, null)
=======
>>>>>>> erdi
        val view = inflater.inflate(R.layout.fragment_gerceklesen_emir, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var geEmirler = mutableListOf(
            GeEmirlerimData("AGHOL","15","24.12","Alış"),
            GeEmirlerimData("ALKIM","20","15.04","Satış")
        )
        ge_emir_recyclerView.layoutManager= LinearLayoutManager(context)
        ge_emir_recyclerView.adapter= RecyclerViewAdapterGeEmirlerim(geEmirler)
    }
}