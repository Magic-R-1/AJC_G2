import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  searchTerm: string = '';

  search(): void {
    // Effectuez ici l'action de recherche appropriée avec la valeur saisie (this.searchTerm)
    // Par exemple, vous pouvez rediriger vers une nouvelle page de résultats de recherche :
    window.location.href = '/search?q=' + this.searchTerm;
  }

  isScrolled: boolean = false;

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.isScrolled = window.pageYOffset > 0;
  }
}
