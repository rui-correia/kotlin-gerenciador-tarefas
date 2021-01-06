package br.com.braz.rui

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.braz.rui")
		.start()
}

