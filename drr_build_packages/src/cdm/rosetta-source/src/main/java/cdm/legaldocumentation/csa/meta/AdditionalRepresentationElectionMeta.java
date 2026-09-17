package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalRepresentationElection;
import cdm.legaldocumentation.csa.validation.AdditionalRepresentationElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalRepresentationElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.AdditionalRepresentationElectionOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalRepresentationElection.class)
public class AdditionalRepresentationElectionMeta implements RosettaMetaData<AdditionalRepresentationElection> {

	@Override
	public List<Validator<? super AdditionalRepresentationElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalRepresentationElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRepresentationElection> validator(ValidatorFactory factory) {
		return factory.<AdditionalRepresentationElection>create(AdditionalRepresentationElectionValidator.class);
	}

	@Override
	public Validator<? super AdditionalRepresentationElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalRepresentationElection>create(AdditionalRepresentationElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRepresentationElection> validator() {
		return new AdditionalRepresentationElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRepresentationElection> typeFormatValidator() {
		return new AdditionalRepresentationElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRepresentationElection, Set<String>> onlyExistsValidator() {
		return new AdditionalRepresentationElectionOnlyExistsValidator();
	}
}
