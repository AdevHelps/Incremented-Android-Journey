package com.example.incrementedandroidjourney

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.incrementedandroidjourney.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postNotificationsPermissionRequestCode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ActivityCompat.checkSelfPermission(
                        this@MainActivity,
                        android.Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_DENIED
                ) {

                    requestPostNotificationPermission()
                }
            }

            showNotificationButton.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (ActivityCompat.checkSelfPermission(
                            this@MainActivity,
                            android.Manifest.permission.POST_NOTIFICATIONS
                        ) == PackageManager.PERMISSION_DENIED
                    ) {

                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this@MainActivity,
                            android.Manifest.permission.POST_NOTIFICATIONS
                        )){
                            requestPermission()

                        }else {

                            showAlertDialog(
                                "Please grant the permission from the settings",
                                "OK",
                                {openSetting()},
                                "DISMISS"
                            )
                        }

                    } else {

                        showNotification("Permission state", "Permission already granted")
                    }
                } else {

                    showNotification("Here is your notification", "YO !")
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            postNotificationsPermissionRequestCode -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this@MainActivity,
                            android.Manifest.permission.POST_NOTIFICATIONS
                        )
                    ) {

                        showAlertDialog(
                            "This app cannot work without granting this permission",
                            "GRANT",
                            {requestPostNotificationPermission()},
                            "IGNORE"
                        )
                    }
                }
            }
        }
    }

    private fun requestPostNotificationPermission() {
            requestPermission()

    }

    private fun requestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                postNotificationsPermissionRequestCode
            )
        }
    }

    private fun showAlertDialog(
        message: String,
        positiveButton: String,
        positiveButtonAction:() -> Unit,
        negativeButton: String
    ) {
        MaterialAlertDialogBuilder(this@MainActivity)
            .setMessage(message)
            .setPositiveButton(positiveButton) { _, _ ->

                positiveButtonAction.invoke()

            }
            .setNegativeButton(negativeButton) { dialog, _ ->
                dialog.dismiss()
            }
            .show()

    }

    private fun openSetting() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.setData(uri)
        startActivity(intent)
    }

    private fun showNotification(title: String, text: String) {

        val permissionsNotificationChannelID = "permissions_channel_ID"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    permissionsNotificationChannelID,
                    "Permissions notification channel",
                    NotificationManager.IMPORTANCE_HIGH
                )

                val notificationManager =
                    getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }


        val notificationID = Random.nextInt(1, 300)
        val builder = NotificationCompat.Builder(
            this@MainActivity,
            permissionsNotificationChannelID
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(text)
            .setAutoCancel(true)

        if (ActivityCompat.checkSelfPermission(
                this@MainActivity,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            val notificationManagerCompat =
                NotificationManagerCompat.from(this@MainActivity)
            notificationManagerCompat.notify(notificationID, builder.build())

        }
    }
}