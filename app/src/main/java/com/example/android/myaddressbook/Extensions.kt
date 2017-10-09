package com.example.android.myaddressbook

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Ehitshamshami on 10/10/2017.
 */

internal inline fun EditText.validateWidth(passIcon:Drawable=ContextCompat.getDrawable(context,
        R.drawable.ic_pass), failIcon: Drawable=ContextCompat.getDrawable(context,
R.drawable.ic_fail),validator:(TextView)->Boolean):Boolean
{
    setCompoundDrawablesWithIntrinsicBounds(null, null,
            if (validator(this)) passIcon else failIcon, null)

    return validator(this)
}

