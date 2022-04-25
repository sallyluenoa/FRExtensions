package org.fog_rock.frextensionssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import org.fog_rock.frextensionssample.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        private const val ARGS_COUNT = "count"
        private const val DEFAULT_VALUE = 0

        fun newInstance(count: Int = DEFAULT_VALUE): MainFragment =
            MainFragment().apply {
                arguments = bundleOf(ARGS_COUNT to count)
            }
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = run {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val count = arguments?.getInt(ARGS_COUNT, DEFAULT_VALUE) ?: DEFAULT_VALUE
        binding.textViewMessage.text = getString(R.string.label_textView_mainFragment, count)

        binding.root
    }
}