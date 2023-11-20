<template>
  <div class="login-page">
      <div class="login-container">
      <h2>VOLUNTARIADO</h2>
      <div class="login-buttons">
        <router-link to="/user-login">
          <button class="login-button">Iniciar Sesión</button>
        </router-link>
        <router-link to="/user-register">
          <button class="register-button">Registrarse</button>
        </router-link>
        <router-link to="/">
          <button class="back-button">Volver</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  // ...
};
</script>

<style scoped>
.login-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh; /* Ocupa todo el alto de la ventana */
  margin: 0;
  padding: 0;

}

.login-container {
  text-align: center; /* Centra el texto de los elementos hijos */
  padding: 4%;
  
  box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.3);
  background-color: #000000;
  opacity: 0.6;
}

.login-buttons {
  display: flex;
  flex-direction: column; /* Apila los botones verticalmente */
  align-items: center; /* Centra los botones horizontalmente */
  gap: 1rem; /* Espacio entre botones */
}
.login-button, .register-button, .back-button, .login-button {
  min-width: 150px; /* Ajusta según tus necesidades */
  padding: 10px 20px; /* Añade espacio alrededor del texto del botón */
  border: none;
  border-radius: 5px;
  background-color: #ffffff; /* Morado más claro */
  color: #000000;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 30px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Poppins'; /* Aplicar la fuente Roboto Mono */
  margin: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease; /* Transición de color de fondo */
}

.login-button:hover, .register-button:hover, .back-button:hover {
  background-color:rgb(111, 37, 126);
  color: #fff;
}

h2{
  font-family: 'Poppins';
  font-weight: bold;
  color: white;
  opacity: 1;
  letter-spacing: 3px;
  margin-bottom: 2rem;
}
</style>
