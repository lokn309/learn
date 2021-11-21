package lokn.gateway.outbound.okhttp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/21 16:01
 */
public class OkhttpClient {

    public static void main(String[] args) throws InterruptedException {
        String url = "http://127.0.0.1:8801";

    }

    private static void connect(String url) throws InterruptedException {
        int port = 9999;

        ServerBootstrap b = new ServerBootstrap();
        NioEventLoopGroup boos = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(16);
        try {
            b.group(boos, worker);
            b.option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            sc.pipeline().addLast(new OkhttpOutboundHandler());
                        }
                    });
            Channel channel = b.bind(port).sync().channel();
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            channel.closeFuture().sync();
        } finally {
            worker.shutdownGracefully();
            boos.shutdownGracefully();
        }
    }

}
