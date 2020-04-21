<template>
  <div class="container">
    <div v-show="!testStarted">
      <h4>{{contentPart.name}}</h4>
      <hr />
      <p>{{contentPart.description}}</p>
      <span v-if="questionsList.length==0">The questions are not added to the test yet</span>
      <div v-show="questionsList.length!=0" class="center-align">
        <button
          v-on:click="testStarted=true"
          class="btn-floating btn-large waves-effect waves-light red"
        >
          <i class="material-icons">forward</i>
        </button>
      </div>
    </div>
    <form style="margin-top:50px;" v-if="questionsList.length!=0" v-show="testStarted">
      <div class="row">
        <div class="col s12 m12">{{questionsList[questionIndex].questionText}}</div>
      </div>
      <div class="row">
        <div class="col m6 s12">
          <p>
            <label>
              <input type="checkbox" v-model="optionA" />
              <span>{{questionsList[questionIndex].optionA}}</span>
            </label>
          </p>
        </div>
        <div class="col m6 s12">
          <p>
            <label>
              <input type="checkbox" v-model="optionB" />
              <span>{{questionsList[questionIndex].optionB}}</span>
            </label>
          </p>
        </div>
        <div class="col m6 s12">
          <p>
            <label>
              <input type="checkbox" v-model="optionC" />
              <span>{{questionsList[questionIndex].optionC}}</span>
            </label>
          </p>
        </div>
        <div class="col m6 s12">
          <p>
            <label>
              <input type="checkbox" v-model="optionD" />
              <span>{{questionsList[questionIndex].optionD}}</span>
            </label>
          </p>
        </div>
      </div>
      <div class="row">
        <button
          type="button"
          v-show="questionIndex!=0"
          v-on:click="nextQuestion(-1)"
          class="btn m6"
        >Prev</button>
        <button
          type="button"
          v-show="questionIndex+1!=questionsList.length"
          v-on:click="nextQuestion(1)"
          class="btn m6"
        >Next</button>
        <button
          type="button"
          v-show="questionIndex+1==questionsList.length"
          v-on:click="finishExam()"
          class="btn m6"
        >Finish</button>
      </div>
    </form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "QuizComponent",
  props: {
    id: Number,
    contentId: Number,
    contentPart: Object
  },

  data() {
    return {
      testStarted: false,
      questionIndex: 0,
      optionA: false,
      optionB: false,
      optionC: false,
      optionD: false,
      questionsList: [],
      finalScore: 0,
      attemptedQuestions: 0,
      notAttemptedQuestions: 0
    };
  },
  created() {
    this.getQuestions();
    console.log("commiting" + this.contentPart)

    this.$store.commit('setParentNav','PART',this.contentPart);

  },
  methods: {
    nextQuestion(nextIndex) {
      var selectedAnswer = "";

      if (this.optionA) {
        selectedAnswer += "A";
      }
      if (this.optionB) {
        selectedAnswer += "B";
      }
      if (this.optionC) {
        selectedAnswer += "C";
      }
      if (this.optionD) {
        selectedAnswer += "D";
      }

      this.questionsList[this.questionIndex].selectedAnswer = selectedAnswer;

      this.questionIndex += nextIndex;

      if (this.questionsList[this.questionIndex].selectedAnswer != undefined) {
        this.optionA =
          this.questionsList[this.questionIndex].selectedAnswer.indexOf("A") !=
          -1;
        this.optionB =
          this.questionsList[this.questionIndex].selectedAnswer.indexOf("B") !=
          -1;
        this.optionC =
          this.questionsList[this.questionIndex].selectedAnswer.indexOf("C") !=
          -1;
        this.optionD =
          this.questionsList[this.questionIndex].selectedAnswer.indexOf("D") !=
          -1;
      } else {
        this.optionA = false;
        this.optionB = false;
        this.optionC = false;
        this.optionD = false;
      }
    },
    finishExam() {
      this.nextQuestion(0);
      let correctQuestions = 0;
      let notAttemptedQuestions = 0;
      let attemptedQuestions = 0;

      this.questionsList.forEach(item => {
        if (item.selectedAnswer == item.answer) {
          correctQuestions++;
        }
        if (item.selectedAnswer == undefined || item.selectedAnswer == null) {
          notAttemptedQuestions++;
        }
        attemptedQuestions++;
      });

      let finalScore = (correctQuestions / this.questionsList.length) * 100;

      this.$router.push({
        name: "ScoreCard",
        params: {
          contentPart: this.contentPart,
          score: {
            percentage: finalScore,
            correct: correctQuestions,
            attempted: attemptedQuestions,
            notAttempted: notAttemptedQuestions
          }
        }
      });
    },
    getQuestions() {
      axios
        .get(
          "http://localhost:8080/contents/" +
            this.contentId +
            "/parts/" +
            this.id +
            "/questions/"
        )
        .then(response => {
          this.questionsList = response.data;
        })
        .catch(error => {
          console.log("Something went wrong");
        });
    }
  },
  watch: {
    $route() {
      this.getQuestions();
    }
  }
};
</script>