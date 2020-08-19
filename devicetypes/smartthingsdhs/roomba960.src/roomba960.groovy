/**
*  iRobot Roomba v2.2
*. 900/i7 series - Virtual Switch
*
*  Copyright 2016 Steve-Gregory
*  Modified by Adrian Caramaliu to add support for v2 local API
*  Modified by Justin Dybedahl to fix local API polling, fix tile actions, and add battery low state reporting
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

/*Known NotReady states*/
def getRoombaStates() {
    def ROOMBA_READY = 0
    def ROOMBA_STUCK = 1
    def ROOMBA_BIN_FULL = 16
    def ROOMBA_DEBRIS_EXTRACTOR = 6
    def ROOMBA_NOT_UPRIGHT = 7
    def ROOMBA_IN_THE_DARK = 8
    def ROOMBA_BATTERYLOW = 15
    def ROOMBA_STATES = ['ready': ROOMBA_READY, 'stuck': ROOMBA_STUCK, 'full': ROOMBA_BIN_FULL, 'tilted': ROOMBA_NOT_UPRIGHT, 'dark': ROOMBA_IN_THE_DARK, 'batterylow': ROOMBA_BATTERYLOW, 'debrisextractors': ROOMBA_DEBRIS_EXTRACTOR]
    return ROOMBA_STATES
}
metadata {
    definition (name: "Roomba960", namespace: "SmartThingsDHs", author: "Steve Gregory, Adrian Caramaliu, and Justin Dybedahl") {
        capability "Battery"
        capability "Switch"
        capability "Refresh"
        capability "Polling"
        capability "Consumable"
        capability "Timed Session"
        capability "Configuration"

        command "dock"
        command "resume"
        command "pause"
        command "cancel"
        command "pauseAndDock"

        attribute "runtimeMins", "number"
        attribute "totalJobs", "number"
        attribute "totalJobHrs", "number"
        attribute "headline", "string"
        attribute "robotName", "string"
        attribute "preferences_set", "string"
        attribute "status", "string"
        //For ETA heuristic
        attribute "lastSqft", "number"
        attribute "lastRuntime", "number"
        attribute "lastDate", "string"
    }
}
// simulator metadata
simulator {
}
//Preferences
preferences {
    section("Cloud Roomba API Type") {
        input "localAPI", "bool", title: "Use a local REST gateway for Roomba", description: "You must installed a local REST gateway for Roomba and provide the IP of that gateway", displayDuringSetup: true
    }
    section("Roomba Local Settings") {
    	input type: "paragraph", title: "Fill these parameters if using a local REST gateway"
        input "roomba_host", "string", title:"IP of Roomba local REST Gateway", displayDuringSetup: true
        input "roomba_port", "number", range: "1..65535", defaultValue: 3000, title:"Port of Roomba local REST Gateway", displayDuringSetup: true
    }
    section("Misc.") {
        input type: "paragraph", title: "Polling Interval [minutes]", description: "This feature allows you to change the frequency of polling for the robot in minutes (1-59)"
        input "pollInterval", "number", title: "Polling Interval", description: "Change polling frequency (in minutes)", defaultValue:4, range: "1..59", required: true, displayDuringSetup: true
    }
}
// UI tile definitions
tiles {
    multiAttributeTile(name:"CLEAN", type:"generic", width: 6, height: 4, canChangeIcon: false) {
        tileAttribute("device.status", key: "PRIMARY_CONTROL") {
            attributeState "error", label: 'Error', icon:"https://raw.githubusercontent.com/fieldsjm/Resources/master/warning.png", backgroundColor:"#FC030F"
            attributeState "bin-full", label: 'Bin Full', icon:"https://raw.githubusercontent.com/fieldsjm/Resources/master/warning.png", backgroundColor:"#FC030F"
            attributeState "docked", label: 'Start Clean', action: "switch.on", icon:"st.samsung.da.RC_ic_rc", backgroundColor:"#8CFC03", nextState: "starting"
            attributeState "docking", label: 'Docking', icon:"st.presence.house.unlocked", backgroundColor:"#5F07F7"
            attributeState "starting", label: 'Starting Clean', icon:"st.samsung.da.RC_ic_rc", backgroundColor:"#8CFC03"
            attributeState "cleaning", label: 'Push To Stop', action: "stop", icon:"", backgroundColor:"#FC030F", nextState: "pausing"
            attributeState "pausing", label: 'Stopping', icon:"", backgroundColor:"#FC030F"
            attributeState "paused", label: 'Send Home', action: "switch.off", icon:"st.nest.nest-home", backgroundColor:"#5F07F7", nextState: "docking"
            attributeState "resuming", label: 'Stop Clean', icon:"https://raw.githubusercontent.com/fieldsjm/Resources/master/stop.png", backgroundColor:"#FC030F"
        }
        tileAttribute("device.headline", key: "SECONDARY_CONTROL") {
           attributeState "default", label:'${currentValue}'
        }
    }
    valueTile("DOCK", "device.status", width: 2, height: 2) {
        state "docked", label: 'Docked', backgroundColor: "#79b821"
        state "docking", label: 'Docking', backgroundColor: "#ffa81e"
        state "starting", label: 'UnDocking', backgroundColor: "#ffa81e"
        state "cleaning", label: 'Not on Dock', backgroundColor: "#ffffff", nextState: "docking", action: "dock"
        state "pausing", label: 'Not on Dock', backgroundColor: "#ffffff", nextState: "docking", action: "dock"
        state "paused", label: 'Dock', backgroundColor: "#ffffff", nextState: "docking", action: "dock"
        state "bin-full", label: 'Bin full', backgroundColor: "#bc2323", nextState: "docking", action: "dock"
        state "resuming", label: 'Not on Dock', backgroundColor: "#ffffff", defaultState: true, nextState: "docking", action: "dock"
    }
    valueTile("PAUSE", "device.status", width: 2, height: 2) {
        state "docked", label: 'Pause', backgroundColor: "#ffffff", defaultState: true
        state "docking", label: 'Pause', backgroundColor: "#ffffff"
        state "starting", label: 'Pause', backgroundColor: "#ffffff", nextState: "pausing", action: "pause"
        state "cleaning", label: 'Pause', backgroundColor: "#ffffff", nextState: "pausing", action: "pause"
        state "pausing", label: 'Pausing..', backgroundColor: "#79b821"
        state "paused", label: 'Paused', backgroundColor: "#79b821"
        state "bin-full", label: 'Bin full', backgroundColor: "#bc2323"
        state "resuming", label: 'Pause', backgroundColor: "#ffffff", nextState: "pausing", action: "pause"
    }
    valueTile("RESUME", "device.status", width: 2, height: 2) {
        state "docked", label: 'Resume', backgroundColor: "#ffffff", defaultState: true
        state "docking", label: 'Resume', backgroundColor: "#ffffff"
        state "starting", label: 'Resume', backgroundColor: "#ffffff"
        state "cleaning", label: 'Resume', backgroundColor: "#ffffff"
        state "pausing", label: 'Resume', backgroundColor: "#79b821", nextState: "resuming", action: "switch.on"
        state "paused", label: 'Resume', backgroundColor: "#ffffff", nextState: "resuming", action: "switch.on"
        state "bin-full", label: 'Bin full', backgroundColor: "#bc2323"
        state "resuming", label: 'Resuming..', backgroundColor: "#79b821"
    }
    standardTile("refresh", "device.status", width: 2, height: 2, decoration: "flat") {
        state "default", label:'', action:"refresh.refresh", icon:"st.secondary.refresh"
    }
    valueTile("battery", "device.battery", width: 2, height: 2, decoration: "flat") {
        state "default", label:'Battery ${currentValue}%', backgroundColors:[
            [value: 5, color: "#FF0000"],
            [value: 15, color: "#FF7F00"],
            [value: 25, color: "#FEFF00"],
            [value: 75, color: "#7FFF00"],
            [value: 100, color: "#00FF00"]
        ]
    }
    valueTile("consumable", "device.consumable", width: 2, height: 2, decoration: "flat") {
        state "default", label:'Bin:\n${currentValue}'
    }
   	valueTile("job_count", "device.totalJobs", width: 3, height: 1, decoration: "flat") {
        state "default", label:'Number of Cleaning Jobs:\n${currentValue} jobs'
    }
    valueTile("job_hr_count", "device.totalJobHrs", width: 3, height: 1, decoration: "flat") {
        state "default", label:'Total Job Time:\n${currentValue} hours'
    }
    valueTile("current_job_time", "device.runtimeMins", width: 3, height: 1, decoration: "flat") {
        state "default", label:'Current Job Runtime:\n${currentValue} minutes'
    }
    valueTile("current_job_sqft", "device.runtimeSqft", width: 3, height: 1, decoration: "flat") {
        state "default", label:'Current Job Sqft:\n${currentValue} ft'
    }

    main "CLEAN"
    details(["STATUS",
             "CLEAN", "DOCK", "PAUSE", "RESUME",
             "refresh",
             "battery",
             "consumable",
             "current_job_time",
             "current_job_sqft",
             "job_hr_count", "job_count"
             ])
}
// Settings updated
def updated() {
    //log.debug "Updated settings ${settings}..
    runIn(3, "updateDeviceNetworkID")
    schedule("0 0/${settings.pollInterval} * * * ?", poll)  // 4min polling is normal for irobots
    //poll()
}
// Configuration
def configure() {
    log.debug "Configuring.."
    poll()
}

//Consumable
def setConsumableStatus(statusString) {
    log.debug "User requested setting the Consumable Status - ${statusString}"
    def status = device.latestValue("status")
    log.debug "Setting value based on last roomba state - ${status}"

    if(bin_full == true) {
        state.consumable = "Full"
    } else if(bin_present == false){
        state.consumable = "Missing"
    } else {
        state.consumable = "Empty"
    }
    return state.consumable
}
//Refresh
def refresh() {
    log.debug "Executing 'refresh'"
    return poll
}
//Polling
def poll() {
    log.debug "Polling for status ----"
    sendEvent(name: "headline", value: "Polling status API", displayed: false)
    state.RoombaCmd = "getStatus"
    local_poll()
}
// Switch methods
def on() {
    // Always start roomba
    def status = device.latestValue("status")
    log.debug "On based on state - ${status}"
    if(status == "paused") {
	    return resume()
    } else {
	    return start()
    }
}
def off() {
    // Always return to dock..

    def status = device.latestValue("status")
    log.debug "Off based on state - ${status}"
    if(status == "paused") {
    	return dock()
    } else {
	    return pauseAndDock()
    }
}
// Timed Session
def start() {
    sendEvent(name: "status", value: "starting")
    state.RoombaCmd = "start"
    runIn(15, poll)
    local_start()
}
def stop() {
    sendEvent(name: "status", value: "stopping")
    state.RoombaCmd = "stop"
    runIn(15, poll)
    local_stop()
}
def pauseAndDock() {
    sendEvent(name: "status", value: "pausing")
    state.RoombaCmd = "pause"
    local_pauseAndDock()
}
def pause() {
    sendEvent(name: "status", value: "pausing")
    state.RoombaCmd = "pause"
    runIn(15, poll)
    local_pause()
}
def cancel() {
	return off()
}

// Actions
def dock() {
    sendEvent(name: "status", value: "docking")
    state.RoombaCmd = "dock"
    runIn(15, poll)
    local_dock()
}
def resume() {
    sendEvent(name: "status", value: "resuming")
    state.RoombaCmd = "resume"
    runIn(15, poll)
    local_resume()
}
// API methods
def parse(description) {
	log.trace "GOT HERE"
    def msg = parseLanMessage(description)
    log.trace "GOT MSG $msg"
    def headersAsString = msg.header // => headers as a string
    def headerMap = msg.headers      // => headers as a Map
    def body = msg.body              // => request body as a string
    def status = msg.status          // => http status code of the response
    def json = msg.json              // => any JSON included in response body, as a data structure of lists and maps
    def xml = msg.xml                // => any XML included in response body, as a document tree structure
    def data = msg.data              // => either JSON or XML in response body (whichever is specified by content-type header in response)
}

def parseResponseByCmd(resp, command) {
    def data = resp.data
    if(command == "getStatus") {
        setStatus(data)
    } else if(command == "accumulatedHistorical" ) {
        /*readSummaryInfo -- same as getStatus but easier to parse*/
    } else if(command == "missionHistory") {
        setMissionHistory(data)
    }
}
def convertDate(dateStr) {
    return Date.parse("yyyyMMdd H:m", dateStr)
}

def setStatus(data) {
    def rstatus = data.robot_status
    def robotName = data.robotName
	state.robotName = robotName
	def mission = data.mission
    def runstats = data.bbrun
    def cschedule = data.cleanSchedule
    def pmaint = data.preventativeMaintenance
    def robot_status = new groovy.json.JsonSlurper().parseText(rstatus)
    def robot_history = new groovy.json.JsonSlurper().parseText(mission)
    def runtime_stats = new groovy.json.JsonSlurper().parseText(runstats)
    def schedule = new groovy.json.JsonSlurper().parseText(cschedule)
    def maintenance = new groovy.json.JsonSlurper().parseText(pmaint)
    log.debug "Robot status = ${robot_status}"
    log.debug "Robot history = ${robot_history}"
    log.debug "Runtime stats= ${runtime_stats}"
    log.debug "Robot schedule= ${schedule}"
    log.debug "Robot maintenance= ${maintenance}"
    def current_cycle = robot_status['cycle']
    def current_charge = robot_status['batPct']
    def current_phase = robot_status['phase']
    def current_sqft = robot_status['sqft']
    def num_mins_running = robot_status['mssnM']
    def flags = robot_status['flags']  // Unknown what 'Flags' 0/1/2/5 mean?
    def readyCode = robot_status['notReady']
    def num_cleaning_jobs = robot_history['nMssn']
    def num_dirt_detected = runtime_stats['nScrubs']
    def total_job_time = runtime_stats['hr']
    

    def new_status = get_robot_status(current_phase, current_cycle, current_charge, readyCode)
    def roomba_value = get_robot_enum(current_phase, readyCode)

    log.debug("Robot updates -- ${roomba_value} + ${new_status}")
    //Set the state object
    if(roomba_value == "cleaning") {
        state.switch = "on"
    } else {
        state.switch = "off"
    }

    /* Consumable state-changes */
    if(bin_full == true) {
        state.consumable = "Full"
    } else if(bin_present == false){
        state.consumable = "Missing"
    } else {
        state.consumable = "Empty"
    }

    /* Timed Session state-changes */
    if(roomba_value == "cleaning") {
        state.sessionStatus = "running"
    } else if (roomba_value == "paused") {
        state.sessionStatus = "paused"
    } else if (roomba_value == "docked" || roomba_value == "docking") {
        state.sessionStatus = "canceled"
    } else {
        state.sessionStatus = "stopped"
    }

    /*send events, display final event*/
    sendEvent(name: "robotName", value: robotName, displayed: false)
    sendEvent(name: "runtimeMins", value: num_mins_running, displayed: false)
    sendEvent(name: "runtimeSqft", value: current_sqft, displayed: false)
    sendEvent(name: "totalJobHrs", value: total_job_time, displayed: false)
    sendEvent(name: "totalJobs", value: num_cleaning_jobs, displayed: false)
    sendEvent(name: "battery", value: current_charge, displayed: false)
    sendEvent(name: "headline", value: new_status, displayed: false)
    sendEvent(name: "status", value: roomba_value)
    sendEvent(name: "switch", value: state.switch)
    sendEvent(name: "sessionStatus", value: state.sessionStatus)
    sendEvent(name: "consumable", value: state.consumable)
}

def get_robot_enum(current_phase, readyCode) {
    def ROOMBA_STATES = getRoombaStates()

    if(readyCode != ROOMBA_STATES['ready']) {
        if(readyCode == ROOMBA_STATES['full']) {
            return "bin-full"
        } else if(readyCode != ROOMBA_STATES['dark']) {
            return "error"
        }
    }

    if(current_phase == "charge") {
        return "docked"
    } else if(current_phase == "hmUsrDock") {
        return "docking"
    } else if(current_phase == "pause" || current_phase == "stop") {
        return "paused"
    } else if(current_phase == "run") {
        return "cleaning"
    } else {
        //"Stuck" phase falls into this category.
        log.error "Unknown phase - Raw 'robot_status': ${status}. Add to 'get_robot_enum'"
        return "error"
    }
}
def parse_not_ready_status(readyCode) {
    def robotName = state.robotName
    def ROOMBA_STATES = getRoombaStates()

    if(readyCode == ROOMBA_STATES['full']) {
      return "${robotName}'s bin is full. Empty bin to continue."
    } else if(readyCode == ROOMBA_STATES['tilted']) {
      return "${robotName} is not upright. Place robot on flat surface to continue."
    } else if (readyCode == ROOMBA_STATES['stuck']) {
      return "${robotName} is stuck. Move robot to continue."
    } else if (readyCode == ROOMBA_STATES['batterylow']) {
      return "${robotName}'s battery is low. Please send Roomba to dock or place on dock."
    } else if (readyCode == ROOMBA_STATES['debrisextractors']) {
      return "${robotName}'s debris extractors are blocked. Please clear them."
    } else {
      return "${robotName} returned notReady=${readyCode}. See iRobot app for details."
    }
}

def get_robot_status(current_phase, current_cycle, current_charge, readyCode) {
    def robotName = state.robotName
    def ROOMBA_STATES = getRoombaStates()

    // 0 and 8 are "okay to run"
    if(readyCode != ROOMBA_STATES['ready'] && readyCode != ROOMBA_STATES['dark']) {
      return parse_not_ready_status(readyCode)
    } else if(current_phase == "charge") {
        if (current_charge == 100) {
            return "${robotName} is Docked/Fully Charged"
        } else {
            return "${robotName} is Docked/Charging"
        }
    } else if(current_phase == "hmUsrDock") {
        return "${robotName} is returning home"
    } else if(current_phase == "run") {
        return "${robotName} is cleaning (${current_cycle} cycle)"
    } else if(current_phase == "pause" || current_phase == "stop") {
        return "Paused - 'Dock' or 'Resume'?"
    }

    log.error "Unknown phase - ${current_phase}."
    return "Error - refresh to continue. Code changes required if problem persists."
}




/* local REST gw support */

def lanEventHandler(evt) {
	log.trace "GOT HERE"
    def description = evt.description
    def hub = evt?.hubId
	def parsedEvent = parseLanMessage(description)
	log.trace "RECEIVED LAN EVENT: $parsedEvent"
}

private local_get(path, cbk) {
    def host = "$roomba_host:$roomba_port"

	sendHubCommand(new physicalgraph.device.HubAction("""GET $path HTTP/1.1\r\nHOST: $host\r\n\r\n""", physicalgraph.device.Protocol.LAN, null, [callback: cbk])) 
}

void local_dummy_cbk(physicalgraph.device.HubResponse hubResponse) {
}

void local_poll_cbk(physicalgraph.device.HubResponse hubResponse) {
    def data = hubResponse.json
    def current_charge = data.batPct
    def mission = data.cleanMissionStatus
    	def current_cycle = mission.cycle
    	def current_phase = mission.phase
    	def current_sqft = mission.sqft
    	def num_mins_running = mission.mssnM
    	def readyCode = mission.notReady
    	def num_cleaning_jobs = mission.nMssn
    def num_dirt_detected = data.bbrun.nScrubs
    def total_job_time = data.bbrun.hr
	def bin = data.bin
     	def bin_full = bin.full
        def bin_present = bin.present
    def robotName = data.name
		state.robotName = robotName
    
    

    def new_status = get_robot_status(current_phase, current_cycle, current_charge, readyCode)
    def roomba_value = get_robot_enum(current_phase, readyCode)
    log.debug("Robot updates -- 2 ${roomba_value} + ${new_status}")
    //Set the state object
    if(roomba_value == "cleaning") {
        state.switch = "on"
    } else {
        state.switch = "off"
    }   

    /* Consumable state-changes */
    if(bin_full == true) {
        state.consumable = "Full"
    } else if(bin_present == false){
        state.consumable = "Missing"
    } else {
        state.consumable = "Empty"
    }

    /* Timed Session state-changes */
    if(roomba_value == "cleaning") {
        state.sessionStatus = "running"
    } else if (roomba_value == "paused") {
        state.sessionStatus = "paused"
    } else if (roomba_value == "docked" || roomba_value == "docking") {
        state.sessionStatus = "canceled"
    } else {
        state.sessionStatus = "stopped"
    }

    /*send events, display final event*/
    sendEvent(name: "robotName", value: robotName, displayed: false)
    sendEvent(name: "runtimeMins", value: num_mins_running, displayed: false)
    sendEvent(name: "runtimeSqft", value: current_sqft, displayed: false)
    sendEvent(name: "totalJobHrs", value: total_job_time, displayed: false)
    sendEvent(name: "totalJobs", value: num_cleaning_jobs, displayed: false)
    sendEvent(name: "battery", value: current_charge, displayed: false)
    sendEvent(name: "headline", value: new_status, displayed: false)
    sendEvent(name: "status", value: roomba_value)
    sendEvent(name: "switch", value: state.switch)
    sendEvent(name: "sessionStatus", value: state.sessionStatus)
    sendEvent(name: "consumable", value: state.consumable)    
}

private local_poll() {
	local_get('/api/local/config/preferences', 'local_poll_cbk')
}

private local_start() {
	local_get('/api/local/action/start', 'local_dummy_cbk')
}

private local_stop() {
	local_get('/api/local/action/stop', 'local_dummy_cbk')
}

private local_pause() {
	local_get('/api/local/action/pause', 'local_dummy_cbk')
}

private local_resume() {
	local_get('/api/local/action/resume', 'local_dummy_cbk')
}

private local_dock() {
	local_get('/api/local/action/dock', 'local_dummy_cbk')
}

private local_pauseAndDock() {
	local_get('/api/local/action/pause', 'local_dummy_cbk')
    pause(1000)
	local_get('/api/local/action/dock', 'local_dummy_cbk')
}

def updateDeviceNetworkID() {
	log.debug "Executing 'updateDeviceNetworkID'"
    def iphex = convertIPtoHex(roomba_host).toUpperCase()
    def porthex = convertPortToHex(roomba_port).toUpperCase()
	device.setDeviceNetworkId(iphex + ":" + porthex)
}

private String convertIPtoHex(ipAddress) { 
    String hex = ipAddress.tokenize( '.' ).collect {  String.format( '%02x', it.toInteger() ) }.join()
    //log.debug "IP address entered is $ipAddress and the converted hex code is $hex"
    return hex
}

private String convertPortToHex(port) {
    String hexport = port.toString().format( '%04x', port.toInteger() )
    //log.debug hexport
    return hexport
}