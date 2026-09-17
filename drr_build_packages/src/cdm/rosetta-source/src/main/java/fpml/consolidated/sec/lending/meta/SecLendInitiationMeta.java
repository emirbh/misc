package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecLendInitiation;
import fpml.consolidated.sec.lending.validation.SecLendInitiationTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecLendInitiationValidator;
import fpml.consolidated.sec.lending.validation.exists.SecLendInitiationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecLendInitiation.class)
public class SecLendInitiationMeta implements RosettaMetaData<SecLendInitiation> {

	@Override
	public List<Validator<? super SecLendInitiation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecLendInitiation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecLendInitiation> validator(ValidatorFactory factory) {
		return factory.<SecLendInitiation>create(SecLendInitiationValidator.class);
	}

	@Override
	public Validator<? super SecLendInitiation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecLendInitiation>create(SecLendInitiationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecLendInitiation> validator() {
		return new SecLendInitiationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecLendInitiation> typeFormatValidator() {
		return new SecLendInitiationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecLendInitiation, Set<String>> onlyExistsValidator() {
		return new SecLendInitiationOnlyExistsValidator();
	}
}
