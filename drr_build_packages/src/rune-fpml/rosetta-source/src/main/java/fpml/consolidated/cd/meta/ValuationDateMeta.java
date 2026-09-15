package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ValuationDate;
import fpml.consolidated.cd.validation.ValuationDateTypeFormatValidator;
import fpml.consolidated.cd.validation.ValuationDateValidator;
import fpml.consolidated.cd.validation.datarule.ValuationDateChoice;
import fpml.consolidated.cd.validation.exists.ValuationDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationDate.class)
public class ValuationDateMeta implements RosettaMetaData<ValuationDate> {

	@Override
	public List<Validator<? super ValuationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ValuationDate>create(ValuationDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ValuationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationDate> validator(ValidatorFactory factory) {
		return factory.<ValuationDate>create(ValuationDateValidator.class);
	}

	@Override
	public Validator<? super ValuationDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationDate>create(ValuationDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationDate> validator() {
		return new ValuationDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationDate> typeFormatValidator() {
		return new ValuationDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDate, Set<String>> onlyExistsValidator() {
		return new ValuationDateOnlyExistsValidator();
	}
}
