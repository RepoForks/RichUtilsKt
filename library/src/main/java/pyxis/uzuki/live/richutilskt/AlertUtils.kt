package pyxis.uzuki.live.richutilskt

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.text.TextUtils
import android.widget.Toast

/**
 * Created by pyxis on 2017. 5. 30..
 */

class AlertUtils(val ctx: Context)

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()
fun Context.toast(message: Int, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

fun Context.alert(title: String? = "", message: String, positiveButton: String? = null, callback: DialogInterface.() -> Unit = {}) {
    val builder = AlertDialog.Builder(this)
    if (!TextUtils.isEmpty(title))
        builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveButton ?: getString(android.R.string.ok), { dialog, _ -> dialog.callback() })
    builder.setCancelable(true)
    builder.show()
}

fun Context.confirm(title: String? = "", message: String, positiveButton: String? = null, negitiveButton: String? = null, callback: DialogInterface.() -> Unit) {
    val builder = AlertDialog.Builder(this)
    if (!TextUtils.isEmpty(title))
        builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveButton ?: getString(android.R.string.ok), { dialog, _ -> dialog.callback() })
    builder.setNegativeButton(negitiveButton ?: getString(android.R.string.no), { dialog, _ -> run {} })
    builder.setCancelable(true)
    builder.show()
}

fun Context.progress(title: String? = null, message: String) {
    ProgressDialog(this).apply {
        setProgressStyle(ProgressDialog.STYLE_SPINNER)
        setMessage(message)
        if (title != null) setTitle(title)
        show()
    }
}