/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.robertopinetti.geradorxmlnfe.frame.jtable;

import br.com.robertopinetti.geradorxmlnfe.xml.dao.TNFe;
import br.com.robertopinetti.geradorxmlnfe.xml.dao.TNFe.InfNFe.Det.Prod;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asus
 */
public class ProdutoTableModel extends AbstractTableModel {

    private List<TNFe.InfNFe.Det> xmlDet;
    private final List<Prod> prod;
    private final String[] colunas = {"Cód. Produto",
        "Desc. do Produto",
        "Código NCM",
        "CFOP",
        "Unid Comercial",
        "Qtd Comercial",
        "Valor Unit Com",
        "Valor Bruto",
        "Unid. Tributável",
        "Qtd. Tributável",
        "Valor Unit tributação",
        "Compõe o Valor Total",
        "Pedido",
        "Item do Pedido"};

    public ProdutoTableModel() {

        this.prod = new ArrayList<>();

//        // Evento para atualização dos dados
//        super.addTableModelListener((TableModelEvent e) -> {
//            int linha = e.getFirstRow();
//            
//            Prod p = prod.get(linha);
//        });
    }

    /**
     * Preenche a lista da jTable
     *
     * @param lista Lista dos Produtos
     */
    public void addAll(List<TNFe.InfNFe.Det> lista) {

        this.xmlDet = lista;
        this.prod.clear();

        this.xmlDet.stream().forEach((det) -> {

            TNFe.InfNFe.Det d = this.preencheDetalhe(det);

            this.prod.add(d.getProd());

        });

    }   // addAll(List<Prod> lista)

    /**
     * Inclui uma linha no JTable
     *
     * @return
     */
    public TNFe.InfNFe.Det addRow() {

        TNFe.InfNFe.Det d = this.newRow(new TNFe.InfNFe.Det());

        super.fireTableDataChanged();
        return d;

    }   // void addRow

    /**
     *
     * @param linha
     * @param p
     * @return
     */
    public List<TNFe.InfNFe.Det> changeRow(int linha, Prod p) {

        this.prod.set(linha, p);
        this.xmlDet.get(linha).setProd(p);

        super.fireTableDataChanged();
        return this.xmlDet;

    }   // void changeRow

    /**
     * Remove a linha do JTable
     *
     * @param linha Linha que será removida
     */
    public void removeRow(int linha) {

        this.xmlDet.remove(linha);
        this.prod.remove(linha);

        super.fireTableRowsDeleted(linha, linha);

    }   // void removeRow

    /**
     * Duplica uma linha no JTable
     *
     * @param linha Linha que será duplicada
     */
    public void copyRow(int linha) {      
        
        TNFe.InfNFe.Det d = this.preencheDetalhe(this.xmlDet.get(linha));
        
        this.xmlDet.add(d);
        this.prod.add(d.getProd());
                        
        super.fireTableDataChanged();

    }   // void copyRow

    private TNFe.InfNFe.Det newRow(TNFe.InfNFe.Det det) {

        int proxId = this.getRowCount() + 1;

        TNFe.InfNFe.Det d = this.preencheDetalhe(det);
        d.setNItem(String.valueOf(proxId));
        
        this.xmlDet.add(d);

        if (d.getProd() == null) {
            this.prod.add(new Prod());
        } else {
            this.prod.add(d.getProd());
        }   // if (d.getProd() == null)
        
        return d;
        
    }   // TNFe.InfNFe.Det newRow

    /**
     *
     * @param det
     * @return
     */
    private TNFe.InfNFe.Det preencheDetalhe(TNFe.InfNFe.Det det) {

        TNFe.InfNFe.Det d = new TNFe.InfNFe.Det();

        if (det.getProd() != null) {

            d.setImposto(det.getImposto());
            d.setImpostoDevol(det.getImpostoDevol());
            d.setInfAdProd(det.getInfAdProd());
            d.setProd(det.getProd());

        } else {

            d.setImposto(new TNFe.InfNFe.Det.Imposto());
            d.setImpostoDevol(new TNFe.InfNFe.Det.ImpostoDevol());
            d.setInfAdProd(" ");
            d.setProd(new TNFe.InfNFe.Det.Prod());

        }   // if (det.getProd() != null)

        return d;

    }   // Det preencheDetalhe

    /**
     * Retorna os dados da linha selecioanda
     *
     * @param linha Número da linha selecioanda
     * @return Dados do Detalhe da NF-e
     */
    public TNFe.InfNFe.Det get(int linha) {
        return this.xmlDet.get(linha);
    }   // Det get

    /**
     * Torna as céluas editáveis
     *
     * @param rowIndex Número da linha
     * @param columnIndex Número da coluna
     * @return true -> Editavel
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }   // isCellEditable(int rowIndex, int columnIndex)

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        if (!this.prod.isEmpty()) {

            switch (columnIndex) {
                case 0:
                    this.prod.get(rowIndex).setCProd(String.valueOf(aValue));
                    break;
                case 1:
                    this.prod.get(rowIndex).setXProd(String.valueOf(aValue));
                    break;
                case 2:
                    this.prod.get(rowIndex).setNCM(String.valueOf(aValue));
                    break;
                case 3:
                    this.prod.get(rowIndex).setCFOP(String.valueOf(aValue));
                    break;
                case 4:
                    this.prod.get(rowIndex).setUCom(String.valueOf(aValue));
                    break;
                case 5:
                    this.prod.get(rowIndex).setQCom(String.valueOf(aValue));
                    break;
                case 6:
                    this.prod.get(rowIndex).setVUnCom(String.valueOf(aValue));
                    break;
                case 7:
                    this.prod.get(rowIndex).setVProd(String.valueOf(aValue));
                    break;
                case 8:
                    this.prod.get(rowIndex).setUTrib(String.valueOf(aValue));
                    break;
                case 9:
                    this.prod.get(rowIndex).setQTrib(String.valueOf(aValue));
                    break;
                case 10:
                    this.prod.get(rowIndex).setVUnTrib(String.valueOf(aValue));
                    break;
                case 11:
                    this.prod.get(rowIndex).setIndTot(String.valueOf(aValue));
                    break;
                case 12:
                    this.prod.get(rowIndex).setXPed(String.valueOf(aValue));
                    break;
                case 13:
                    this.prod.get(rowIndex).setNItemPed(String.valueOf(aValue));
                    break;
            }   // switch (columnIndex)

        }   // if (!this.prod.isEmpty())

    }   // getValueAt(int rowIndex, int columnIndex)

    /**
     * Retorna o nome da coluna
     *
     * @param num Número da Coluna
     * @return Nome da Coluna
     */
    @Override
    public String getColumnName(int num) {
        return this.colunas[num];
    }

    /**
     * Retorna a quantidade de registros
     *
     * @return Quantidade de Registros da Lista prod
     */
    @Override
    public int getRowCount() {
        return this.prod.size();
    }

    /**
     * Retorna a quantidade de colunas do JTable
     *
     * @return Quantidade de colunas
     */
    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    /**
     * Retorna o valor da coluna
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (this.prod.isEmpty()) {
            return null;
        }

        switch (columnIndex) {
            case 0:
                return this.prod.get(rowIndex).getCProd();
            case 1:
                return this.prod.get(rowIndex).getXProd();
            case 2:
                return this.prod.get(rowIndex).getNCM();
            case 3:
                return this.prod.get(rowIndex).getCFOP();
            case 4:
                return this.prod.get(rowIndex).getUCom();
            case 5:
                return this.prod.get(rowIndex).getQCom();
            case 6:
                return this.prod.get(rowIndex).getVUnCom();
            case 7:
                return this.prod.get(rowIndex).getVProd();
            case 8:
                return this.prod.get(rowIndex).getUTrib();
            case 9:
                return this.prod.get(rowIndex).getQTrib();
            case 10:
                return this.prod.get(rowIndex).getVUnTrib();
            case 11:
                return this.prod.get(rowIndex).getIndTot();
            case 12:
                return this.prod.get(rowIndex).getXPed();
            case 13:
                return this.prod.get(rowIndex).getNItemPed();
        }
        
        return null;
        
    }   // getValueAt(int rowIndex, int columnIndex)

}   // class ProdutoTableModel
