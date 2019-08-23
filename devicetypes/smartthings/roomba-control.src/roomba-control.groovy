metadata {
	definition (name: "Roomba Control", namespace: "SmartThings", author: "fieldsjm", vid: "generic-contact-4", ocfdevicetype: "oic.d.garagedoor") {
		capability "Actuator"
		capability "Door Control"
        capability "Garage Door Control"
        capability "Momentary"
		capability "Refresh"
		capability "Sensor"
        capability "Switch"
        
        command "start"
        command "pause"
        command "running"
        command "complete"
        command "dock"
	}

	simulator {
		
	}

	tiles {
		standardTile("toggle", "device.door", inactiveLabel: true, width: 3, height: 3) {
			state("closed", label:"Start", action:"door control.open", icon:"st.Electronics.electronics13", backgroundColor:"#8CFC03")
			state("opening", label:"In-Process", icon:"st.Health & Wellness.health7", backgroundColor:"#078bf7")
			state("closing", label:"Paused", action:"door control.close", icon:"st.sonos.pause-btn", backgroundColor:"#FC030F")
			state("open", label:"Dock", icon:"st.presence.house.unlocked", backgroundColor:"#5F07F7")
			
		}
		standardTile("start", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Start", action:"door control.open", icon:"st.Electronics.electronics13"
		}
		standardTile("pause", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"", action:"door control.close", icon:"st.sonos.pause-btn"
		}
        standardTile("dock", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Dock", action:"dock", icon:"st.presence.house.unlocked"
		}

		standardTile("switch", "device.switch", inactiveLabel: false, width: 3, height: 1){
			state("off", label: "", icon: "st.nest.empty", action: "switch.on", backgroundColor: "#ffffff", nextState: "on", defaultState: "true")
			state("on", label: "Complete", action: "switch.off", backgroundColor: "#00a0dc")
		}
		valueTile("Status", "device.longText", width: 3, height: 2) {
			state ("Ready", label: "Ready", icon:"st.Electronics.electronics13", backgroundColor:"#8CFC03")
            state ("Running", label: "Running", icon:"st.Health & Wellness.health7", backgroundColor:"#078bf7")
            state ("Paused", label: "Paused", icon:"st.sonos.pause-btn", backgroundColor:"#FC030F")
            state ("Docking", label: "Docking", icon:"st.presence.house.unlocked", backgroundColor:"#5F07F7")
            state ("Finished", label: "Finished", icon:"st.Electronics.electronics13", backgroundColor:"#8CFC03")
            
		}

		main "Status"
		details(["Status", "start", "pause", "dock"])
	}
}

def parse(String description) {
	log.trace "parse($description)"
}
def installed() {
	sendEvent(name: "longText", value: "Ready")
    sendEvent(name: "switch", value: "off")
    
    }

def start() {
	sendEvent(name: "door", value: "opening")
    sendEvent(name: "longText", value: "Running")
}

def pause() {
    sendEvent(name: "door", value: "closing")
    sendEvent(name: "longText", value: "Paused")
}

def dock() {
    sendEvent(name: "door", value: "closed")
    sendEvent(name: "longText", value: "Docking")
}

def on() {
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "longText", value: "Finished")
}

def off() {
	sendEvent(name: "switch", value: "off")
    sendEvent(name: "longText", value: "Ready")
}