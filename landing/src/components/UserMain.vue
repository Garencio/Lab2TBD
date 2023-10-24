<template>
  <router-link to="/">
    <button class="back-button">Volver</button>
  </router-link>
  <div class="login-page">
    <div class="login-container">
      <div class="login-buttons">
        <router-link to="/user-login">
          <button class="login-button">Iniciar Sesión</button>
        </router-link>
        <router-link to="/user-register">
          <button class="register-button">Registrarse</button>
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
  justify-content: center;
  align-items: center;
  background-color: #24075b;
  border-radius: 15px;
}



.login-container {
  background-color: #24075b;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 15px;
}

.back-button {
  background-color: #320a6c; /* Morado más claro */
  margin-bottom: 20px; /* Agrega un margen inferior al botón */
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 20px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace; /* Aplicar la fuente Roboto Mono */
}

.back-button:hover {
  background-color: #5c359c; /* Color de fondo más oscuro al pasar el cursor */
}

.login-buttons {
  text-align: center;
  border: 2px solid #000;
  padding: 20px;
  border-radius: 10px;
}

.login-button,
.register-button {
  padding: 15px 30px;
  font-size: 16px;
  cursor: pointer;
  border: none;
  border-radius: 5px;
  margin: 10px;
  transition: background-color 0.3s, color 0.3s;
  font-family: 'Roboto Mono', monospace;
}

.login-button {
  background-color: #5f2ab6;
  color: #fff;
}

.register-button {
  background-color: #5f2ab6;
  color: #fff;
}

.login-button:hover,
.register-button:hover {
  background-color: #1c2fb7;
  color: #fff;
}
</style>
