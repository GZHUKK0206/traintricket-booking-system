package big_work.big_work.utils;

import big_work.big_work.Pojo.Guest;
import big_work.big_work.Pojo.Operator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Jwtutils {
    // 建议将密钥保存在安全的地方，不要硬编码在代码中

    private static String secretKey = "123";
    private static long expirationTime = 3600000; // 默认过期时间 1 小时

    public static String generateToken(Operator operator) {
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalArgumentException("Secret key cannot be null or empty.");
        }

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        // 设置 JWT 的载荷
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", operator.getId());
        claims.put("username", operator.getUsername());
        // 注意：密码等敏感信息不应该放在 JWT 的载荷中

        // 生成 JWT 令牌
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }

    public static String generateTokenGuest(Guest guest) {
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalArgumentException("Secret key cannot be null or empty.");
        }

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        // 设置 JWT 的载荷
        Map<String, Object> claims = new HashMap<>();
        claims.put("Guestid", guest.getGuestID());
        claims.put("username", guest.getUsername());
        // 注意：密码等敏感信息不应该放在 JWT 的载荷中

        // 生成 JWT 令牌
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }

    public static Claims parseJWT(String jwt) {
        try {
            if (jwt == null || jwt.isEmpty()) {
                throw new IllegalArgumentException("JWT cannot be null or empty.");
            }

            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes()) // 设置签名密钥
                    .parseClaimsJws(jwt)
                    .getBody();

            System.out.println("guestid="+claims.get("Guestid"));
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
