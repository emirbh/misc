package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.HoldingAndUsingPostedCollateralElection;
import cdm.legaldocumentation.csa.validation.HoldingAndUsingPostedCollateralElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.HoldingAndUsingPostedCollateralElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.HoldingAndUsingPostedCollateralElectionOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=HoldingAndUsingPostedCollateralElection.class)
public class HoldingAndUsingPostedCollateralElectionMeta implements RosettaMetaData<HoldingAndUsingPostedCollateralElection> {

	@Override
	public List<Validator<? super HoldingAndUsingPostedCollateralElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super HoldingAndUsingPostedCollateralElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HoldingAndUsingPostedCollateralElection> validator(ValidatorFactory factory) {
		return factory.<HoldingAndUsingPostedCollateralElection>create(HoldingAndUsingPostedCollateralElectionValidator.class);
	}

	@Override
	public Validator<? super HoldingAndUsingPostedCollateralElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HoldingAndUsingPostedCollateralElection>create(HoldingAndUsingPostedCollateralElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HoldingAndUsingPostedCollateralElection> validator() {
		return new HoldingAndUsingPostedCollateralElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HoldingAndUsingPostedCollateralElection> typeFormatValidator() {
		return new HoldingAndUsingPostedCollateralElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HoldingAndUsingPostedCollateralElection, Set<String>> onlyExistsValidator() {
		return new HoldingAndUsingPostedCollateralElectionOnlyExistsValidator();
	}
}
