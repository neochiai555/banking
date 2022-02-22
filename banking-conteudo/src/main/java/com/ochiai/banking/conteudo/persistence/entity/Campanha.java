package com.ochiai.banking.conteudo.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("campanhas")
public class Campanha {

        @Id
        private String id;

        private String nome;
        private String tipo;
        private String descricao;
        
        public Campanha(String nome, String tipo, String descricao) {
            super();
            this.nome = nome;
            this.tipo = tipo;
            this.descricao = descricao;
        }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}