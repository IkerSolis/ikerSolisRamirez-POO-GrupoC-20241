# Examen Unidad 3 - BANCO KAMARON
Nos complace presentar el resultado de nuestro trabajo en el desarrollo del sistema para la próxima entidad bancaria **"Banco Kamarón"**. Con un enfoque meticuloso, nuestro equipo ha creado una solución en Java que aborda los requerimientos específicos de la empresa en su transición hacia un banco completo.

El sistema se centra en la gestión de sucursales, comenzando con las dos ubicaciones iniciales: **"Madero"** y **"Acueducto"**. Cada sucursal está diseñada para tener un único gerente, estableciendo así una clara estructura de liderazgo.

Nuestro proceso incluyó un análisis exhaustivo de los requisitos, seguido de la creación de un *diagrama UML* detallado que sirvió como guía para el desarrollo del producto. Estamos seguros de que esta solución no solo cumple con los requisitos actuales, sino que también está preparada para adaptarse y escalar a medida que **Banco Kamarón** continúe su crecimiento en el sector financiero.

<br>

# Roles
El sistema va a contar con los siguientes seis roles:

```javascript
private ObservableList<RolesEmpleados> rolEmpleado;

rolEmpleado.add(new RolesEmpleados(1,"Gerente de sucursal"));
rolEmpleado.add(new RolesEmpleados(2,"Ejecutivos de cuenta"));
rolEmpleado.add(new RolesEmpleados(3,"Capturista"));
rolEmpleado.add(new RolesEmpleados(4,"Clientes"));
rolEmpleado.add(new RolesEmpleados(5,"Inversionistas"));
```

Cada uno de estos roles ha sido cuidadosamente integrado en el sistema para garantizar un funcionamiento fluido y eficiente.

<br>

## Empleados
Cada miembro del equipo contará con un perfil completo, incluyendo los siguientes datos:

|    |    |    |
| ------------ | ------------ | ------------ |
|  Nombre  |  Apellidos  |  Año de nacimiento  |
|  Ciudad  |  Estado  |  RFC  |
|  CURP  |  Dirección  |  Sucursal a la que pertenece  |
|  Salario  |  Rol  |  Fecha de inicio de trabajo  |
|    |    |    | |    

<br>

### Gerente de sucursal
El **Gerente de Sucursal** tiene el privilegio de realizar *todas las operaciones* disponibles en el sistema. Es una pieza clave en nuestra infraestructura, encargado de supervisar y dirigir las actividades en cada sucursal.

Es importante destacar que, una vez que el sistema esté listo para su despliegue, debe contar automáticamente con un **Gerente de Sucursal**registrado por defecto. Esto garantiza un inicio sin contratiempos en nuestras operaciones bancarias y facilita la transición hacia la plena funcionalidad del sistema.
<br>

### Capturista
El **Capturista** desempeña un papel específico en nuestra infraestructura, siendo responsable de *realizar registros o modificaciones* exclusivamente sobre los **ejecutivos de cuenta**. Esto significa que su acceso se limita únicamente a operaciones relacionadas con este grupo de usuarios, asegurando así la integridad y confidencialidad de nuestros datos.

Es esencial destacar que el diseño de este rol se ha enfocado en la seguridad y la eficiencia, permitiendo que el **Capturista** cumpla con sus responsabilidades de manera efectiva y sin riesgos de error.
<br>

### Ejecutivos de Cuenta
El **Ejecutivo de Cuenta** tiene la responsabilidad de llevar a cabo *todo el proceso relacionado con los clientes*, incluyendo registros, modificaciones, eliminaciones, búsquedas y más. Su función abarca desde el primer contacto con el cliente hasta el mantenimiento continuo de su cuenta.

Además, un aspecto destacado de este rol es su capacidad para autorizar solicitudes de tarjetas de crédito por parte de los clientes. Junto con el **Gerente**, el **Ejecutivo de Cuenta** tiene el poder exclusivo de otorgar esta autorización, lo que garantiza un control preciso y seguro sobre este aspecto crítico de nuestros servicios financieros.
<br>

## Clientes
Los **Cliente**s pueden ser dados de alta en el sistema exclusivamente por los empleados con el rol de **Ejecutivos de Cuenta**. Esta medida garantiza un proceso de registro seguro y controlado, llevado a cabo por personal capacitado y autorizado.
Cada cliente contará con un perfil completo, incluyendo los siguientes datos:

|    |    |    |
| ------------ | ------------ | ------------ |
|  Nombre  |  Apellidos  |  Año de nacimiento  |
|  Ciudad  |  Estado  |  RFC  |
|  CURP  |  Dirección  |  Sucursal a la que pertenece  |
|  Fecha de registro  |    |    |  |

<br>

### Tarjetas
Al crear un cliente en nuestro sistema, se le asignará automáticamente una tarjeta de débito con la siguiente información:

|    |    |    |
| ------------ | ------------ | ------------ |
|  Número de tarjeta  |  Fecha de creación  |  Saldo  |
|  CVV  |  Clabe interbancaria  |  Fecha de vencimiento  |
<br>

Cada cliente puede ver las tarjetas asociadas a su cuenta. En nuestro sistema, un cliente puede poseer como máximo una tarjeta de débito y hasta tres tarjetas de crédito.

Las tarjetas de crédito se dividen en tres tipos: **Simplicity, Platino y Oro**. El cliente puede solicitar estas tarjetas una vez que tenga una tarjeta de débito o un saldo igual o mayor a *$50,000 MXN, $100,000 MXN y $200,000 MXN*, respectivamente.

Cada tipo de tarjeta de crédito tiene un límite máximo de crédito, como sigue:

- **Tarjeta Simplicity:** Crédito máximo de *$60,000 MXN*
- **Tarjeta Platino:** Crédito máximo de *$150,000 MXN*
- **Tarjeta Oro:** Crédito máximo de *$400,000 MXN*

```javascript
public enum TipoTarjetaCredito {
    SIMPLICITY,
    PLATINO,
    ORO
}
```

Cuando un cliente realiza una compra con una tarjeta de crédito, el monto de la compra se resta del crédito máximo disponible en la tarjeta. Esto garantiza que el cliente no gaste más de lo permitido. Para volver a gastar con la tarjeta, el cliente debe realizar el pago correspondiente para aumentar su crédito disponible.



## Inversionistas
Los **Inversionistas** son responsables de *proveer fondos al banco* y pueden ser registrados, modificados, eliminados, etc., únicamente por el Gerente. Además, para garantizar la máxima seguridad en el sistema, cualquier operación relacionada con los inversionistas requerirá una contraseña, incluso para el **Gerente**.

Una vez que un inversionista está registrado, tiene la capacidad de ingresar a su perfil y proporcionar fondos al banco. Estos fondos son visibles únicamente para el **Gerente**, quien podrá ver qué inversionista realizó qué movimiento, junto con la fecha correspondiente.
<br>

## Integrantes

- Carlos Emiliano Magaña Huipe
- Aaron Telles Magaña
- Iker Solís Ramírez
