java -Drebel.license=$HOME/.jrebel/jrebel.lic -javaagent:$HOME/tools/jrebel-5-3-1/jrebel.jar \
-Drebel.lift_plugin=true -noverify -Xmx1024M -Xss2M -XX:MaxPermSize=512m -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launch-0.12.1.jar "$@"
