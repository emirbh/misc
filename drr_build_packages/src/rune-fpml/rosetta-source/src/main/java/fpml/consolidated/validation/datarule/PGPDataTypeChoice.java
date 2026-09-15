package fpml.consolidated.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.PGPDataType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PGPDataTypeChoice")
@ImplementedBy(PGPDataTypeChoice.Default.class)
public interface PGPDataTypeChoice extends Validator<PGPDataType> {
	
	String NAME = "PGPDataTypeChoice";
	String DEFINITION = "if pgpKeyID exists then anyContents1 is absent else if pgpKeyPacket exists then anyContents0 is absent else False";
	
	class Default implements PGPDataTypeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PGPDataType pGPDataType) {
			ComparisonResult result = executeDataRule(pGPDataType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PGPDataType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PGPDataType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PGPDataType pGPDataType) {
			try {
				if (exists(MapperS.of(pGPDataType).<String>map("getPgpKeyID", _pGPDataType -> _pGPDataType.getPgpKeyID())).getOrDefault(false)) {
					return notExists(MapperS.of(pGPDataType).<String>mapC("getAnyContents1", _pGPDataType -> _pGPDataType.getAnyContents1()));
				}
				if (exists(MapperS.of(pGPDataType).<String>map("getPgpKeyPacket", _pGPDataType -> _pGPDataType.getPgpKeyPacket())).getOrDefault(false)) {
					return notExists(MapperS.of(pGPDataType).<String>mapC("getAnyContents0", _pGPDataType -> _pGPDataType.getAnyContents0()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PGPDataTypeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PGPDataType pGPDataType) {
			return Collections.emptyList();
		}
	}
}
