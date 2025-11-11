package com.seohyun.sorry // (이건 님 패키지 이름이니 그대로 두세요)

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // "이 앱에서 Hilt를 사용합니다!" 라는 스위치
class MainApplication : Application() {
}