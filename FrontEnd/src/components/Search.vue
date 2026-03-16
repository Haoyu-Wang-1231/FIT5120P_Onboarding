<template>
  <div class="search-container">
    <input type="text" v-model="query" placeholder="Enter your search query" />
    <button @click="search">Search</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      query: '',
    };
  },
  methods: {
    search() {
      // Perform search logic here
      console.log('Searching for:', this.query);
    },
  },
};
</script>

<style scoped>
.search-container {
  margin-top: 20px;
}
</style>
