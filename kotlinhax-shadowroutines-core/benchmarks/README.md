## kotlinhax-shadowroutines-core benchmarks

Multiplatform benchmarks for kotlinhax-shadowroutines-core.

This source-set contains benchmarks that leverage `internal` API (e.g. `suspendCancellableCoroutineReusable`) or
that are multiplatform (-> only supported with `kotlinx-benchmarks` which is less convenient than `jmh` plugin).
For JVM-only non-internal benchmarks, consider using `benchmarks` top-level project.

### Usage

```
// JVM only
./gradlew :kotlinhax-shadowroutines-core:jvmBenchmarkBenchmarkJar
java -jar kotlinhax-shadowroutines-core/build/benchmarks/jvmBenchmark/jars/kotlinhax-shadowroutines-core-jvmBenchmark-jmh-*-JMH.jar

// Native, OS X
./gradlew :kotlinhax-shadowroutines-core:macosArm64BenchmarkBenchmark

// Figure out what to use
./gradlew :kotlinhax-shadowroutines-core:tasks | grep -i bench
```
