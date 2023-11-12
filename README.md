# StudIt

## Integrantes 2-TDSR
  
  Abner Rodrigues Ferreira - RM: 93576
  Davi Oliveira Da Silva - RM: 95535
  Emerson Nascimento Figueredo Silva - RM:95199
  Guilherme De Jesus Ferreira - RM: 95542
  João Victor Oliveira Da Silva - RM: 94231

---

## How to Do Cloud

### Criado o Servidor SQL e o Banco no portal da Azure
  Comandos no Azure Client
  ``` js
    az group create --name rg-bcosql --location brazilsouth
    az sql server create -l brazilsouth -g rg-bcosql -n sqlserver-rm95199 -u admsql -p devops@Fiap2tds --enable-public-network true
    az sql db create -g rg-bcosql -s sqlserver-rm95199 -n lifeshare --service-objective Basic --backup-storage-redundancy Local --zone-redundant false
    az sql server firewall-rule create -g rg-bcosql -s sqlserver-rm95199 -n AllowAll --start-ip-address 0.0.0.0 --end-ip-address 255.255.255.255
  ```
  Servidor SQL
  ![image](https://github.com/emersonnfs/studIt/assets/101301360/10362d77-28b7-4773-9f69-a4d0ea079de6)
  
  SQL Database liveshare
  ![image](https://github.com/emersonnfs/studIt/assets/101301360/bb1485eb-7e40-4de2-b84f-3b4b37984c92)

---

### Criado Deploy de Web App Azure
  Após baixar o plugin da Azure no Intellij em Tools>Azure>Deploy to Azure Web Apps
  ![Captura de tela 2023-10-10 104058](https://github.com/emersonnfs/studIt/assets/101301360/da568585-bdfc-494d-8edf-0698f656970e)
  
  Escolha a plataforma e nome(que será o domínio)
  ![Captura de tela 2023-10-10 104243](https://github.com/emersonnfs/studIt/assets/101301360/28e4860b-6183-44b2-956f-4ffe7740d9dd)

  Aperte Run e o Web App será feito a criação do Grupo de Recursos , Plano de Serviço e Serviço de APP
  ![Captura de tela 2023-10-10 104311](https://github.com/emersonnfs/studIt/assets/101301360/f004f90d-f16c-4ad4-9999-4fc60b32a4de)

  Criado o  Grupo de Recursos e o Plano de Serviço
  ![Captura de tela 2023-10-10 104351](https://github.com/emersonnfs/studIt/assets/101301360/18fd1d95-8587-4405-ac5a-206d79992418)

  Criado o Web App na Azure com a URL funcional
  ![Captura de tela 2023-10-10 104616](https://github.com/emersonnfs/studIt/assets/101301360/94a2a958-efa3-4d4e-8b8f-70e1d776292c)

---

## Exemplo de Operações GET, POST, PUT e DELETE
   ``` json
    {
    	"info": {
    		"_postman_id": "313223fd-dc47-4276-9f53-14c0f97c8199",
    		"name": "CP5-Devops",
    		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
    		"_exporter_id": "23679644"
    	},
    	"item": [
    		{
    			"name": "Registrar Usuario",
    			"request": {
    				"method": "POST",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n    \"nome\": \"Ozzy Osbourne\",\r\n    \"email\": \"ozzy@email.com\",\r\n    \"senha\": \"NoMoreTears\",\r\n    \"dataNascimento\": \"1948-12-03T00:00:00\"\r\n}",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/usuario",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"usuario"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Login Usuario",
    			"request": {
    				"method": "POST",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n    \"email\" : \"emerson@email.com\",\r\n    \"senha\" : \"senha123\"\r\n}",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/usuario/login",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"usuario",
    						"login"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Post Exercicio",
    			"request": {
    				"method": "POST",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n  \"pergunta\": \"Qual é o rio mais longo do mundo?\",\r\n  \"alternativas\": [\"Rio Amazonas\", \"Rio Yangtzé\", \"Rio Mississipi\", \"Rio Paraná\", \"Rio Nilo\"],\r\n  \"resposta\": \"4\",\r\n  \"resolucao\": \"O rio mais longo do mundo é o Rio Amazonas.\",\r\n  \"materiaEnum\": \"Geografia\",\r\n  \"usuario\": {\"id\": 1}\r\n}\r\n",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/exercicio",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"exercicio"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Get All Exercicio",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/exercicio",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"exercicio"
    					],
    					"query": [
    						{
    							"key": "page",
    							"value": "1",
    							"disabled": true
    						}
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Get Exercicio by Id",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/exercicio/2",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"exercicio",
    						"2"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Post Resumo",
    			"request": {
    				"method": "POST",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n   \"conteudo\": \"A Revolução Industrial foi um dos marcos mais significativos da história, transformando a sociedade e a economia de formas profundas. Explique as causas, consequências e principais inovações desse período.\",\r\n   \"dataCriacao\": \"2023-10-10T10:15:45\",\r\n   \"materiaEnum\": \"Sociologia\",\r\n   \"usuario\": {\"id\": 1}\r\n}\r\n",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/resumo",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"resumo"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Get All Resumos",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/resumo",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"resumo"
    					],
    					"query": [
    						{
    							"key": "",
    							"value": "",
    							"disabled": true
    						}
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Get Resumo by Id",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/resumo/2",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"resumo",
    						"2"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Atualizar Usuario",
    			"request": {
    				"method": "PUT",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n    \"nome\": \"Emerson Silva\",\r\n    \"email\": \"emerson@email.com\",\r\n    \"senha\": \"senha123\",\r\n    \"dataNascimento\": \"1996-11-08T18:30:00\"\r\n}",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/usuario/1",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"usuario",
    						"1"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Get All Usuario",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/usuario",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"usuario"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Get Usuario by id",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/usuario/1",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"usuario",
    						"1"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Atualizar Exercicio",
    			"request": {
    				"method": "PUT",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n  \"pergunta\": \"Qual é o rio mais longo do mundo?\",\r\n  \"alternativas\": [\"Rio Amazonas\", \"Rio Yangtzé\", \"Rio Mississipi\", \"Rio Paraná\", \"Rio Nilo\"],\r\n  \"resposta\": \"0\",\r\n  \"resolucao\": \"O rio mais longo do mundo é o Rio Amazonas.\",\r\n  \"materiaEnum\": \"Geografia\"\r\n}\r\n",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/exercicio/2",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"exercicio",
    						"2"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Atualizar Resumo",
    			"request": {
    				"method": "PUT",
    				"header": [],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n   \"conteudo\": \"A Revolução Industrial foi um dos marcos mais significativos da história, transformando a sociedade e a economia de formas profundas. Explique as causas, consequências e principais inovações desse período.\",\r\n   \"dataCriacao\": \"2023-10-10T10:15:45\",\r\n   \"materiaEnum\": \"Historia\"\r\n}\r\n",
    					"options": {
    						"raw": {
    							"language": "json"
    						}
    					}
    				},
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/resumo/2",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"resumo",
    						"2"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Delete Exercicio",
    			"request": {
    				"method": "DELETE",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/exercicio/2",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"exercicio",
    						"2"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Delete Resumo",
    			"request": {
    				"method": "DELETE",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/resumo/2",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"resumo",
    						"2"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "Delete Usuario",
    			"request": {
    				"method": "DELETE",
    				"header": [],
    				"url": {
    					"raw": "app-studit-devops.azurewebsites.net/api/usuario/3",
    					"host": [
    						"app-studit-devops",
    						"azurewebsites",
    						"net"
    					],
    					"path": [
    						"api",
    						"usuario",
    						"3"
    					]
    				}
    			},
    			"response": []
    		}
    	]
    }
  ```
---

## Link youtube: https://youtu.be/mqKhPGVmRlU
