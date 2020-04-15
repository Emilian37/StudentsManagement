package gui;

/**
 * <p> Interfata comand se utilizeaza pentru a fi implementata de catre orice clasa din intefata grafica care executa sarcini
 * cu efect important asupra aplicatiei (sunt comenzi , toate butoanele si o parte din combo boxuri : cb de modificare 
 * student , cb de modificare disciplina , cb de modificare nota , primele doua cb din inserare nota , cb din vizualizare nota studenti.  </p>
 * @author Emilian
 *
 */
public interface Comanda {
	public void executa();
}
