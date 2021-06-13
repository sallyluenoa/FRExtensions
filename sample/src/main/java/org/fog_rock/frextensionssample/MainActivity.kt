package org.fog_rock.frextensionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.fog_rock.frextensions.android.logI
import org.fog_rock.frextensions.android.startActivity
import org.fog_rock.frextensions.android.startActivityAndFinishAll
import org.fog_rock.frextensionssample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTestStartActivity.setOnClickListener {
            logI("Clicked Test startActivity.")
            val message = binding.editTextPutExtraMessage.text.toString()
            if (message.isEmpty()) {
                logI("startActivity without message.")
                startActivity<SubActivity>()
            } else {
                logI("startActivity with message.")
                startActivity<SubActivity>(Bundle().apply {
                    putString(SubActivity.ARGS_MESSAGE, message)
                })
            }
        }
        binding.buttonTestStartActivityAndFinishAll.setOnClickListener {
            logI("Clicked Test startActivityAndFinishAll.")
            val message = binding.editTextPutExtraMessage.text.toString()
            if (message.isEmpty()) {
                logI("startActivityAndFinishAll without message.")
                startActivityAndFinishAll<SubActivity>()
            } else {
                logI("startActivityAndFinishAll with message.")
                startActivityAndFinishAll<SubActivity>(Bundle().apply {
                    putString(SubActivity.ARGS_MESSAGE, message)
                })
            }
        }
    }
}