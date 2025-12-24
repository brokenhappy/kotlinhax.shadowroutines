package kotlinhax.shadowroutines.test

actual fun testResultChain(block: () -> TestResult, after: (Result<Unit>) -> TestResult): TestResult =
    block().then(
        {
            after(Result.success(Unit))
        }, {
            after(Result.failure(it))
        })
