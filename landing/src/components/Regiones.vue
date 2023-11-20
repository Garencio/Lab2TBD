<template>
    <div>
      <Header />
      <div class="region-selector">
        <select v-model="selectedRegion">
          <option value="" disabled>Selecciona una región</option>
          <option v-for="region in regiones" :key="region" :value="region">{{ region }}</option>
        </select>
        <div class="mostrar-button">
        <button @click="fetchEmergencias">Mostrar Emergencias</button>
        </div>

        </div>
  
      <div class="emergencias-list">
        <ul v-if="emergencias.length > 0">
          <li v-for="emergencia in emergencias" :key="emergencia.id">
            <h3>{{ emergencia.nombre }}</h3>
            <p>Descripción: {{ emergencia.descripcion }}</p>
        </li>
        </ul>
        <p v-else>No hay emergencias para mostrar.</p>
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
        regiones: [
            "Región de Arica y Parinacota",
            "Región de Tarapacá",
            "Región de Antofagasta",
            "Región de Magallanes y Antártica Chilena",
            "Región de Aysén del Gral.Ibáñez del Campo",
            "Región de Atacama",
            "Región de Coquimbo",
            "Región de Valparaíso",
            "Región Metropolitana de Santiago",
            "Región de Los Lagos",
            "Región de Los Ríos",
            "Región de La Araucanía",
            "Región del Biobío",
            "Región de Ñuble",
            "Región del Maule",
            "Región del Libertador Bernardo O'Higgins"  
        ], 
        selectedRegion: '',
        emergencias: []
      };
    },
    methods: {
      fetchEmergencias() {
        if (this.selectedRegion) {
          axios.get(`http://localhost:8086/emergencias/region/${this.selectedRegion}`)
            .then(response => {
              this.emergencias = response.data;
            })
            .catch(error => {
              console.error('Error al obtener emergencias:', error);
            });
        }
      }
    }
  };
  </script>

  
  <style>
  .region-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 0;
  padding: 0;
  height: 15vh;
  }

button{
  min-width: 150px; 
  margin: 5px 0; 
  padding: 10px 20px; 
  border: none;
  border-radius: 5px;
  color: #000000; 
  cursor: pointer;
  transition: background-color 0.3s ease; 
  font-family: 'Poppins';
  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);
}

button:hover{
  background-color: rgb(111, 37, 126); 
  color: white;
}

.emergencias-list{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center; 
  margin: 0;
  padding: 0;
  text-align: center;
  margin-bottom: 3rem;
  font-family: 'Poppins';
  font-weight: bold;
  color: rgb(255, 255, 255);
  opacity: 1;
  letter-spacing: 3px;
  flex: 1;
  padding: 2rem;
  margin: 4rem;

  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);
}


  </style>
  