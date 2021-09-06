package com.elifersumer.myapplication.data

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.elifersumer.myapplication.R
import java.sql.Connection
import java.sql.SQLException

class DataManager(){


    var dbConnection:DbConnection ?=null
    val con : Connection? = dbConnection?.Conn()
    lateinit var customer: Customer

    fun getData(tckn : Int,context:Context) : Customer{

        if(con==null){
            Toast.makeText(context,"Couldn't reach the database!",Toast.LENGTH_LONG).show()
        }else{
            val statement=con.createStatement()

            customer.firstName = statement.executeQuery("SELECT first_name FROM customers where tc_no='"+tckn+"'").toString()
            customer.lastName = statement.executeQuery("SELECT last_name FROM customers where tc_no='"+tckn+"'").toString()
            customer.tcNo = statement.executeQuery("SELECT tc_no FROM customers where tc_no='"+tckn+"'").toString().toInt()
            customer.phoneNo = statement.executeQuery("SELECT phone FROM customers where tc_no='"+tckn+"'").toString().toInt()
            val customerId : Int = statement.executeQuery("SELECT customer_id FROM customers where tc_no='"+tckn+"'").toString().toInt()
            customer.balanceInv = statement.executeQuery("SELECT balance_invest FROM information where customer_id='"+customerId+"'").toString().toDouble()
            customer.balanceAcc = statement.executeQuery("SELECT balance_account FROM information where customer_id='"+customerId+"'").toString().toDouble()

        }
        return customer
    }

    fun setData(firstName:String, lastName:String, tckn:Int, phone:Int, password:Int){

        if(con==null){
            val error : String ="Error in sql connection"
        }else {
            try{
                val statement = con.createStatement()

                customer.firstName=statement.executeQuery("INSERT INTO customers(first_name) VALUES('"+firstName+"') ").toString()
                customer.lastName=statement.executeQuery("INSERT INTO customers(last_name) VALUES('"+lastName+"') ").toString()
                customer.tcNo=statement.executeQuery("INSERT INTO customers(tc_no) VALUES('"+tckn+"') ").toString().toInt()
                customer.phoneNo=statement.executeQuery("INSERT INTO customers(phone) VALUES('"+phone+"') ").toString().toInt()
                customer.password=statement.executeQuery("INSERT INTO customers(password) VALUES('"+password+"')").toString().toInt()

            }catch (ex : SQLException){
                Log.e("error", ex.message.toString())
            }
        }
    }



}
