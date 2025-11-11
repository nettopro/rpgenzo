import { Component, model, output } from '@angular/core';
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
}
