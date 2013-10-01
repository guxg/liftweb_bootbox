package code
package lib

import scala.xml.NodeSeq
import net.liftweb.http.js.JsCmd
 
 object BootBoxAlert {
     
    
     /**
      * Requires the bootbox.js
      *
      * @link http://bootboxjs.com/
      *
      * @param html the html for the ModalDialog
      * @param to display
      */
     def apply(message: String) = new BootBoxAlert(message)
 }
 
 class BootBoxAlert(html: NodeSeq, message: String ) extends JsCmd {
     val toJsCmd = fixHtmlCmdFunc("inline", html){
         str => "bootbox.alert(\""+ message +" \", function() {});"
     }
       
 }