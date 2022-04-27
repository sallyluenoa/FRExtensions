/**
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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import org.fog_rock.frextensionssample.databinding.FragmentSubBinding

class SubFragment : Fragment() {

    companion object {
        private const val ARGS_COUNT = "count"
        private const val DEFAULT_VALUE = 0

        fun newInstance(count: Int = DEFAULT_VALUE): SubFragment =
            SubFragment().apply {
                arguments = bundleOf(ARGS_COUNT to count)
            }
    }

    private var _binding: FragmentSubBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = run {
        _binding = FragmentSubBinding.inflate(inflater, container, false)

        val count = arguments?.getInt(ARGS_COUNT, DEFAULT_VALUE) ?: DEFAULT_VALUE
        binding.textViewMessage.text = getString(R.string.label_textView_subFragment, count)

        binding.root
    }
}