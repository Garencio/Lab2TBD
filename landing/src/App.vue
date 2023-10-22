<template>
  <div id="app">
    <header>
      <h1></h1>
      <nav>
        <router-link to="/login">Iniciar Sesión</router-link>
        <router-link to="/register">Registrarse</router-link>
      </nav>
    </header>

    <main>
      <router-view v-if="showContent"></router-view>
    </main>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      showContent: true, // Mostrar contenido inicialmente
    };
  },
};
</script>

<style scoped>
</style>
