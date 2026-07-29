export interface NavigationItem {
    label: string
    href?: string
    items?: NavigationItem[]
}

export const navigationLinks: NavigationItem[] = [
    {
    label: "Sobre",
    items: [
      {
        label: "Quem Somos",
        href: "/quem-somos",
      },
      {
        label: "Planejamento Estratégico",
        href: "/planejamento-estrategico",
      },
      {
        label: "Cerfox Geração",
        href: "/cerfox-geracao",
      },
      {
        label: "Cerfox Telecom",
        href: "/cerfox-telecom",
      },
      {
        label: "Cerfox Distribuição",
        href: "/cerfox-distribuicao",
      },
      {
        label: "Programas Sociais",
        href: "/programas-sociais",
      },
      {
        label: "Contabilidade",
        href: "/contabilidade",
      },
      {
        label: "Fornecedores",
        href: "/fornecedores",
      }
    ],
  },
  {
    label: "Agência Virtual",
    items: [
      {
        label: "Agência Virtual",
        href: "/agencia-virtual",
      },
      {
        label: "Falta de Energia",
        href: "/falta-de-energia",
      },
      {
        label: "Convênios",
        href: "/convenios",
      },
      {
        label: "Declaração de Quitação de Débitos",
        href: "/declaracao-de-quitacao-de-debitos",
      }
    ],
  },
  {
    label: "Normas e Projetos",
    items: [
      {
        label: "Geração Distrubuída",
        href: "/geracao-distribuida",
      },
      {
        label: "Projetos Particulares",
        href: "/projetos-particulares",
      },
      {
        label: "Documentos",
        href: "/documentos",
      },
      {
        label: "Mercado Livre - ACL",
        href: "/mercado-livre-acl",
      },
      {
        label: "Informes Técnicos",
        href: "/informes-tecnicos",
      },
      { 
        label: "Contato",
        href: "/contato",
      },
    ],
  },
  {
    label: "Serviços",
    items: [
      {
        label: "Tarifas e Serviços Cobráveis Vigentes",
        href: "/tarifas-e-servicos-cobraveis-vigentes",
      },
      {
        label: "Canais de Relacionamento",
        href: "/canais-de-relacionamento",
      },
      {
        label: "Nova Ligação e Aumento de Carga",
        href: "/nova-ligacao-e-aumento-de-carga",
      },
      {
        label: "Troca de Titularidade",
        href: "/troca-de-titularidade",
      },
      {
        label: "Desligamento da Unidade Consumidora",
        href: "/desligamento-da-unidade-consumidora",
      },
      { 
        label: "Ressarcimento de Danos Elétricos",
        href: "/ressarcimento-de-danos-eletricos",
      },
      { 
        label: "Denúncia de Irregularidades",
        href: "/denuncia-de-irregularidades",
      },
      { 
        label: "Simulação de Consumo",
        href: "/simulacao-de-consumo",
      },
      { 
        label: "Iluminação Pública",
        href: "/iluminacao-publica",
      },
      { 
        label: "Consumo Consciente",
        href: "/consumo-consciente",
      },
      { 
        label: "Resolução 1000",
        href: "/resolucao-1000",
      },
    ],
  },
  {
    label: "Comunicação",
    items: [
      {
        label: "Notícias Semanais",
        href: "/noticias-semanais",
      },
      {
        label: "Notícias Eventuais",
        href: "/noticias-eventuais",
      },
      {
        label: "Política de Privacidade",
        href: "/politica-de-privacidade",
      },
      {
        label: "Resiliência Operacional",
        href: "/resiliencia-operacional",
      },
      {
        label: "Energy View",
        href: "/energy-view",
      },
      { 
        label: "Eventos",
        href: "/eventos",
      },
      { 
        label: "Propaganda",
        href: "/propaganda",
      },
      { 
        label: "Cerfox em Números",
        href: "/cerfox-em-numeros",
      },
      { 
        label: "Editais",
        href: "/editais",
      },
    ],
  },
  {
    label: "Contato",
    href: "#contato",
  },
  {
    label: "Vagas",
    href: "#vagas",
  }
]