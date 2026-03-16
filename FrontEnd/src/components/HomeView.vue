<template>
  <div class="home-container">
    <div class="card">
      <h1 class="title">Real-Time UV Protection</h1>
      <p class="subtitle">Know exactly when UV radiation becomes dangerous</p>

      <div class="input-group">
        <label>Set Your Location</label>
        <button class="current-loc-btn" @click="useCurrentLocation">
          <span>📍</span> Use My Current Location
        </button>
      </div>

      <div class="divider">
        <span class="or-text">or</span>
      </div>

      <div class="search-group">
        <input
          type="text"
          placeholder="Enter city name..."
          v-model="city"
          @keyup.enter="searchCity"
        />
        <button class="search-btn" @click="searchCity">Search</button>
      </div>

      <div class="info-text">
        <p>UV levels change rapidly throughout the day.</p>
        <p>Get accurate, localized data to protect your skin.</p>
      </div>
    </div>

    <div v-if="showErrorModal" class="modal-overlay">
      <div class="modal-content">
        <div class="modal-header error-header">
          <span class="warning-icon">❌</span>
          <h2>Location Not Found</h2>
        </div>
        <div class="modal-body">
          <p>We couldn't find the location "{{ city }}". Please check the spelling or try entering a different city.</p>
          <button class="try-again-btn" @click="showErrorModal = false">Try Again</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      city: '',
      showErrorModal: false
    }
  },
  methods: {
    useCurrentLocation() {
      this.$emit('location-selected', 'Current Location');
    },
    searchCity() {
      if (!this.city.trim()) {
        return;
      }

      if (this.city.trim().toLowerCase().startsWith('x')) {
        this.showErrorModal = true;
      } else {
        this.$emit('location-selected', this.city.trim());
      }
    }
  }
}
</script>

<style scoped>
.home-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 80vh;
  background-color: #f0f4f8;
  padding: 20px;
}

.card {
  background-color: white;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-align: center;
  max-width: 500px;
  width: 100%;
}

.title {
  color: #003366;
  margin-bottom: 10px;
}

.subtitle {
  color: #666;
  margin-bottom: 30px;
}

.input-group, .search-group {
  margin-bottom: 20px;
}

.current-loc-btn {
  width: 100%;
  padding: 12px;
  background-color: #007BFF;
  color: white;
  border-style: none;
  border-radius: 6px;
  font-size: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  transition: background-color 0.3s;
}

.current-loc-btn:hover {
  background-color: #0056b3;
}

.divider {
  position: relative;
  text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
}

.divider::before {
  content: "";
  position: absolute;
  top: 50%;
  left: 0;
  width: 100%;
  height: 1px;
  background-color: #ddd;
}

.or-text {
  background-color: white;
  padding-left: 10px;
  padding-right: 10px;
  color: #999;
  position: relative;
}

.search-group {
  display: flex;
  gap: 10px;
}

.search-group input {
  flex-grow: 1;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 6px;
}

.search-btn {
  padding: 10px 20px;
  background-color: #007BFF;
  color: white;
  border-style: none;
  border-radius: 6px;
  cursor: pointer;
}

.info-text {
  margin-top: 30px;
  font-size: 0.9rem;
  color: #888;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background-color: white;
  border-radius: 8px;
  width: 90%;
  max-width: 400px;
  overflow: hidden;
  box-shadow: 0 4px 15px rgba(0,0,0,0.2);
  text-align: center;
}

.modal-header {
  padding: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  color: white;
}

.error-header {
  background-color: #6c757d;
}

.modal-header h2 {
  margin: 0;
  font-size: 1.2rem;
}

.modal-body {
  padding: 20px;
  color: #333;
}

.modal-body p {
  margin-bottom: 20px;
  line-height: 1.5;
}

.try-again-btn {
  background-color: #007BFF;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 6px;
  cursor: pointer;
  font-size: 1rem;
  width: 100%;
}

.try-again-btn:hover {
  background-color: #0056b3;
}
</style>
