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
		name: "ACC Football",
		namespace: "SmartThingsDHs",
		author: "fieldsjm") {

		capability "Actuator"
        capability "Button"
        capability "Configuration"
        capability "Sensor"
        capability "Health Check"
         
		attribute "Team","string"
        attribute "Team_Abbr","string"
		attribute "Year","string"
		attribute "secondary_header","string"
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
        attribute "Value23","string"
        attribute "Value24","string"
        attribute "Value25","string"
        attribute "Value26","string"
        attribute "Value27","string"
        attribute "Value28","string"
        attribute "Value29","string"
        attribute "Value30","string"
        attribute "Value31","string"
        attribute "Value32","string"
        attribute "Value33","string"
        attribute "Value34","string"
        attribute "Value35","string"
        attribute "Value36","string"
        attribute "Value37","string"
        attribute "Value38","string"
        attribute "Value39","string"
        attribute "Value40","string"
        attribute "Value41","string"
        attribute "Value42","string"
        attribute "Value43","string"
        attribute "Value44","string"
        attribute "Value45","string"
        attribute "Value46","string"
        attribute "Value47","string"
        attribute "Value48","string"
        attribute "Value49","string"
        attribute "Value50","string"
        attribute "Value51","string"
        attribute "Value52","string"
        attribute "Value53","string"
        attribute "Value54","string"
        attribute "Value55","string"
        attribute "Value56","string"
        attribute "Value57","string"
        attribute "Value58","string"
        attribute "Value59","string"
        attribute "Value60","string"
        attribute "Value61","string"
        attribute "Value62","string"
        attribute "Value63","string"
        attribute "Value64","string"
        attribute "Value65","string"
        attribute "Value66","string"
        attribute "Value67","string"
        attribute "Value68","string"
        attribute "Value69","string"
        attribute "Value70","string"
        attribute "Value71","string"
        attribute "Value72","string"
        attribute "Value73","string"
        attribute "Value74","string"
        attribute "Value75","string"
        attribute "Value76","string"
        attribute "Value77","string"
        attribute "Value78","string"
        attribute "Value79","string"
        attribute "Value80","string"
        attribute "Value81","string"
        attribute "Value82","string"
        attribute "Value83","string"
		attribute "Value84","string"
        attribute "Value85","string"
        attribute "Value86","string"
		attribute "Value87","string"
        attribute "Value88","string"
        attribute "Value89","string"
        attribute "Value90","string"
        attribute "Value91","string"
    
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
        command "changeValue23"
        command "changeValue24"
        command "changeValue25"
        command "changeValue26"
        command "changeValue27"
        command "changeValue28"
        command "changeValue29"
        command "changeValue30"
        command "changeValue31"
        command "changeValue32"
        command "changeValue33"
        command "changeValue34"
        command "changeValue35"
        command "changeValue36"
        command "changeValue37"
        command "changeValue38"
        command "changeValue39"
        command "changeValue40"
        command "changeValue41"
        command "changeValue42"
        command "changeValue43"
        command "changeValue44"
        command "changeValue45"
        command "changeValue46"
        command "changeValue47"
        command "changeValue48"
        command "changeValue49"
        command "changeValue50"
        command "changeValue51"
        command "changeValue52"
        command "changeValue53"
        command "changeValue54"
        command "changeValue55"
        command "changeValue56"
        command "changeValue57"
        command "changeValue58"
        command "changeValue59"
        command "changeValue60"
        command "changeValue61"
        command "changeValue62"
        command "changeValue63"
        command "changeValue64"
        command "changeValue65"
        command "changeValue66"
        command "changeValue67"
        command "changeValue68"
        command "changeValue69"
        command "changeValue70"
        command "changeValue71"
		command "changeValue72"
        command "changeValue73"
        command "changeValue74"
        command "changeValue75"
        command "changeValue76"
        command "changeValue77"
        command "changeValue78"
        command "changeValue79"
        command "changeValue80"
        command "changeValue81"
        command "changeValue82"
        command "changeValue83"        
        command "changeValue84"        
        command "changeValue85"        
        command "changeValue86"        
        command "changeValue87"        
        command "changeValue88"        
        command "changeValue89"        
        command "changeValue90"        
        command "changeValue91"        
	}
    
preferences {
	section("Team"){
    	input "accteam", "enum", title: "Team", options: ["Boston College","Clemson","Duke","Florida State","Georgia Tech","Louisville","Miami","NC State","North Carolina","Notre Dame","Pittsburgh","Syracuse","Virginia","Virginia Tech","Wake Forest"], multiple: false, required: true
        }
	section("Season"){
    	input "year", "text", title: "Year (in which season began)", required: true
        }
}

	tiles (scale:2){
		multiAttributeTile(name:"button1", type: "generic", width: 6, height: 4, decoration: "flat") {
        	tileAttribute ("device.button1", key: "PRIMARY_CONTROL"){
                attributeState("Boston College", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png", backgroundColor: "#726158")
                attributeState("Clemson", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png", backgroundColor: "#522D80")
                attributeState("Duke", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png", backgroundColor: "#FFFFFF")
                attributeState("Florida State", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png", backgroundColor: "#CEB888")
                attributeState("Georgia Tech", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png", backgroundColor: "#003057")
                attributeState("Louisville", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png", backgroundColor: "#000000")
                attributeState("Miami", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png", backgroundColor: "#FFFFFF")
                attributeState("NC State", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png", backgroundColor: "#FFFFFF")
                attributeState("North Carolina", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png", backgroundColor: "#CC0000")
                attributeState("Notre Dame", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png", backgroundColor: "#C99700")
                attributeState("Pittsburgh", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png", backgroundColor: "#003594")
                attributeState("Syracuse", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png", backgroundColor: "#6F777D")
                attributeState("Virginia", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png", backgroundColor: "#232D4B")
                attributeState("Virginia Tech", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png", backgroundColor: "#CF4520")
                attributeState("Wake Forest", label:'', action: "push1", icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png", backgroundColor: "#000000")
            }
			tileAttribute("device.Value68", key: "SECONDARY_CONTROL") {
        		attributeState ("default", label:'${currentValue}')
            	}
		}

        valueTile("BoxScore_Header", "device.Value49", width: 6, height: 2){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_blank", "blank", width: 1, height: 1){
            state("default", label:'')}
		valueTile("BoxScore_QTR1", "qtr1", width: 1, height: 1){
            state("default", label:'1')}
		valueTile("BoxScore_QTR2", "qtr2", width: 1, height: 1){
            state("default", label:'2')}
		valueTile("BoxScore_QTR3", "qtr3", width: 1, height: 1){
            state("default", label:'3')}
		valueTile("BoxScore_QTR4", "device.Value63", width: 1, height: 1){
            state("default", label:'4${currentValue}')}
		valueTile("BoxScore_Final", "device.Value64", width: 1, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("BoxScore_Away", "device.Value50", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_A_QTR1", "device.Value51", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_A_QTR2", "device.Value52", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_A_QTR3", "device.Value53", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_A_QTR4", "device.Value54", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_A_Final", "device.Value55", width: 1, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("BoxScore_Home", "device.Value56", width: 1, height: 1){
            state("default", label:'${currentValue}')}            
		valueTile("BoxScore_H_QTR1", "device.Value57", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_H_QTR2", "device.Value58", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_H_QTR3", "device.Value59", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_H_QTR4", "device.Value60", width: 1, height: 1){
            state("default", label:'${currentValue}')}
		valueTile("BoxScore_H_Final", "device.Value61", width: 1, height: 1){
            state("default", label:'${currentValue}')}
        
        valueTile("Play_Header", "device.Value62", width: 6, height: 3){
            state("default", label:'Current Drive: ${currentValue}')}
            
        valueTile("Logo", "device.Logo", width: 1, height: 1){
            state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
            state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
            state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
            state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
            state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
            state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
            state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
            state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
            state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
            state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
            state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
            state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
            state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
            state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
            state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
            }
        valueTile("Main", "device.Main", width: 1, height: 1){
            state("default", label:'', icon:"https://accsports.com/wp-content/uploads/2016/05/ACC-4.png", default: true)
            state("Boston College", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
            state("Clemson", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
            state("Duke", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
            state("Florida State", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
            state("Georgia Tech", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
            state("Louisville", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
            state("Miami", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
            state("NC State", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
            state("North Carolina", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
            state("Notre Dame", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
            state("Pittsburgh", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
            state("Syracuse", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
            state("Virginia", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
            state("Virginia Tech", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
            state("Wake Forest", label:'${currentValue}', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
            }

        valueTile("Header", "device.Header", width: 4, height: 1){
            state "default", label:'${currentValue}'}
        valueTile("Record", "device.Value69", width: 1, height: 1){
        	state "default", label:'${currentValue}'}

        valueTile("Value1", "device.Value1", width: 1, height: 1){
            state("game1date", label:'${currentValue}')}
        valueTile("Value2", "device.Value2", width: 1, height: 1){
            state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value2a", "device.Value2", width: 2, height: 1){
            state("game1team", label:'${currentValue}')}
        valueTile("Value3", "device.Value3", width: 1, height: 1){
            state("game1home", label:'${currentValue}')}
        valueTile("Value4", "device.Value4", width: 1, height: 1){
            state("game1score", label:'${currentValue}')}
        valueTile("Value5", "device.Value5", width: 1, height: 1){
            state("game2date", label:'${currentValue}')}
        valueTile("Value6", "device.Value6", width: 1, height: 1){
            state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value6a", "device.Value6", width: 2, height: 1){
            state("game2team", label:'${currentValue}')}
        valueTile("Value7", "device.Value7", width: 1, height: 1){
            state("game2home", label:'${currentValue}')}
        valueTile("Value8", "device.Value8", width: 1, height: 1){
            state("game2score", label:'${currentValue}')}
        valueTile("Value9", "device.Value9", width: 1, height: 1){
            state("game3date", label:'${currentValue}')}
        valueTile("Value10", "device.Value10", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value10a", "device.Value10", width: 2, height: 1){
            state("game3team", label:'${currentValue}')}
        valueTile("Value11", "device.Value11", width: 1, height: 1){
            state("game3home", label:'${currentValue}')}
        valueTile("Value12", "device.Value12", width: 1, height: 1){
            state("game3score", label:'${currentValue}')}
        valueTile("Value13", "device.Value13", width: 1, height: 1){
            state("game4date", label:'${currentValue}')}
        valueTile("Value14", "device.Value14", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value14a", "device.Value14", width: 2, height: 1){
            state("game4team", label:'${currentValue}')}
        valueTile("Value15", "device.Value15", width: 1, height: 1){
            state("game4home", label:'${currentValue}')}
        valueTile("Value16", "device.Value16", width: 1, height: 1){
            state("game4score", label:'${currentValue}')}
        valueTile("Value17", "device.Value17", width: 1, height: 1){
            state("game5date", label:'${currentValue}')}
        valueTile("Value18", "device.Value18", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value18a", "device.Value18", width: 2, height: 1){
            state("game5team", label:'${currentValue}')}
        valueTile("Value19", "device.Value19", width: 1, height: 1){
            state("game5home", label:'${currentValue}')}
        valueTile("Value20", "device.Value20", width: 1, height: 1){
            state("game5score", label:'${currentValue}')}
        valueTile("Value21", "device.Value21", width: 1, height: 1){
            state("game6date", label:'${currentValue}')}
        valueTile("Value22", "device.Value22", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value22a", "device.Value22", width: 2, height: 1){
            state("game6team", label:'${currentValue}')}
        valueTile("Value23", "device.Value23", width: 1, height: 1){
            state("game6home", label:'${currentValue}')}
        valueTile("Value24", "device.Value24", width: 1, height: 1){
            state("game6score", label:'${currentValue}')}
        valueTile("Value25", "device.Value25", width: 1, height: 1){
            state("game7date", label:'${currentValue}')}
        valueTile("Value26", "device.Value26", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value26a", "device.Value26", width: 2, height: 1){
            state("game7team", label:'${currentValue}')}
        valueTile("Value27", "device.Value27", width: 1, height: 1){
            state("game7home", label:'${currentValue}')}
        valueTile("Value28", "device.Value28", width: 1, height: 1){
            state("game7score", label:'${currentValue}')}
        valueTile("Value29", "device.Value29", width: 1, height: 1){
            state("game8date", label:'${currentValue}')}
        valueTile("Value30", "device.Value30", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value30a", "device.Value30", width: 2, height: 1){
            state("game8team", label:'${currentValue}')}
        valueTile("Value31", "device.Value31", width: 1, height: 1){
            state("game8home", label:'${currentValue}')}
        valueTile("Value32", "device.Value32", width: 1, height: 1){
            state("game8score", label:'${currentValue}')}
        valueTile("Value33", "device.Value33", width: 1, height: 1){
            state("game9date", label:'${currentValue}')}
        valueTile("Value34", "device.Value34", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value34a", "device.Value34", width: 2, height: 1){
            state("game9team", label:'${currentValue}')}
        valueTile("Value35", "device.Value35", width: 1, height: 1){
            state("game9home", label:'${currentValue}')}
        valueTile("Value36", "device.Value36", width: 1, height: 1){
            state("game9score", label:'${currentValue}')}
        valueTile("Value37", "device.Value37", width: 1, height: 1){
            state("game10date", label:'${currentValue}')}
        valueTile("Value38", "device.Value38", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value38a", "device.Value38", width: 2, height: 1){
            state("game10team", label:'${currentValue}')}
        valueTile("Value39", "device.Value39", width: 1, height: 1){
            state("game10home", label:'${currentValue}')}
        valueTile("Value40", "device.Value40", width: 1, height: 1){
            state("game10score", label:'${currentValue}')}
        valueTile("Value41", "device.Value41", width: 1, height: 1){
            state("game11date", label:'${currentValue}')}
        valueTile("Value42", "device.Value42", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")

}
        valueTile("Value42a", "device.Value42", width: 2, height: 1){
            state("game11team", label:'${currentValue}')}
        valueTile("Value43", "device.Value43", width: 1, height: 1){
            state("game11home", label:'${currentValue}')}
        valueTile("Value44", "device.Value44", width: 1, height: 1){
            state("game11score", label:'${currentValue}')}
        valueTile("Value45", "device.Value45", width: 1, height: 1){
            state("game12date", label:'${currentValue}')}
        valueTile("Value46", "device.Value46", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")
}
        valueTile("Value46a", "device.Value46", width: 2, height: 1){
            state("game12team", label:'${currentValue}')}
        valueTile("Value47", "device.Value47", width: 1, height: 1){
            state("game12home", label:'${currentValue}')}
        valueTile("Value48", "device.Value48", width: 1, height: 1){
            state("game12score", label:'${currentValue}')}

        valueTile("Value84", "device.Value84", width: 1, height: 1){
            state("game13date", label:'${currentValue}')}
        valueTile("Value85", "device.Value85", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")
}
        valueTile("Value85a", "device.Value85", width: 2, height: 1){
            state("game13team", label:'${currentValue}')}
        valueTile("Value86", "device.Value86", width: 1, height: 1){
            state("game13home", label:'${currentValue}')}
        valueTile("Value87", "device.Value87", width: 1, height: 1){
            state("game13score", label:'${currentValue}')}
            
        valueTile("Value88", "device.Value88", width: 1, height: 1){
            state("game14date", label:'${currentValue}')}
        valueTile("Value89", "device.Value89", width: 1, height: 1){
           	state("OFF", label:'-')
state("Default", label:'', icon:"https://a.thumbs.redditmedia.com/_JGFTy6V0bODjfUfADk3EsyNY_qwxCxAAqQP9IgWTX4.png")
state("Boston College", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/103.png")
state("Clemson", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/228.png")
state("Duke", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/150.png")
state("Florida State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/52.png")
state("Georgia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/59.png")
state("Louisville", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/97.png")
state("Miami", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png")
state("NC State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/152.png")
state("North Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/153.png")
state("Notre Dame", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/87.png")
state("Pittsburgh", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/221.png")
state("Syracuse", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/183.png")
state("Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/258.png")
state("Virginia Tech", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/259.png")
state("Wake Forest", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/154.png")
state("Alabama", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/333.png")
state("Alabama State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2011.png")
state("Boise State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/68.png")
state("Charlotte", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2429.png")
state("Delaware", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/48.png")
state("Elon", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2210.png")
state("Florida", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/57.png")
state("Furman", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/231.png")
state("Georgia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/61.png")
state("Holy Cross", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/107.png")
state("Kansas", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2305.png")
state("Liberty", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2335.png")
state("Maryland", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/120.png")
state("Mid Tennessee", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2393.png")
state("NC A&T", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2448.png")
state("Ohio", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/195.png")
state("Old Dominion", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/295.png")
state("Penn State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/213.png")
state("Rice", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/242.png")
state("Richmond", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/257.png")
state("Rutgers", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/164.png")
state("S Carolina", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2579.png")
state("Temple", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/218.png")
state("Texas A&M", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/245.png")
state("The Citadel", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2643.png")
state("UCF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2116.png")
state("UL Monroe", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2433.png")
state("URI", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/227.png")
state("USF", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/58.png")
state("Utah State", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/328.png")
state("W Michigan", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2711.png")
state("West Virginia", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/277.png")
state("William & Mary", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2729.png")
state("Wofford", label:'', icon:"https://a.espncdn.com/i/teamlogos/ncaa/500/2747.png")
}
        valueTile("Value89a", "device.Value89", width: 2, height: 1){
            state("game14team", label:'${currentValue}')}
        valueTile("Value90", "device.Value90", width: 1, height: 1){
            state("game14home", label:'${currentValue}')}
        valueTile("Value91", "device.Value91", width: 1, height: 1){
            state("game14score", label:'${currentValue}')}

        valueTile("atlantic", "atlantic", width: 3, height: 1){
            state("default", label:'ACC - Atlantic')}
        valueTile("atl1", "device.Value70", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("atl2", "device.Value72", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("atl3", "device.Value74", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("atl4", "device.Value76", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("atl5", "device.Value78", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("atl6", "device.Value80", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("atl7", "device.Value82", width: 3, height: 1){
            state("default", label:'${currentValue}')}

        valueTile("coastal", "coastal", width: 3, height: 1){
            state("default", label:'ACC - Coastal')}
        valueTile("coast1", "device.Value71", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("coast2", "device.Value73", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("coast3", "device.Value75", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("coast4", "device.Value77", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("coast5", "device.Value79", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("coast6", "device.Value81", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        valueTile("coast7", "device.Value83", width: 3, height: 1){
            state("default", label:'${currentValue}')}
        
 		main(["Main"])
 		details(["button1","BoxScore_Header","BoxScore_blank","BoxScore_QTR1","BoxScore_QTR2","BoxScore_QTR3","BoxScore_QTR4","BoxScore_Final","BoxScore_Away","BoxScore_A_QTR1","BoxScore_A_QTR2","BoxScore_A_QTR3","BoxScore_A_QTR4","BoxScore_A_Final","BoxScore_Home","BoxScore_H_QTR1","BoxScore_H_QTR2","BoxScore_H_QTR3","BoxScore_H_QTR4","BoxScore_H_Final","Play_Header","Custom1","Custom2","Custom3","Custom4","Custom5","Logo","Header","Record","Value1","Value2","Value2a","Value3","Value4","Value5","Value6","Value6a","Value7","Value8","Value9","Value10","Value10a","Value11","Value12","Value13","Value14","Value14a","Value15","Value16","Value17","Value18","Value18a","Value19","Value20","Value21","Value22","Value22a","Value23","Value24","Value25","Value26","Value26a","Value27","Value28","Value29","Value30","Value30a","Value31","Value32","Value33","Value34","Value34a","Value35","Value36","Value37","Value38","Value38a","Value39","Value40","Value41","Value42","Value42a","Value43","Value44","Value45","Value46","Value46a","Value47","Value48","Value84","Value85","Value85a","Value86","Value87","Value88","Value89","Value89a","Value90","Value91","atlantic","coastal","atl1","coast1","atl2","coast2","atl3","coast3","atl4","coast4","atl5","coast5","atl6","coast6","atl7","coast7"])
 	}
 }

def installed() {
    initialize()
}

def updated() {
    initialize()
}

def initialize(){
    sendEvent(name: "Main", value: "${settings.accteam}")
    sendEvent(name: "Team", value: "${settings.accteam}")
    sendEvent(name: "Team_Abbr", value: Team_Abbr())
    sendEvent(name: "Year", value: "${settings.year}")
    sendEvent(name: "Logo", value: "${settings.accteam}")
    sendEvent(name: "button1", value: "${settings.accteam}")
    sendEvent(name: "Header", value: "${settings.accteam} \n${settings.year} Schedule")
	sendEvent(name: "secondary_header", value: "${device.Value54} \n${device.Value55}")
    push1()
}
def Team_Abbr(){
    if("${settings.accteam}" == "Boston College") {
    	return "BC"
    } else if("${settings.accteam}" == "Clemson") {
    	return "CLEM"
    } else if("${settings.accteam}" == "Duke") {
    	return "DUKE"
    } else if("${settings.accteam}" == "Florida State") {
    	return "FSU"
    } else if("${settings.accteam}" == "Georgia Tech") {
    	return "GT"
    } else if("${settings.accteam}" == "Louisville") {
    	return "louisville-cardinals"
    } else if("${settings.accteam}" == "Miami") {
    	return "MIA"
    } else if("${settings.accteam}" == "NC State") {
    	return "NCST"
    } else if("${settings.accteam}" == "North Carolina") {
    	return "UNC"
    } else if("${settings.accteam}" == "Notre Dame") {
    	return "ND"
    } else if("${settings.accteam}" == "Pittsburgh") {
    	return "PITT"
    } else if("${settings.accteam}" == "Syracuse") {
    	return "SYR"
    } else if("${settings.accteam}" == "Virginia") {
    	return "UVA"
    } else if("${settings.accteam}" == "Virginia Tech") {
    	return "VT"
    } else if("${settings.accteam}" == "Wake Forest") {
    	return "WAKE"
    } else{
    	return "ACC"
    }
}
def parse(String description) {
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
def changeValue17 (param17) { sendEvent("name":"Value17", "value":param17)}
def changeValue18 (param18) { sendEvent("name":"Value18", "value":param18)}
def changeValue19 (param19) { sendEvent("name":"Value19", "value":param19)}
def changeValue20 (param20) { sendEvent("name":"Value20", "value":param20)}
def changeValue21 (param21) { sendEvent("name":"Value21", "value":param21)}
def changeValue22 (param22) { sendEvent("name":"Value22", "value":param22)}
def changeValue23 (param23) { sendEvent("name":"Value23", "value":param23)}
def changeValue24 (param24) { sendEvent("name":"Value24", "value":param24)}
def changeValue25 (param25) { sendEvent("name":"Value25", "value":param25)}
def changeValue26 (param26) { sendEvent("name":"Value26", "value":param26)}
def changeValue27 (param27) { sendEvent("name":"Value27", "value":param27)}
def changeValue28 (param28) { sendEvent("name":"Value28", "value":param28)}
def changeValue29 (param29) { sendEvent("name":"Value29", "value":param29)}
def changeValue30 (param30) { sendEvent("name":"Value30", "value":param30)}
def changeValue31 (param31) { sendEvent("name":"Value31", "value":param31)}
def changeValue32 (param32) { sendEvent("name":"Value32", "value":param32)}
def changeValue33 (param33) { sendEvent("name":"Value33", "value":param33)}
def changeValue34 (param34) { sendEvent("name":"Value34", "value":param34)}
def changeValue35 (param35) { sendEvent("name":"Value35", "value":param35)}
def changeValue36 (param36) { sendEvent("name":"Value36", "value":param36)}
def changeValue37 (param37) { sendEvent("name":"Value37", "value":param37)}
def changeValue38 (param38) { sendEvent("name":"Value38", "value":param38)}
def changeValue39 (param39) { sendEvent("name":"Value39", "value":param39)}
def changeValue40 (param40) { sendEvent("name":"Value40", "value":param40)}
def changeValue41 (param41) { sendEvent("name":"Value41", "value":param41)}
def changeValue42 (param42) { sendEvent("name":"Value42", "value":param42)}
def changeValue43 (param43) { sendEvent("name":"Value43", "value":param43)}
def changeValue44 (param44) { sendEvent("name":"Value44", "value":param44)}
def changeValue45 (param45) { sendEvent("name":"Value45", "value":param45)}
def changeValue46 (param46) { sendEvent("name":"Value46", "value":param46)}
def changeValue47 (param47) { sendEvent("name":"Value47", "value":param47)}
def changeValue48 (param48) { sendEvent("name":"Value48", "value":param48)}
def changeValue49 (param49) { sendEvent("name":"Value49", "value":param49)}
def changeValue50 (param50) { sendEvent("name":"Value50", "value":param50)}
def changeValue51 (param51) { sendEvent("name":"Value51", "value":param51)}
def changeValue52 (param52) { sendEvent("name":"Value52", "value":param52)}
def changeValue53 (param53) { sendEvent("name":"Value53", "value":param53)}
def changeValue54 (param54) { sendEvent("name":"Value54", "value":param54)}
def changeValue55 (param55) { sendEvent("name":"Value55", "value":param55)}
def changeValue56 (param56) { sendEvent("name":"Value56", "value":param56)}
def changeValue57 (param57) { sendEvent("name":"Value57", "value":param57)}
def changeValue58 (param58) { sendEvent("name":"Value58", "value":param58)}
def changeValue59 (param59) { sendEvent("name":"Value59", "value":param59)}
def changeValue60 (param60) { sendEvent("name":"Value60", "value":param60)}
def changeValue61 (param61) { sendEvent("name":"Value61", "value":param61)}
def changeValue62 (param62) { sendEvent("name":"Value62", "value":param62)}
def changeValue63 (param63) { sendEvent("name":"Value63", "value":param63)}
def changeValue64 (param64) { sendEvent("name":"Value64", "value":param64)}
def changeValue65 (param65) { sendEvent("name":"Value65", "value":param65)}
def changeValue66 (param66) { sendEvent("name":"Value66", "value":param66)}
def changeValue67 (param67) { sendEvent("name":"Value67", "value":param67)}
def changeValue68 (param68) { sendEvent("name":"Value68", "value":param68)}
def changeValue69 (param69) { sendEvent("name":"Value69", "value":param69)}
def changeValue70 (param70) { sendEvent("name":"Value70", "value":param70)}
def changeValue71 (param71) { sendEvent("name":"Value71", "value":param71)}
def changeValue72 (param72) { sendEvent("name":"Value72", "value":param72)}
def changeValue73 (param73) { sendEvent("name":"Value73", "value":param73)}
def changeValue74 (param74) { sendEvent("name":"Value74", "value":param74)}
def changeValue75 (param75) { sendEvent("name":"Value75", "value":param75)}
def changeValue76 (param76) { sendEvent("name":"Value76", "value":param76)}
def changeValue77 (param77) { sendEvent("name":"Value77", "value":param77)}
def changeValue78 (param78) { sendEvent("name":"Value78", "value":param78)}
def changeValue79 (param79) { sendEvent("name":"Value79", "value":param79)}
def changeValue80 (param80) { sendEvent("name":"Value80", "value":param80)}
def changeValue81 (param81) { sendEvent("name":"Value81", "value":param81)}
def changeValue82 (param82) { sendEvent("name":"Value82", "value":param82)}
def changeValue83 (param83) { sendEvent("name":"Value83", "value":param83)}
def changeValue84 (param84) { sendEvent("name":"Value84", "value":param84)}
def changeValue85 (param85) { sendEvent("name":"Value85", "value":param85)}
def changeValue86 (param86) { sendEvent("name":"Value86", "value":param86)}
def changeValue87 (param87) { sendEvent("name":"Value87", "value":param87)}
def changeValue88 (param88) { sendEvent("name":"Value88", "value":param88)}
def changeValue89 (param89) { sendEvent("name":"Value89", "value":param89)}
def changeValue90 (param90) { sendEvent("name":"Value90", "value":param90)}
def changeValue91 (param91) { sendEvent("name":"Value91", "value":param91)}

def push1() {
	push(1)
}

private push(button) {
    log.debug "$device.displayName button $button was pushed"
    sendEvent(name: "button", value: "pushed", data: [buttonNumber: button], descriptionText: "$device.displayName button $button was pushed", isStateChange: true)
}