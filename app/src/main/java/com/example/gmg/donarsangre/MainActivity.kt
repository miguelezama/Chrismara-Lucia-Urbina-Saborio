package com.example.gmg.donarsangre

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.view.View
import android.widget.ArrayAdapter

import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private val personasList = ArrayList<Personas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {

        val i = Intent(this, Agregar::class.java)
        startActivityForResult(i, 1234)
    }

    public override fun onActivityResult(request: Int, respond: Int, data: Intent?) {
        if (request == 1234 && respond == Activity.RESULT_OK) {
            val persona = data!!.extras!!.get("persona") as Personas
            personasList.add(persona)
        }

    }

    fun onListar(view: View) {
        val i = Intent(this, BuscarPersona::class.java)
        startActivity(i)
    }

    fun onEliminar(view: View) {
        val i = Intent(this, eliminar::class.java)
        startActivity(i)
    }

    fun premodificar(view: View) {
        val i = Intent(this, pre_modificar::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
