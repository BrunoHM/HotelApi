#HotelApi

Banco de dados - Postgresql {

	Database: DesafioSenior;
  
	Schema: dtbHotel;
  
	Tabelas: 
		idCheckInOut {
			campo: "id" - Integer not null auto increment primary key;
			campo: "entryDate" - timestamp with time zone ;
			campo: "departureDate" - timestamp with time zone ;
			campo: "additionalGarage" - boolean ;
			campo: "billingValue" - double precision ;
			campo: "person_idPerson" - integer;
		},
    
		person {
			campo: "id" - Integer not null auto increment primary key;
			campo: "firstName" - character varying 30;
			campo: "lastName" - character varying 30;
			campo: "cpf" - character varying 11;
			campo: "ddd" - character varying 3;
			campo: "telephoneNumber" - character varying 9;
		}
},

  Chamadas Rest Disponíveis {
  
    Inserir nova pessoa / Hóspede {
		enderecoDaAplicação:PortaDaAplicação/savePerson
		ex: localhost:8080/savePerson
		Tipo da requisição: Post
		Retorno: true quando inserido com sucesso, false quando não inserido;

		Exemplo de Request (
			"{
			    "id":"",
			    "name":"Bruno", 
			    "lastName":"Murta",
			    "cpf":"12345678999",
			    "ddd":"123",
			    "telephoneNumber":"912345678"
			}"
		)
	}

	Inserir novo checkIn/CheckOut {
		enderecoDaAplicação:PortaDaAplicação/saveCheckInOut
		ex: localhost:8080/saveCheckInOut
		Tipo da requisição: Post
		Retorno: true quando inserido com sucesso, false quando não inserido;

		Exemplo de Request (
			"{
			    "idCheckInOut":"0",
			    "entryDate":"2021-02-01T10:15:30+03:00",
			    "departureDate":null,
			    "additionalGarage":"true",
			    "person_idPerson":1
			}"
		)
	}

	Recuperar todos hóspedes que não estão mais no hotel {
		enderecoDaAplicação:PortaDaAplicação/personOutHotel
		ex: localhost:8080/personOutHotel
		Tipo da requisição: Post
		Retorna uma lista do tipo <Person> quando requisição for executada com sucesso, false quando não;

		Exemplo de retorno(
			"[
			    {
			        "id": 1,
			        "firstName": "bruno",
			        "lastName": "murta",
			        "cpf": "12345678999",
			        "ddd": "47",
			        "telephoneNumber": "945217896"
			    },
			    {
			        "id": 2,
			        "firstName": "Bruno",
			        "lastName": "Murta",
			        "cpf": "12345678999",
			        "ddd": "123",
			        "telephoneNumber": "912345678"
			    },
			    {
			        "id": 5,
			        "firstName": "Bruno",
			        "lastName": "Murta",
			        "cpf": "12345678999",
			        "ddd": "123",
			        "telephoneNumber": "912345678"
			    }
			]"
		)
	}

	Recuperar todos hóspedes que estão no hotel {
		enderecoDaAplicação:PortaDaAplicação/personAtHotel
		ex: localhost:8080/personAtHotel
		Tipo da requisição: Post
		Retorna uma lista do tipo <Person> quando requisição for executada com sucesso, false quando não;

		Exemplo de retorno(
			"[
			    [
			        5,
			        "Bruno",
			        "Murta",
			        "12345678999",
			        "123",
			        "912345678",
			        6431.4800000000005,
			        5441.64
			    ]
			]"
		)
	}

	
	Recuperar alguma pessoa por nome/ sobrenome/ documento/ telefone {
		enderecoDaAplicação:PortaDaAplicação/getPerson
		ex: localhost:8080/getPerson
		Tipo da requisição: Get
		Retorna uma lista do tipo <Person> quando requisição for executada com sucesso, false quando não;
		
		Obs: Busca será feita através do primeiro campo fornecido com algum dado.

		Exemplo de request(
			"{
			    "name":"",
			    "lastName":"",
			    "cpf":"12345678999",
			    "ddd":"123",
			    "telephoneNumber":"912345678"
			}"
		)
	}


	Efetua o checkOut de algum hóspede {
		enderecoDaAplicação:PortaDaAplicação/saveCheckOut
		ex: localhost:8080/saveCheckOut
		Tipo da requisição: Post
		Retorno: true quando efetuado checkout com sucesso, false quando não;

		Exemplo de request(
			"{
			    "idCheckInOut":"1",
			    "entryDate":"2021-01-01T10:15:30+03:00",
			    "departureDate":"2021-01-15T17:15:30+03:00",
			    "additionalGarage":"true"
			}"
		)
	}

}
