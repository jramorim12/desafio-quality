# Desafio Quality - MeLi Bootcamp

## Postman

No diretório raíz, existe um arquivo com uma coleção de Requests do POSTMAN. O nome do arquivo é: Postman - Desafio Quality.json.

## Payload

Todas as funcionalidades recebem o mesmo Payload.

```bash
{
    "name" : "Nome da Casa",
    "district" : "Bairro 01",
    "rooms" : [
        {
            "name" : "Quarto",
            "width" :  4,
            "length" : 5
        },
        {
            "name" : "Cozinha",
            "width" :  3,
            "length" : 6
        }
    ]
}
```

### Descrição dos parâmetros
| Parâmetro | Tipo | Descrição |
| :---: | :---: | :---: |
| name | String | Representa o nome da casa inserida. |
| district | String | Representa o bairro da casa inserida. |
| rooms | List | Representa lista de cômodos da casa. |
| rooms.name | String | Representa o nome de um cômodo da casa. |
| rooms.width | Double | Representa o largura de um cômodo da casa. |
| rooms.length | Double | Representa a comprimento de um cômodo da casa. |

### Validade dos parâmetros
  
Os parâmetros descritos acima, só serão considerados válidos seguindo as seguintes condições. A validação da existencia do bairro inserido, é realizada apenas na funcionalidade US 0002.
  
| Parâmetro | Obrigatório | Validação | Mensagem de Erro |
| :---: | :---: | :--- | :--- |
| name | Sim | * Campo não pode estar vazio <br> * Comece com letra maiúscula <br> * Comprimento máximo de 30 caractéres| * The field name must not be empty <br> * The field name must start with a capital letter <br> * The field name can not exceed 30 characters| 
| district | Sim | * Campo não pode estar vazio <br> * Comprimento máximo de 45 caractéres| * The field district must not be empty <br> * The field name can not exceed 45 characters | 
| rooms | Sim | * Campo não pode estar vazio | * The field rooms must not be empty |
| rooms.name | Sim | * Campo não pode estar vazio <br> * Comece com letra maiúscula <br> * Comprimento máximo de 30 caractéres| * The field 'name' in rooms must not be empty <br> * The field 'name' in rooms must start with a capital letter <br> * The field 'name' in rooms can not exceed 30 characters| 
| rooms.width | Sim | * Campo não pode estar vazio <br> * A largura máxima é de 25 metros <br> * A largura mínima é de 1 metro | * The field 'width' in rooms must not be empty <br> * The field 'width' in rooms must not exceed 25 meters <br> * The field 'width' in rooms must have, at least, 1 meter| 
| rooms.length | Sim | * Campo não pode estar vazio <br> * O comprimento máximo é de 33 metros <br> * O comprimento mínimo é de 1 metro | * The field 'width' in rooms must not be empty <br> * The field 'length' in rooms must not exceed 33 meters <br> * The field 'length' in rooms must have, at least, 1 meter | 

## Funcionalidades

Abaixo todas as funcionalidades implementadas estão descritas.

### US 0001

Retorna a área de uma propriedade.

#### Method: Post
#### Sign: /getHouseArea

#### Response :  

This house has "AREA DA CASA" m².

### US 0002

Retorna o valor de uma propriedade com base na sua localização.

#### Method: Post
#### Sign: /getHousePrice

#### Response :  

The price of the house is R$ "VALOR DA CASA".
  
### US 0003

Retorna o maior cômodo de uma casa.

#### Method: Post
#### Sign: /getBiggestRoom

#### Response :  

The biggest room is "NOME DO CÔMODO", it has "ÁREA DO CÔMODO" m².

### US 0004

Retorna a área de cada cômodo de uma propriedade.

#### Method: Post
#### Sign: /areaEachRoom

#### Response :  

```bash
[
    {
        "name": "Quarto",
        "area": 20.0
    },
    {
        "name": "Cozinha",
        "area": 18.0
    }
]
```
| Parâmetro | Tipo | Descrição |
| :---: | :---: | :---: |
| name | String | Representa o nome do cômodo. |
| area | Double | Representa a área do cômodo. |

