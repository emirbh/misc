package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.asset.DividendPaymentDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnadjustedDateToDividendPaymentDate.MapUnadjustedDateToDividendPaymentDateDefault.class)
public abstract class MapUnadjustedDateToDividendPaymentDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapUnadjustedDateToAdjustableOrRelativeDate mapUnadjustedDateToAdjustableOrRelativeDate;

	/**
	* @param fpmlUnadjustedDate 
	* @return dividendPaymentDate 
	*/
	public DividendPaymentDate evaluate(IdentifiedDate fpmlUnadjustedDate) {
		DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDateBuilder = doEvaluate(fpmlUnadjustedDate);
		
		final DividendPaymentDate dividendPaymentDate;
		if (dividendPaymentDateBuilder == null) {
			dividendPaymentDate = null;
		} else {
			dividendPaymentDate = dividendPaymentDateBuilder.build();
			objectValidator.validate(DividendPaymentDate.class, dividendPaymentDate);
		}
		
		return dividendPaymentDate;
	}

	protected abstract DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(IdentifiedDate fpmlUnadjustedDate);

	public static class MapUnadjustedDateToDividendPaymentDateDefault extends MapUnadjustedDateToDividendPaymentDate {
		@Override
		protected DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(IdentifiedDate fpmlUnadjustedDate) {
			DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate = DividendPaymentDate.builder();
			return assignOutput(dividendPaymentDate, fpmlUnadjustedDate);
		}
		
		protected DividendPaymentDate.DividendPaymentDateBuilder assignOutput(DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate, IdentifiedDate fpmlUnadjustedDate) {
			dividendPaymentDate = toBuilder(DividendPaymentDate.builder()
				.setDividendDateValue(mapUnadjustedDateToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlUnadjustedDate).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(fpmlUnadjustedDate).<String>map("getId", identifiedDate -> identifiedDate.getId()).get()))
				.build());
			
			return Optional.ofNullable(dividendPaymentDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
