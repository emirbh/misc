package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxRangeAccrual;
import fpml.consolidated.fx.accruals.validation.FxRangeAccrualTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxRangeAccrualValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxRangeAccrualChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxRangeAccrualChoice1;
import fpml.consolidated.fx.accruals.validation.exists.FxRangeAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxRangeAccrual.class)
public class FxRangeAccrualMeta implements RosettaMetaData<FxRangeAccrual> {

	@Override
	public List<Validator<? super FxRangeAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxRangeAccrual>create(FxRangeAccrualChoice0.class),
			factory.<FxRangeAccrual>create(FxRangeAccrualChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxRangeAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxRangeAccrual> validator(ValidatorFactory factory) {
		return factory.<FxRangeAccrual>create(FxRangeAccrualValidator.class);
	}

	@Override
	public Validator<? super FxRangeAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxRangeAccrual>create(FxRangeAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxRangeAccrual> validator() {
		return new FxRangeAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxRangeAccrual> typeFormatValidator() {
		return new FxRangeAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRangeAccrual, Set<String>> onlyExistsValidator() {
		return new FxRangeAccrualOnlyExistsValidator();
	}
}
