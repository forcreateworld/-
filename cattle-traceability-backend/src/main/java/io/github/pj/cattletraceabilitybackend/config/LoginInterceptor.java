package io.github.pj.cattletraceabilitybackend.config;
import io.github.pj.cattletraceabilitybackend.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor<Claims> implements HandlerInterceptor {

    @Override
    public boolean validateTokenAndSetAttributes(HttpServletRequest request, String token) {
        try {
            // 使用JwtUtils解析Token
            Claims claims = JwtUtils.parseToken(token);
            if (claims != null) {
                // Token有效，进行有效性验证
                if (isValidToken(claims)) {
                    // 将用户信息存入request供后续使用
                    Integer userId = claims.getInteger("userId");
                    String username = claims.getString("username");

                    if (userId != null && username != null) {
                        request.setAttribute("userId", userId);
                        request.setAttribute("username", username);
                        return true; // 请求可以继续
                    } else {
                        // 如果userId或username为null，这也是一种异常情况
                        // 可以记录日志或进行其他处理
                        System.out.println("UserId or Username is null in the JWT claims.");
                    }
                } else {
                    // Token无效或未通过有效性验证
                    System.out.println("Token failed validation checks.");
                }
            } else {
                // Claims为null，可能是因为token解析失败
                System.out.println("Token parsing failed or token is null.");
            }
        } catch (Exception e) {
            // 捕获解析token或进行有效性验证时可能抛出的异常
            System.out.println("Exception occurred during token validation: " + e.getMessage());
        }

        // 在出现任何问题时，返回false，阻止请求继续
        return false;
    }

    // 检查Token的有效性，这可以包括但不限于检查过期时间、确保必要的claims存在等
// 请根据你的实际需求扩展这个方法
    private boolean isValidToken(Claims claims) {
        // 示例：检查token是否过期
        Date expirationDate = claims.getExpiration();
        if (expirationDate != null && expirationDate.before(new Date())) {
            return false; // Token已过期
        }

        // 这里可以添加更多的验证逻辑

        return true; // Token通过验证
    }
}
