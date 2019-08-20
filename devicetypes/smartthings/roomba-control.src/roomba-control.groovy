metadata {
	definition (name: "Roomba Control", namespace: "SmartThings", author: "fieldsjm", vid: "generic-contact-4", ocfdevicetype: "oic.d.garagedoor") {
		capability "Actuator"
		capability "Door Control"
        capability "Garage Door Control"
		capability "Refresh"
		capability "Sensor"
        
        command "start"
        command "pause"
        command "running"
        command "complete"
	}

	simulator {
		
	}

	tiles {
		standardTile("toggle", "device.door", inactiveLabel: true, width: 3, height: 3) {
			state("closed", label:"Start", action:"door control.open", icon:"st.Electronics.electronics13", backgroundColor:"#8CFC03")
			state("opening", label:"In-Process", icon:"st.Health & Wellness.health7", backgroundColor:"#078bf7")
			state("open", label:"Paused", action:"door control.close", icon:"st.sonos.pause-btn", backgroundColor:"#FC030F")
			state("closing", label:"Complete", icon:"st.nest.nest-leaf", backgroundColor:"#5F07F7")
			
		}
		standardTile("open", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Start", action:"door control.open", icon:"st.Electronics.electronics13"
		}
		standardTile("close", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"", action:"door control.close", icon:"st.sonos.pause-btn"
		}
        standardTile("running", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Running", action:"running", icon:"st.Health & Wellness.health7"
		}
        standardTile("complete", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Complete", action:"complete", icon:"st.nest.nest-leaf"
		}
        standardTile("refresh", "device.alarmStatus", inactiveLabel: false, decoration: "flat") {
        	state "refresh", action:"polling.poll", icon:"st.secondary.refresh"
            }

		main "toggle"
		details(["toggle", "open", "close", "refresh"])
	}
}

def parse(String description) {
	log.trace "parse($description)"
}

def open() {
	sendEvent(name: "door", value: "opening")
}

def close() {
    sendEvent(name: "door", value: "closing")
}

def running() {
    sendEvent(name: "door", value: "open")
}

def complete() {
    sendEvent(name: "door", value: "closed")
}