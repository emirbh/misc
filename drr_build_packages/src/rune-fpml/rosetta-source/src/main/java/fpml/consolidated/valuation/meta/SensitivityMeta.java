package fpml.consolidated.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.Sensitivity;
import fpml.consolidated.valuation.validation.SensitivityTypeFormatValidator;
import fpml.consolidated.valuation.validation.SensitivityValidator;
import fpml.consolidated.valuation.validation.exists.SensitivityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Sensitivity.class)
public class SensitivityMeta implements RosettaMetaData<Sensitivity> {

	@Override
	public List<Validator<? super Sensitivity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Sensitivity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Sensitivity> validator(ValidatorFactory factory) {
		return factory.<Sensitivity>create(SensitivityValidator.class);
	}

	@Override
	public Validator<? super Sensitivity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Sensitivity>create(SensitivityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Sensitivity> validator() {
		return new SensitivityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Sensitivity> typeFormatValidator() {
		return new SensitivityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Sensitivity, Set<String>> onlyExistsValidator() {
		return new SensitivityOnlyExistsValidator();
	}
}
