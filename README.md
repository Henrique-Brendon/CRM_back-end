🧱 Melhorias Futuras (Planejamento de Arquitetura)
✅ API Gateway com Spring Cloud Gateway
Centralizar chamadas de múltiplos microserviços em um ponto único.

Suporte a rota dinâmica, autenticação e filtragem.

Permite versionamento de APIs e monitoramento centralizado.

✅ Segurança com Spring Security + JWT
Proteger os endpoints com autenticação baseada em token JWT.

Permitir autorização por perfil (admin, cliente, etc).

Adicionar CORS seguro via allowedOriginPatterns.

✅ Banco de Dados de Produção
Migrar do H2 para PostgreSQL ou MySQL.

Usar Flyway/Liquibase para versionamento de schema.

Criar perfis diferentes (dev, prod) com configurações isoladas.

✅ Observabilidade e Logs
Incluir Actuator para métricas e health check.

Integração com Prometheus + Grafana para monitoramento.

Logs estruturados com Log4j + ELK Stack (ElasticSearch, Logstash, Kibana).

✅ Cache
Integração com Redis para cachear autenticações e respostas frequentes.

Reduzir latência e carga em endpoints críticos.

✅ Resiliência com Spring Cloud Circuit Breaker
Usar Resilience4j para fallback automático em falhas de rede ou lentidão de serviços terceiros.

Timeout controlado e tentativas com backoff exponencial.

✅ Docker e Kubernetes
Empacotar como imagem Docker.

Orquestrar microserviços com Kubernetes para alta disponibilidade.

Deploy automatizado via GitHub Actions.

✅ Documentação
Swagger/OpenAPI com Springdoc para descrever e testar endpoints diretamente no navegador.

Postman Collection para facilitar o consumo externo.
