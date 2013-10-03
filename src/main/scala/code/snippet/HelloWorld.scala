package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.SHtml._
import _root_.net.liftweb.http.js.{JE,JsCmd,JsCmds}
import JsCmds._ // For implicits
import JE.{JsRaw,Str}
import net.liftweb.common.Loggable

class HelloWorld extends Loggable{
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.toString//date.map(_.toString)

  def alert(in :NodeSeq) = ajaxButton("Alert", () => BootBoxAlert("hello")) 
  
  
  def confirm(in :NodeSeq) = ajaxButton("Confirm", () => BootBoxConfirm("Confirm text",ajaxFunc1))


  def ajaxFunc1() : JsCmd = {
      logger.info("bootbox confirm callback called ");
      JsRaw("alert('confirmed')")
  }

  ///prompt exmample
  def prompt(in:NodeSeq) = ajaxButton("Prompt",() => new BootBoxPrompt("Write something",ajaxFunc2, ajaxFunc3))

  def ajaxFunc2() : JsCmd = {
       logger.info("bootbox confirm callback called ")
       JsRaw("alert('you wrote '+ promptResult)")
   }
   
   def ajaxFunc3() : JsCmd = {
         JsRaw("alert('empty')")
   }
   
  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

