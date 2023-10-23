<template>
  <div class="form-group">
    <label :for="inputId">{{ label }}</label>
    <input :type="type" :id="inputId" :value="modelValue" @input="updateValue">
  </div>
</template>

<script>
export default {
  props: {
    label: String,
    type: {
      type: String,
      default: 'text'
    },
    inputId: String,
    modelValue: String
  },
  methods: {
    updateValue(event) {
      this.$emit('update:modelValue', event.target.value);
    }
  }
};
</script>

<style scoped>

</style>
