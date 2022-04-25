package org.fog_rock.frextensionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.fog_rock.frextensions.androidx.fragment.addFragment
import org.fog_rock.frextensions.androidx.fragment.replaceFragment
import org.fog_rock.frextensions.androidx.log.logI
import org.fog_rock.frextensionssample.databinding.ActivityFragmentMainBinding

class FragmentMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTestAddFragment.setOnClickListener {
            logI("Clicked Test addFragment.")
            val count = supportFragmentManager.backStackEntryCount + 1
            addFragment(SubFragment.newInstance(count), R.id.fragment_container)
        }
        binding.buttonTestReplaceFragment.setOnClickListener {
            logI("Clicked Test replaceFragment.")
            replaceFragment(SubFragment.newInstance(), R.id.fragment_container)
        }

        replaceFragment(MainFragment.newInstance(), R.id.fragment_container)
    }
}