package org.fog_rock.frextensionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.fog_rock.frextensions.android.logI
import org.fog_rock.frextensions.android.startActivity
import org.fog_rock.frextensions.android.startActivityAndFinishAll
import org.fog_rock.frextensionssample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTestStartActivity.setOnClickListener {
            logI("Clicked Test startActivity.")
            startActivity<SubActivity>()
        }
        binding.buttonTestStartActivityAndFinishAll.setOnClickListener {
            logI("Clicked Test startActivityAndFinishAll.")
            startActivityAndFinishAll<SubActivity>()
        }
    }
}