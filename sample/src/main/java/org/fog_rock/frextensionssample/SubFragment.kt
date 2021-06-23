package org.fog_rock.frextensionssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.fog_rock.frextensions.androidx.fragment.FRFragmentCallback
import org.fog_rock.frextensions.androidx.fragment.activityCallback
import org.fog_rock.frextensions.androidx.log.TAG
import org.fog_rock.frextensionssample.databinding.FragmentDefaultBinding

class SubFragment : Fragment() {

    private var _binding: FragmentDefaultBinding? = null
    private val binding get() = _binding!!

    private val callback: FRFragmentCallback? by lazy { activityCallback() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDefaultBinding.inflate(inflater, container, false)
        binding.textViewClassName.text = TAG
        callback?.onCreateFragmentView(TAG)
        return binding.root
    }
}