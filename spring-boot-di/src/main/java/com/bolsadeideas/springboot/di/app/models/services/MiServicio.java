package com.bolsadeideas.springboot.di.app.models.services;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

//@Component("miServicioSimple") Si tenemos nuestras propias clases implementadas por nosotros lo podemos hacer con components o con service. Si son externas(API) es necesario hacerlas con una clase de configuracion  
//@Primary
public class MiServicio implements IServicio{	
//La anotacion @Primary permite seleccionar el candidato que queremos inyectar
//por defecto en nuestras clases, ya sea controlador o cualquier otra clase que utilice este componente
//sin tener que estar cambiando y modificando la clase que lo utiliza
//Usamos la interfaz siempre y en las implementaciones concretas de los componentes indicamos cual es el principal

//Todo componente Spring debe tener un constructor por defecto sin argumentos(vacio), ya sea implicito o explicito
//Spring los instancia automaticamente sin argumentos	
	
	
	@Override //estamos sobre escribiendo o implementando este metodo
	public String operacion() {
		return "ejecutando algun proceso importante simple...";
	}
	
	
	
	
}
