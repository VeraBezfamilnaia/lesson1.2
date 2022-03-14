public class Worker {
    private static final int ERROR_NUMBER = 33;
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == ERROR_NUMBER) {
                errorCallback.onError("Task " + i + " isn't done");
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}
