package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MiscFeeType;
import fpml.consolidated.loan.validation.MiscFeeTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.MiscFeeTypeValidator;
import fpml.consolidated.loan.validation.exists.MiscFeeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MiscFeeType.class)
public class MiscFeeTypeMeta implements RosettaMetaData<MiscFeeType> {

	@Override
	public List<Validator<? super MiscFeeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MiscFeeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MiscFeeType> validator(ValidatorFactory factory) {
		return factory.<MiscFeeType>create(MiscFeeTypeValidator.class);
	}

	@Override
	public Validator<? super MiscFeeType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MiscFeeType>create(MiscFeeTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MiscFeeType> validator() {
		return new MiscFeeTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MiscFeeType> typeFormatValidator() {
		return new MiscFeeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MiscFeeType, Set<String>> onlyExistsValidator() {
		return new MiscFeeTypeOnlyExistsValidator();
	}
}
