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
         println("Application scala routine, line 18, request content type = " + request.contentType)
         println("Application scala routine, line 19, request body = " + request.body)
         println("Application scala routine, line 20, request body to String = " + request.toString)
         var cel = ""
         var code = ""
         (request.body \ "Cel").asOpt[String].map { cell => cel = cell}.getOrElse 
         {
             BadRequest("Missing parameter [name]")
         }
         (request.body \ "Code").asOpt[String].map { codd => code = codd}.getOrElse 
         {
             BadRequest("Missing parameter [name]")
         }         
         System.out.println("Application scala routine, line 29, cel received =  " + cel)
         System.out.println("Application scala routine, line 27, code received =  " + code)        
         Ok(Json.toJson(Map("Cel" -> cel, "Code" -> code )))
  }

  def receiveSimple1 = Action
  {
      request => 
         println("Application scala routine, line 35, request content type = " + request.contentType)
         println("Application scala routine, line 36, request body = " + request.body)
         println("Application scala routine, line 37, request body to String = " + request.toString)
         Ok("received simple stuff" + request.toString + "body..." + request.body.toString)
  }  
  
  
}