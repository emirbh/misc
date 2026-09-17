package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReasonCode;
import fpml.consolidated.doc.validation.ReasonCodeTypeFormatValidator;
import fpml.consolidated.doc.validation.ReasonCodeValidator;
import fpml.consolidated.doc.validation.exists.ReasonCodeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReasonCode.class)
public class ReasonCodeMeta implements RosettaMetaData<ReasonCode> {

	@Override
	public List<Validator<? super ReasonCode>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReasonCode, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReasonCode> validator(ValidatorFactory factory) {
		return factory.<ReasonCode>create(ReasonCodeValidator.class);
	}

	@Override
	public Validator<? super ReasonCode> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReasonCode>create(ReasonCodeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReasonCode> validator() {
		return new ReasonCodeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReasonCode> typeFormatValidator() {
		return new ReasonCodeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReasonCode, Set<String>> onlyExistsValidator() {
		return new ReasonCodeOnlyExistsValidator();
	}
}
