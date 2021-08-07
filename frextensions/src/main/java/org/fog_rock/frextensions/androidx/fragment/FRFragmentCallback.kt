package org.fog_rock.frextensions.androidx.fragment

import androidx.fragment.app.Fragment

/**
 * A callback interface for a fragment to notify its parent activity of an event.
 * @see org.fog_rock.frextensions.androidx.fragment.activityCallback
 */
interface FRFragmentCallback {
    /**
     * Notify that a fragment view is created.
     * @param tag A class tag
     * @see Fragment.onCreateView
     * @see org.fog_rock.frextensions.androidx.log.TAG
     */
    fun onCreateFragmentView(tag: String)
}