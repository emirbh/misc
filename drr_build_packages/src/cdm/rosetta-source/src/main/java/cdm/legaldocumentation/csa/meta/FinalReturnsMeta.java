package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.FinalReturns;
import cdm.legaldocumentation.csa.validation.FinalReturnsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.FinalReturnsValidator;
import cdm.legaldocumentation.csa.validation.datarule.FinalReturnsAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.exists.FinalReturnsOnlyExistsValidator;
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
@RosettaMeta(model=FinalReturns.class)
public class FinalReturnsMeta implements RosettaMetaData<FinalReturns> {

	@Override
	public List<Validator<? super FinalReturns>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FinalReturns>create(FinalReturnsAdditionalLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super FinalReturns, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinalReturns> validator(ValidatorFactory factory) {
		return factory.<FinalReturns>create(FinalReturnsValidator.class);
	}

	@Override
	public Validator<? super FinalReturns> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinalReturns>create(FinalReturnsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinalReturns> validator() {
		return new FinalReturnsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinalReturns> typeFormatValidator() {
		return new FinalReturnsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinalReturns, Set<String>> onlyExistsValidator() {
		return new FinalReturnsOnlyExistsValidator();
	}
}
