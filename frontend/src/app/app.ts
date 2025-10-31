import { Component, DestroyRef, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AcaoService } from './lista-acao/acao/acao.service';
import { Acao } from './lista-acao/acao/acao.model';
import { AcaoComponent } from './lista-acao/acao/acao';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AcaoComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected title = 'frontend';

  private acaoService = new AcaoService();
  protected acoes = signal<Acao[]>([]);
  private destroyRef = inject(DestroyRef);

  ngOnInit() {
    const subscription = this.acaoService.getTodasAcoes().subscribe(
      {
        next: (acoes) => {
          this.acoes.set(acoes);
          console.log(this.acoes());
        },
        error: (error: Error) => {
          console.error('Erro coletando acoes:', error);
        },
      }
    );
    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    });
  }
}
