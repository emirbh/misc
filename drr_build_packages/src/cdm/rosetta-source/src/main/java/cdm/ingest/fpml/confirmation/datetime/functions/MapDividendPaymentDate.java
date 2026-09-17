package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.asset.DividendDateReference;
import cdm.product.asset.DividendPaymentDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.DividendDateReferenceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Offset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendPaymentDate.MapDividendPaymentDateDefault.class)
public abstract class MapDividendPaymentDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDateOrAdjustedRelativeDate mapAdjustableDateOrAdjustedRelativeDate;
	@Inject protected MapOffset mapOffset;

	/**
	* @param fpmlDividendPaymentDate 
	* @return dividendPaymentDate 
	*/
	public DividendPaymentDate evaluate(fpml.consolidated.eq.shared.DividendPaymentDate fpmlDividendPaymentDate) {
		DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDateBuilder = doEvaluate(fpmlDividendPaymentDate);
		
		final DividendPaymentDate dividendPaymentDate;
		if (dividendPaymentDateBuilder == null) {
			dividendPaymentDate = null;
		} else {
			dividendPaymentDate = dividendPaymentDateBuilder.build();
			objectValidator.validate(DividendPaymentDate.class, dividendPaymentDate);
		}
		
		return dividendPaymentDate;
	}

	protected abstract DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(fpml.consolidated.eq.shared.DividendPaymentDate fpmlDividendPaymentDate);

	public static class MapDividendPaymentDateDefault extends MapDividendPaymentDate {
		@Override
		protected DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(fpml.consolidated.eq.shared.DividendPaymentDate fpmlDividendPaymentDate) {
			DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate = DividendPaymentDate.builder();
			return assignOutput(dividendPaymentDate, fpmlDividendPaymentDate);
		}
		
		protected DividendPaymentDate.DividendPaymentDateBuilder assignOutput(DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate, fpml.consolidated.eq.shared.DividendPaymentDate fpmlDividendPaymentDate) {
			dividendPaymentDate = toBuilder(DividendPaymentDate.builder()
				.setDividendDateReference(DividendDateReference.builder()
					.setDateReference(MapperS.of(fpmlDividendPaymentDate).<DividendDateReferenceEnum>map("getDividendDateReference", _dividendPaymentDate -> _dividendPaymentDate.getDividendDateReference()).checkedMap("to-enum", e -> cdm.product.asset.DividendDateReferenceEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setPaymentDateOffset(mapOffset.evaluate(MapperS.of(fpmlDividendPaymentDate).<Offset>map("getPaymentDateOffset", _dividendPaymentDate -> _dividendPaymentDate.getPaymentDateOffset()).get()))
					.build())
				.setDividendDateValue(mapAdjustableDateOrAdjustedRelativeDate.evaluate(MapperS.of(fpmlDividendPaymentDate).<AdjustableDate>map("getAdjustableDate", _dividendPaymentDate -> _dividendPaymentDate.getAdjustableDate()).get(), null))
				.build());
			
			return Optional.ofNullable(dividendPaymentDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
