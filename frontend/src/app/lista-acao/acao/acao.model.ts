export interface Acao {
  id: number;
  nome: string;
  descricao: string;
  acaoCusto: number;
  acaoLivreCusto: boolean;
  reacaoAcionamento: string;
  requerimento: string;
  tipoNomes: string[];
}