/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.libraryjsf.util;

import java.util.ResourceBundle;

/**
 *
 * @author Otto
 */
public class StringUtil {
    private static final String FILE_NAME = "conf";

    public static final String KEY_MSG_ERRO_CADASTRAR = "msg_erro_cadastrar";
    public static final String KEY_MSG_ERRO_DELETAR = "msg_erro_deletar";
    public static final String KEY_MSG_ERRO_EDITAR = "msg_erro_editar";
    public static final String KEY_MSG_ERRO_BUSCAR = "msg_erro_buscar";
    public static final String KEY_MSG_ERRO_BUSCAR_NOME = "msg_erro_buscar_nome";
    public static final String KEY_MSG_ERRO_LISTAR = "msg_erro_listar";

    private static final ResourceBundle bundle = ResourceBundle.getBundle(FILE_NAME);

    public static String getStringValue(String key) {
        return bundle.getString(key);
    }
}
