package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.FrenchLawAddendum;
import cdm.legaldocumentation.csa.validation.FrenchLawAddendumTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.FrenchLawAddendumValidator;
import cdm.legaldocumentation.csa.validation.datarule.FrenchLawAddendumApplicable;
import cdm.legaldocumentation.csa.validation.exists.FrenchLawAddendumOnlyExistsValidator;
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
@RosettaMeta(model=FrenchLawAddendum.class)
public class FrenchLawAddendumMeta implements RosettaMetaData<FrenchLawAddendum> {

	@Override
	public List<Validator<? super FrenchLawAddendum>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FrenchLawAddendum>create(FrenchLawAddendumApplicable.class)
		);
	}
	
	@Override
	public List<Function<? super FrenchLawAddendum, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FrenchLawAddendum> validator(ValidatorFactory factory) {
		return factory.<FrenchLawAddendum>create(FrenchLawAddendumValidator.class);
	}

	@Override
	public Validator<? super FrenchLawAddendum> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FrenchLawAddendum>create(FrenchLawAddendumTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FrenchLawAddendum> validator() {
		return new FrenchLawAddendumValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FrenchLawAddendum> typeFormatValidator() {
		return new FrenchLawAddendumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FrenchLawAddendum, Set<String>> onlyExistsValidator() {
		return new FrenchLawAddendumOnlyExistsValidator();
	}
}
