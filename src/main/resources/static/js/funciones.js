// ContentType: Cuando envíe datos al servidor, use este tipo de contenido. El valor predeterminado es application/x-www-form-urlencoded; charset=UTF-8, lo cual está bien para la mayoría de los casos.
// DataType: El tipo de datos que espera del servidor. Si no se especifica ninguno, jQuery intentará inferirlo en función del tipo MIME de la respuesta. Puede ser text, xml, html, script, json, jsonp.

//const BASE_URL = 'http://132.226.156.104:81';
 const BASE_URL = 'http://localhost';

function guardarInformacionCategoria(){

    $("#resultado").empty();

    let myData ={name:$("#nombreCategoria").val(),description:$("#descripcionCategoria").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : BASE_URL+'/api/Category/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            //console.log(respuesta);
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}


function traerInformacionCategoria(){
    $.ajax(
              {
                url:BASE_URL+'/api/Category/all',
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){                
                    pintarRespuestaCategoria(respuesta);
                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }
              }
               
          );
}


function pintarRespuestaCategoria(items){

     $("#resultado").empty();

    //declarar variables js
    let myTable="<table>";
    myTable += "<tr><th>Codigo</th><th>Nombre</th></tr>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+ items[i].id+ "</td>";
        myTable+="<td>"+ items[i].name+"</td>";
        myTable+="<td>"+ items[i].description+"</td>";
        // myTable+="<td><button onclick='borrarCategoria("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable +="</table>";
    $("#resultado").append(myTable);
}


function traerInformacionAuditorio(){
    $.ajax(
              {
                url:BASE_URL+'/api/Audience/all',
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaAuditorio(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }      
              }
               
          );
}

// [{"id":1,"name":"Gw shimano 25","brand":"GW","year":2013,
// "description":"Gw shimano 25",
// "category":{"id":1,"name":"cat1","description":"test category"},"messages":[],"reservations":[]}]

function pintarRespuestaAuditorio(items){

     $("#resultado").empty();

    //declarar variables js
    let myTable="<table>";
    myTable += "<tr><th>Codigo</th><th>Nombre</th> <th> Marca</th><th>Año</th><th>descripcion</th><th>Codigo Categoria</th><th>Nombre Categoria</th><th>Descripcion Categoria</th> <th>Mensaje</th><th>Reservacion</th></tr>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].anio+"</td>";
        myTable+="<td>"+items[i].description+"</td>";                
        myTable+="<td>"+items[i].category.id +"</td>";                
        myTable+="<td>"+items[i].category.name +"</td>";                
        myTable+="<td>"+items[i].category.description +"</td>";                
        myTable+="<td>"+items[i].messages +"</td>";                        
        myTable+="<td>"+items[i].reservations+"</td>";                
        // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable +="</table>";
    $("#resultado").append(myTable);
}


//{"brand":"GW","year":2013,"category":{"id":1},"name":"Gw shimano 25","description":"Gw shimano 25"}
function guardarInformacionAuditorio(){

    $("#resultado").empty();

    let myData ={brand:$("#marcaAuditorio").val(),anio:$("#anioCategoria").val(),category:{id:$("#idCategoria").val()},name:$("#nombreAuditorio").val(),description:$("#descripcionAuditorio").val(),}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : BASE_URL+'/api/Audience/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            //console.log(respuesta);
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}



function guardarInformacionCliente(){

    $("#resultado").empty();

    let myData ={name:$("#nombreCliente").val(),email:$("#emailCliente").val(),password:$("#claveCliente").val(),age:$("#edadCliente").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : BASE_URL+'/api/Client/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            //console.log(respuesta);
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}

function traerInformacionCliente(){
    $.ajax(
              {
                url:BASE_URL+'/api/Client/all',
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaCliente(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }
            
                    
              }
               
          );
}


function pintarRespuestaCliente(items){

    $("#resultado").empty();

   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo</th><th> Correo</th><th>password</th><th>Nombre</th><th>Edad</th><th>Mensaje</th><th>Reservaciones</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idClient+"</td>";
       myTable+="<td>"+items[i].email+"</td>";
       myTable+="<td>"+items[i].password+"</td>";
       myTable+="<td>"+items[i].name+"</td>";
       myTable+="<td>"+items[i].age+"</td>";                
       myTable+="<td>"+items[i].messages +"</td>";                        
       myTable+="<td>"+items[i].reservations+"</td>";                
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}


function guardarInformacionMensaje(){

    $("#resultado").empty();

    let myData ={messageText:$("#mensaje").val(),audience:{id:$("#idAuditorioM").val()},client:{idClient:$("#idClienteM").val()}}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : BASE_URL+'/api/Message/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            //console.log(respuesta);
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}

function traerInformacionMensaje(){
    $.ajax(
              {
                url:BASE_URL+'/api/Message/all',
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaMensaje(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }
            
                    
              }
               
          );
}


function pintarRespuestaMensaje(items){

    $("#resultado").empty();

   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo</th><th> Mensaje</th><th>codigo Auditorio</th><th>Nombre Auditorio</th><th>Codigo Cliente</th><th>Nombre Cliente</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idMessage+"</td>";
       myTable+="<td>"+items[i].messageText+"</td>";
       myTable+="<td>"+items[i].audience.id+"</td>";       
       myTable+="<td>"+items[i].audience.name+"</td>";
       myTable+="<td>"+items[i].client.idClient+"</td>";
       myTable+="<td>"+items[i].client.name+"</td>";
       
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}

// {"startDate":"2020-12-20","devolutionDate":"2020-12-20",
// "client":{"idClient":1},"bike":{"id":1}}
function guardarInformacionReservacion(){

    $("#resultado").empty();

    let myData ={startDate:$("#fechaInicio").val(),devolutionDate:$("#fechaFinal").val(),client:{idClient:$("#idClienteR").val()},audience:{id:$("#idAuditorioR").val()}}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {

            url          : BASE_URL+'/api/Reservation/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            //console.log(respuesta);
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}

function traerInformacionReservacion(){
    $.ajax(
              {
                url:BASE_URL+'/api/Reservation/all',
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaReservacion(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }
            
                    
              }
               
          );
}


function pintarRespuestaReservacion(items){

    $("#resultado").empty();

   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo Res</th><th> Fecha Inicio</th><th>Fecha fin</th><th>Status</th><th>Codigo Auditorio</th><th>Nombre AUditorio</th><th>Codigo Cliente</th><th>Nombre Cliente</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idReservation+"</td>";
       myTable+="<td>"+items[i].startDate+"</td>";
       myTable+="<td>"+items[i].devolutionDate+"</td>";
       myTable+="<td>"+items[i].status+"</td>";       
       myTable+="<td>"+items[i].audience.id+"</td>";       
       myTable+="<td>"+items[i].audience.name+"</td>";
       myTable+="<td>"+items[i].client.idClient+"</td>";
       myTable+="<td>"+items[i].client.name+"</td>";
       
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}

