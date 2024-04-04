# Sistema de Administración para el Zoológico de Morelia

Este proyecto consiste en un sistema de administración para el Zoológico de Morelia, diseñado para gestionar las operaciones del zoológico, incluyendo el personal, visitantes y animales. El sistema proporciona funciones para registrar, modificar, eliminar y consultar información sobre empleados, visitantes y animales, con algunas restricciones específicas para las visitas y los mantenimientos.

## Funcionalidades del Sistema

### Empleados
- Registro: Permite registrar información detallada de los empleados, incluyendo:
  - Nombre
  - Apellidos
  - Fecha de nacimiento
  - Fecha de ingreso como trabajador
  - RFC
  - CURP
  - Salario
  - Horario
  - Rol (Veterinario, Guía, Mantenimiento, Administración, etc.)

- Modificación y Eliminación: Se pueden modificar y eliminar empleados, siempre y cuando no rompa alguna relación con otras entidades (como visitas o mantenimientos).

- Consulta: Permite consultar la información de los empleados almacenada en el sistema.

### Visitantes
- Registro: Permite registrar información de los visitantes, incluyendo:
  - Nombre
  - Apellidos
  - Fecha de nacimiento
  - CURP
  - Número de visitas (se incrementa automáticamente cada vez que se registra una visita)
  - Fecha de registro

- Modificación y Eliminación: No se permite modificar o eliminar visitantes una vez registrados, para mantener la integridad de las visitas registradas.

- Consulta: Permite consultar la información de los visitantes almacenada en el sistema.

- Registrar Visita: Cada vez que un visitante llega al zoológico, se puede registrar una visita, incluyendo:
  - Guía a cargo
  - Visitantes en la visita
  - Costo total de la visita (suma de los boletos)
  - Fecha de la visita
  - Cantidad de niños y adultos (calculados a partir de las fechas de nacimiento)
  - Se aplica un descuento del 20% cada 5 visitas.

### Animales
- Registro: Permite registrar información de los animales, incluyendo:
  - Tipo de animal
  - Fecha de nacimiento
  - Fecha de llegada al zoológico
  - Peso
  - Enfermedades (si las tiene)
  - Frecuencia de alimentación
  - Tipo de alimentación
  - Cuenta con vacunas (Sí/No)

- Modificación y Eliminación: Se pueden modificar y eliminar animales, siempre y cuando no rompa alguna relación con otras entidades (como mantenimientos).

- Consulta: Permite consultar la información de los animales almacenada en el sistema.

### Mantenimientos
- Registro: Permite registrar información de los mantenimientos realizados en los animales, incluyendo:
  - Empleado a cargo (rol de Mantenimiento)
  - ID del animal
  - Proceso realizado (Mantenimiento, limpieza, alimentación, etc.)
  - Fecha del proceso
  - Observaciones (opcional)

- Consulta: Permite consultar la información de los mantenimientos realizados.

## Seguridad
- El sistema cuenta con una contraseña para acceder, garantizando que solo el director del zoológico pueda realizar las operaciones descritas.

## Notas Adicionales
- Las visitas y los mantenimientos tienen restricciones específicas: no se pueden eliminar ni modificar una vez registrados.
- El sistema calcula automáticamente la cantidad de niños y adultos en una visita basándose en las fechas de nacimiento de los visitantes.
- Los precios de los boletos por persona son $100 MXN para adultos y $50 MXN para niños.

Este sistema proporciona una solución completa para la gestión del zoológico, permitiendo al director llevar un control detallado del personal, visitantes y animales, así como de las operaciones diarias del zoológico.

## Integrantes
- Carlos Emiliano Magaña Huipe
- Iker Solis Ramirez
- Aaron Telles Magaña
