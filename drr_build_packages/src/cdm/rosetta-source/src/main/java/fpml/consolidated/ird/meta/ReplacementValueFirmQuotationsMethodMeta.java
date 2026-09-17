package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import fpml.consolidated.ird.validation.ReplacementValueFirmQuotationsMethodTypeFormatValidator;
import fpml.consolidated.ird.validation.ReplacementValueFirmQuotationsMethodValidator;
import fpml.consolidated.ird.validation.exists.ReplacementValueFirmQuotationsMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReplacementValueFirmQuotationsMethod.class)
public class ReplacementValueFirmQuotationsMethodMeta implements RosettaMetaData<ReplacementValueFirmQuotationsMethod> {

	@Override
	public List<Validator<? super ReplacementValueFirmQuotationsMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReplacementValueFirmQuotationsMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReplacementValueFirmQuotationsMethod> validator(ValidatorFactory factory) {
		return factory.<ReplacementValueFirmQuotationsMethod>create(ReplacementValueFirmQuotationsMethodValidator.class);
	}

	@Override
	public Validator<? super ReplacementValueFirmQuotationsMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReplacementValueFirmQuotationsMethod>create(ReplacementValueFirmQuotationsMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValueFirmQuotationsMethod> validator() {
		return new ReplacementValueFirmQuotationsMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValueFirmQuotationsMethod> typeFormatValidator() {
		return new ReplacementValueFirmQuotationsMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReplacementValueFirmQuotationsMethod, Set<String>> onlyExistsValidator() {
		return new ReplacementValueFirmQuotationsMethodOnlyExistsValidator();
	}
}
