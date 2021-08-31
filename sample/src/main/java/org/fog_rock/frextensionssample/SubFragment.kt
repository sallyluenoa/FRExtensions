package org.fog_rock.frextensionssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.fog_rock.frextensionssample.databinding.FragmentSubBinding

class SubFragment : Fragment() {

    private var _binding: FragmentSubBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubBinding.inflate(inflater, container, false)
        return binding.root
    }
}