import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal } from "@angular/core";
import { Acao } from "./acao";


@Injectable({
  providedIn: 'root',
})
export class AcaoService {

  private httpClient = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/acoes';
  private acoes = signal<Acao[]>([]);

}
