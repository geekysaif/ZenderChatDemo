package com.niit.zenderchatdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import zendesk.core.AnonymousIdentity
import zendesk.core.Zendesk
import zendesk.support.Support
import zendesk.support.guide.HelpCenterActivity

class MainActivity : AppCompatActivity() {

    val strKey=     "**************************************"
    val strClientId="**************************************"
    val strUrl="https://melcom-group.zendesk.com"
    val strPackage="com.niit.zenderchatdemo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnSupport)

       //Chat.INSTANCE.init(this, strKey);

        // Zendesk.INSTANCE.init(this, "https://omniwear.zendesk.com", strKey, " ")
        // Zendesk.INSTANCE.init(this, strUrl, strPackage, strKey)
        Zendesk.INSTANCE.init(this, strUrl, strKey, strClientId)

        //val identity: Identity = AnonymousIdentity()
        val identity = AnonymousIdentity.Builder()
            .withNameIdentifier("name")
            .withEmailIdentifier("name@gmail.com")
            .build()
        Zendesk.INSTANCE.setIdentity(identity)
        Support.INSTANCE.init(Zendesk.INSTANCE)

        button?.setOnClickListener()
        {

            HelpCenterActivity.builder()
                .show( this)

           /* MessagingActivity.builder()
                .withEngines(ChatEngine.engine())
                .show(this)*/

        }

    }
}