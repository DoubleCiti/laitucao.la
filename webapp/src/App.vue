<template>
  <div id="app" class="container">
    <posts></posts>
  </div>
</template>

<script>
import Posts from './components/Posts.vue'

export default {
  components: {
    Posts
  }
}
</script>

<style>
body {
  font-family: Helvetica, sans-serif;
}
</style>
