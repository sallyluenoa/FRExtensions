package org.fog_rock.frextensionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.fog_rock.frextensionssample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    companion object {
        const val ARGS_MESSAGE = "message"
    }

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.materialTextViewMessage.text =
            intent.getStringExtra(ARGS_MESSAGE) ?: getString(R.string.empty)
    }
}