package com.example.kmmproject01.utils

import com.example.kmmproject01.resources.TextResource

abstract class CallToAction {
    class Email(
        val address: TextResource,
        val subject: TextResource,
    ):CallToAction()

    class Call(
        val number: TextResource,
    ):CallToAction()

}