package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.party.LegalEntity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CashNoExchange")
@ImplementedBy(CashNoExchange.Default.class)
public interface CashNoExchange extends Validator<Cash> {
	
	String NAME = "CashNoExchange";
	String DEFINITION = "exchange is absent and isExchangeListed is absent";
	
	class Default implements CashNoExchange {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash cash) {
			ComparisonResult result = executeDataRule(cash);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Cash cash) {
			try {
				return notExists(MapperS.of(cash).<LegalEntity>map("getExchange", _cash -> _cash.getExchange())).andNullSafe(notExists(MapperS.of(cash).<Boolean>map("getIsExchangeListed", _cash -> _cash.getIsExchangeListed())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashNoExchange {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash cash) {
			return Collections.emptyList();
		}
	}
}
