<template>
  <div class="login-page">
    <h2>IDENTIFICARSE</h2>
    <div class="login-container">
      <div class="login-buttons">
        <router-link to="/admin-login">
          <button class="login-button">Coordinador</button>
        </router-link>
        <router-link to="/user-main">
          <button class="register-button">Voluntariado</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  // Lógica del componente
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

.login-buttons {
  display: flex;
  flex-direction: column; /* Apila los botones verticalmente */
  align-items: center; /* Centra los botones horizontalmente */
  gap: 2rem; /* Espacio entre botones */

}

.login-button, .register-button {
  min-width: 150px; /* Ajusta según tus necesidades */
  margin: 5px 0; /* Espacio arriba y abajo */
  padding: 10px 20px; /* Añade espacio alrededor del texto del botón */
  border: none;
  border-radius: 5px;

  color: #000000; /* Color del texto de los botones */
  cursor: pointer;
  transition: background-color 0.3s ease; /* Transición de color de fondo */

}

h2{
  padding: 2rem;
}

.login-button:hover, .register-button:hover {
  background-color: #3A5E8D; /* Cambia el color de fondo al pasar el mouse */
}
</style>
