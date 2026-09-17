package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.RecalculationOfValueElection;
import cdm.legaldocumentation.csa.validation.RecalculationOfValueElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.RecalculationOfValueElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.RecalculationOfValueElectionOnlyExistsValidator;
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
@RosettaMeta(model=RecalculationOfValueElection.class)
public class RecalculationOfValueElectionMeta implements RosettaMetaData<RecalculationOfValueElection> {

	@Override
	public List<Validator<? super RecalculationOfValueElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RecalculationOfValueElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RecalculationOfValueElection> validator(ValidatorFactory factory) {
		return factory.<RecalculationOfValueElection>create(RecalculationOfValueElectionValidator.class);
	}

	@Override
	public Validator<? super RecalculationOfValueElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RecalculationOfValueElection>create(RecalculationOfValueElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RecalculationOfValueElection> validator() {
		return new RecalculationOfValueElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RecalculationOfValueElection> typeFormatValidator() {
		return new RecalculationOfValueElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RecalculationOfValueElection, Set<String>> onlyExistsValidator() {
		return new RecalculationOfValueElectionOnlyExistsValidator();
	}
}
