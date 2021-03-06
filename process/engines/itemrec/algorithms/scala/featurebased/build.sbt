import xerial.sbt.Pack._

name := "predictionio-process-itemrec-algorithms-scala-featurebased"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.1",
  "com.twitter" %% "scalding-args" % "0.8.11",
  "org.clapper" %% "grizzled-slf4j" % "1.0.1",
  "commons-io" % "commons-io" % "2.4")

packSettings

packJarNameConvention := "full"

packExpandedClasspath := true

packGenerateWindowsBatFile := false

packMain := Map(
  "itemrec.featurebased.Batch" ->
  "io.prediction.algorithms.itemrec.featurebased.UserProfileRecommendationBatch",
  "itemrec.featurebased.Realtime" ->
  "io.prediction.algorithms.itemrec.featurebased.UserProfileRecommendationRealtime"
  )

packJvmOpts := Map(
  "itemrec.featurebased.Batch" -> Common.packCommonJvmOpts,
  "itemrec.featurebased.Realtime" -> Common.packCommonJvmOpts
  )


testOptions in Test += Tests.Argument("failtrace")

// Can exclude some paths
// testOptions in Test += Tests.Argument("tracefilter", "/io.prediction.algorithms.itemrec.featurebased.CustomMatcher")
