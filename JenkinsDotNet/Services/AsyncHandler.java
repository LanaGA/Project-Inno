package JenkinsDotNet.Services;


import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

class AsyncHandler implements CompletionHandler<Integer, ByteBuffer>
{
    CompletableFuture<Byte> future;
    int state;
    String filePath;

    public AsyncHandler(CompletableFuture<Byte> future, String filePath)
    {
        this.future = future;
        this.state = 0;
        this.filePath = filePath;
    }

    @Override
    public void completed(Integer arg0, ByteBuffer arg1) {
        try {
            if (state == 0) {
                state = 1;
                Path path = Paths.get(filePath);
                AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);

                ByteBuffer buffer = ByteBuffer.allocate(100_000);
                channel.read(buffer, 0, buffer, this);
                return;
            } else {
                Byte ret = arg1.get(0);
                future.complete(ret);
            }

        } catch (Exception e) {
            future.completeExceptionally(e);
        }
    }

    @Override
    public void failed(Throwable arg0, ByteBuffer arg1) {
        future.completeExceptionally(arg0);
    }
}