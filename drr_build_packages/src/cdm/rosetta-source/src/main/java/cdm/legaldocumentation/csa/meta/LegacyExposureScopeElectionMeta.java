package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyExposureScopeElection;
import cdm.legaldocumentation.csa.validation.LegacyExposureScopeElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyExposureScopeElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.LegacyExposureScopeElectionOnlyExistsValidator;
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
@RosettaMeta(model=LegacyExposureScopeElection.class)
public class LegacyExposureScopeElectionMeta implements RosettaMetaData<LegacyExposureScopeElection> {

	@Override
	public List<Validator<? super LegacyExposureScopeElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyExposureScopeElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyExposureScopeElection> validator(ValidatorFactory factory) {
		return factory.<LegacyExposureScopeElection>create(LegacyExposureScopeElectionValidator.class);
	}

	@Override
	public Validator<? super LegacyExposureScopeElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyExposureScopeElection>create(LegacyExposureScopeElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyExposureScopeElection> validator() {
		return new LegacyExposureScopeElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyExposureScopeElection> typeFormatValidator() {
		return new LegacyExposureScopeElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyExposureScopeElection, Set<String>> onlyExistsValidator() {
		return new LegacyExposureScopeElectionOnlyExistsValidator();
	}
}
