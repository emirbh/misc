package cdm.product.asset.validation.datarule;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.product.asset.BondReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("BondReferenceBondUnderlier")
@ImplementedBy(BondReferenceBondUnderlier.Default.class)
public interface BondReferenceBondUnderlier extends Validator<BondReference> {
	
	String NAME = "BondReferenceBondUnderlier";
	String DEFINITION = "bond -> instrumentType = InstrumentTypeEnum -> Debt";
	
	class Default implements BondReferenceBondUnderlier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondReference bondReference) {
			ComparisonResult result = executeDataRule(bondReference);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondReference", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BondReference", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BondReference bondReference) {
			try {
				return areEqual(MapperS.of(bondReference).<Security>map("getBond", _bondReference -> _bondReference.getBond()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondReferenceBondUnderlier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondReference bondReference) {
			return Collections.emptyList();
		}
	}
}
