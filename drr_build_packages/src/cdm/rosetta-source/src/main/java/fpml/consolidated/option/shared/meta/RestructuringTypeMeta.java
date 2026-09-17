package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.RestructuringType;
import fpml.consolidated.option.shared.validation.RestructuringTypeTypeFormatValidator;
import fpml.consolidated.option.shared.validation.RestructuringTypeValidator;
import fpml.consolidated.option.shared.validation.exists.RestructuringTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RestructuringType.class)
public class RestructuringTypeMeta implements RosettaMetaData<RestructuringType> {

	@Override
	public List<Validator<? super RestructuringType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RestructuringType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RestructuringType> validator(ValidatorFactory factory) {
		return factory.<RestructuringType>create(RestructuringTypeValidator.class);
	}

	@Override
	public Validator<? super RestructuringType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RestructuringType>create(RestructuringTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RestructuringType> validator() {
		return new RestructuringTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RestructuringType> typeFormatValidator() {
		return new RestructuringTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RestructuringType, Set<String>> onlyExistsValidator() {
		return new RestructuringTypeOnlyExistsValidator();
	}
}
