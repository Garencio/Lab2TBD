<template>
  <div>
    <Header />

    <div class="container">
      <div class="column">
        <h2 class="section-title">LISTA DE EMERGENCIAS</h2>
        <ul>
          <li v-for="emergencia in emergencias" :key="emergencia.id">{{ emergencia.nombre }}</li>
        </ul>
      </div>
      <div class="column">
        <h2 class="section-title">TAREAS CON MENOS VOLUNTARIOS</h2>
        <ul>
          <li v-for="tarea in tareasConMenosVoluntarios" :key="tarea.id">
            ID: {{tarea.id}} - {{ tarea.nombre }} - Voluntarios inscritos: {{ tarea.voluntariosInscritos }}
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from '@/components/Header.vue';

export default {
  components: {
    Header 
  },
  data() {
    return {
      emergencias: [],
      emergenciaTareas: {},
      tareaVoluntarios: {},
    };
  },
  computed: {
    tareasConMenosVoluntarios() {
      const tareas = [];
      for (const [emergenciaId, tareasDeEmergencia] of Object.entries(this.emergenciaTareas)) {
        for (const tarea of tareasDeEmergencia) {
          const voluntariosInscritos = this.tareaVoluntarios[tarea.id] || 0;
          tareas.push({ ...tarea, voluntariosInscritos });
        }
      }
      return tareas;
    }
  },
  mounted() {
    this.obtenerDatos();
  },
  methods: {
    async obtenerDatos() {
      try {
        const response = await axios.get('http://localhost:8086/api/voluntario/listado-emergencias-y-tareas');
        this.emergencias = response.data.emergencias;
        this.emergenciaTareas = response.data.emergenciaTareas;
        this.tareaVoluntarios = response.data.tareaVoluntarios;
      } catch (error) {
        console.error('Error al obtener datos:', error);
      }
    },
    logout() {
      localStorage.removeItem('token');
      this.$router.push({ name: 'Admin' });
    }
  }
};
</script>

<style scoped>

.logout-button {
  padding: 5px 10px;
  font-size: 12px;
  cursor: pointer;
  background-color: #44337A;
  color: #ffffff;
  border: 1px solid #ffffff;
  border-radius: 5px;
  transition: background-color 0.3s;
}

.logout-button:hover {
  background-color: #5A4E8D;
}


.container {
  display: flex;
  flex-direction: row; 
  justify-content: center; 
  align-items: center; 
  height: 100vh;}

.column {
  flex: 1;
  padding: 2rem;
  margin: 4rem;
  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);
  background-color: #000000;
  opacity: 0.7;
  letter-spacing: 3px;
}

.section-title {
  font-size: 20px;
  margin-bottom: 10px;
  color: #ffffff;
  font-family: 'Roboto Mono', monospace;
  text-align: center;
}

ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

li {
  margin: 10px 0;
  font-size: 16px;
  color: #ffffff;
  font-family: 'Poppins';
  text-align: center;

}

</style>