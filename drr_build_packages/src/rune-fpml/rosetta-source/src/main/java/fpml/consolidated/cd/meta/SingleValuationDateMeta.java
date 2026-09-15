package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.SingleValuationDate;
import fpml.consolidated.cd.validation.SingleValuationDateTypeFormatValidator;
import fpml.consolidated.cd.validation.SingleValuationDateValidator;
import fpml.consolidated.cd.validation.exists.SingleValuationDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SingleValuationDate.class)
public class SingleValuationDateMeta implements RosettaMetaData<SingleValuationDate> {

	@Override
	public List<Validator<? super SingleValuationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SingleValuationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SingleValuationDate> validator(ValidatorFactory factory) {
		return factory.<SingleValuationDate>create(SingleValuationDateValidator.class);
	}

	@Override
	public Validator<? super SingleValuationDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SingleValuationDate>create(SingleValuationDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SingleValuationDate> validator() {
		return new SingleValuationDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SingleValuationDate> typeFormatValidator() {
		return new SingleValuationDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SingleValuationDate, Set<String>> onlyExistsValidator() {
		return new SingleValuationDateOnlyExistsValidator();
	}
}
