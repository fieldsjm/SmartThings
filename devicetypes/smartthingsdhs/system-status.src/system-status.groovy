/**
 *  Copyright 2016 SmartThings, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
	definition (
		name: "System Status",
		namespace: "SmartThingsDHs",
		author: "fieldsjm") {

		capability "Actuator"
        capability "Button"
        capability "Configuration"
        capability "Sensor"
        capability "Health Check"
         
        attribute "Value1","string"
    	attribute "Value2","string"
    	attribute "Value3","string"
		attribute "Value4","string"
		attribute "Value5","string"
		attribute "Value6","string"
		attribute "Value7","string"
		attribute "Value8","string"
		attribute "Value9","string"
		attribute "Value10","string"
		attribute "Value11","string"
		attribute "Value12","string"
		attribute "Value13","string"
        attribute "Value14","string"
        attribute "Value15","string"
        attribute "Value16","string"
        attribute "Value17","string"
        attribute "Value18","string"
        attribute "Value19","string"
        attribute "Value20","string"
        attribute "Value21","string"
        attribute "Value22","string"
    
    	command "push1"
        command "changeValue1"
        command "changeValue2"
        command "changeValue3"
		command "changeValue4"
		command "changeValue5"
		command "changeValue6"
		command "changeValue7"
		command "changeValue8"
		command "changeValue9"
		command "changeValue10"
		command "changeValue11"
		command "changeValue12"
		command "changeValue13"
		command "changeValue14"
		command "changeValue15"
        command "changeValue16"
        command "changeValue17"
        command "changeValue18"
        command "changeValue19"
        command "changeValue20"
        command "changeValue21"
        command "changeValue22"        
	}
    
	tiles (scale:2){
        standardTile("button1", "device.button1", width: 2, height: 2, decoration: "flat") {
			state("default", label: 'Check\nNow', action: "push1", backgroundColor: "#C2C5CC")
    	}
        valueTile("Value1", "device.Value1", width: 4, height: 2){
            state("default", label:'${currentValue}')}
        valueTile("Value2", "device.Value2", width: 6, height: 2){
            state("default", label:'${currentValue}')}
        valueTile("Value3", "device.Value3", width: 6, height: 2){
            state("default", label:'${currentValue}')}   
		
        valueTile("battHeader", "device.header1", width: 5, height: 1){
            state("default", label:'Battery levels are:')}
		valueTile("Value4", "device.Value4", width: 1, height: 1){
            state("default", label:'', backgroundColors: getBattColors())}
        valueTile("Value5", "device.Value5", width: 2, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("Value6", "device.Value6", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}
        valueTile("Value7", "device.Value7", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value8", "device.Value8", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}
        valueTile("Value9", "device.Value9", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value10", "device.Value10", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}
        valueTile("Value11", "device.Value11", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value12", "device.Value12", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}
        valueTile("Value13", "device.Value13", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value14", "device.Value14", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}
        valueTile("Value15", "device.Value15", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value16", "device.Value16", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}  
        valueTile("Value17", "device.Value17", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value18", "device.Value18", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}  
        valueTile("Value19", "device.Value19", width: 2, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("Value20", "device.Value20", width: 1, height: 1){
            state("default", label:'${currentValue}%', backgroundColors: getBattColors())}  
            
 		main(["button1"])
 		details(["button1","Value1","Value2","Value3","battHeader","Value4","Value5","Value6","Value7","Value8","Value9","Value10","Value11","Value12","Value13","Value14","Value15","Value16","Value17","Value18","Value19","Value20"])
 	}
 }

def installed() {
    initialize()
}

def updated() {
    initialize()
}

def initialize(){
    push1()
}
def parse(String description) {
}
def getBattColors() {
	def colorMap

	colorMap = [
		[value: 0, color: "#FF0000"],
		[value: 40, color: "#FFFF00"],
		[value: 100, color: "#008000"]
	]
    return colorMap
}
 def changeValue1 (param1) {
    sendEvent("name":"Value1", "value":param1)
	}
 def changeValue2 (param2) {
    sendEvent("name":"Value2", "value":param2)
	}
def changeValue3 (param3) {
	sendEvent("name":"Value3", "value":param3)
    }
def changeValue4 (param4) {
	sendEvent("name":"Value4", "value":param4)
    }
def changeValue5 (param5) {
	sendEvent("name":"Value5", "value":param5)
    }
def changeValue6 (param6) {
	sendEvent("name":"Value6", "value":param6)
    }
def changeValue7 (param7) {
	sendEvent("name":"Value7", "value":param7)
    }
def changeValue8 (param8) {
	sendEvent("name":"Value8", "value":param8)
    }
def changeValue9 (param9) {
	sendEvent("name":"Value9", "value":param9)
    }
def changeValue10 (param10) {
	sendEvent("name":"Value10", "value":param10)
    }
def changeValue11 (param11) {
	sendEvent("name":"Value11", "value":param11)
    }
def changeValue12 (param12) {
	sendEvent("name":"Value12", "value":param12)
    }
def changeValue13 (param13) {
	sendEvent("name":"Value13", "value":param13)
    }
def changeValue14 (param14) {
	sendEvent("name":"Value14", "value":param14)
    }
def changeValue15 (param15) {
	sendEvent("name":"Value15", "value":param15)
    }
def changeValue16 (param16) {
	sendEvent("name":"Value16", "value":param16)
    }
def changeValue17 (param17) {
	sendEvent("name":"Value17", "value":param17)
    }
def changeValue18 (param18) {
	sendEvent("name":"Value18", "value":param18)
    }
def changeValue19 (param19) {
	sendEvent("name":"Value19", "value":param19)
    }
def changeValue20 (param20) {
	sendEvent("name":"Value20", "value":param20)
    }

def push1() {
	push(1)
}

private push(button) {
    log.debug "$device.displayName button $button was pushed"
    sendEvent(name: "button", value: "pushed", data: [buttonNumber: button], descriptionText: "$device.displayName button $button was pushed", isStateChange: true)
}