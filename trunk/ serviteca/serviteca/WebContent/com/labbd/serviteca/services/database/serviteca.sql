create table tb_usuario(
  nombre varchar2(20) primary key,
  clave varchar2(15) not null
); 

insert into tb_usuario values('julian','1234');
insert into tb_usuario values('camilo','1234');
insert into tb_usuario values('federico','4567');
insert into tb_usuario values('roberto','4567');
insert into tb_usuario values('guillermo','7897');
insert into tb_usuario values('rodrigo','7897');
insert into tb_usuario values('ramiro','7897');


create table tb_rol(
  codigo varchar2(4) primary key,
  nombre varchar2(20) not null,
  descripcion varchar2(200)
);

insert into tb_rol values('0','root','Administrador del sistema y encargado de la base de datos de la serviteca.');
insert into tb_rol values('1','Administrador','Encargado de agregar y modificar servicios de reparacion y adjuntar y quitar repuestos a los mismos.');
insert into tb_rol values('2','Contador','Encargado de la contabilidad de la empresa.');
insert into tb_rol values('3','Mecanico','Empleado de la serviteca encargado de realizar las reparaciones en los vehiculos.');
insert into tb_rol values('4','Mensajero','Encargado de las encomiendas y transporte de papeleria en la empresa.');

create table tb_rol_por_usuario(
  codigo_rol varchar2(4) references tb_rol,
  nombre_usuario varchar2(20) references tb_usuario,
  primary key(codigo_rol, nombre_usuario)
);

insert into tb_rol_por_usuario values('1','julian');
insert into tb_rol_por_usuario values('2','julian');
insert into tb_rol_por_usuario values('1','camilo');
insert into tb_rol_por_usuario values('2','camilo');
insert into tb_rol_por_usuario values('1','federico');
insert into tb_rol_por_usuario values('2','roberto');
insert into tb_rol_por_usuario values('1','guillermo');
insert into tb_rol_por_usuario values('2','rodrigo');

create table tb_estado(
  codigo varchar2(4) primary key,
  nombre varchar2(20) not null,
  descripcion varchar2(200)
);

insert into tb_estado values('1','En proceso','La reparacion ha sido comenzada y esta en el proceso');
insert into tb_estado values('2','Sin empezar','La reparacion aun no ha sido comenzada');
insert into tb_estado values('3','Cancelada','La reparacion fue cancelada antes de su finalizacion');
insert into tb_estado values('4','Finalizada','La reparacion fue completada en su totalidad');

create table tb_especialidad(
  codigo varchar2(4) primary key,
  nombre varchar2(20) not null,
  descripcion varchar2(200)
);

insert into tb_especialidad values('1','Motores','Especialidad en todo tipo de motores de cualquier modelo y marca de carro');
insert into tb_especialidad values('2','Pintura','Especialidad en pintado de vehiculos y diseño exterior');
insert into tb_especialidad values('3','Electricidad','Especialidad en la parte electrica del vehiculo');
insert into tb_especialidad values('4','Cojineria','Especialidad en asientos e interior del vehiculo');

create table tb_mecanico(
  cedula varchar2(10) primary key,
  nombre varchar2(20) not null,
  apellido varchar2(20) not null,
  tel_fijo varchar2(7),
  tel_movil varchar2(10),
  email varchar2(30),
  sueldo number not null
);

insert into tb_mecanico values('123324','fernando','gomez','2557849','3005484999','fern@gmail.com',600000);
insert into tb_mecanico values('8978945','jaime','ramirez','2998414','3208548444','jaime@gmail.com',750000);
insert into tb_mecanico values('4568791','sebastian','pelaez','2874455','3115698499','seb@gmail.com',1750000);
insert into tb_mecanico values('78894211','camilo','botero','2487799','3236558877','botero@gmail.com',500000);

create table tb_esp_por_mecanico(
  codigo_esp varchar2(4) references tb_especialidad,
  ced_mecanico varchar2(10) references tb_mecanico,
  primary key(codigo_esp, ced_mecanico)
);

insert into tb_esp_por_mecanico values('1','123324');
insert into tb_esp_por_mecanico values('2','123324');
insert into tb_esp_por_mecanico values('2','8978945');
insert into tb_esp_por_mecanico values('3','4568791');
insert into tb_esp_por_mecanico values('4','78894211');


create table tb_proveedor(
  nit varchar2(10) primary key,
  nombre_empresa varchar2(40) not null,
  nombre_encargado varchar2(20) not null,
  apellido_encargado varchar2(20) not null,
  tel_fijo varchar2(7) not null,
  tel_movil varchar2(10) not null,
  email varchar2(30) not null,
  direccion varchar2(30)
);

insert into tb_proveedor values('5467234','respuestos wilmar','wilmar','restrepo','3654322','3252146655','respuesto@wilmar.com','crr 32 # 98 - 29');
insert into tb_proveedor values('7894564','autorepuestos','sofia','jaramillo','3487715','3125986648','autorepuestos@yahoo.com','calle 24C # 105 - 2');
insert into tb_proveedor values('1264654','respuestos medellin','pedro','perez','4581694','3215896455','repmedellin@medellin.com','crr 24B # 48 - 5');

create table tb_repuesto(
  codigo varchar2(10) primary key,
  nombre varchar2(20) not null,
  existencias number not null,
  proveedor references tb_proveedor,
  costo_compra number not null,
  marca varchar2(30) not null,
  descripcion varchar2(200)
);

insert into tb_repuesto values('CH01K', 'Bujia',45,'5467234',24900,'Ridium','');
insert into tb_repuesto values('DH201G', 'Radiador',20,'5467234',120000,'HardH20','');
insert into tb_repuesto values('KKI38H', 'Exosto',45,'7894564',30000,'Faycar','');
insert into tb_repuesto values('GFD8AF', 'Neumatico',3,'7894564',20000,'Pirelli','');
insert into tb_repuesto values('IJ875AA', 'Suspencion',10,'7894564',180000,'Grob','');
insert into tb_repuesto values('CH02P', 'Bujia',99,'1264654',90000,'Astra','');

create table tb_cliente(
  cedula varchar2(10) primary key,
  nombre varchar2(20) not null,
  apellido varchar2(20) not null,
  tel_fijo varchar2(7) not null,
  tel_movil varchar2(10),
  email varchar2(30)
);

insert into tb_cliente values('15464165','juan','perez','4895455','3156545654','juan.perez@gmail.com');
insert into tb_cliente values('489546','pedro','cañola','2498756','3156748654','pedro.cañola@gmail.com');
insert into tb_cliente values('7495145','gloria','martinez','4826947','3105897854','gloria.martinez@gmail.com');
insert into tb_cliente values('7865214','monica','gutierres','7894564','3105789854','monica.gutierres@gmail.com');
insert into tb_cliente values('89446521','laura','orozco','4370456','3004897565','laura.orozco@gmail.com');
insert into tb_cliente (cedula,nombre,apellido,tel_fijo) values('11203648','rafael','lombana','7894156');

create table tb_automovil(
  codigo varchar2(10) primary key,
  placa varchar2(8) not null,
  matricula varchar2(15) not null,
  marca varchar2(10) not null,
  linea varchar(10) not null,
  modelo varchar2(5) not null,
  motor varchar2(15) not null,
  color varchar2(10) not null,
  chasis varchar2(15) not null,
  cliente varchar2(8) references tb_cliente,
  observaciones varchar2(200)
);

insert into tb_automovil values('1','123qwe','12455456545','mazda','seis','2008','45fsdf5486sd','azul','45846fsdf512fs','15464165','reparacion de la puerta delantera derecha');
insert into tb_automovil values('2','854jui','48987456515','renault','twingo','2004','8465fsdf674f','negro','4821d65f45fsd','7495145','reparacion de motor');
insert into tb_automovil values('3','849tre','98456521458','chevrolet','aveo','2010','846f5sdfg645','blanco','245f6gf5gh465','89446521','choque en el bomper trasero');
insert into tb_automovil values('4','489lpi','12654658455','mitsubishi','cielo','1995','45627cdsf654sd','cafe','9954fsd54sdg','11203648','reparado completamente');
insert into tb_automovil values('5','744aer','89545654565','mazda','alegro','2000','89545dffsd654','plata','356654f6sdg54','7865214','reparado completamente');
insert into tb_automovil values('6','856ert','64751624565','renault','clio','2008','5654654654565','dorado','6565gfgf6545','489546','bujia para motor');
insert into tb_automovil values('7','548lki','65486545584','toyota','prado','2011','545fsdf654vg5','gris','98456ffsdg5455','89446521','reparacion cableado');

create table tb_reparacion(
  codigo varchar2(15) primary key,
  automovil varchar2(10) references tb_automovil,
  fecha_ingreso date not null,
  fecha_salida date not null,
  encargado references tb_mecanico,
  estado references tb_estado,
  costo number  
);

insert into tb_reparacion values('1','1','01/04/2009','02/06/2009','123324','1',1500000);
insert into tb_reparacion values('2','2','01/06/2009','04/07/2009','123324','1',3500000);
insert into tb_reparacion values('3','3','23/06/2010','08/10/2009','8978945','2',200000);
insert into tb_reparacion values('4','4','15/08/2011','01/09/2011','4568791','3',1800000);
insert into tb_reparacion values('5','5','04/04/2011','08/07/2011','4568791','4',350000);
insert into tb_reparacion values('6','6','09/02/2011','10/04/2011','78894211','4',500000);

create table tb_repuesto_por_repa(
  codigo_repuesto varchar2(10) references tb_repuesto,
  codigo_repa varchar2(15) references tb_reparacion,
  cantidad number not null,
  costo_venta number not null
);

insert into tb_repuesto_por_repa values('CH01K','1',5,30000);
insert into tb_repuesto_por_repa values('IJ875AA','1',1,250000);
insert into tb_repuesto_por_repa values('DH201G','2',5,180000);

create table tb_factura(
  codigo varchar2(10) primary key,
  reparacion references tb_reparacion,
  valor_neto number not null,
  iva number not null,
  valor_total number not null
);

create or replace function generar_factura (reparacion in varchar2) return varchar2 is
  costo_reparacion number:=0;
  costo_repuestos number:=0;
  valor_neto number:=0;
  iva number:=0;
  codigo_nuevo varchar2(10):='0';
  valor_total number:=0;
begin
  select costo into costo_reparacion from tb_reparacion where codigo=reparacion;
  select nvl(sum(cantidad * costo_venta),0) into costo_repuestos from tb_repuesto_por_repa where codigo_repa=reparacion;
  valor_neto:= (costo_reparacion + costo_repuestos);
  iva:=  valor_neto*0.16;
  valor_total:= valor_neto + iva;
  codigo_nuevo:='1';
  insert into tb_factura values(codigo_nuevo,reparacion,valor_neto,iva,valor_total);
  select max(codigo) into codigo_nuevo from tb_factura;
  return codigo_nuevo;
end;
/

CREATE SEQUENCE seq_factura
INCREMENT BY 1
START WITH 1
NOMINVALUE
NOMAXVALUE;

CREATE TRIGGER tg_factura
BEFORE INSERT ON tb_factura
FOR EACH ROW
BEGIN
SELECT seq_factura.NEXTVAL INTO :NEW.codigo FROM dual;
END;
/

CREATE SEQUENCE seq_reparacion
INCREMENT BY 1
START WITH 1
NOMINVALUE
NOMAXVALUE;

CREATE TRIGGER tg_reparacion
BEFORE INSERT ON tb_reparacion
FOR EACH ROW
BEGIN
SELECT seq_reparacion.NEXTVAL INTO :NEW.codigo FROM dual;
END;
/

commit;
