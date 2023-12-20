package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.util.ArrayList;
import java.util.List;

public enum CategoriasEnum {

  AMEACA("AMEAÇA"),
  ASSALTO("ASSALTO"),
  HOMICIDIO("HOMICÍDIO"),
  ATOOBSCENO("ATO / ESCRITO / OBJETO OBSCENO"),
  APROPRIAçÃO("APROPRIAçÃO INDÉBITA"),
  DANO("DANO / DEPREDAÇÃO"),
  ESTELIONATO("ESTELIONATO / FRAUDE"),
  POSSEINVASAO("POSSE / INVASÃO DE PROPRIEDADE"),
  CONSTRANGIMENTO("CONSTRANGIMENTO ILEGAL"),
  VIOLACAO("VIOLAÇÃO DE DOMICÍLIO"),
  PERTURBACAO("PERTURBAÇÃO DO SOSSEGO / TRANQUILIDADE PÚBLICA"),
  DESACATO("DESACATO"),
  RETENCAODENOTA("DEIXAR DE ENTREGAR NOTA FISCAL"),
  INTIMIDACAO("FAZER COBRANÇA DE DIVIDAS DE MANEIRA AMEAÇADORA"),
  FALSIDADE("FALSA IDENTIDADE / FALSIDADE IDEOLÓGICA "),
  EXTRAVIO("EXTRAVIO"),
  OUTRAS("OUTRAS OCORRÊNCIAS"),
  CRIMESCONSUMIDOR("CRIMES AO CONSUMIDOR"),
  INTOLERANCIA("INTOLERÂNCIA RELIGIOSA"),
  EXERCÍCIO("EXERCÍCIO ILEGAL DA PROFISSÃO"),
  CRUELDADE("CRUELDADE CONTRA ANIMAIS"),
  VIAS("VIAS DE FATO"),
  RIXA("RIXA"),
  DESENTENDIMENTO("DESENTENDIMENTO/DISCUSSÃO"),
  ASSEDIO("ASSÉDIO SEXUAL"),
  INJURIA("INJURIA QUALIFICADA RACIAL"),
  ROUBO("ROUBO"),
  FURTO("FURTO"),
  VIOLENCIADOMESTICA("VIOLÊNCIA DOMÉSTICA/FAMILIAR"),
  APROPRIACAO("APROPRIAÇÃO DE BENS/RENDIMENTOS"),
  CALUNIA("CALÚNIA"),
  COACAO("COAÇÃO DE IDOSO"),
  DISCRIMINACAO("DISCRIMINAÇÃO"),
  INDUZIMENTO("INDUZIMENTO DE IDOSO"),
  OMISSAO("OMISSÃO DE ASSISTÊNCIA"),
  RETENCAO("RETENÇÃO DE DOCUMENTO"),
  DIFERENCA("DIFERENÇA DE FLUXO  CAIXA"),
  INVASAO("INVASÃO DE DISPOSITIVO INFORMÁTICO"),
  CARCERE("CÁRCERE PRIVADO"),
  DESCUMPRIMENTO("DESCUMPRIMENTO DE MEDIDA PROTETIVA"),
  DIFAMACAO("DIFAMAÇÃO");

  private final String nome;

  private CategoriasEnum(String nome) {
    
    this.nome = nome;
  }

  public String getName() {
    
    return nome;
  }

  public List<String> getAllNames() {

    ArrayList<String> names = new ArrayList<String>();
    
    for (CategoriasEnum categoria : CategoriasEnum.values()) {
      names.add(categoria.getName());
    }

    return names;
  }
}