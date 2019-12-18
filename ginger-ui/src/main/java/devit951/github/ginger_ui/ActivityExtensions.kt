package devit951.github.ginger_ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

fun FragmentActivity.fragmentTransaction(transaction: FragmentTransaction.() -> FragmentTransaction){
    supportFragmentManager.beginTransaction().transaction().commit()
}

fun FragmentActivity.replaceFragment(containerId: Int, fragment: Fragment, tag: String = ""){
    fragmentTransaction {
        replace(containerId, fragment, tag)
    }
}

fun FragmentActivity.addFragment(containerId: Int, fragment: Fragment, tag: String = ""){
    fragmentTransaction {
        add(containerId, fragment, tag)
    }
}