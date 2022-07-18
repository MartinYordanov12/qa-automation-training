package com.yandex.Tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;


public class TestWatcherResult extends BaseTest implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        if(context.getExecutionException().isPresent()){
            Allure.addByteAttachmentAsync(context.getDisplayName(), "image/png", () -> currentScreenShot);
        }
    }
}
