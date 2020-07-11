/**
 * 
 */
package ar.edu.unju.fi.testeos.model;

import java.time.LocalDateTime;

/**
 * @author user
 *
 */
public class ObjetoConsulta {
 public String barrio;
 public String time1;
 public String time2;
 

 public ObjetoConsulta() {}
 
/**
 * @param barrio
 * @param time1
 * @param time2
 */
public ObjetoConsulta(String barrio, String time1, String time2) {
	this.barrio = barrio;
	this.time1 = time1;
	this.time2 = time2;
}
/**
 * @return the barrio
 */
public String getBarrio() {
	return barrio;
}
/**
 * @param barrio the barrio to set
 */
public void setBarrio(String barrio) {
	this.barrio = barrio;
}

/**
 * @return the time1
 */
public String getTime1() {
	return time1;
}

/**
 * @param time1 the time1 to set
 */
public void setTime1(String time1) {
	this.time1 = time1;
}

/**
 * @return the time2
 */
public String getTime2() {
	return time2;
}

/**
 * @param time2 the time2 to set
 */
public void setTime2(String time2) {
	this.time2 = time2;
}


}
