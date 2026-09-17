package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.ird.PrincipalExchange;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPrincipalPaymentDate.MapPrincipalPaymentDateDefault.class)
public abstract class MapPrincipalPaymentDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPrincipalExchange 
	* @return principalPaymentDate 
	*/
	public AdjustableDate evaluate(PrincipalExchange fpmlPrincipalExchange) {
		AdjustableDate.AdjustableDateBuilder principalPaymentDateBuilder = doEvaluate(fpmlPrincipalExchange);
		
		final AdjustableDate principalPaymentDate;
		if (principalPaymentDateBuilder == null) {
			principalPaymentDate = null;
		} else {
			principalPaymentDate = principalPaymentDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, principalPaymentDate);
		}
		
		return principalPaymentDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(PrincipalExchange fpmlPrincipalExchange);

	public static class MapPrincipalPaymentDateDefault extends MapPrincipalPaymentDate {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(PrincipalExchange fpmlPrincipalExchange) {
			AdjustableDate.AdjustableDateBuilder principalPaymentDate = AdjustableDate.builder();
			return assignOutput(principalPaymentDate, fpmlPrincipalExchange);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder principalPaymentDate, PrincipalExchange fpmlPrincipalExchange) {
			principalPaymentDate = toBuilder(AdjustableDate.builder()
				.setAdjustedDateValue(MapperS.of(fpmlPrincipalExchange).<ZonedDateTime>map("getAdjustedPrincipalExchangeDate", principalExchange -> principalExchange.getAdjustedPrincipalExchangeDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setUnadjustedDate(MapperS.of(fpmlPrincipalExchange).<ZonedDateTime>map("getUnadjustedPrincipalExchangeDate", principalExchange -> principalExchange.getUnadjustedPrincipalExchangeDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(principalPaymentDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
