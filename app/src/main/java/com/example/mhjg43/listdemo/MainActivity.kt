package com.example.mhjg43.listdemo

/**
 * created by Andy, 05/30/17
 *
 * *                #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #                  God Bless No Bug                 #
 * #                                                   #
 */

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal var dataModels : ArrayList<Model> ? = null
    internal var listView : ListView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list) as ListView

        dataModels = ArrayList<Model>()

        dataModels!!.add(Model("Apple Pie", "Android 1.0", "1", "September 23, 2008"))
        dataModels!!.add(Model("Banana Bread", "Android 1.1", "2", "February 9, 2009"))
        dataModels!!.add(Model("Cupcake", "Android 1.5", "3", "April 27, 2009"))
        dataModels!!.add(Model("Donut", "Android 1.6", "4", "September 15, 2009"))
        dataModels!!.add(Model("Eclair", "Android 2.0", "5", "October 26, 2009"))
        dataModels!!.add(Model("Froyo", "Android 2.2", "8", "May 20, 2010"))
        dataModels!!.add(Model("Gingerbread", "Android 2.3", "9", "December 6, 2010"))
        dataModels!!.add(Model("Honeycomb", "Android 3.0", "11", "February 22, 2011"))
        dataModels!!.add(Model("Ice Cream Sandwich", "Android 4.0", "14", "October 18, 2011"))
        dataModels!!.add(Model("Jelly Bean", "Android 4.2", "16", "July 9, 2012"))
        dataModels!!.add(Model("Kitkat", "Android 4.4", "19", "October 31, 2013"))
        dataModels!!.add(Model("Lollipop", "Android 5.0", "21", "November 12, 2014"))
        dataModels!!.add(Model("Marshmallow", "Android 6.0", "23", "October 5, 2015"))

        var adapter = CustomAdapter(dataModels!!,applicationContext)

        listView!!.adapter = adapter
        listView!!.onItemClickListener = AdapterView.OnItemClickListener{parent,view, position, id ->

            val dataModel = dataModels!![position]

            Toast.makeText(applicationContext ,  dataModel!!.name + "\n" + dataModel!!.type + " API: " + dataModel!!.version_number, Toast.LENGTH_LONG).show()
        }
    }
}
