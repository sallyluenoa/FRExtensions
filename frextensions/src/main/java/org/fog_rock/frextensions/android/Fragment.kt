package org.fog_rock.frextensions.android

import androidx.fragment.app.Fragment
import org.fog_rock.frextensions.android.callback.FRFragmentCallback
import org.fog_rock.frextensions.kotlin.downCastOrNull

inline fun <reified T: FRFragmentCallback> Fragment.activityCallback(): T? =
    requireActivity().downCastOrNull()
