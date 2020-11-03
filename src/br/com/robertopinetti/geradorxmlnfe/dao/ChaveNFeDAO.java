/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.robertopinetti.geradorxmlnfe.dao;

import br.com.robertopinetti.geradorxmlnfe.Utils;

/**
 *
 * @author asus
 */
public class ChaveNFeDAO {

    private String regiao;
    private String ano;
    private String mes;
    private String cnpjEmit;
    private String modelo;
    private String serie;
    private String nfe;
    private String docnum;
    private String cdv;

    public ChaveNFeDAO() {

    }   // public ChaveNFeDAO

    public ChaveNFeDAO(String chave) {

        this.regiao = chave.substring(0, 2);
        this.ano = chave.substring(2, 4);
        this.mes = chave.substring(4, 6);
        this.cnpjEmit = chave.substring(6, 20);
        this.modelo = chave.substring(20, 22);
        this.serie = chave.substring(22, 25);
        this.nfe = chave.substring(25, 34);
        this.docnum = chave.substring(34, 43);
        this.cdv = chave.substring(43, 44);

    }   //public ChaveNFeDAO

    /**
     * @return the regiao
     */
    public String getRegiao() {
        return regiao;
    }

    /**
     * @param regiao the regiao to set
     */
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the cnpjEmit
     */
    public String getCnpjEmit() {
        return cnpjEmit;
    }

    /**
     * @param cnpjEmit the cnpjEmit to set
     */
    public void setCnpjEmit(String cnpjEmit) {
        this.cnpjEmit = cnpjEmit;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the nfe
     */
    public String getNfe() {
        return nfe;
    }

    /**
     * @param nfe the nfe to set
     */
    public void setNfe(String nfe) {
        this.nfe = nfe;
    }

    /**
     * @return the docnum
     */
    public String getDocnum() {
        return docnum;
    }

    /**
     * @param docnum the docnum to set
     */
    public void setDocnum(String docnum) {
        this.docnum = docnum;
    }

    /**
     * @return the cdv
     */
    public String getCdv() {
        return cdv;
    }

    /**
     * @param cdv the cdv to set
     */
    public void setCdv(String cdv) {
        this.cdv = cdv;
    }

    public String gerarChave(String cnpj) {
        
        int iNFe = (int) (Math.random() * 100000);
        int iDocnum = (int) (Math.random() * 1000000000);
        
        String sNFe = String.valueOf(iNFe);
        String sDocnum = String.valueOf(iDocnum);
        
        this.setAno(Utils.getAno2());
        this.setMes(Utils.getMes());
        this.setCnpjEmit(cnpj);
        this.setNfe(Utils.alphaInput(sNFe, 9));
        this.setDocnum(sDocnum);
        
        return this.toString();
        
    }   // String gerarChave

    @Override
    public String toString() {

        String sChave;

        sChave = this.regiao;
        sChave += this.ano;
        sChave += this.mes;
        sChave += this.cnpjEmit;
        sChave += this.modelo;
        sChave += this.serie;
        sChave += this.nfe;
        sChave += this.docnum;
        sChave += this.cdv;

        return sChave;
    }   // String toString

}   // public class ChaveNFeDAO
