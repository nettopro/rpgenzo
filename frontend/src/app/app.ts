import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Acao } from './lista-acao/acao/acao';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Acao],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'frontend';
}
