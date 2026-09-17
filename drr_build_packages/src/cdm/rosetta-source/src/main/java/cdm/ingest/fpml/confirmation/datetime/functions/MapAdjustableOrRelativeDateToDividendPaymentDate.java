package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.asset.DividendPaymentDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrRelativeDateToDividendPaymentDate.MapAdjustableOrRelativeDateToDividendPaymentDateDefault.class)
public abstract class MapAdjustableOrRelativeDateToDividendPaymentDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;

	/**
	* @param fpmlAdjustableOrRelativeDate 
	* @return dividendPaymentDate 
	*/
	public DividendPaymentDate evaluate(AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
		DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDateBuilder = doEvaluate(fpmlAdjustableOrRelativeDate);
		
		final DividendPaymentDate dividendPaymentDate;
		if (dividendPaymentDateBuilder == null) {
			dividendPaymentDate = null;
		} else {
			dividendPaymentDate = dividendPaymentDateBuilder.build();
			objectValidator.validate(DividendPaymentDate.class, dividendPaymentDate);
		}
		
		return dividendPaymentDate;
	}

	protected abstract DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate);

	public static class MapAdjustableOrRelativeDateToDividendPaymentDateDefault extends MapAdjustableOrRelativeDateToDividendPaymentDate {
		@Override
		protected DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
			DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate = DividendPaymentDate.builder();
			return assignOutput(dividendPaymentDate, fpmlAdjustableOrRelativeDate);
		}
		
		protected DividendPaymentDate.DividendPaymentDateBuilder assignOutput(DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate, AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
			dividendPaymentDate = toBuilder(DividendPaymentDate.builder()
				.setDividendDateValue(mapAdjustableOrRelativeDate.evaluate(fpmlAdjustableOrRelativeDate))
				.build());
			
			return Optional.ofNullable(dividendPaymentDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
