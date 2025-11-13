export interface Acao {
  id: number;
  nome: string;
  descricao: string;
  acaoCusto: number;
  ehAcaoLivre: boolean;
  ehReacao: boolean;
  reacaoAcionamento: string;
  requerimento: string;
  sucessoCritico: string;
  sucesso: string;
  falha: string;
  falhaCritica: string;
  tipoNomes: string[];
}