package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.product.asset.CashflowRepresentation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Cashflows;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashflowRepresentation.MapCashflowRepresentationDefault.class)
public abstract class MapCashflowRepresentation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPaymentCalculationPeriodList mapPaymentCalculationPeriodList;

	/**
	* @param fpmlCashflows 
	* @return cashflowRepresentation 
	*/
	public CashflowRepresentation evaluate(Cashflows fpmlCashflows) {
		CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentationBuilder = doEvaluate(fpmlCashflows);
		
		final CashflowRepresentation cashflowRepresentation;
		if (cashflowRepresentationBuilder == null) {
			cashflowRepresentation = null;
		} else {
			cashflowRepresentation = cashflowRepresentationBuilder.build();
			objectValidator.validate(CashflowRepresentation.class, cashflowRepresentation);
		}
		
		return cashflowRepresentation;
	}

	protected abstract CashflowRepresentation.CashflowRepresentationBuilder doEvaluate(Cashflows fpmlCashflows);

	public static class MapCashflowRepresentationDefault extends MapCashflowRepresentation {
		@Override
		protected CashflowRepresentation.CashflowRepresentationBuilder doEvaluate(Cashflows fpmlCashflows) {
			CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentation = CashflowRepresentation.builder();
			return assignOutput(cashflowRepresentation, fpmlCashflows);
		}
		
		protected CashflowRepresentation.CashflowRepresentationBuilder assignOutput(CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentation, Cashflows fpmlCashflows) {
			cashflowRepresentation = toBuilder(CashflowRepresentation.builder()
				.setCashflowsMatchParameters(MapperS.of(fpmlCashflows).<Boolean>map("getCashflowsMatchParameters", cashflows -> cashflows.getCashflowsMatchParameters()).get())
				.setPaymentCalculationPeriod(new ArrayList(mapPaymentCalculationPeriodList.evaluate(fpmlCashflows)))
				.build());
			
			return Optional.ofNullable(cashflowRepresentation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
