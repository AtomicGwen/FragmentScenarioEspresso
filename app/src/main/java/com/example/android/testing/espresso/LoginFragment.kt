package com.example.android.testing.espresso

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.testing.espresso.fragmentscenario.R
import kotlinx.android.synthetic.main.fragment_sample.*
import java.io.*




class LoginFragment : Fragment() {

    var viewmodel: LoginViewModel = LoginViewModel()

//    companion object Factory{
//        fun getInstanceWith(viewModel: LoginViewModel): LoginFragment{
//            val instance = LoginFragment()
//            instance.viewmodel = viewModel
//            return instance
//        }
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.android.testing.espresso.fragmentscenario.R.layout.fragment_sample, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginButton.isEnabled = true

        loginButton.setOnClickListener{v ->
            logIn()
        }
    }

    fun logIn () {
        loginButton.isEnabled = false
        //someIO()
        viewmodel.logIn()

        val intent = Intent(context, GitActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun someIO () {
        // Commented out code
        // System.out.println("Hello")
        // System.out.println("World")

        val path = context?.filesDir
        val file = File(path, "File.txt")

        file.appendText("Text here")
//        File("File.txt").useLines { lines -> lines.forEach { }}

        try {
            var inputStream = context?.openFileInput("File.txt")
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val receiveString = bufferedReader.readLine()

            inputStream?.close();
        } catch (e: FileNotFoundException) {
            // I am error
        } catch (e: IOException) {
            // I am error
        }
    }
}
