<template>
  <div class="login-page">
    <div class="login-container">
      <h2>IDENTIFICARSE</h2>
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
.login-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh; 
  margin: 0;
  padding: 0;
}

.login-container {
  text-align: center; 
  padding: 4%;
  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);
  background-color: #000000;
  opacity: 0.6;
}

.login-buttons {
  display: flex;
  flex-direction: column; 
  align-items: center; 
  gap: 2rem; 
}

.login-button, .register-button {
  min-width: 150px; 
  margin: 5px 0; 
  padding: 10px 20px; 
  border: none;
  border-radius: 5px;
  color: #000000; 
  cursor: pointer;
  transition: background-color 0.3s ease; 
  font-family: 'Poppins';
}

h2{
  margin-bottom: 3rem;
  font-family: 'Poppins';
  font-weight: bold;
  color: white;
  opacity: 1;
  letter-spacing: 3px;
}

.login-button:hover, .register-button:hover {
  background-color: rgb(111, 37, 126); 
  color: white;
}
</style>
