package cdm.regulation.meta;

import cdm.regulation.ExctgPrsn;
import cdm.regulation.validation.ExctgPrsnTypeFormatValidator;
import cdm.regulation.validation.ExctgPrsnValidator;
import cdm.regulation.validation.exists.ExctgPrsnOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=ExctgPrsn.class)
public class ExctgPrsnMeta implements RosettaMetaData<ExctgPrsn> {

	@Override
	public List<Validator<? super ExctgPrsn>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExctgPrsn, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExctgPrsn> validator(ValidatorFactory factory) {
		return factory.<ExctgPrsn>create(ExctgPrsnValidator.class);
	}

	@Override
	public Validator<? super ExctgPrsn> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExctgPrsn>create(ExctgPrsnTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExctgPrsn> validator() {
		return new ExctgPrsnValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExctgPrsn> typeFormatValidator() {
		return new ExctgPrsnTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExctgPrsn, Set<String>> onlyExistsValidator() {
		return new ExctgPrsnOnlyExistsValidator();
	}
}
