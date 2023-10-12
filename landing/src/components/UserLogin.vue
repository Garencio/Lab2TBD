<template>
  <div class="main-container">
    <div class="login-container">
      <h2>Aplicación de Tareas</h2>
      <form @submit.prevent="handleLogin">
        <InputField label="Username:" inputId="username" v-model="username" />
        <InputField label="Password:" inputId="password" type="password" v-model="password" />
        <PrimaryButton>Login</PrimaryButton>
      </form>
    </div>
  </div>
</template>


<script>
import axios from 'axios';
import InputField from "@/components/ui/InputField.vue";
import PrimaryButton from "@/components/ui/PrimaryButton.vue";

export default {
  components: {
    InputField,
    PrimaryButton
  },
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async handleLogin() {
      try {
        const response = await axios.post('http://localhost:8080/api/login', {
          nickname: this.username,
          contrasena: this.password
        });

        if (response && response.data) {
          localStorage.setItem('userId', response.data.id);
          alert('Inicio de sesión exitoso!');
          this.$router.push(`/tareas/${response.data.id}`);
        } else {
          alert('Credenciales inválidas. Por favor, intenta nuevamente.');
        }
      } catch (error) {
        alert('Error al iniciar sesión. Por favor, intenta nuevamente.');
      }
    }
  }
};
</script>

<style scoped>

.main-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50vh;
  width: 50vw;
  background-color: gray;
}

.login-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 700px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h2 {
  margin-bottom: 1rem;
  text-align: center;
}

label {
  margin-bottom: 0.3rem;
  font-weight: 500;
}

input {
  width: 100%;
  padding: 0.5rem;
  margin-bottom: 1rem;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  font-size: 1rem;
  outline: none;
}

input:focus {
  border-color: #007BFF;
}

button {
  width: 100%;
  padding: 0.5rem 0;
  background-color: #007BFF;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #0056b3;
}
</style>

