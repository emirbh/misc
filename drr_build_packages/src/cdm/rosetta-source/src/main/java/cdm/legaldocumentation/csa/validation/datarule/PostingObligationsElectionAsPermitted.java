package cdm.legaldocumentation.csa.validation.datarule;

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
@RosettaDataRule("PostingObligationsElectionAsPermitted")
@ImplementedBy(PostingObligationsElectionAsPermitted.Default.class)
public interface PostingObligationsElectionAsPermitted extends Validator<PostingObligationsElection> {
	
	String NAME = "PostingObligationsElectionAsPermitted";
	String DEFINITION = "if asPermitted = True then eligibleCollateral is absent";
	
	class Default implements PostingObligationsElectionAsPermitted {
	
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
				if (areEqual(MapperS.of(postingObligationsElection).<Boolean>map("getAsPermitted", _postingObligationsElection -> _postingObligationsElection.getAsPermitted()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(postingObligationsElection).<EligibleCollateralCriteria>mapC("getEligibleCollateral", _postingObligationsElection -> _postingObligationsElection.getEligibleCollateral()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PostingObligationsElectionAsPermitted {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostingObligationsElection postingObligationsElection) {
			return Collections.emptyList();
		}
	}
}
