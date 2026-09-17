package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.FrenchLawAddendumElection;
import cdm.legaldocumentation.csa.validation.FrenchLawAddendumElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.FrenchLawAddendumElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.FrenchLawAddendumElectionAddendumLanguage;
import cdm.legaldocumentation.csa.validation.exists.FrenchLawAddendumElectionOnlyExistsValidator;
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
@RosettaMeta(model=FrenchLawAddendumElection.class)
public class FrenchLawAddendumElectionMeta implements RosettaMetaData<FrenchLawAddendumElection> {

	@Override
	public List<Validator<? super FrenchLawAddendumElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FrenchLawAddendumElection>create(FrenchLawAddendumElectionAddendumLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super FrenchLawAddendumElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FrenchLawAddendumElection> validator(ValidatorFactory factory) {
		return factory.<FrenchLawAddendumElection>create(FrenchLawAddendumElectionValidator.class);
	}

	@Override
	public Validator<? super FrenchLawAddendumElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FrenchLawAddendumElection>create(FrenchLawAddendumElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FrenchLawAddendumElection> validator() {
		return new FrenchLawAddendumElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FrenchLawAddendumElection> typeFormatValidator() {
		return new FrenchLawAddendumElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FrenchLawAddendumElection, Set<String>> onlyExistsValidator() {
		return new FrenchLawAddendumElectionOnlyExistsValidator();
	}
}
