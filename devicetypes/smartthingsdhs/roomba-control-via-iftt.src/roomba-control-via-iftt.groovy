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
 
preferences {
	section("WebHook Command Input"){
		input "start_command", "text", title: "Start Command", required: false
		input "pause_command", "text", title: "Pause Command", required: false
        input "stop_command", "text", title: "Stop Command", required: false
        input "dock_command", "text", title: "Dock Command", required: false
        input "key", "password", title: "iFTT Maker Key", required: true
	}
}

metadata {
    definition (name: "Roomba Control via iFTT", namespace: "SmartThingsDHs", author: "fieldsjm", mnmn: "SmartThings", vid: "generic-sensor") {
        capability "Actuator"
        capability "Alarm"
        capability "Button"
        capability "Lock"
        capability "Sensor"
        capability "Switch"
        capability "motionSensor"
        capability "Health Check"

        command "push1"
        command "push2"
        command "push3"
        command "push4"
        command "push5"
    }

    simulator {
    }
    
    tiles (scale: 2){
	/*Status tile based on intended action*/
	multiAttributeTile(name:"status", type: "generic", width: 6, height: 4){
    	tileAttribute ("device.status", key: "PRIMARY_CONTROL") {
			attributeState ("Ready", label: "Ready", icon:"st.samsung.da.RC_ic_rc", backgroundColor:"#8CFC03")
			attributeState ("Running", label: "In-Process", icon:"st.Health & Wellness.health7", backgroundColor:"#078bf7")
			attributeState ("Paused", label: "Paused", icon:"http://cdn.device-icons.smartthings.com/sonos/pause-icon@2x.png", backgroundColor:"#FC030F")
			attributeState ("Docking", label: "Docking", icon:"st.presence.house.unlocked", backgroundColor:"#5F07F7")
			attributeState ("Docked", label: "Docked", icon:"st.presence.house.secured", backgroundColor:"#5F07F7")
			attributeState ("Stopped", label: "Stopped", icon:"https://raw.githubusercontent.com/fieldsjm/Resources/master/stop.png", backgroundColor:"#FC030F")
			attributeState ("Ended", label: "Complete", icon:"st.samsung.da.RC_ic_rc", backgroundColor:"#8CFC03")
			attributeState ("Error", label: "Error", icon:"https://raw.githubusercontent.com/fieldsjm/Resources/master/warning.png", backgroundColor:"#FC030F")
		}
        tileAttribute("device.motion", key: "SECONDARY_CONTROL") {
        	attributeState ("active", label: "Cleaning")
			attributeState ("inactive", label: "Docked")
        }
	}
	   /*Start*/
        standardTile("push1", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "Start", icon:"st.samsung.da.RC_ic_rc", backgroundColor: "#ffffff", action: "push1"
        }
        /*Pause*/
        standardTile("push2", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "", icon:"st.sonos.pause-btn", backgroundColor: "#ffffff", action: "push2"
            }
        /*Dock*/
        standardTile("push3", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "Dock", icon:"st.nest.nest-home", backgroundColor: "#ffffff", action: "push3"
        }
        /*Stop*/
        standardTile("push4", "device.button", width: 3, height: 2, decoration: "flat") {
            state "default", label: "", icon:"st.sonos.stop-btn", backgroundColor: "#ffffff", action: "push4"
        }
        /*Reset*/
        standardTile("push5", "device.button", width: 6, height: 2, decoration: "flat") {
            state "default", label: "Reset", icon:"st.secondary.refresh-icon", backgroundColor: "#ffffff", action: "push5"
        }
        /*Switch for IFTT feedback of Started - Hidden by default*/
        standardTile("switch", "device.switch", inactiveLabel: false, width: 6, height: 2, decoration: "flat"){
			state("off", label: "Ready", action: "switch.on", backgroundColor: "#ffffff", nextState: "on", defaultState: "true")
			state("on", label: "Cleaning", action: "switch.off", backgroundColor: "#00a0dc", nextState: "off")
		}
        /*Alarm for IFTT feedback of Error - Hidden by default*/
        standardTile("alarm", "device.alarm", inactiveLabel: false, width: 6, height: 2, decoration: "flat") {
			state("off", label:"Ready / Pending", action:'alarm.strobe', icon:"st.alarm.alarm.alarm", backgroundColor:"#ffffff", nextState: "strobe", defaultState: "true")
			state("strobe", label:"Error", action:'alarm.off', icon:"st.alarm.alarm.alarm", backgroundColor:"#e86d13", nextState: "off")
		}
        /*Lock for IFTT feedback of mission complete - Hidden by default*/
		standardTile("lock", "device.lock", inactiveLabel: false, width: 6, height: 2, decoration: "flat"){
			state("unlocked", label: "Ready / Pending", action: "lock.lock", backgroundColor: "#ffffff", nextState: "locked", defaultState: "true")
			state("locked", label: "Mission Complete", action: "lock.unlock", backgroundColor: "#00a0dc", nextState: "unlocked")
		}
        
        main "status"
        details(["status","push1","push2","push3","push4","push5", "switch","alarm","lock"])
    }
}

def parse(String description) {

}

/*Start - Sends iFTT Webhook - if Roomba starts successfully, iFTT will turn on switch*/
def push1() {
	push(1)
    
    	def cmd = "https://maker.ifttt.com/trigger/${settings.start_command}/with/key/${settings.key}";

		log.debug "Sending request cmd[${cmd}]"

			httpGet(cmd) {resp ->
				if (resp.data) {
					log.info "${resp.data}"
				} 
			}
	sendHubCommand(result)
	log.debug "Executing push1" 
	log.debug result
}

/*Pause - Sends iFTT Webhook - no feedback available*/
def push2() {
	push(2)
    sendEvent(name: "status", value: "Paused")
    sendEvent(name: "motion", value: "active")
    
    	def cmd = "https://maker.ifttt.com/trigger/${settings.pause_command}/with/key/${settings.key}";

		log.debug "Sending request cmd[${cmd}]"

			httpGet(cmd) {resp ->
				if (resp.data) {
					log.info "${resp.data}"
				} 
			}
	sendHubCommand(result)
	log.debug "Executing push1" 
	log.debug result
}

/*Dock - Sends iFTT Webhook - minimal feedback available, once docked iFTT will also send docking mission complete (fail safe of conversational delay to Docked then Ready Status)*/
def push3() {
    push(3)
    sendEvent(name: "status", value: "Docking")
    sendEvent(name: "motion", value: "active")
    runIn(60, docked)
    
    	def cmd = "https://maker.ifttt.com/trigger/${settings.dock_command}/with/key/${settings.key}";

		log.debug "Sending request cmd[${cmd}]"

			httpGet(cmd) {resp ->
				if (resp.data) {
					log.info "${resp.data}"
				} 
			}
	sendHubCommand(result)
	log.debug "Executing push1" 
	log.debug result
}
def docked() {
	sendEvent(name: "status", value: "Docked")
    sendEvent(name: "motion", value: "inactive")
    runIn(10, push5)
}

/*Stop - Sends iFTT Webhook - no feedback available*/
def push4() {
    push(4)
    sendEvent(name: "status", value: "Stopped")
    sendEvent(name: "motion", value: "active")
    
    	def cmd = "https://maker.ifttt.com/trigger/${settings.stop_command}/with/key/${settings.key}";

		log.debug "Sending request cmd[${cmd}]"

			httpGet(cmd) {resp ->
				if (resp.data) {
					log.info "${resp.data}"
				} 
			}
	sendHubCommand(result)
	log.debug "Executing push1" 
	log.debug result
}

/*Status Reset*/
def push5() {
    push(5)
	unlock()
    off()    
    sendEvent(name: "status", value: "Ready")
    sendEvent(name: "motion", value: "inactive")
}

private push(button) {
    log.debug "$device.displayName button $button was pushed"
    sendEvent(name: "button", value: "pushed", data: [buttonNumber: button], descriptionText: "$device.displayName button $button was pushed", isStateChange: true)
}

/*Feedback Mechanisms*/
/*Started - iFTT turns on if Roomba starts successfully*/
def on(){
	sendEvent(name: "switch", value: "on")
    sendEvent(name: "status", value: "Running")
    sendEvent(name: "motion", value: "active")
    log.debug "$device.displayName (iFTT) has reported starting"
    }
def off(){    
    sendEvent(name: "switch", value: "off")
    sendEvent(name: "alarm", value: "off")
    sendEvent(name: "status", value: "Ready")
    sendEvent(name: "motion", value: "inactive")
    }
/*Misson Complete - iFTT turns on if Roomba completes task*/
def lock() {
    sendEvent(name: "lock", value: "locked")
    sendEvent(name: "status", value: "Ended")
    sendEvent(name: "motion", value: "inactive")
    log.debug "$device.displayName (iFTT) has reported misson complete"
	}
def unlock() {
    sendEvent(name: "lock", value: "unlocked")
    sendEvent(name: "status", value: "Ready")
    sendEvent(name: "motion", value: "inactive")
	}
/*Error - iFTT turns on if Roomba encounters an error (stuck, low battery, etc)*/
def strobe() {
	sendEvent(name: "alarm", value: "strobe")
    sendEvent(name: "status", value: "Error")
    sendEvent(name: "motion", value: "active")
    log.debug "$device.displayName (iFTT) has reported an error"
    }

def installed() {
    initialize()
}

def updated() {
    initialize()
}

def initialize() {
    sendEvent(name: "numberOfButtons", value: 5)
    sendEvent(name: "status", value: "Ready")
    sendEvent(name: "motion", value: "inactive")
    sendEvent(name: "healthStatus", value: "online")
}