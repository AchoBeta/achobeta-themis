package com.achobeta.themis.config;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.http.HttpMcpTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class McpConfig {
    @Value("${tavily.api-key:}")
    private String apiKey;

    @Value("${tavily.api-url:https://api.tavily.com/search}")
    private String apiUrl;
// TODO 待测

//    @Bean
//    public McpToolProvider tavilyMcpToolProvider() {
//        // 1. 配置MCP传输方式（HTTP/SSE）
//        McpTransport transport = new HttpMcpTransport.Builder()
//                // Tavily MCP服务的SSE端点URL
//                // 注意：需要确认Tavily是否提供MCP服务，如果没有可以使用其他Web搜索MCP服务
//                .sseUrl("https://api.tavily.com/mcp/sse?api_key=" + apiKey)
//                // 或者使用智谱的Web Search MCP服务作为替代：
//                // .sseUrl("https://open.bigmodel.cn/api/mcp/web_search/sse?Authorization=" + apiKey)
//                .logRequests(true)  // 开启请求日志
//                .logResponses(true) // 开启响应日志
//                .build();
//
//        // 2. 创建MCP客户端
//        McpClient mcpClient = new DefaultMcpClient.Builder()
//                .key("tavilyMcpClient") // 客户端标识
//                .transport(transport)
//                .build();
//
//        // 3. 创建MCP工具提供者
//        return McpToolProvider.builder()
//                .mcpClients(mcpClient)
//                .build();
//    }
}
