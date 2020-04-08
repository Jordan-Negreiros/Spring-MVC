package br.com.jordan.curso.domain;

public enum TipoSexo {
    FEMININO('F'), MASCULINO('M');

    private char desc;

    TipoSexo(char desc) {
        this.desc = desc;
    }

    public char getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoSexo{");
        sb.append("desc=").append(desc);
        sb.append('}');
        return sb.toString();
    }
}
