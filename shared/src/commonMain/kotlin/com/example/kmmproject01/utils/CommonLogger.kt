package com.example.kmmproject01.utils

// 1) Como criar um logger comum customizado em KMM
// 2) Como implementar expect/actual em cada plataforma
// 3) Como dispobilizar a classe IMPL
// 4) Como usar na prática dentro do ViewModel
expect interface CommonLogger {
    open fun log(message: String, type: LogType)
}