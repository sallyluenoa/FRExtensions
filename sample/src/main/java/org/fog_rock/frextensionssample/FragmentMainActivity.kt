/*
 * Copyright (c) 2021 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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