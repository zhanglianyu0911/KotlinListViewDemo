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

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomAdapter(private val dataSet : ArrayList<Model>, internal var mContext: Context)
                : ArrayAdapter<Model>(mContext,R.layout.row_item,dataSet), View.OnClickListener{
    private class ViewHolder{
        internal var txtName: TextView? = null
        internal var txtType: TextView? = null
        internal var txtVersion: TextView? = null
        internal var info: ImageView? = null
    }


    override fun onClick(v: View) {
        val position = v.tag as Int
        val obj = getItem(position)

            when(v.id){
                R.id.item_info -> Toast.makeText(mContext, "Release Date "+ obj!!.feature, Toast.LENGTH_LONG).show()
            }
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var v= convertView

        val dataModel = getItem(position)
        val viewHolder : ViewHolder

        if(v == null){
            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            v = inflater.inflate(R.layout.row_item,parent,false)

            viewHolder.txtName = v.findViewById(R.id.name) as TextView
            viewHolder.txtType = v.findViewById(R.id.type) as TextView
            viewHolder.txtVersion = v.findViewById(R.id.version_number) as TextView
            viewHolder.info = v.findViewById(R.id.item_info) as ImageView

            v.tag = viewHolder
        } else{
            viewHolder = v.tag as ViewHolder
        }

        viewHolder.txtName!!.text = dataModel.name
        viewHolder.txtType!!.text = dataModel.type
        viewHolder.txtVersion!!.text = dataModel.version_number
        viewHolder.info!!.setOnClickListener(this)
        viewHolder.info!!.tag = position

        return v
    }

}