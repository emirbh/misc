package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
import fpml.consolidated.fx.accruals.validation.FxAccrualRegionUpperBoundTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualRegionUpperBoundValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualRegionUpperBoundChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualRegionUpperBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualRegionUpperBound.class)
public class FxAccrualRegionUpperBoundMeta implements RosettaMetaData<FxAccrualRegionUpperBound> {

	@Override
	public List<Validator<? super FxAccrualRegionUpperBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualRegionUpperBound>create(FxAccrualRegionUpperBoundChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionUpperBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualRegionUpperBound> validator(ValidatorFactory factory) {
		return factory.<FxAccrualRegionUpperBound>create(FxAccrualRegionUpperBoundValidator.class);
	}

	@Override
	public Validator<? super FxAccrualRegionUpperBound> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualRegionUpperBound>create(FxAccrualRegionUpperBoundTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualRegionUpperBound> validator() {
		return new FxAccrualRegionUpperBoundValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualRegionUpperBound> typeFormatValidator() {
		return new FxAccrualRegionUpperBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionUpperBound, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionUpperBoundOnlyExistsValidator();
	}
}
