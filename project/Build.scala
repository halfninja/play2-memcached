import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play2-memcached"
    val appVersion      = "0.1-SNAPSHOT"


    val appDependencies = Seq(
      "spy" % "spymemcached" % "2.6"
    )

    val main = PlayProject(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
      resolvers += "Spy Repository" at "http://files.couchbase.com/maven2",
      organization := "com.github.mumoshu"
    )

    val scalaSample = PlayProject(appName + "-scala-sample", appVersion, path = file("samples/scala"), mainLang = SCALA).settings(
      // Add your own project settings here
    ).dependsOn(main)

    val javaSample = PlayProject(appName + "-java-sample", appVersion, path = file("samples/java"), mainLang = JAVA).settings(
      // Add your own project settings here
    ).dependsOn(main)

}
