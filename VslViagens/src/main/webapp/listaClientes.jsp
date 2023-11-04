<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;900&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
    />

    <style>
   @import url('https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;500;600;700&display=swap');


* {
    margin: 0;
    padding: 0;
    overflow: hidden;
      font-family: 'Nunito';

}
      body {
        overflow-x: hidden;
        min-height: 100vh;
        background: linear-gradient(45deg, #f3e524, #f2cb04, #f3b806, #ff9d2e);
        background-size: 250% 250%;
        animation: fundogradiente 10s ease infinite;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      @keyframes fundogradiente {
        0% {
          background-position: 0% 50%;
        }

        50% {
          background-position: 100% 50%;
        }

        100% {
          background-position: 0% 50%;
        }
      }


      main {
        display: flex;
        border-radius: 10px;
        justify-content: space-between;
        width: 90%;
        height: 80vh;
        background-color: #ffffff;
      }

      .container-logo {
        display: flex;
        align-items: center;
        justify-content: center;
      }

      .logo {
        width: 160px;
      }

      .telaesquerda-sistema {
        display: flex;
        padding: 30px;
        width: 25%;
        flex-direction: column;
        justify-content: space-between;
        background-color: #232323;
        height: 100%;
        align-items: center;
      }

      .vertical-menu {
        padding: 0;
        height: 70%;
        justify-content: space-between;
        display: flex;
        flex-direction: column;
        list-style-type: none;
      }

      .vertical-menu li {
        color: white;
        text-align: center;
      }

      .vertical-menu li a {
        display: flex;
        align-items: center;
        justify-content: baseline;
        align-content: center;
        text-decoration: none;
        color: inherit;
        padding: 10px;
      }

      .vertical-menu i {
        margin-right: 9px;
        font-size: 24px;
        animation: pulse 1s infinite alternate;
      }

      @keyframes pulse {
        0% {
          transform: scale(1);
        }
        100% {
          transform: scale(1.1);
        }
      }

      h1 {
        font-size: 35px;
      }
      .teladireita-sistema {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 75%;
        text-align: center;
        padding: 10px;
      }


 .table-container {
        display: flex;
        flex-direction: column;
        height: 100%;
        width:100%;
                border:none;
      }

      .table-header {
        position: sticky;
        top: 0;
        background-color: #ffffff;
        z-index: 1;
        border:none;
      }

      .client-table {
        flex: 1;
        overflow-y: auto;
      }

      .table {
        width: 100%;
      }
      
      .table th, .table td {
        border: none; 
      }
    </style>

    <title>Vsl Viagens - PDV </title>
  </head>
  <body>
    <main>
      <div class="telaesquerda-sistema">
        <div class="container-logo">
          <img class="logo" src="imagens/logo.png" alt="VSL Viagens" />
        </div>

        <ul class="vertical-menu">
          <li>
            <a href="index.html"><i class="fas fa-home"></i> Home</a>
          </li>

          <li>
            <a href="cadastroCliente.html"
              ><i class="fas fa-user"></i> Cadastrar</a
            >
          </li>
          <li>
            <a href="buscarCliente.html"
              ><i class="fas fa-search"></i> Consultar</a
            >
          </li>
          <li>
            <a href="LerClientes"><i class="fas fa-list"></i> Lista Clientes</a>
          </li>
                    <li>
            <a href="#"><i class="fas fa-shopping-cart"></i> Destinos</a>
          </li>
        </ul>
      </div>
      <section class="teladireita-sistema">
        <h1>Lista de Clientes</h1>
        <div class="table-container">
          <div class="table-header">
            <table class="table">
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>Email</th>
                  <th>Cpf</th>
                  <th>Cep</th>
                </tr>
              </thead>
            </table>
          </div>
          <div class="client-table">
            <table class="table">
              <tbody>
                <c:forEach items="${clientes}" var="cliente">
                  <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.cep}</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </section>
    </main>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
    