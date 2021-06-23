package org.fog_rock.frextensionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.fog_rock.frextensions.androidx.fragment.FRFragmentCallback
import org.fog_rock.frextensions.androidx.fragment.addFragment
import org.fog_rock.frextensions.androidx.fragment.replaceFragment
import org.fog_rock.frextensions.androidx.log.logI
import org.fog_rock.frextensionssample.databinding.ActivityFragmentMainBinding

class FragmentMainActivity : AppCompatActivity(), FRFragmentCallback {

    private lateinit var binding: ActivityFragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTestAddFragment.setOnClickListener {
            logI("Clicked Test addFragment.")
            addFragment(SubFragment(), R.id.fragment_container)
        }
        binding.buttonTestReplaceFragment.setOnClickListener {
            logI("Clicked Test replaceFragment.")
            replaceFragment(SubFragment(), R.id.fragment_container)
        }

        replaceFragment(MainFragment(), R.id.fragment_container)
    }

    override fun onCreateFragmentView(tag: String) {
        binding.textViewMessage.text = tag
    }
}