#!/usr/bin/env groovy
import groovy.json.*

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    println("Bonjour ${config.nom} !")
    println("Message : ${config.message}")
}
