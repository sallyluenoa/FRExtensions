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
import org.fog_rock.frextensions.androidx.content.startActivity
import org.fog_rock.frextensions.androidx.content.startActivityAndFinishAll
import org.fog_rock.frextensions.androidx.log.logI
import org.fog_rock.frextensionssample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTestStartActivity.setOnClickListener {
            logI("Clicked Test startActivity.")
            val message = binding.editTextMessage.text.toString()
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
            val message = binding.editTextMessage.text.toString()
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
        binding.buttonShowFragmentMainActivity.setOnClickListener {
            logI("Show FragmentMainActivity.")
            startActivity<FragmentMainActivity>()
        }
    }
}