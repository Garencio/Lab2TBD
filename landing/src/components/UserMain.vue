<template>
  <div class="login-page">
      <router-link to="/">
        <button class="back-button">Volver</button>
      </router-link>
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
  border-radius: 2rem;
  box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.3);
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
  display: flex;
  flex-direction: column; /* Apila los botones verticalmente */
  align-items: center; /* Centra los botones horizontalmente */
  gap: 2rem; /* Espacio entre botones */
}

.login-button,
.register-button {
  min-width: 150px; /* Ajusta según tus necesidades */
  margin: 5px 0; /* Espacio arriba y abajo */
  padding: 10px 20px; /* Añade espacio alrededor del texto del botón */
  border: none;
  border-radius: 5px;

  color: #000000; /* Color del texto de los botones */
  cursor: pointer;
  transition: background-color 0.3s ease; /* Transición de color de fondo */
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
