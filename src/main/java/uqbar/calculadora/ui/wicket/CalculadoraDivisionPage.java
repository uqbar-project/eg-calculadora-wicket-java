package uqbar.calculadora.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import uqbar.calculadora.domain.CalculadoraDivision;

/**
 *
 */
public class CalculadoraDivisionPage extends WebPage {
	private static final long serialVersionUID = 1L;

	public CalculadoraDivisionPage() {
		Form<CalculadoraDivision> form = new FormCopado<CalculadoraDivision>("calculadoraForm", new CompoundPropertyModel(new CalculadoraDivision()));
		this.add(form);

		this.addFields(form);
		this.addActions(form);
    }
    
	private void addActions(Form<CalculadoraDivision> form) {
		form.add(new SmartButton("dividir") {
			@Override
			protected void onSmartSubmit() {
				getCalculadora().dividir();
			}
		});
	}

	private void addFields(Form<CalculadoraDivision> form) {
		form.add(new TextField<Double>("dividendo"));
		
		final TextField<Double> divisorTextField = new TextField<Double>("divisor");
		divisorTextField.add(new PropertyValidator());
		form.add(divisorTextField);
		
		form.add(new Label("resultado"));
		form.add(new FeedbackPanel("feedbackPanel"));
	}

	protected CalculadoraDivision getCalculadora() {
		return (CalculadoraDivision) this.getDefaultModelObject();
	}

}
