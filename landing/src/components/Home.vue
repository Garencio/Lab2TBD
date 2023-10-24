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

};
</script>

<style scoped>


.login-container {
  background-color: #24075b;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
}
h2{
  font-family: 'Roboto Mono', monospace;
  text-align: center;
  color: white;
  padding: 10px;
}

.login-buttons {
  text-align: center;
  border: 2px solid rgb(0, 0, 0);
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
