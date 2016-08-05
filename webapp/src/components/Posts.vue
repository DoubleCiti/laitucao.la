<template>
  <div class="posts">
    <h1>Load posts</h1>
    <div class="panel panel-default">
      <div class="panel-body" v-for="post in posts.data">
        <a href="#">{{ post.title }}</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      // Note: modifying `msg` below will not cause changes to occur with
      // hot-reload. As reloaded components preserve their initial state,
      // modifying these values will have no effect.
      posts: this.$http.get('http://127.0.0.1:8080/v1/posts').then((response) => {
        console.log(response);
      }, (response) => {
        console.log('error!');
      })
    }
  }
}
</script>
