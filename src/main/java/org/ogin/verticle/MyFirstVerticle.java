package org.ogin.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author ogin
 */
public class MyFirstVerticle extends AbstractVerticle{
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.createHttpServer().requestHandler(r -> {
            r.response().end("<h1>Hello from my first " + "vert.x 3 Application</h1>");
        }).listen(config().getInteger("http.port", 8080), result -> {
            if (result.succeeded()) {
                startFuture.complete();
            } else {
                startFuture.fail(result.cause());
            }
        });

    }
}
