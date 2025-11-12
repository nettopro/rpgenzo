import { Component, model, output, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-filtro',
  imports: [FormsModule],
  templateUrl: './filtro.html',
  styleUrl: './filtro.scss',
})
export class Filtro {
  filtro = model<string>();
  pontoAcaoFiltro = model<number>();
  reacaoFiltro = model<boolean>();
  acaoLivreFiltro = model<boolean>();

  toggleReacao() {
    this.reacaoFiltro.update(v => !v);
  }

  toggleAcaoLivre() {
    this.acaoLivreFiltro.update(v => !v);
  }
}
