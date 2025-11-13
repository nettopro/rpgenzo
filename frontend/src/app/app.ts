import {
  Component,
  computed,
  DestroyRef,
  inject,
  model,
  OnInit,
  signal,
} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AcaoService } from './lista-acao/acao/acao.service';
import { Acao } from './lista-acao/acao/acao.model';
import { AcaoComponent } from './lista-acao/acao/acao';
import { Filtro } from './filtro/filtro';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AcaoComponent, Filtro],
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App implements OnInit {
  protected title = 'frontend';

  private acaoService = new AcaoService();
  acoes = signal<Acao[]>([]);
  private destroyRef = inject(DestroyRef);

  textoFiltro = signal<string>('');
  filtroPontosAcao = signal<number>(1);
  filtroReacao = signal<boolean>(false);
  filtroAcaoLivre = signal<boolean>(false);

  ngOnInit() {
    const subscription = this.acaoService.getTodasAcoes().subscribe({
      next: (acoes) => {
        this.acoes.set(acoes);
        console.log(this.acoes());
      },
      error: (error: Error) => {
        console.error('Erro coletando acoes:', error);
      },
    });
    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    });
  }

  acoesFiltradas = computed(() => {
    const filtro = this.textoFiltro().toLowerCase();
    return this.acoes().filter(
      (acao) =>
        acao.nome.toLowerCase().includes(filtro) &&
        acao.acaoCusto == this.filtroPontosAcao()
    );
  });
}
