/**
 *  Copyright 2015 SmartThings
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
    definition (name: "Roomba Control v2", namespace: "SmartThingsDHs", author: "fieldsjm", mnmn: "SmartThings", vid: "generic.switch") {
        capability "Actuator"
        capability "Button"
        capability "Holdable Button"
        capability "Configuration"
        capability "Lock"
        capability "Sensor"
        capability "Switch"
        capability "Health Check"

        command "push1"
        command "push2"
        command "push3"
        command "push4"
        command "hold1"
        command "hold2"
        command "hold3"
        command "hold4"
    }

    simulator {
        status "button 1 pushed":  "command: 2001, payload: 01"
        status "button 1 held":  "command: 2001, payload: 15"
        status "button 2 pushed":  "command: 2001, payload: 29"
        status "button 2 held":  "command: 2001, payload: 3D"
        status "button 3 pushed":  "command: 2001, payload: 51"
        status "button 3 held":  "command: 2001, payload: 65"
        status "button 4 pushed":  "command: 2001, payload: 79"
        status "button 4 held":  "command: 2001, payload: 8D"
        status "wakeup":  "command: 8407, payload: "
    }
    tiles (scale: 2){
	/*Status tile based on intended action*/
	valueTile("Status", "device.longText", width: 6, height: 4) {
		state ("Ready", label: "Ready", icon:"st.Electronics.electronics13", backgroundColor:"#8CFC03")
		state ("Running", label: "Running", icon:"st.Health & Wellness.health7", backgroundColor:"#078bf7")
		state ("Paused", label: "Paused", icon:"http://cdn.device-icons.smartthings.com/sonos/pause-icon@2x.png", backgroundColor:"#FC030F")
		state ("Docking", label: "Docking", icon:"st.presence.house.unlocked", backgroundColor:"#5F07F7")
		state ("Docked", label: "Docked", icon:"st.presence.house.secured", backgroundColor:"#5F07F7")
		state ("Ended", label: "Job Complete", icon:"st.Electronics.electronics13", backgroundColor:"#8CFC03")
        state ("Error", label: "Error", icon:"https://github.com/fieldsjm/Resources/blob/master/warning.png?raw=true", backgroundColor:"#FC030F")
            
		}
	standardTile("button", "device.button") {
            state "default", label: "", icon: "", backgroundColor: "#ffffff"
        }
        /*Start*/
        standardTile("push1", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "Start", icon:"st.Electronics.electronics13", backgroundColor: "#ffffff", action: "push1"
        }
        /*Pause*/
        standardTile("push2", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "Pause", icon:"http://cdn.device-icons.smartthings.com/sonos/pause-icon@2x.png", backgroundColor: "#ffffff", action: "push2"
        }
        /*Dock*/
        standardTile("push3", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "Dock", icon:"st.nest.nest-home", backgroundColor: "#ffffff", action: "push3"
        }
        /*Reset*/
        standardTile("push4", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "Reset", icon:"st.secondary.refresh-icon", backgroundColor: "#ffffff", action: "push4"
        }
        /*Hidden switch for IFTT feedback of error*/
		standardTile("switch", "device.switch", inactiveLabel: false, width: 3, height: 1, decoration: "flat"){
			state("off", label: '${name}', action: "switch.on", backgroundColor: "#ffffff", nextState: "on", defaultState: "true")
			state("on", label: '${name}', action: "switch.off", backgroundColor: "#00a0dc", nextState: "off")
		}
        /*Hidden lock for IFTT feedback of mission complete*/
		standardTile("lock", "device.lock", inactiveLabel: false, width: 3, height: 1, decoration: "flat"){
			state("unlocked", label: '${name}', action: "lock.lock", backgroundColor: "#ffffff", nextState: "locked", defaultState: "true")
			state("locked", label: '${name}', action: "lock.unlock", backgroundColor: "#00a0dc", nextState: "unlocked")
		}
        
        main "Status"
        details(["Status","push1","push2","push3","push4"])
    }
}

def parse(String description) {

}

/*Start*/
def push1() {
    push(1)
	sendEvent(name: "longText", value: "Running")
}

/*Pause*/
def push2() {
    push(2)
    sendEvent(name: "longText", value: "Paused")
}

/*Dock*/
def push3() {
    push(3)
    sendEvent(name: "longText", value: "Docking")
    runin(60, docked)
}
def docked() {
	sendEvent(name: "longText", value: "Docked")
    runin(10, push4)
}

/*Reset*/
def push4() {
    push(4)
    sendEvent(name: "longText", value: "Ready")
}

private push(button) {
    log.debug "$device.displayName button $button was pushed"
    sendEvent(name: "button", value: "pushed", data: [buttonNumber: button], descriptionText: "$device.displayName button $button was pushed", isStateChange: true)
}

/*Misson Complete*/
def lock() {
    sendEvent(name: "lock", value: "locked")
    sendEvent(name: "longText", value: "Ended")
    
}

def unlock() {
    sendEvent(name: "lock", value: "unlocked")
    sendEvent(name: "longText", value: "Ready")
}

/*Error*/
def on(){
	sendEvent(name: "on", value: "switch")
    sendEvent(name: "longText", value: "Error")
    }
    
def off(){    
    sendEvent(name: "off", value: "switch")
    sendEvent(name: "longText", value: "Ready")
    }

def installed() {
    initialize()
}

def updated() {
    initialize()
}

def initialize() {
    sendEvent(name: "numberOfButtons", value: 4)
    sendEvent(name: "longText", value: "Ready")

    sendEvent(name: "DeviceWatch-DeviceStatus", value: "online")
    sendEvent(name: "healthStatus", value: "online")
    sendEvent(name: "DeviceWatch-Enroll", value: [protocol: "cloud", scheme:"untracked"].encodeAsJson(), displayed: false)
}