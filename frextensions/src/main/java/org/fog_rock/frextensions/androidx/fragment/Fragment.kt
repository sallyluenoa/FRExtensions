package org.fog_rock.frextensions.androidx.fragment

import androidx.fragment.app.Fragment
import org.fog_rock.frextensions.ktx.downcast.downCastOrNull

inline fun <reified T: FRFragmentCallback> Fragment.activityCallback(): T? =
    requireActivity().downCastOrNull()
