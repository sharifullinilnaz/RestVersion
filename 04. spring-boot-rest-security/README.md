# JWT

## Links

* [BASE64](https://ru.wikipedia.org/wiki/Base64)

* [JWT WIKI](https://en.wikipedia.org/wiki/JSON_Web_Token)

* [JWT.IO](https://jwt.io/)

## Json Web Token

* Он хранит данные, которые необходимы для проверки прав пользователя и для того, чтобы убедиться что это вообще за пользователь.

* Не нужно обращаться в БД или другое хранилище.

## Структура токена

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwibmFtZSI6Ik1hcnNlbCIsInJvbGUiOiJBRE1JTiJ9.YIC4M1WHckTLf6Wu6BqkYqsP6FrQLnY9w80J5K--68U

```
HEADER
{
  "alg": "HS256",
  "typ": "JWT"
}
PAYLOAD
{
  "sub": "1",
  "name": "Marsel",
  "role": "USER"
}
SIGNATURE
HMAC-SHA256(
 base64urlEncoding(header) + '.' +
 base64urlEncoding(payload),
 secret
)
```

## Составление токена

token = base64urlEncoding(header) + '.' + base64urlEncoding(payload) + '.' + base64urlEncoding(signature)
