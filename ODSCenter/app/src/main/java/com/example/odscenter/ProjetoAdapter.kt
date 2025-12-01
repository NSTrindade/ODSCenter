package com.example.odscenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjetoAdapter(private val listaProjetos: List<Projeto>) :
    RecyclerView.Adapter<ProjetoAdapter.ProjetoViewHolder>() {

    // Cria a visualização do item (o cartão)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjetoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_projeto, parent, false)
        return ProjetoViewHolder(view)
    }

    // Preenche os dados no cartão
    override fun onBindViewHolder(holder: ProjetoViewHolder, position: Int) {
        val projeto = listaProjetos[position]
        holder.txtTitulo.text = projeto.titulo
        holder.txtDescricao.text = projeto.descricao
        holder.txtAutor.text = "Por: ${projeto.autor}"
        holder.txtOds.text = "ODS ${projeto.ods}"
    }

    // Diz quantos itens a lista tem
    override fun getItemCount(): Int = listaProjetos.size

    // Classe auxiliar para encontrar os componentes visuais
    class ProjetoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitulo: TextView = view.findViewById(R.id.txtTituloProjeto)
        val txtDescricao: TextView = view.findViewById(R.id.txtDescricaoProjeto)
        val txtAutor: TextView = view.findViewById(R.id.txtAutorProjeto)
        val txtOds: TextView = view.findViewById(R.id.txtOdsProjeto)
    }
}