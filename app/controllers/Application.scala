package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

object Application extends Controller 
{
  
  def index = Action 
  {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def receiveJson1 = Action(parse.json)
  {
      request => 
         println("Application scala routine, line 18, request method type = " + request.method)
         println("Application scala routine, line 19, request content type = " + request.contentType)
         println("Application scala routine, line 20, request body = " + request.body)
         println("Application scala routine, line 21, request body to String = " + request.body.toString)
         var cel = ""
         var code = ""
         var infoIncomingRequest = ""
         (request.body \ "Cel").asOpt[String].map { cell => cel = cell}.getOrElse 
         {
             BadRequest("Missing parameter [name]")
         }
         (request.body \ "Code").asOpt[String].map { codd => code = codd}.getOrElse 
         {
             BadRequest("Missing parameter [name]")
         }
         infoIncomingRequest = "method = " + request.method + "\r\n" + 
                               "content type = " + request.contentType + "\r\n" + 
                               "body" + request.body.toString                              
         System.out.println("Application scala routine, line 29, cel received =  " + cel)
         System.out.println("Application scala routine, line 27, code received =  " + code)        
         Ok(Json.toJson(Map("Cel" -> cel, "Code" -> code, "InfoIncomingRequest" -> infoIncomingRequest )))
  }

  def receiveSimple1 = Action
  {
      request => 
         println("Application scala routine, line 39, request method type = " + request.method)
         println("Application scala routine, line 40, request content type = " + request.contentType)
         println("Application scala routine, line 41, request body = " + request.body)
         println("Application scala routine, line 42, request to String = " + request.toString)
         Ok("received method = " + request.method +
            "received content type = " + request.contentType + 
            "received simple stuff = " + request.toString + 
            "body = " + request.body.toString)
  }  
  
  
}