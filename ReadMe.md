# 🤖 Spring Boot Telegram Bot

REST API üzerinden Telegram'a mesaj gönderen bir Spring Boot uygulaması.

---

## 📋 İçindekiler

- [Gereksinimler](#gereksinimler)
- [Telegram Bot Oluşturma](#telegram-bot-oluşturma)
- [Chat ID Bulma](#chat-id-bulma)
- [Kurulum](#kurulum)
- [Yapılandırma](#yapılandırma)
- [Kullanım](#kullanım)
- [Proje Yapısı](#proje-yapısı)

---

## ⚙️ Gereksinimler

- Java 17+
- Gradle
- Telegram hesabı

---

## 🤖 Telegram Bot Oluşturma

1. Telegram'da arama kutusuna **@BotFather** yaz ve sohbeti aç
2. `/start` komutunu gönder
3. `/newbot` komutunu gönder
4. Bot için bir **isim** gir (örn: `My_Spring_Boot_Coffee_Bot`)
5. Bot için bir **kullanıcı adı** gir — sonunda `Bot` ile bitmeli (örn: `MySpringBootCoffeeBot`)
6. BotFather sana bir **API token** verecek — bunu kaydet

> ⚠️ Token'ını kimseyle paylaşma ve asla Git'e push'lama!

---

## 🆔 Chat ID Bulma

1. `/mybots` komutu ile botunu seç ve **"Start"** butonuna bas ya da bota `/start` yaz
2. Aşağıdaki URL'yi tarayıcında aç (uygulama **kapalıyken**):

```
https://api.telegram.org/bot{API_TOKEN}/getUpdates
```

3. Dönen JSON içinde `chat.id` alanını bul:

```json
{
  "ok": true,
  "result": [
    {
      "message": {
        "chat": {
          "id": 8476353218
        }
      }
    }
  ]
}
```

> ⚠️ Uygulama çalışırken getUpdates boş döner çünkü bot mesajları zaten tüketir.

---

## 🚀 Kurulum

```bash
git clone https://github.com/furkankayam/spring-boot-telegram.git
cd spring-boot-telegram
./gradlew build
./gradlew bootRun
```

---

## 🔧 Yapılandırma

`src/main/resources/application.yml` dosyasını düzenle:

```yaml
spring:
  application:
    name: spring-boot-telegram

bot:
  name: MySpringBootCoffeeBot
  token: YOUR_BOT_TOKEN
  chat-id: YOUR_CHAT_ID
```

---

## 📡 Kullanım

Uygulama ayağa kalktıktan sonra aşağıdaki endpoint ile Telegram'a mesaj gönderebilirsin:

### GET `/telegram/send`

| Parametre | Tip    | Açıklama          |
|-----------|--------|-------------------|
| `message` | String | Gönderilecek mesaj |

**Tarayıcıdan:**
```
http://localhost:8080/telegram/send?message=Merhaba%20Furkan
```

**cURL:**
```bash
curl "http://localhost:8080/telegram/send?message=Merhaba%20Furkan"
```

**Başarılı Response:**
```
✅ Mesaj gönderildi!
```

---

## 📁 Proje Yapısı

```
spring-boot-telegram/
├── src/
│   ├── main/
│   │   ├── java/com/furkankayam/
│   │   │   ├── SpringBootTelegramApplication.java
│   │   │   ├── bot/
│   │   │   │   └── TelegramBot.java
│   │   │   ├── config/
│   │   │   │   └── TelegramConfig.java
│   │   │   └── controller/
│   │   │       └── TelegramController.java
│   │   └── resources/
│   │       └── application.yml
└── build.gradle
```

---

## 🛠️ Kullanılan Teknolojiler

- [Spring Boot 4.x](https://spring.io/projects/spring-boot)
- [telegrambots-spring-boot-starter 6.9.7.0](https://github.com/rubenlagus/TelegramBots)
- [springdoc-openapi 2.8.0](https://springdoc.org/)
- [Lombok](https://projectlombok.org/)