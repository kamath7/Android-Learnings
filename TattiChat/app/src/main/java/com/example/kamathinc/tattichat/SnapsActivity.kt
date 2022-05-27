package com.example.kamathinc.tattichat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.auth.FirebaseAuth

class SnapsActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    var snapsListView: ListView? = null
    var emails: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snaps)
        Toast.makeText(this, "Welcome to TattiChat",Toast.LENGTH_SHORT).show()
        snapsListView = findViewById(R.id.snapsListView)

        
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_2, )
        snapsListView?.adapter = adapter
        FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.currentUser?.uid).child("snaps").addChildEventListener(object: ChildEventListener {
            
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {

                emails.add(p0.child("from")?.value as String)
                adapter.notifyDataSetChanged()

            }
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {

            }

            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {

            }


            override fun onChildRemoved(p0: DataSnapshot?) {

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.snaps,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.createSnap){

            val intent = Intent(this, CreateSnapActivity::class.java)
            startActivity(intent)

        }else if(item?.itemId == R.id.logout){
            mAuth.signOut()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        super.onBackPressed()
        mAuth.signOut()
    }
}
