package org.fog_rock.frextensions.androidx.fragment

import androidx.fragment.app.Fragment

/**
 * Get a callback interface for a fragment to notify its parent activity of an event.
 * @return A callback interface if the parent activity implements it, or null otherwise.
 * @see org.fog_rock.frextensions.androidx.fragment.FRFragmentCallback
 */
inline fun <reified T: FRFragmentCallback> Fragment.activityCallback(): T? =
    requireActivity() as? T
