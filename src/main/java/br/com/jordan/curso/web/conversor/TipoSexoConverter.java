package br.com.jordan.curso.web.conversor;

import br.com.jordan.curso.domain.TipoSexo;
import org.springframework.core.convert.converter.Converter;

public class TipoSexoConverter implements Converter<String, TipoSexo> {
    @Override
    public TipoSexo convert(String s) {
        char tipo = s.charAt(0);
        return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
    }
}
