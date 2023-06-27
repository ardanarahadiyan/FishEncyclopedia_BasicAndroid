package com.dicoding.fishcollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFishes : RecyclerView
    private val list = ArrayList<Fish>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFishes = findViewById(R.id.rv_fishes)
        rvFishes.setHasFixedSize(true)

        list.addAll(getListFishes())
        showRecycleList()
    }

    private fun getListFishes(): Collection<Fish> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPicture = resources.obtainTypedArray(R.array.data_picture)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataSize = resources.getStringArray(R.array.data_size)
        val dataPrice = resources.getStringArray(R.array.data_price)

        val listFish = ArrayList<Fish>()
        for (i in dataName.indices){
            val fish = Fish(dataName[i], dataDescription[i], dataPicture.getResourceId(i, -1), dataLocation[i], dataSize[i], dataPrice[i])
            listFish.add(fish)
        }

        return listFish
    }

    private fun showRecycleList(){
        rvFishes.layoutManager = LinearLayoutManager(this)
        val listFishAdapter = ListFishAdapter(list)
        rvFishes.adapter = listFishAdapter

        /*listFishAdapter.setOnItemClickCallback(object : ListFishAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Fish) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("key_fish", data)
                startActivity(intentToDetail)
            }

        })*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about ->{
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}