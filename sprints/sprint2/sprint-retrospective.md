# Retrospectiva — Sprint 2

## O que foi entregue
- Implementação de TurmaModel, ProfessorModel e DisciplinaModel
- Controllers com endpoints CRUD para as três entidades
- Integração com MySQL
- Templates Thymeleaf para formulários e listagens
- Pipeline CI/CD no GitHub Actions
- Dockerfile e Docker Compose configurados
- Métricas DORA levantadas

## O que foi bem
- Issues com critérios de aceitação bem definidos
- Padrão de projeto mantido em todas as entidades
- Relacionamentos JPA implementados corretamente
- Docker Compose simplificou o setup local
- Comunicação diária eficaz

## O que pode melhorar
- Falta de testes automatizados (apenas testes manuais)
- Change Failure Rate em 16% (falta de validação)
- Estimativas imprecisas no Cadastro de Professor
- Pipeline CI/CD sem execução de testes
- Faltou documentação do diagrama ER

## O que faremos diferente na Sprint 3
- Implementar testes antes do código (TDD)
- Testes unitários e de integração para todos os endpoints
- Integrar testes automatizados na pipeline
- Meta: Reduzir Change Failure Rate para menos de 10%

