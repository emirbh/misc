package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.repo.SecurityValuation;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SecurityValuationChoice1")
@ImplementedBy(SecurityValuationChoice1.Default.class)
public interface SecurityValuationChoice1 extends Validator<SecurityValuation> {
	
	String NAME = "SecurityValuationChoice1";
	String DEFINITION = "if cleanPrice exists then unitPrice is absent and quoteUnits is absent else if dirtyPrice exists then accruals is absent and unitPrice is absent and quoteUnits is absent else if unitPrice exists then dirtyPrice is absent and accruals is absent and relativePrice is absent and yieldToMaturity is absent and inflationFactor is absent and allInPrice is absent else False";
	
	class Default implements SecurityValuationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityValuation securityValuation) {
			ComparisonResult result = executeDataRule(securityValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecurityValuation securityValuation) {
			try {
				if (exists(MapperS.of(securityValuation).<BigDecimal>map("getCleanPrice", _securityValuation -> _securityValuation.getCleanPrice())).getOrDefault(false)) {
					return notExists(MapperS.of(securityValuation).<NonNegativeMoney>map("getUnitPrice", _securityValuation -> _securityValuation.getUnitPrice())).andNullSafe(notExists(MapperS.of(securityValuation).<PriceQuoteUnits>map("getQuoteUnits", _securityValuation -> _securityValuation.getQuoteUnits())));
				}
				if (exists(MapperS.of(securityValuation).<BigDecimal>map("getDirtyPrice", _securityValuation -> _securityValuation.getDirtyPrice())).getOrDefault(false)) {
					return notExists(MapperS.of(securityValuation).<BigDecimal>map("getAccruals", _securityValuation -> _securityValuation.getAccruals())).andNullSafe(notExists(MapperS.of(securityValuation).<NonNegativeMoney>map("getUnitPrice", _securityValuation -> _securityValuation.getUnitPrice()))).andNullSafe(notExists(MapperS.of(securityValuation).<PriceQuoteUnits>map("getQuoteUnits", _securityValuation -> _securityValuation.getQuoteUnits())));
				}
				if (exists(MapperS.of(securityValuation).<NonNegativeMoney>map("getUnitPrice", _securityValuation -> _securityValuation.getUnitPrice())).getOrDefault(false)) {
					return notExists(MapperS.of(securityValuation).<BigDecimal>map("getDirtyPrice", _securityValuation -> _securityValuation.getDirtyPrice())).andNullSafe(notExists(MapperS.of(securityValuation).<BigDecimal>map("getAccruals", _securityValuation -> _securityValuation.getAccruals()))).andNullSafe(notExists(MapperS.of(securityValuation).<RelativePrice>map("getRelativePrice", _securityValuation -> _securityValuation.getRelativePrice()))).andNullSafe(notExists(MapperS.of(securityValuation).<BigDecimal>map("getYieldToMaturity", _securityValuation -> _securityValuation.getYieldToMaturity()))).andNullSafe(notExists(MapperS.of(securityValuation).<BigDecimal>map("getInflationFactor", _securityValuation -> _securityValuation.getInflationFactor()))).andNullSafe(notExists(MapperS.of(securityValuation).<BigDecimal>map("getAllInPrice", _securityValuation -> _securityValuation.getAllInPrice())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecurityValuationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityValuation securityValuation) {
			return Collections.emptyList();
		}
	}
}
