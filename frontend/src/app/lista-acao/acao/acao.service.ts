import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Acao } from './acao.model';

@Injectable({
  providedIn: 'root',
})
export class AcaoService {
  private httpClient = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/acoes';

  getTodasAcoes() {
    return this.httpClient.get<Acao[]>(`${this.apiUrl}/com-tipo`);
  }
}
