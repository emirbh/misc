package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.validation.ReasonTypeFormatValidator;
import fpml.consolidated.doc.validation.ReasonValidator;
import fpml.consolidated.doc.validation.exists.ReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Reason.class)
public class ReasonMeta implements RosettaMetaData<Reason> {

	@Override
	public List<Validator<? super Reason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Reason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Reason> validator(ValidatorFactory factory) {
		return factory.<Reason>create(ReasonValidator.class);
	}

	@Override
	public Validator<? super Reason> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Reason>create(ReasonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Reason> validator() {
		return new ReasonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Reason> typeFormatValidator() {
		return new ReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Reason, Set<String>> onlyExistsValidator() {
		return new ReasonOnlyExistsValidator();
	}
}
