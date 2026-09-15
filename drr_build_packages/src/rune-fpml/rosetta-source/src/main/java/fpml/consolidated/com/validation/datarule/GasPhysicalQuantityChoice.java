package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.GasPhysicalQuantity;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.shared.PartyReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("GasPhysicalQuantityChoice")
@ImplementedBy(GasPhysicalQuantityChoice.Default.class)
public interface GasPhysicalQuantityChoice extends Validator<GasPhysicalQuantity> {
	
	String NAME = "GasPhysicalQuantityChoice";
	String DEFINITION = "if physicalQuantitySchedule exists then physicalQuantity is absent and minPhysicalQuantity is absent and maxPhysicalQuantity is absent and electingParty is absent else physicalQuantity exists and minPhysicalQuantity is absent and maxPhysicalQuantity is absent and electingParty is absent or totalPhysicalQuantity exists and minPhysicalQuantity is absent and maxPhysicalQuantity is absent and electingParty is absent or totalPhysicalQuantity is absent and physicalQuantity is absent";
	
	class Default implements GasPhysicalQuantityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalQuantity gasPhysicalQuantity) {
			ComparisonResult result = executeDataRule(gasPhysicalQuantity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GasPhysicalQuantity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GasPhysicalQuantity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GasPhysicalQuantity gasPhysicalQuantity) {
			try {
				if (exists(MapperS.of(gasPhysicalQuantity).<CommodityPhysicalQuantitySchedule>map("getPhysicalQuantitySchedule", _gasPhysicalQuantity -> _gasPhysicalQuantity.getPhysicalQuantitySchedule())).getOrDefault(false)) {
					return notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>map("getPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getPhysicalQuantity())).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>mapC("getMinPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getMinPhysicalQuantity()))).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>mapC("getMaxPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getMaxPhysicalQuantity()))).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<PartyReference>map("getElectingParty", _gasPhysicalQuantity -> _gasPhysicalQuantity.getElectingParty())));
				}
				return exists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>map("getPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getPhysicalQuantity())).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>mapC("getMinPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getMinPhysicalQuantity()))).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>mapC("getMaxPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getMaxPhysicalQuantity()))).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<PartyReference>map("getElectingParty", _gasPhysicalQuantity -> _gasPhysicalQuantity.getElectingParty()))).orNullSafe(exists(MapperS.of(gasPhysicalQuantity).<UnitQuantity>map("getTotalPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getTotalPhysicalQuantity())).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>mapC("getMinPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getMinPhysicalQuantity()))).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>mapC("getMaxPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getMaxPhysicalQuantity()))).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<PartyReference>map("getElectingParty", _gasPhysicalQuantity -> _gasPhysicalQuantity.getElectingParty())))).orNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<UnitQuantity>map("getTotalPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getTotalPhysicalQuantity())).andNullSafe(notExists(MapperS.of(gasPhysicalQuantity).<CommodityNotionalQuantity>map("getPhysicalQuantity", _gasPhysicalQuantity -> _gasPhysicalQuantity.getPhysicalQuantity()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GasPhysicalQuantityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalQuantity gasPhysicalQuantity) {
			return Collections.emptyList();
		}
	}
}
