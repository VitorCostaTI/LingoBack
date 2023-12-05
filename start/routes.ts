import Route from '@ioc:Adonis/Core/Route'

/*
|--------------------------------------------------------------------------
| Saudações
|--------------------------------------------------------------------------
*/

Route.get('/', async () => {
  return {
    Welcome: 'Seja bem vindo ao servidor back-end Lingo Kennel',
    Tecnologia: 'AdonisJS - TypeScript',
    DevOPS: 'Docker',
    Database: 'SQL',
    Desenvolvedor: 'Vitor Costa'
  }
});

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
  
  /**** Clientes ****/ 
  Route.get('clientes', 'ClientesController.get');
  Route.get('clientes/:id', 'ClientesController.getID');
  Route.post('clientes', 'ClientesController.post');
  Route.put('clientes', 'ClientesController.update');
  Route.delete('clientes', 'ClientesController.delete');

  /**** Empresas ****/ 
  Route.get('empresas', 'EmpresasController.get');
  Route.get('empresas/:id', 'EmpresasController.getID');
  Route.post('empresas', 'EmpresasController.post');
  Route.put('empresas', 'EmpresasController.update');
  Route.delete('empresas', 'EmpresasController.delete');

  /**** Usuarios ****/ 
  Route.get('usuarios', 'UsuariosController.get');
  Route.get('usuarios/:id', 'UsuariosController.getID');
  Route.post('usuarios', 'UsuariosController.post');
  Route.put('usuarios', 'UsuariosController.update');
  Route.delete('usuarios', 'UsuariosController.delete');
  
}).prefix('/api').middleware('auth')
