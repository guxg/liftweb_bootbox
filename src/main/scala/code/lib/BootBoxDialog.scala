package code
package lib

import scala.xml.NodeSeq
import net.liftweb.http.js.JsCmd
 
 class ModalDialog(html: NodeSeq, message: String ) extends JsCmd {
     val toJsCmd = fixHtmlCmdFunc("inline", html){
         str => "bootbox.alert(\""+ message +" \", function() {});"
     }
       
 }