<template>
  <div id="app">
    <Header @goHome="resetToHome" />

    <main class="main-content">
      <HomeView
        v-if="currentView === 'home'"
       q @location-selected="handleLocationSelected"
      />

      <DashboardView
        v-else-if="currentView === 'dashboard'"
        :location="selectedLocation"
        @changeLocation="resetToHome"
        @triggerAlert="showAlert = true"
      />
    </main>

    <Footer />

    <AlertModal
      :isVisible="showAlert"
      @close="showAlert = false"
    />
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'
import HomeView from './components/HomeView.vue'
import DashboardView from './components/DashboardView.vue'
import AlertModal from './components/AlertModal.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer,
    HomeView,
    DashboardView,
    AlertModal
  },
  data() {
    return {
      currentView: 'home',
      selectedLocation: '',
      showAlert: false
    }
  },
  methods: {
    handleLocationSelected(location) {
      this.selectedLocation = location;
      setTimeout(() => {
        this.currentView = 'dashboard';
      }, 500);
    },
    resetToHome() {
      this.currentView = 'home';
      this.selectedLocation = '';
      this.showAlert = false;
    }
  }
}
</script>

<style>
body {
  margin: 0;
  padding: 0;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: #2c3e50;
  background-color: #f8f9fa;
}

#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main-content {
  flex-grow: 1;
}

button {
  cursor: pointer;
}

* {
  box-sizing: border-box;
}
</style>
