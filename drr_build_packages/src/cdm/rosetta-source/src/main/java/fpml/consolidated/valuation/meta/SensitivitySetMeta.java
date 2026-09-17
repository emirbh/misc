package fpml.consolidated.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.SensitivitySet;
import fpml.consolidated.valuation.validation.SensitivitySetTypeFormatValidator;
import fpml.consolidated.valuation.validation.SensitivitySetValidator;
import fpml.consolidated.valuation.validation.exists.SensitivitySetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SensitivitySet.class)
public class SensitivitySetMeta implements RosettaMetaData<SensitivitySet> {

	@Override
	public List<Validator<? super SensitivitySet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SensitivitySet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivitySet> validator(ValidatorFactory factory) {
		return factory.<SensitivitySet>create(SensitivitySetValidator.class);
	}

	@Override
	public Validator<? super SensitivitySet> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SensitivitySet>create(SensitivitySetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SensitivitySet> validator() {
		return new SensitivitySetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SensitivitySet> typeFormatValidator() {
		return new SensitivitySetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivitySet, Set<String>> onlyExistsValidator() {
		return new SensitivitySetOnlyExistsValidator();
	}
}
