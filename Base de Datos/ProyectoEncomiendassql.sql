Drop database IF EXISTS ProyectoEncomiendas;
Create database ProyectoEncomiendas;
Use ProyectoEncomiendas;



CREATE table Usuarios(
nombre varchar (20) not null,
apellido varchar (20) not null,
cedulausuario varchar(20) not null,
nombreusuario varchar (20) not null,
claveacceso varchar(20) not null,
tipo varchar(20),
PRIMARY KEY (cedulausuario)
)
ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;


CREATE table Clientes(
nombreremitente varchar (20) not null,
cedulacliente varchar(20) not null,
telefono varchar(20) not null,
direccion varchar(20) not null,
nombredestinatario varchar(20),
PRIMARY KEY (cedulacliente)
)
ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;



CREATE table Encomiendas(
codigopaquete int auto_increment not null,
estado varchar (20) not null,
origen varchar(20) not null,
destino varchar (20) not null,
fecharecibido varchar(20) not null,
fechaentregado varchar(20)  null,
tipo varchar(20) not null,
fk_cedulausuario varchar (20),
fk_cedulacliente varchar (20),
observaciones varchar (20),
PRIMARY KEY (codigopaquete),
FOREIGN KEY (fk_cedulausuario) REFERENCES Usuarios(cedulausuario),
FOREIGN KEY (fk_cedulacliente) REFERENCES Clientes(cedulacliente)
)
ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;




INSERT into Usuarios (nombre,apellido,cedulausuario,nombreusuario,claveacceso,tipo) values ('Laca', 'Sabe',' 17684154', 'admin','1234','Administrador');
INSERT into Usuarios (nombre,apellido,cedulausuario,nombreusuario,claveacceso,tipo) values ('Nelson', 'Baitx',' 15072165', 'elnel','2357','Recepcionista');
INSERT into Usuarios (nombre,apellido,cedulausuario,nombreusuario,claveacceso,tipo) values ('Pedro', 'Perez','51070488 ', 'elpe','5678','Recepcionista');

