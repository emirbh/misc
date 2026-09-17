package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNumberOfOptionsAndOptionEntitlementToQuantity.MapNumberOfOptionsAndOptionEntitlementToQuantityDefault.class)
public abstract class MapNumberOfOptionsAndOptionEntitlementToQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlNumberOfOptions 
	* @param fpmlFinancialUnit 
	* @param fpmlOptionEntitlement 
	* @param fpmlCurrency 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(BigDecimal fpmlNumberOfOptions, FinancialUnitEnum fpmlFinancialUnit, BigDecimal fpmlOptionEntitlement, Currency fpmlCurrency) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNumberOfOptions, fpmlFinancialUnit, fpmlOptionEntitlement, fpmlCurrency);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNumberOfOptions, FinancialUnitEnum fpmlFinancialUnit, BigDecimal fpmlOptionEntitlement, Currency fpmlCurrency);

	public static class MapNumberOfOptionsAndOptionEntitlementToQuantityDefault extends MapNumberOfOptionsAndOptionEntitlementToQuantity {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNumberOfOptions, FinancialUnitEnum fpmlFinancialUnit, BigDecimal fpmlOptionEntitlement, Currency fpmlCurrency) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNumberOfOptions, fpmlFinancialUnit, fpmlOptionEntitlement, fpmlCurrency);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlNumberOfOptions, FinancialUnitEnum fpmlFinancialUnit, BigDecimal fpmlOptionEntitlement, Currency fpmlCurrency) {
			if (exists(MapperS.of(fpmlNumberOfOptions)).getOrDefault(false)) {
				final FieldWithMetaString ifThenElseResult0;
				if (exists(MapperS.of(fpmlOptionEntitlement)).getOrDefault(false)) {
					ifThenElseResult0 = mapCurrency.evaluate(fpmlCurrency);
				} else {
					ifThenElseResult0 = FieldWithMetaString.builder().build();
				}
				FinancialUnitEnum ifThenElseResult1 = null;
				if (exists(MapperS.of(fpmlFinancialUnit)).getOrDefault(false)) {
					ifThenElseResult1 = fpmlFinancialUnit;
				}
				nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
					.setValue(fpmlNumberOfOptions)
					.setUnit(UnitType.builder()
						.setFinancialUnit(FinancialUnitEnum.CONTRACT)
						.build())
					.setMultiplier(Measure.builder()
						.setValue(fpmlOptionEntitlement)
						.setUnit(UnitType.builder()
							.setCurrency(ifThenElseResult0)
							.setFinancialUnit(ifThenElseResult1)
							.build())
						.build())
					.build());
			} else {
				nonNegativeQuantitySchedule = null;
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
