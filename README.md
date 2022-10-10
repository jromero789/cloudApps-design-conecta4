# cloudApps-design-conecta4

Datos:
- Master: CloudApps
- Asignatura: Diseño y calidad de software. Práctica Conecta4.
- Alumno: Juan Romero González
- Email: j.romero1.2016@alumnos.urjc.es
- Fecha: 10/10/2022

Contenido:

1. Docs
Contiene modelo del dominio en diagrama de clases

2. DomainModel
- Primera implementación en base a modelo del dominio y ejemplo TicTacToe
- Logica posicionamiento de fichas, validación de columna llena y de tablero lleno
- Comentario: Se guarda información replicada en el board, cómodo para acceso pero puede dar problemas de coherencia
- ToDo: Verificación de connecta4 (usando diagonales entre coordenadas) y representación en consola


3. ModelViewController
- Implementación separando vista de controlador en base implementación anterior y ejemplo TicTacToe
- Logica posicionamiento de fichas y representación del tablero
- Comentario: Se guarda información replicada en el board, cómodo para acceso pero puede dar problemas de coherencia
- ToDo: Verificación de connecta4 (usando diagonales entre coordenadas) y funcionamiento undo, redo

