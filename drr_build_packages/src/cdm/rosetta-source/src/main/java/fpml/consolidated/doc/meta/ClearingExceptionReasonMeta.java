package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.validation.ClearingExceptionReasonTypeFormatValidator;
import fpml.consolidated.doc.validation.ClearingExceptionReasonValidator;
import fpml.consolidated.doc.validation.exists.ClearingExceptionReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingExceptionReason.class)
public class ClearingExceptionReasonMeta implements RosettaMetaData<ClearingExceptionReason> {

	@Override
	public List<Validator<? super ClearingExceptionReason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingExceptionReason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingExceptionReason> validator(ValidatorFactory factory) {
		return factory.<ClearingExceptionReason>create(ClearingExceptionReasonValidator.class);
	}

	@Override
	public Validator<? super ClearingExceptionReason> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingExceptionReason>create(ClearingExceptionReasonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingExceptionReason> validator() {
		return new ClearingExceptionReasonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingExceptionReason> typeFormatValidator() {
		return new ClearingExceptionReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingExceptionReason, Set<String>> onlyExistsValidator() {
		return new ClearingExceptionReasonOnlyExistsValidator();
	}
}
