<template>
  <div class="container">
    <div class="column">
      <h2 class="section-title">Lista de Emergencias</h2>
      <ul>
        <li v-for="emergencia in emergencias" :key="emergencia.id">{{ emergencia.nombre }}</li>
      </ul>
    </div>
    <div class="column">
      <h2 class="section-title">Tareas con Menos Voluntarios</h2>
      <ul>
        <li v-for="tarea in tareasConMenosVoluntarios" :key="tarea.id">
          ID: {{tarea.id}} - {{ tarea.nombre }} - Voluntarios inscritos: {{ tarea.voluntariosInscritos }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
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
    }
  }
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: space-between;
  margin: 0px 200px 500px;
}

.column {
  flex: 1;
  padding: 40px 100px;
  border: 1px solid #000000;
  border-radius: 5px;
  background-color: #300870;
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
  font-family: 'Roboto Mono', monospace;
  text-align: center;

}

</style>