package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcType;
import fpml.consolidated.loan.validation.LcTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LcTypeValidator;
import fpml.consolidated.loan.validation.exists.LcTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcType.class)
public class LcTypeMeta implements RosettaMetaData<LcType> {

	@Override
	public List<Validator<? super LcType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcType> validator(ValidatorFactory factory) {
		return factory.<LcType>create(LcTypeValidator.class);
	}

	@Override
	public Validator<? super LcType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcType>create(LcTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcType> validator() {
		return new LcTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcType> typeFormatValidator() {
		return new LcTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcType, Set<String>> onlyExistsValidator() {
		return new LcTypeOnlyExistsValidator();
	}
}
