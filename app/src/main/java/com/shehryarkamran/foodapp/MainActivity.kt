package com.shehryarkamran.foodapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?=null
    var listOfFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //food list
        listOfFoods.add(Food("Green Tea","Green tea is a type of tea that is made from " +
                "Camellia sinensis leaves that have not undergone the same withering and oxidation " +
                "process used to make oolong and black tea.",R.drawable.greentea))
        listOfFoods.add(Food("Fried Egg","A fried egg is a cooked dish commonly made " +
                "using a fresh hen's egg, fried whole with minimal accompaniment. ",R.drawable.egg))
        listOfFoods.add(Food("Sushi","Sushi is the Japanese preparation and serving of " +
                "specially prepared vinegared rice combined with varied ingredients such as chiefly " +
                "seafood (often uncooked), vegetables, and occasionally tropical fruits.Styles of " +
                "sushi and its presentation vary widely, but the key ingredient is sushi rice, also " +
                "referred to as shari , or sumeshi .",R.drawable.sushi))
        listOfFoods.add(Food("Beer","Beer is the oldest and most widely consumed alcoholic" +
                " drink in the world, and the third most popular drink overall after water and tea." +
                " Beer is brewed from cereal grains — most commonly from malted barley, though wheat, maize (corn)," +
                " and rice are also used. During the brewing process, fermentation of the starch " +
                "sugars in the wort produces ethanol and carbonation in the resulting beer",R.drawable.beer))
        listOfFoods.add(Food("Sandwich","A sandwich is a food typically consisting of " +
                "vegetables, sliced cheese or meat, placed on or between slices of bread, or more " +
                "generally any dish wherein two or more pieces of bread serve as a container or " +
                "wrapper for another food type.",R.drawable.sandwich))
        listOfFoods.add(Food("HamBurger","Hamburgers are often served with cheese, " +
                "lettuce, tomato, bacon, onion, pickles, or chiles; condiments such as mustard, " +
                "mayonnaise, ketchup, relish, or \"special sauce\"; " +
                "and are frequently placed on sesame seed buns. ",R.drawable.hamburger))
        adapter= FoodAdapter(this,listOfFoods)
        gvListFood.adapter = adapter
    }

    class FoodAdapter:BaseAdapter {
        var listOfFood = ArrayList<Food>()
        var context:Context?=null
        constructor(context: Context,listOfFood: ArrayList<Food>):super(){
            this.context = context
            this.listOfFood =listOfFood
        }
        override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
            val food = listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket,null)
            foodView.ivFoodimage.setImageResource(food.image!!)
            foodView.ivFoodimage.setOnClickListener {
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvName.text = food.name!!
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }

}