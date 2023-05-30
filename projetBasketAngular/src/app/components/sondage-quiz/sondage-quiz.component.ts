import { Component } from '@angular/core';

@Component({
  selector: 'app-sondage-quiz',
  templateUrl: './sondage-quiz.component.html',
  styleUrls: ['./sondage-quiz.component.css'],
})
export class SondageQuizComponent {
  questions = [
    {
      question:
        'Qui est considéré comme le meilleur joueur de basket-ball de tous les temps ?',
      answers: [
        'Michael Jordan',
        'LeBron James',
        'Kobe Bryant',
        'Magic Johnson',
      ],
      correctAnswer: 'Michael Jordan',
    },
    {
      question: 'Quelle équipe a remporté le championnat NBA en 2020 ?',
      answers: [
        'Los Angeles Lakers',
        'Golden State Warriors',
        'Toronto Raptors',
        'Miami Heat',
      ],
      correctAnswer: 'Los Angeles Lakers',
    },
    // Ajoutez d'autres questions ici
  ];

  currentQuestionIndex = 0;
  currentQuestion = this.questions[this.currentQuestionIndex];
  selectedAnswer!: string | null;

  quizCompleted = false;
  score = 0;

  nextQuestion() {
    if (
      this.selectedAnswer !== null &&
      this.selectedAnswer === this.currentQuestion.correctAnswer
    ) {
      this.score++;
    }

    this.currentQuestionIndex++;

    if (this.currentQuestionIndex < this.questions.length) {
      this.currentQuestion = this.questions[this.currentQuestionIndex];
      this.selectedAnswer = null;
    } else {
      this.quizCompleted = true;
    }
  }

  resetQuiz() {
    this.currentQuestionIndex = 0;
    this.currentQuestion = this.questions[this.currentQuestionIndex];
    this.selectedAnswer = null;
    this.quizCompleted = false;
    this.score = 0;
  }
}
