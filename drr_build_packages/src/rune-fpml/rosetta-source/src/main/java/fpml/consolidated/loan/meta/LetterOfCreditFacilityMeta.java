package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LetterOfCreditFacility;
import fpml.consolidated.loan.validation.LetterOfCreditFacilityTypeFormatValidator;
import fpml.consolidated.loan.validation.LetterOfCreditFacilityValidator;
import fpml.consolidated.loan.validation.exists.LetterOfCreditFacilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LetterOfCreditFacility.class)
public class LetterOfCreditFacilityMeta implements RosettaMetaData<LetterOfCreditFacility> {

	@Override
	public List<Validator<? super LetterOfCreditFacility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditFacility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LetterOfCreditFacility> validator(ValidatorFactory factory) {
		return factory.<LetterOfCreditFacility>create(LetterOfCreditFacilityValidator.class);
	}

	@Override
	public Validator<? super LetterOfCreditFacility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LetterOfCreditFacility>create(LetterOfCreditFacilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCreditFacility> validator() {
		return new LetterOfCreditFacilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCreditFacility> typeFormatValidator() {
		return new LetterOfCreditFacilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditFacility, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditFacilityOnlyExistsValidator();
	}
}
