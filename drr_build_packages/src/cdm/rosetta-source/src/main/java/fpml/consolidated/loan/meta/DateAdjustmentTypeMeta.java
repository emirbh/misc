package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DateAdjustmentType;
import fpml.consolidated.loan.validation.DateAdjustmentTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.DateAdjustmentTypeValidator;
import fpml.consolidated.loan.validation.exists.DateAdjustmentTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DateAdjustmentType.class)
public class DateAdjustmentTypeMeta implements RosettaMetaData<DateAdjustmentType> {

	@Override
	public List<Validator<? super DateAdjustmentType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateAdjustmentType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DateAdjustmentType> validator(ValidatorFactory factory) {
		return factory.<DateAdjustmentType>create(DateAdjustmentTypeValidator.class);
	}

	@Override
	public Validator<? super DateAdjustmentType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DateAdjustmentType>create(DateAdjustmentTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DateAdjustmentType> validator() {
		return new DateAdjustmentTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DateAdjustmentType> typeFormatValidator() {
		return new DateAdjustmentTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateAdjustmentType, Set<String>> onlyExistsValidator() {
		return new DateAdjustmentTypeOnlyExistsValidator();
	}
}
