/**
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
    }
    
metadata {
	definition (name: "WAN-IP", namespace: "fieldsjm", "vid": "7f05b788-4020-3d65-9977-a76c6ebb049e","mnmn": "SmartThingsDHs") {
		capability "dictionaryfabric11101.adjustTextA"
		capability "Health Check"
        capability "Refresh"
                
		attribute "labelA", "string"
	    attribute "GVstatus", "string"

		command ResetGV
    }

	simulator {
    
    }

	tiles {
        valueTile("labelA", "device.labelA", inactiveLabel: false, decoration: "flat", width: 3, height: 1) {
        	state "default", label:'${currentValue}'
        }
        
        main "labelA"
        details(["labelA"])
	}
}

def installed() {
    sendEvent(name: "labelA", value: "--", displayed: false)
    sendEvent(name: "GVstatus", value: "start", displayed: false, isStateChange: true)
}

def updated() {
    sendEvent(name: "GVstatus", value: "update", displayed: false, isStateChange: true)
}

def setLabelA(value) {
	sendEvent(name: "labelA", value: "labelA")
    textChange("labelA", value)
}

def textChange(String valString, String newval) {
    Logger("valueChange: ${valString} Target ${newval}")
    sendEvent("name":valString, "value":newval, displayed: true)
    sendEvent(name: "GVstatus", value: valString, displayed: false, isStateChange: true)
}

def ResetGV() {
    sendEvent(name: "GVstatus", value: "clear", displayed: false, isStateChange: true)
}
def Logger(String logString) {
	log.info(logString)
}