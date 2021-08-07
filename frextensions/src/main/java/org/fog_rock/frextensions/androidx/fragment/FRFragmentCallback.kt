package org.fog_rock.frextensions.androidx.fragment

import androidx.fragment.app.Fragment

/**
 * A callback interface for a fragment to notify its parent activity of an event.
 * @see activityCallback
 */
interface FRFragmentCallback {
    /**
     * Notify that a fragment view is created.
     * @param tag A tag
     * @see Fragment.onCreateView
     */
    fun onCreateFragmentView(tag: String)
}