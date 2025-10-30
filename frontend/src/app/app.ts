import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Acao } from './lista-acao/acao/acao';
import { HttpClient } from '@angular/common/http';
import { AcaoService } from './lista-acao/acao/acao.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Acao],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected title = 'frontend';

  private acaoService = new AcaoService();

  ngOnInit() {
    this.acaoService.getTodasAcoes();
  }
}
