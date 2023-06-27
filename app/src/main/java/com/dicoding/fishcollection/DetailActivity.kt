package com.dicoding.fishcollection

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataFish = intent.getParcelableExtra<Fish>("key_fish")

        val detailedItemName:TextView = findViewById(R.id.detailed_item_name)
        val detailedItemDescription : TextView = findViewById(R.id.detailed_item_description)
        val detailedItemPicture : ImageView = findViewById(R.id.detailed_item_picture)

        val detailedLocation : TextView = findViewById(R.id.detailed_item_location)
        val detailedSize : TextView = findViewById(R.id.detailed_item_size)
        val detailedPrice : TextView = findViewById(R.id.detailed_item_price)

        val actionShare : View = findViewById(R.id.action_share)
        actionShare.setOnClickListener(this)

        if (dataFish != null) {
            detailedItemName.text = dataFish.name
            detailedItemDescription.text = dataFish.description
            detailedItemPicture.setImageResource(dataFish.picture)
            detailedSize.text = dataFish.size
            detailedLocation.text = dataFish.location
            detailedPrice.text = dataFish.price
        }
    }

    override fun onClick(v: View){
        val dataFish = intent.getParcelableExtra<Fish>("key_fish")
        val sharedText = "This is my favorite fish and I want to share it with you!\n\n${dataFish?.name}\n\nLocation : ${dataFish?.location}\nSize : ${dataFish?.size}\nPrice : ${dataFish?.price}\n\n${dataFish?.description}"

        when (v.id){
            R.id.action_share -> {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "$sharedText")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent,null)
                startActivity(shareIntent)
            }
        }
    }
}