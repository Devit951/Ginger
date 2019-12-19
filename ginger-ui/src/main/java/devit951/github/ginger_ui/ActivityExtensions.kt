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

fun <T: Fragment> FragmentActivity.savedFragment(containerId: Int, tag: String, fragmentToSave: () -> T): T{
    val savedFragment = supportFragmentManager.findFragmentByTag(tag)
    return if (savedFragment == null){
        val fragment = fragmentToSave.invoke()
        addFragment(containerId, fragment, tag)
        fragment
    } else {
        savedFragment as T
    }
}

fun FragmentActivity.autoHideShowFragment(fragment: Fragment){
    supportFragmentManager.fragments.forEach {
        fragmentTransaction {
            hide(it)
        }
    }
    fragmentTransaction { show(fragment) }
}