<template>
  <div class="login-buttons">
    <button class="login-button" @click="login">Iniciar Sesión</button>
    <button class="register-button" @click="register">Registrarse</button>
  </div>
</template>

<script>
export default {
  methods: {
    login() {
      // Lógica para iniciar sesión
      alert("Iniciar Sesión");
    },
    register() {
      // Lógica para registrarse
      alert("Registrarse");
    },
  },
};
</script>

<style scoped>
.login-buttons {
  display: flex;
  justify-content: center;
  align-items: center;
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
}

.login-button {
  background-color: #007BFF;
  color: #fff;
}

.register-button {
  background-color: #34C759;
  color: #fff;
}

.login-button:hover,
.register-button:hover {
  background-color: #0056b3;
}
</style>
