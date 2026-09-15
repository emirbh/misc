package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MetricAdjustmentType;
import fpml.consolidated.loan.validation.MetricAdjustmentTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.MetricAdjustmentTypeValidator;
import fpml.consolidated.loan.validation.exists.MetricAdjustmentTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MetricAdjustmentType.class)
public class MetricAdjustmentTypeMeta implements RosettaMetaData<MetricAdjustmentType> {

	@Override
	public List<Validator<? super MetricAdjustmentType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MetricAdjustmentType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MetricAdjustmentType> validator(ValidatorFactory factory) {
		return factory.<MetricAdjustmentType>create(MetricAdjustmentTypeValidator.class);
	}

	@Override
	public Validator<? super MetricAdjustmentType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MetricAdjustmentType>create(MetricAdjustmentTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MetricAdjustmentType> validator() {
		return new MetricAdjustmentTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MetricAdjustmentType> typeFormatValidator() {
		return new MetricAdjustmentTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MetricAdjustmentType, Set<String>> onlyExistsValidator() {
		return new MetricAdjustmentTypeOnlyExistsValidator();
	}
}
