<template>
  <div class="dashboard">
    <div class="location-bar">
      <div class="location-info">
        <span class="location-icon">📍</span>
        <span class="city-name">{{ location }}</span>
        <span class="weather-info">Max forecast: UV {{ uvIndex }} ({{ getUvLevel() }})</span>
      </div>
      <button class="change-loc-btn" @click="$emit('changeLocation')">Change location</button>
    </div>

    <nav class="sub-nav">
      <ul>
        <li>Understanding UV</li>
        <li>Understanding skin cancer</li>
        <li>Sun protection</li>
        <li>Resources</li>
      </ul>
    </nav>

    <main class="content-area">
      <section class="hero-card" :class="getUvClass()">
        <div class="uv-ring-container">
          <div class="uv-ring">
            <span class="uv-number">{{ uvIndex }}</span>
            <span class="uv-label">{{ getUvLevel() }}</span>
          </div>
        </div>
      </section>

      <section v-if="uvIndex >= 8" class="alert-card">
        <div class="alert-header">
          <span class="alert-icon">⚠</span>
          <h3>Very High UV - This is serious!</h3>
        </div>
      </section>

      <ClothingRecommendations />

      <section class="info-card tips-card">
        <h3>Protection Tips</h3>
        <ul class="tips-list">
          <li>Slip on sun-protective clothing</li>
          <li>Slop on SPF 30+ sunscreen</li>
          <li>Slap on a broad-brimmed hat</li>
          <li>Seek shade</li>
          <li>Slide on sunglasses</li>
        </ul>
      </section>
    </main>
  </div>
</template>

<script>
import ClothingRecommendations from './ClothingRecommendations.vue';

export default {
  components: {
    ClothingRecommendations
  },
  props: ['location'],
  data() {
    return {
      uvIndex: 9,
    }
  },
  methods: {
    getUvLevel() {
      if (this.uvIndex <= 2) return 'LOW';
      if (this.uvIndex <= 5) return 'MODERATE';
      if (this.uvIndex <= 7) return 'HIGH';
      if (this.uvIndex <= 10) return 'VERY HIGH';
      return 'EXTREME';
    },
    getUvClass() {
      return this.getUvLevel().toLowerCase().replace(' ', '-');
    }
  },
  mounted() {
    if (this.uvIndex >= 9) {
      this.$emit('triggerAlert');
    }
  }
}
</script>

<style scoped>
.dashboard {
  background-color: #f4f7fa;
  min-height: 100vh;
  padding-bottom: 40px;
}

.location-bar {
  background: white;
  padding: 15px 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #eee;
  font-size: 0.9rem;
}

.location-info {
  display: flex;
  align-items: center;
  gap: 10px;
  font-weight: 500;
}

.change-loc-btn {
  background: none;
  border: 1px solid #ccc;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 0.8rem;
}

.sub-nav {
  background: #003366;
  color: white;
  padding: 10px 0;
  overflow-x: auto;
}

.sub-nav ul {
  display: flex;
  list-style: none;
  padding: 0 20px;
  margin: 0;
  gap: 20px;
  white-space: nowrap;
}

.content-area {
  padding: 20px;
  max-width: 800px;
  margin-left: auto;
  margin-right: auto;
}

.content-area > * {
  margin-bottom: 20px;
}

.hero-card {
  background: linear-gradient(135deg, #0056b3, #004494);
  color: white;
  border-radius: 12px;
  padding: 30px;
  text-align: center;
  box-shadow: 0 4px 10px rgba(0,50,100,0.2);
}

.uv-ring {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  border: 10px solid rgba(255,255,255,0.3);
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.hero-card.very-high .uv-ring { border-color: #e63946; }
.hero-card.moderate .uv-ring { border-color: #ffb703; }
.hero-card.low .uv-ring { border-color: #2a9d8f; }

.uv-number {
  font-size: 3rem;
  font-weight: bold;
}

.uv-label {
  font-size: 1rem;
  text-transform: uppercase;
}

.alert-card {
  background-color: #ffebee;
  border: 1px solid #ffcdd2;
  color: #b71c1c;
  padding: 15px;
  border-radius: 8px;
}

.info-card {
  background: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0,0,0,0.05);
}

.info-card h3 {
  margin-top: 0;
  border-bottom: 1px solid #eee;
  padding-bottom: 10px;
  margin-bottom: 15px;
}

.tips-list {
  padding-left: 20px;
  line-height: 1.6;
}
</style>
