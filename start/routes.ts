import Route from '@ioc:Adonis/Core/Route'

/*
|--------------------------------------------------------------------------
| Saudações
|--------------------------------------------------------------------------
*/

// Route.get('/', async () => {
//   return {
//     Welcome: 'Seja bem vindo ao servidor back-end Lingo Kennel',
//     Tecnologia: 'AdonisJS - TypeScript',
//     DevOPS: 'Docker',
//     Database: 'SQL',
//     Desenvolvedor: 'Vitor Costa'
//   }
// });


Route.get('', 'HomeController.index')

/*
|--------------------------------------------------------------------------
| Autenticação
|--------------------------------------------------------------------------
*/

Route.post('login', 'UsuariosController.login');

Route.get('usuario/teste', 'UsuariosController.teste').middleware('auth');

Route.post('logout', 'UsuariosController.logout');


/*
|--------------------------------------------------------------------------
| Funcionalidades
|--------------------------------------------------------------------------
*/


Route.group(() => {

  /**** Auditoria ****/
  Route.get('auditoria', 'AuditoriasController.get');

  /**** Clientes ****/
  Route.get('clientes', 'ClientesController.get');
  Route.get('clientes/:id', 'ClientesController.getID');
  Route.post('clientes', 'ClientesController.post');
  Route.put('clientes/:id', 'ClientesController.update');
  Route.delete('clientes/:id', 'ClientesController.delete');

  /**** Estoque ****/
  Route.get('estoque', 'EstoquesController.get');
  Route.post('estoque', 'EstoquesController.post');
  
  /**** Empresas ****/
  Route.get('empresas', 'EmpresasController.get');
  Route.get('empresas/:id', 'EmpresasController.getID');
  Route.post('empresas', 'EmpresasController.post');
  Route.put('empresas/:id', 'EmpresasController.update');
  Route.delete('empresas/:id', 'EmpresasController.delete');

  /**** Produtos ****/
  Route.get('produtos', 'ProdutosController.get');
  Route.get('produtos/:id', 'ProdutosController.getID');
  Route.post('produtos', 'ProdutosController.post');
  Route.put('produtos/:id', 'ProdutosController.update');
  Route.delete('produtos/:id', 'ProdutosController.delete');

  /**** Pets ****/
  Route.get('pets', 'PetsController.get');
  Route.get('pets/:id', 'PetsController.getID');
  Route.post('pets', 'PetsController.post');
  Route.put('pets/:id', 'PetsController.update');
  Route.delete('pets/:id', 'PetsController.delete');

  /**** Usuarios ****/
  Route.get('usuarios', 'UsuariosController.get');
  Route.get('usuarios/:id', 'UsuariosController.getID');
  Route.post('usuarios', 'UsuariosController.post');
  Route.put('usuarios/:id', 'UsuariosController.update');
  Route.delete('usuarios/:id', 'UsuariosController.delete');

}).prefix('/api').middleware('auth');

Route.post('usuarios', 'UsuariosController.post'); // Separado por praticidade de desenvolvimento