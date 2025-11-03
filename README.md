# Codcoz API Mongo

API REST construída com **Spring Boot 3** e **Java 21**, conectada ao **MongoDB** e hospedada na **Render**.  
É responsável pela manipulação e persistência de dados relacionados a **cardápios**, **receitas**, **ingredientes**, **histórico de chat**, **histórico de chat FAQ** e **empresas**.

A API integra-se com:
- Aplicativo mobile: [codcoz-mobile](https://github.com/Codcoz/codcoz-mobile)
- Aplicação web: [codcoz-react](https://github.com/Codcoz/codcoz-react)

---

## Tecnologias

- Java 21  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- Spring Boot Actuator (`/health`)  
- Spring Validation (Jakarta Validation)  
- SpringDoc OpenAPI (Swagger UI)  
- Lombok  
- Spring Dotenv  
- Docker  

---

## Endpoints e documentação

A API conta com documentação automática via **Swagger UI**:

🔗 **Swagger:** [https://codcoz-api-mongo-eemr.onrender.com/swagger-ui/index.html](https://codcoz-api-mongo-eemr.onrender.com/swagger-ui/index.html)  
🌍 **Base URL:** [https://codcoz-api-mongo-eemr.onrender.com](https://codcoz-api-mongo-eemr.onrender.com)

Principais recursos manipulados:
- `/cardapio`
- `/receita`
- `/ingrediente`
- `/historicoChat`
- `/historicoChatFAQ`
- `/empresa`

---

## Requisitos

- **Java 21+**
- **Maven 3.9+**
- Banco de dados **MongoDB** (local ou na nuvem)

---

## Estrutura do projeto

```text
.
├─ .github/                   # templates e configurações de PR
├─ .mvn/                      # wrapper Maven
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  ├─ controller/       # controladores REST
│  │  │  ├─ dto/              # objetos de transferência de dados
│  │  │  ├─ exception/        # tratamento de exceções
│  │  │  ├─ model/            # modelos de domínio
│  │  │  ├─ repository/       # interfaces de persistência
│  │  │  ├─ service/          # regras de negócio
│  │  │  ├─ validation/       # validações customizadas
│  │  │  └─ MongoCrudApplication.java  # classe principal
│  │  └─ resources/
│  │     └─ application.properties     # configurações do Spring Boot
├─ Dockerfile                  # imagem Docker para deploy
├─ pom.xml                     # dependências e build
├─ PULL_REQUEST_TEMPLATE.md    # template para PRs
└─ README.md
```
---

## Licença

Este projeto é distribuído sob a licença MIT.
Consulte o arquivo LICENSE (se aplicável) para mais detalhes.

---

## Deploy

Hospedado na Render
Fluxo padrão:
1. Gerar o build com Maven:

      ```mvn clean package```

2. A Render executa o .jar gerado automaticamente após o push.

3. Endpoint público:
	👉 https://codcoz-api-mongo-eemr.onrender.com

Também é compatível com outros provedores (Railway, Fly.io, AWS, etc).
