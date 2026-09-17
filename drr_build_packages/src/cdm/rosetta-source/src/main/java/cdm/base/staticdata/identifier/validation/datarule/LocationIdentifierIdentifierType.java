package cdm.base.staticdata.identifier.validation.datarule;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.CommodityLocationIdentifierTypeEnum;
import cdm.base.staticdata.identifier.LocationIdentifier;
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
@RosettaDataRule("LocationIdentifierIdentifierType")
@ImplementedBy(LocationIdentifierIdentifierType.Default.class)
public interface LocationIdentifierIdentifierType extends Validator<LocationIdentifier> {
	
	String NAME = "LocationIdentifierIdentifierType";
	String DEFINITION = "if locationIdentifierType exists then assignedIdentifier count = 1";
	
	class Default implements LocationIdentifierIdentifierType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LocationIdentifier locationIdentifier) {
			ComparisonResult result = executeDataRule(locationIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LocationIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LocationIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LocationIdentifier locationIdentifier) {
			try {
				if (exists(MapperS.of(locationIdentifier).<CommodityLocationIdentifierTypeEnum>map("getLocationIdentifierType", _locationIdentifier -> _locationIdentifier.getLocationIdentifierType())).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(locationIdentifier).<AssignedIdentifier>mapC("getAssignedIdentifier", _locationIdentifier -> _locationIdentifier.getAssignedIdentifier()).resultCount()), MapperS.of(1), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LocationIdentifierIdentifierType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LocationIdentifier locationIdentifier) {
			return Collections.emptyList();
		}
	}
}
