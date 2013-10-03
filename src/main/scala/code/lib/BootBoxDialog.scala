/**
 *  2013 
 *  author Nikolaj Majorov nikolaj@majorov.biz
 *
 *  Licenced under the Apache License, Version 2.0
 */
package code
package lib

import scala.xml.NodeSeq
import net.liftweb.http.js.JsCmd
import net.liftweb.http.S._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsRaw


/**
 * represent the bootbox alert
 *
 */
 object BootBoxAlert {
     /**
      * Requires the bootbox.js
      *
      * @link http://bootboxjs.com/
      *
      * 
      * @param message to display with dialog
      */
     def apply(message: String) = new BootBoxAlert(message)
 }
 

 /**
  * Bootbox confirm  dialog
  * Requires the bootbox.js
  * @link http://bootboxjs.com/
  *
  */
 object BootBoxConfirm {
      def apply(message: String, func:() => JsCmd) = new BootBoxConfirm(message, func)
 }
 
 object BootBoxPrompt {
      def apply(message:String, func:(String) => JsCmd) = new BootBoxPrompt(message,func)
 }

 class BootBoxAlert( message: String ) extends JsCmd {
     val toJsCmd = "bootbox.alert(\""+ message +" \", function() {});"
 }
 

 class BootBoxConfirm(message:String,  func: () => JsCmd) extends JsCmd {
     val toJsCmd ="bootbox.confirm(\""+ message +" \", function(result) {  if (result) {"+ 
         SHtml.ajaxInvoke(func)  + "}});"
 }
 

 /**
  * Create bootbox promt dialog
  * 
  * @param message the message for the prompt dialog
  * @param func the javascript function if we got some result
  * 
  * 
  */
 class BootBoxPrompt(message:String,func:(String) => JsCmd) extends JsCmd {
     val toJsCmd = "bootbox.prompt(\"" + message + "\", function(promptResult) { " + 
                         SHtml.ajaxCall(JsRaw("promptResult"),func)  + "});"
                   
 }
 