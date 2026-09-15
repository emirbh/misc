package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SettlementPeriodFixingDatesChoice")
@ImplementedBy(SettlementPeriodFixingDatesChoice.Default.class)
public interface SettlementPeriodFixingDatesChoice extends Validator<SettlementPeriodFixingDates> {
	
	String NAME = "SettlementPeriodFixingDatesChoice";
	String DEFINITION = "if fixingDate exists then startDate is absent and endDate is absent and numberOfFixings is absent else if startDate exists or endDate exists then startDate exists and endDate exists and fixingDate is absent and numberOfFixings is absent else if numberOfFixings exists then fixingDate is absent and startDate is absent and endDate is absent else False";
	
	class Default implements SettlementPeriodFixingDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodFixingDates settlementPeriodFixingDates) {
			ComparisonResult result = executeDataRule(settlementPeriodFixingDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodFixingDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodFixingDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementPeriodFixingDates settlementPeriodFixingDates) {
			try {
				if (exists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>mapC("getFixingDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getFixingDate())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getStartDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getStartDate())).andNullSafe(notExists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getEndDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getEndDate()))).andNullSafe(notExists(MapperS.of(settlementPeriodFixingDates).<Integer>map("getNumberOfFixings", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getNumberOfFixings())));
				}
				if (exists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getStartDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getStartDate())).orNullSafe(exists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getEndDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getEndDate()))).getOrDefault(false)) {
					return exists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getStartDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getStartDate())).andNullSafe(exists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getEndDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getEndDate()))).andNullSafe(notExists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>mapC("getFixingDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getFixingDate()))).andNullSafe(notExists(MapperS.of(settlementPeriodFixingDates).<Integer>map("getNumberOfFixings", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getNumberOfFixings())));
				}
				if (exists(MapperS.of(settlementPeriodFixingDates).<Integer>map("getNumberOfFixings", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getNumberOfFixings())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>mapC("getFixingDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getFixingDate())).andNullSafe(notExists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getStartDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getStartDate()))).andNullSafe(notExists(MapperS.of(settlementPeriodFixingDates).<ZonedDateTime>map("getEndDate", _settlementPeriodFixingDates -> _settlementPeriodFixingDates.getEndDate())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodFixingDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodFixingDates settlementPeriodFixingDates) {
			return Collections.emptyList();
		}
	}
}
