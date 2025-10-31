import { Component, input, OnInit } from '@angular/core';
import { AcaoService } from './acao.service';
import { Acao } from './acao.model';

@Component({
  selector: 'app-acao',
  imports: [],
  templateUrl: './acao.html',
  styleUrl: './acao.scss',
})
export class AcaoComponent {
  acao = input.required<Acao>();

  acaoExpandida = false;

  toggleExpandirAcao() {
    this.acaoExpandida = !this.acaoExpandida;
  }
}
