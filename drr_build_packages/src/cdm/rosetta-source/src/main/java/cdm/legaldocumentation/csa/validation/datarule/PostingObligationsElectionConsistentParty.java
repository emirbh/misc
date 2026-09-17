package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.PostingObligationsElection;
import cdm.product.collateral.EligibleCollateralCriteria;
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
@RosettaDataRule("PostingObligationsElectionConsistentParty")
@ImplementedBy(PostingObligationsElectionConsistentParty.Default.class)
public interface PostingObligationsElectionConsistentParty extends Validator<PostingObligationsElection> {
	
	String NAME = "PostingObligationsElectionConsistentParty";
	String DEFINITION = "if eligibleCollateral exists then eligibleCollateral -> appliesTo count = 0";
	
	class Default implements PostingObligationsElectionConsistentParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostingObligationsElection postingObligationsElection) {
			ComparisonResult result = executeDataRule(postingObligationsElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PostingObligationsElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PostingObligationsElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PostingObligationsElection postingObligationsElection) {
			try {
				if (exists(MapperS.of(postingObligationsElection).<EligibleCollateralCriteria>mapC("getEligibleCollateral", _postingObligationsElection -> _postingObligationsElection.getEligibleCollateral())).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(postingObligationsElection).<EligibleCollateralCriteria>mapC("getEligibleCollateral", _postingObligationsElection -> _postingObligationsElection.getEligibleCollateral()).<CounterpartyRoleEnum>mapC("getAppliesTo", eligibleCollateralCriteria -> eligibleCollateralCriteria.getAppliesTo()).resultCount()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PostingObligationsElectionConsistentParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostingObligationsElection postingObligationsElection) {
			return Collections.emptyList();
		}
	}
}
