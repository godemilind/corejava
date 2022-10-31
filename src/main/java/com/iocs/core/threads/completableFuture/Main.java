package com.iocs.core.threads.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture();
        future = CompletableFuture.supplyAsync(()->"Hello").thenApply(s->s.toUpperCase());
        System.out.println(future.get());
    }
}
