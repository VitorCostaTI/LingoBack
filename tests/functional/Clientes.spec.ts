import { test } from '@japa/runner';
import supertest from 'supertest';

const BASE_URL_LOGIN = `http://${process.env.HOST}:${process.env.PORT}`;
const BASE_URL = `http://${process.env.HOST}:${process.env.PORT}/api`;

let authToken = '';

test.group('Clientes CRUD', (group) => {
  group.setup(async () => {
    // Autenticar usuário e obter token
    const authResponse = await supertest(BASE_URL_LOGIN).post('/login').send({
      email: 'vitortecnologia62@gmail.com',
      password: 'vitorcosta'
    });

    authToken = authResponse.body.token;  // Supondo que o token é retornado no campo 'token'
  });

  const cliente = {
    id: 0,
    cliente: "Lorenzo Raimundo Leandro da Mota",
    email: "lorenzo_damota@huios.com.br",
    cpf: "455.817.170-60",
    telefone: "(12) 3579-9327",
    telefone2: "(12) 99508-4456",
    logradouro: "Rua esquina da quadra",
    cep: "13000-000",
    bairro: "Jardim Jacinto",
    cidade: "Jacareí",
    estado: "SP",
    complemento: "Endereço Ficticio"
  };

  test('Cliente POST', async ({ assert }) => {
    try {
      const response = await supertest(BASE_URL)
        .post('/clientes')
        .set('Authorization', `Bearer ${authToken}`)
        .send(cliente);
      assert.equal(response.status, 201);
    } catch (error) {
      assert.fail("Não foi possivel cadastrar cliente: " + error);
    }
  });

  test('Clientes', async ({ assert }) => {
    try {
      const response = await supertest(BASE_URL)
        .get('/clientes')
        .set('Authorization', `Bearer ${authToken}`);
      assert.equal(response.status, 200);
    } catch (error) {
      assert.fail("Não foi possivel buscar clientes: " + error);
    }
  });

  test('Cliente Id', async ({ assert }) => {
    try {
      const response = await supertest(BASE_URL)
        .get('/clientes/0')
        .set('Authorization', `Bearer ${authToken}`);
      assert.equal(response.status, 200);
    } catch (error) {
      assert.fail("Não foi possivel encontrar o cadastro do cliente: " + error);
    }
  });

  test('Cliente PUT', async ({ assert }) => {
    try {
      const response = await supertest(BASE_URL)
        .put('/clientes/0')
        .set('Authorization', `Bearer ${authToken}`)
        .send({ cliente: "Lorenzo Raimundo Leandro da Mota" });
      assert.equal(response.status, 201);
    } catch (error) {
      assert.fail("Não foi possivel cadastrar cliente: " + error);
    }
  });

  test('Delete cliente Id', async ({ assert }) => {
    try {
      const response = await supertest(BASE_URL)
        .delete('/clientes/0')
        .set('Authorization', `Bearer ${authToken}`);
      assert.equal(response.status, 201);
    } catch (error) {
      assert.fail("Não foi possivel deletar cliente: " + error);
    }
  });
});
