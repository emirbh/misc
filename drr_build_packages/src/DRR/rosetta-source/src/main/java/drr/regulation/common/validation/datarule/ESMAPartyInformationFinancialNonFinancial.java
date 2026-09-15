package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.FinancialSectorEnum;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.NonFinancialSector;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAPartyInformationFinancialNonFinancial")
@ImplementedBy(ESMAPartyInformationFinancialNonFinancial.Default.class)
public interface ESMAPartyInformationFinancialNonFinancial extends Validator<ESMAPartyInformation> {
	
	String NAME = "ESMAPartyInformationFinancialNonFinancial";
	String DEFINITION = "if natureOfParty = Financial then corporateSector -> financialSector exists else if natureOfParty = NonFinancial then corporateSector -> nonFinancialSector exists";
	
	class Default implements ESMAPartyInformationFinancialNonFinancial {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAPartyInformation eSMAPartyInformation) {
			ComparisonResult result = executeDataRule(eSMAPartyInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAPartyInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAPartyInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAPartyInformation eSMAPartyInformation) {
			try {
				if (areEqual(MapperS.of(eSMAPartyInformation).<NatureOfPartyEnum>map("getNatureOfParty", _eSMAPartyInformation -> _eSMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.FINANCIAL), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(eSMAPartyInformation).<CorporateSector>map("getCorporateSector", _eSMAPartyInformation -> _eSMAPartyInformation.getCorporateSector()).<FinancialSectorEnum>mapC("getFinancialSector", corporateSector -> corporateSector.getFinancialSector()));
				}
				if (areEqual(MapperS.of(eSMAPartyInformation).<NatureOfPartyEnum>map("getNatureOfParty", _eSMAPartyInformation -> _eSMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(eSMAPartyInformation).<CorporateSector>map("getCorporateSector", _eSMAPartyInformation -> _eSMAPartyInformation.getCorporateSector()).<NonFinancialSector>mapC("getNonFinancialSector", corporateSector -> corporateSector.getNonFinancialSector()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAPartyInformationFinancialNonFinancial {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAPartyInformation eSMAPartyInformation) {
			return Collections.emptyList();
		}
	}
}
