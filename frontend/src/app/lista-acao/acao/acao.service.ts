import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal } from "@angular/core";
import { Acao } from "./acao";
import { log } from "console";


@Injectable({
  providedIn: 'root',
})
export class AcaoService {

  private httpClient = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/acoes';
  private acoes = signal<Acao[]>([]);

  getTodasAcoes() {
    this.httpClient.get<Acao[]>(`${this.apiUrl}/com-tipo`).subscribe(resultado => console.log(resultado));
  }
}
