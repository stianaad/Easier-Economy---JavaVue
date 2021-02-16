<template>
  <v-card
    class="mx-auto"
    max-width="350"
  >
    <v-img
      height="200"
      :src="url"
    ></v-img>

    <v-card-title>{{title}}</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="rating"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ml-4">
          4.5 (413)
        </div>
        <div>
          {{description}}
        </div>
      </v-row>
    </v-card-text>
    <v-divider class="mx-4"></v-divider>
    <v-card-text>
      <v-row align="center" class="mx-0">
        <v-icon>mdi-clock-time-nine-outline</v-icon>
        <div class="grey-darken-3--text ml-4">
          {{minutes}} min
        </div>
        <v-icon class="ml-10">mdi-currency-usd</v-icon>
        <div class="grey-darken-3--text ml-4">
          {{price}} kr
        </div>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
  export default {
    props: {
      title: String,
      rating: Number,
      description: String,
      minutes: Number,
      price: Number,
      url: String
    }
  }
</script>

