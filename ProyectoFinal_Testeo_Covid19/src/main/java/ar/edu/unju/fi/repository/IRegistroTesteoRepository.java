/**
 * 
 */
package ar.edu.unju.fi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * @author Fabian
  * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 *
public interface IRegistroTesteo {
public void guardar();
public void eliminar();
 public RegistroTesteo mostrar();


}*/

public interface IRegistroTesteoRepository extends JpaRepository<RegistroTesteo, Long>{
}