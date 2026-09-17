package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralValuationAgentElection;
import cdm.legaldocumentation.csa.validation.CollateralValuationAgentElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralValuationAgentElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.CollateralValuationAgentElectionOnlyExistsValidator;
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
@RosettaMeta(model=CollateralValuationAgentElection.class)
public class CollateralValuationAgentElectionMeta implements RosettaMetaData<CollateralValuationAgentElection> {

	@Override
	public List<Validator<? super CollateralValuationAgentElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralValuationAgentElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralValuationAgentElection> validator(ValidatorFactory factory) {
		return factory.<CollateralValuationAgentElection>create(CollateralValuationAgentElectionValidator.class);
	}

	@Override
	public Validator<? super CollateralValuationAgentElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralValuationAgentElection>create(CollateralValuationAgentElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValuationAgentElection> validator() {
		return new CollateralValuationAgentElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValuationAgentElection> typeFormatValidator() {
		return new CollateralValuationAgentElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValuationAgentElection, Set<String>> onlyExistsValidator() {
		return new CollateralValuationAgentElectionOnlyExistsValidator();
	}
}
