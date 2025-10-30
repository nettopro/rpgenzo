import { Component } from '@angular/core';

@Component({
  selector: 'app-acao',
  imports: [],
  templateUrl: './acao.html',
  styleUrl: './acao.scss',
})
export class Acao {
  acaoExpandida = false;

  toggleExpandirAcao() {
    this.acaoExpandida = !this.acaoExpandida;
  }
}
