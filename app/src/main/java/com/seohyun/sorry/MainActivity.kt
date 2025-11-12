package com.seohyun.sorry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import android.util.Log // Log.e 사용을 위한 import
//
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. 껍데기(activity_main.xml)를 화면에 표시
        setContentView(R.layout.activity_main)

        // 2. 화면에 탭 바를 연결하는 함수 호출
        setupBottomNav()
    }

    private fun setupBottomNav() {
        try {
            // 3. '하단 탭 바' 부품을 이름(ID)으로 찾습니다.
            val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

            // 4. '지도 관리자'(NavHostFragment)를 찾습니다.
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_container)

            // 5. 안전 장치: 만약 관리자가 제대로 준비되었다면 연결합니다. (NULL 체크)
            if (navHostFragment is NavHostFragment) {
                val navController = navHostFragment.navController

                // 6. '하단 탭 바'와 '지도 관리자'를 서로 연결!
                bottomNavView.setupWithNavController(navController)
            } else {
                // 이 메시지가 뜨면 XML ID가 잘못되었을 확률이 높습니다.
                Log.e("MainActivity", "ERROR: NavHostFragment not found or is null.")
            }
        } catch (e: Exception) {
            // 알 수 없는 충돌 발생 시 로그를 남깁니다.
            Log.e("MainActivity", "Bottom Nav Setup Crash: ${e.message}")
        }
    }
}