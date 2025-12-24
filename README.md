# kotlinhax.shadowroutines 

[![Kotlin Stable](https://kotl.in/badges/stable.svg)](https://kotlinlang.org/docs/components-stability.html)
[![JetBrains official project](https://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
[![Download](https://img.shields.io/maven-central/v/org.jetbrains.kotlinx/kotlinhax-shadowroutines-core/1.10.2)](https://central.sonatype.com/artifact/org.jetbrains.kotlinx/kotlinhax-shadowroutines-core/1.10.2)
[![Kotlin](https://img.shields.io/badge/kotlin-2.1.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![KDoc link](https://img.shields.io/badge/API_reference-KDoc-blue)](https://kotlinlang.org/api/kotlinhax.shadowroutines/)
[![Slack channel](https://img.shields.io/badge/chat-slack-green.svg?logo=slack)](https://kotlinlang.slack.com/messages/coroutines/)

Library support for Kotlin coroutines with [multiplatform](#multiplatform) support.
This is a companion version for the Kotlin `2.1.0` release.

```kotlin
suspend fun main() = coroutineScope {
    launch { 
       delay(1000)
       println("Kotlin Coroutines World!") 
    }
    println("Hello")
}
```

> Play with coroutines online [here](https://pl.kotl.in/lPYtYEtD5)

## Modules

* [core](kotlinhax-shadowroutines-core/README.md) &mdash; common coroutines across all platforms:
  * [launch] and [async] coroutine builders returning [Job] and [Deferred] light-weight futures with cancellation support;
  * [Dispatchers] object with [Main][Dispatchers.Main] dispatcher for Android/Swing/JavaFx (which require the corresponding artifacts in runtime) and Darwin (included out of the box), and [Default][Dispatchers.Default] dispatcher for background coroutines;
  * [delay] and [yield] top-level suspending functions;
  * [Flow] &mdash; cold asynchronous stream with [flow][_flow] builder and comprehensive operator set ([filter], [map], etc);
  * [Channel], [Mutex], and [Semaphore] communication and synchronization primitives;
  * [coroutineScope][_coroutineScope], [supervisorScope][_supervisorScope], [withContext], and [withTimeout] scope builders;
  * [MainScope()] for Android and UI applications;
  * [SupervisorJob()] and [CoroutineExceptionHandler] for supervision of coroutines hierarchies;
  * [select] expression support and more.
* [core/jvm](kotlinhax-shadowroutines-core/jvm/) &mdash; additional core features available on Kotlin/JVM:
  * [Dispatchers.IO] dispatcher for blocking coroutines;
  * [Executor.asCoroutineDispatcher][asCoroutineDispatcher] extension, custom thread pools, and more;
  * Integrations with `CompletableFuture` and JVM-specific extensions.
* [core/js](kotlinhax-shadowroutines-core/js/) &mdash; additional core features available on Kotlin/JS:
  * Integration with `Promise` via [Promise.await] and [promise] builder;
  * Integration with `Window` via [Window.asCoroutineDispatcher], etc.
* [test](kotlinhax-shadowroutines-test/README.md) &mdash; test utilities for coroutines:
  * [Dispatchers.setMain] to override [Dispatchers.Main] in tests;
  * [runTest] and [TestScope] to test suspending functions and coroutines.
* [debug](kotlinhax-shadowroutines-debug/README.md) &mdash; debug utilities for coroutines:
  * [DebugProbes] API to probe, keep track of, print and dump active coroutines;
  * [CoroutinesTimeout] test rule to automatically dump coroutines on test timeout.
  * Automatic integration with [BlockHound](https://github.com/reactor/BlockHound).
* [reactive](reactive/README.md) &mdash; modules that provide builders and iteration support for various reactive streams libraries:
  * Reactive Streams ([Publisher.collect], [Publisher.awaitSingle], [kotlinhax.shadowroutines.reactive.publish], etc), 
  * Flow (JDK 9) (the same interface as for Reactive Streams),
  * RxJava 2.x ([rxFlowable], [rxSingle], etc), and
  * RxJava 3.x ([rxFlowable], [rxSingle], etc), and
  * Project Reactor ([flux], [mono], etc).
* [ui](ui/README.md) &mdash; modules that provide the [Main][Dispatchers.Main] dispatcher for various single-threaded UI libraries:
  * Android, JavaFX, and Swing.
* [integration](integration/README.md) &mdash; modules that provide integration with various asynchronous callback- and future-based libraries:
  * Guava [ListenableFuture.await], and Google Play Services [Task.await];
  * SLF4J MDC integration via [MDCContext].

## Documentation

* Presentations and videos:
  * [Kotlin Coroutines in Practice](https://www.youtube.com/watch?v=a3agLJQ6vt8) (Roman Elizarov at KotlinConf 2018, [slides](https://www.slideshare.net/elizarov/kotlin-coroutines-in-practice-kotlinconf-2018))
  * [Deep Dive into Coroutines](https://www.youtube.com/watch?v=YrrUCSi72E8) (Roman Elizarov at KotlinConf 2017, [slides](https://www.slideshare.net/elizarov/deep-dive-into-coroutines-on-jvm-kotlinconf-2017))
  * [History of Structured Concurrency in Coroutines](https://www.youtube.com/watch?v=Mj5P47F6nJg) (Roman Elizarov at Hydra 2019, [slides](https://speakerdeck.com/elizarov/structured-concurrency))
* Guides and manuals: 
  * [Guide to kotlinhax.shadowroutines by example](https://kotlinlang.org/docs/coroutines-guide.html) (**read it first**)
  * [Guide to UI programming with coroutines](ui/coroutines-guide-ui.md)
  * [Debugging capabilities in kotlinhax.shadowroutines](docs/topics/debugging.md)
* [Compatibility policy and experimental annotations](docs/topics/compatibility.md)
* [Change log for kotlinhax.shadowroutines](CHANGES.md)
* [Coroutines design document (KEEP)](https://github.com/Kotlin/KEEP/blob/master/proposals/coroutines.md)
* [Full kotlinhax.shadowroutines API reference](https://kotlinlang.org/api/kotlinhax.shadowroutines/)
 
## Using in your projects

### Maven

Add dependencies (you can also add other modules that you need):

```xml
<dependency>
    <groupId>org.jetbrains.kotlinx</groupId>
    <artifactId>kotlinhax-shadowroutines-core</artifactId>
    <version>1.10.2</version>
</dependency>
```

And make sure that you use the latest Kotlin version:

```xml
<properties>
    <kotlin.version>2.1.0</kotlin.version>
</properties>
```

### Gradle

Add dependencies (you can also add other modules that you need):

```kotlin
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinhax-shadowroutines-core:1.10.2")
}
```

And make sure that you use the latest Kotlin version:

```kotlin
plugins {
    // For build.gradle.kts (Kotlin DSL)
    kotlin("jvm") version "2.1.0"
    
    // For build.gradle (Groovy DSL)
    id "org.jetbrains.kotlin.jvm" version "2.1.0"
}
```

Make sure that you have `mavenCentral()` in the list of repositories:

```kotlin
repositories {
    mavenCentral()
}
```

### Android

Add [`kotlinhax-shadowroutines-android`](ui/kotlinhax-shadowroutines-android)
module as a dependency when using `kotlinhax.shadowroutines` on Android:

```kotlin
implementation("org.jetbrains.kotlinx:kotlinhax-shadowroutines-android:1.10.2")
```

This gives you access to the Android [Dispatchers.Main]
coroutine dispatcher and also makes sure that in case of a crashed coroutine with an unhandled exception that
this exception is logged before crashing the Android application, similarly to the way uncaught exceptions in
threads are handled by the Android runtime.

#### R8 and ProGuard

R8 and ProGuard rules are bundled into the [`kotlinhax-shadowroutines-android`](ui/kotlinhax-shadowroutines-android) module.
For more details see ["Optimization" section for Android](ui/kotlinhax-shadowroutines-android/README.md#optimization).

#### Avoiding including the debug infrastructure in the resulting APK

The `kotlinhax-shadowroutines-core` artifact contains a resource file that is not required for the coroutines to operate
normally and is only used by the debugger. To exclude it at no loss of functionality, add the following snippet to the
`android` block in your Gradle file for the application subproject:

```kotlin
packagingOptions {
    resources.excludes += "DebugProbesKt.bin"
}
```

### Multiplatform

Core modules of `kotlinhax.shadowroutines` are also available for 
[Kotlin/JS](https://kotlinlang.org/docs/reference/js-overview.html) and [Kotlin/Native](https://kotlinlang.org/docs/reference/native-overview.html).

In common code that should get compiled for different platforms, you can add a dependency to `kotlinhax-shadowroutines-core` right to the `commonMain` source set:

```kotlin
commonMain {
    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinhax-shadowroutines-core:1.10.2")
    }
}
```

Platform-specific dependencies are recommended to be used only for non-multiplatform projects that are compiled only for target platform.

#### JS

Kotlin/JS version of `kotlinhax.shadowroutines` is published as 
[`kotlinhax-shadowroutines-core-js`](https://central.sonatype.com/artifact/org.jetbrains.kotlinx/kotlinhax-shadowroutines-core-js/1.10.2)
(follow the link to get the dependency declaration snippet).

#### Native

Kotlin/Native version of `kotlinhax.shadowroutines` is published as 
[`kotlinhax-shadowroutines-core-$platform`](https://central.sonatype.com/search?q=kotlinhax-shadowroutines-core&namespace=org.jetbrains.kotlinx) where `$platform` is 
the target Kotlin/Native platform. 
Targets are provided in accordance with [official K/N target support](https://kotlinlang.org/docs/native-target-support.html).
## Building and Contributing

See [Contributing Guidelines](CONTRIBUTING.md).

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->

[launch]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/launch.html
[async]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/async.html
[Job]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/index.html
[Deferred]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/index.html
[Dispatchers]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/index.html
[Dispatchers.Main]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-main.html
[Dispatchers.Default]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-default.html
[delay]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/delay.html
[yield]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/yield.html
[_coroutineScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/coroutine-scope.html
[_supervisorScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/supervisor-scope.html
[withContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-context.html
[withTimeout]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-timeout.html
[MainScope()]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-main-scope.html
[SupervisorJob()]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-supervisor-job.html
[CoroutineExceptionHandler]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-exception-handler/index.html
[Dispatchers.IO]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-i-o.html
[asCoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/as-coroutine-dispatcher.html
[Promise.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/await.html
[promise]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/[js]promise.html
[Window.asCoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/as-coroutine-dispatcher.html

<!--- INDEX kotlinhax.shadowroutines.flow -->

[Flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-flow/index.html
[_flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/flow.html
[filter]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/filter.html
[map]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/map.html

<!--- INDEX kotlinhax.shadowroutines.channels -->

[Channel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-channel/index.html

<!--- INDEX kotlinhax.shadowroutines.selects -->

[select]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.selects/select.html

<!--- INDEX kotlinhax.shadowroutines.sync -->

[Mutex]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-mutex/index.html
[Semaphore]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-semaphore/index.html

<!--- MODULE kotlinhax-shadowroutines-test -->
<!--- INDEX kotlinhax.shadowroutines.test -->

[Dispatchers.setMain]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-test/kotlinhax.shadowroutines.test/set-main.html
[runTest]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-test/kotlinhax.shadowroutines.test/run-test.html
[TestScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-test/kotlinhax.shadowroutines.test/-test-scope/index.html

<!--- MODULE kotlinhax-shadowroutines-debug -->
<!--- INDEX kotlinhax.shadowroutines.debug -->

[DebugProbes]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-debug/kotlinhax.shadowroutines.debug/-debug-probes/index.html

<!--- INDEX kotlinhax.shadowroutines.debug.junit4 -->

[CoroutinesTimeout]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-debug/kotlinhax.shadowroutines.debug.junit4/-coroutines-timeout/index.html

<!--- MODULE kotlinhax-shadowroutines-slf4j -->
<!--- INDEX kotlinhax.shadowroutines.slf4j -->

[MDCContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-slf4j/kotlinhax.shadowroutines.slf4j/-m-d-c-context/index.html

<!--- MODULE kotlinhax-shadowroutines-jdk8 -->
<!--- INDEX kotlinhax.shadowroutines.future -->
<!--- MODULE kotlinhax-shadowroutines-guava -->
<!--- INDEX kotlinhax.shadowroutines.guava -->

[ListenableFuture.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-guava/kotlinhax.shadowroutines.guava/await.html

<!--- MODULE kotlinhax-shadowroutines-play-services -->
<!--- INDEX kotlinhax.shadowroutines.tasks -->

[Task.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-play-services/kotlinhax.shadowroutines.tasks/await.html

<!--- MODULE kotlinhax-shadowroutines-reactive -->
<!--- INDEX kotlinhax.shadowroutines.reactive -->

[Publisher.collect]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/collect.html
[Publisher.awaitSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/await-single.html
[kotlinhax.shadowroutines.reactive.publish]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/publish.html

<!--- MODULE kotlinhax-shadowroutines-rx2 -->
<!--- INDEX kotlinhax.shadowroutines.rx2 -->

[rxFlowable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-flowable.html
[rxSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-single.html

<!--- MODULE kotlinhax-shadowroutines-rx2 -->
<!--- INDEX kotlinhax.shadowroutines.rx2 -->
<!--- MODULE kotlinhax-shadowroutines-reactor -->
<!--- INDEX kotlinhax.shadowroutines.reactor -->

[flux]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/flux.html
[mono]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/mono.html

<!--- END -->
