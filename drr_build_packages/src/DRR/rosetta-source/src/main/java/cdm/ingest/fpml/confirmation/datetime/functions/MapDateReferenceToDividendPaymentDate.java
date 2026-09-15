package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.asset.DividendPaymentDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.DateReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateReferenceToDividendPaymentDate.MapDateReferenceToDividendPaymentDateDefault.class)
public abstract class MapDateReferenceToDividendPaymentDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustedRelativeDateReference mapAdjustedRelativeDateReference;

	/**
	* @param fpmlDateReference 
	* @return dividendPaymentDate 
	*/
	public DividendPaymentDate evaluate(DateReference fpmlDateReference) {
		DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDateBuilder = doEvaluate(fpmlDateReference);
		
		final DividendPaymentDate dividendPaymentDate;
		if (dividendPaymentDateBuilder == null) {
			dividendPaymentDate = null;
		} else {
			dividendPaymentDate = dividendPaymentDateBuilder.build();
			objectValidator.validate(DividendPaymentDate.class, dividendPaymentDate);
		}
		
		return dividendPaymentDate;
	}

	protected abstract DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(DateReference fpmlDateReference);

	public static class MapDateReferenceToDividendPaymentDateDefault extends MapDateReferenceToDividendPaymentDate {
		@Override
		protected DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(DateReference fpmlDateReference) {
			DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate = DividendPaymentDate.builder();
			return assignOutput(dividendPaymentDate, fpmlDateReference);
		}
		
		protected DividendPaymentDate.DividendPaymentDateBuilder assignOutput(DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate, DateReference fpmlDateReference) {
			dividendPaymentDate = toBuilder(DividendPaymentDate.builder()
				.setDividendDate(mapAdjustedRelativeDateReference.evaluate(fpmlDateReference))
				.build());
			
			return Optional.ofNullable(dividendPaymentDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
