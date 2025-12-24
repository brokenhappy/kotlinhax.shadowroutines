# Module kotlinhax-shadowroutines-play-services

Integration with Google Play Services [Tasks API](https://developers.google.com/android/guides/tasks).

Extension functions:

| **Name** | **Description**
| -------- | ---------------
| [Task.asDeferred][asDeferred] | Converts a Task into a Deferred
| [Task.await][await] | Awaits for completion of the Task (cancellable)
| [Deferred.asTask][asTask] | Converts a deferred value to a Task

## Example

Using Firebase APIs becomes simple:

```kotlin
FirebaseAuth.getInstance().signInAnonymously().await()
val snapshot = try {
    FirebaseFirestore.getInstance().document("users/$id").get().await() // Cancellable await
} catch (e: FirebaseFirestoreException) {
    // Handle exception
    return@async
}

// Do stuff
```

If the `Task` supports cancellation via passing a `CancellationToken`, pass the corresponding `CancellationTokenSource` to `asDeferred` or `await` to support bi-directional cancellation:

```kotlin
val cancellationTokenSource = CancellationTokenSource()
val currentLocationTask = fusedLocationProviderClient.getCurrentLocation(PRIORITY_HIGH_ACCURACY, cancellationTokenSource.token)
val currentLocation = currentLocationTask.await(cancellationTokenSource) // cancelling `await` also cancels `currentLocationTask`, and vice versa
```


<!--- MODULE kotlinhax-shadowroutines-play-services -->
<!--- INDEX kotlinhax.shadowroutines.tasks -->

[asDeferred]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-play-services/kotlinhax.shadowroutines.tasks/as-deferred.html
[await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-play-services/kotlinhax.shadowroutines.tasks/await.html
[asTask]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-play-services/kotlinhax.shadowroutines.tasks/as-task.html

<!--- END -->
