import sbtappengine.Plugin.{AppengineKeys => gae}

name := "scala-gae-demo"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "jetty" % "6.1.26" % "container",
  "com.google.gwt" % "gwt-user" % "2.5.1"
)

appengineSettings

(gae.onStartHooks in gae.devServer in Compile) += { () =>
  println("hello")
}

(gae.onStopHooks in gae.devServer in Compile) += { () =>
  println("bye")
}

appengineDataNucleusSettings

gae.persistenceApi in gae.enhance in Compile := "JDO"