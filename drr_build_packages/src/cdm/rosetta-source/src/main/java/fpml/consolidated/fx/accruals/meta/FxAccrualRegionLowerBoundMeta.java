package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
import fpml.consolidated.fx.accruals.validation.FxAccrualRegionLowerBoundTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualRegionLowerBoundValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualRegionLowerBoundChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualRegionLowerBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualRegionLowerBound.class)
public class FxAccrualRegionLowerBoundMeta implements RosettaMetaData<FxAccrualRegionLowerBound> {

	@Override
	public List<Validator<? super FxAccrualRegionLowerBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualRegionLowerBound>create(FxAccrualRegionLowerBoundChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionLowerBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualRegionLowerBound> validator(ValidatorFactory factory) {
		return factory.<FxAccrualRegionLowerBound>create(FxAccrualRegionLowerBoundValidator.class);
	}

	@Override
	public Validator<? super FxAccrualRegionLowerBound> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualRegionLowerBound>create(FxAccrualRegionLowerBoundTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualRegionLowerBound> validator() {
		return new FxAccrualRegionLowerBoundValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualRegionLowerBound> typeFormatValidator() {
		return new FxAccrualRegionLowerBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionLowerBound, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionLowerBoundOnlyExistsValidator();
	}
}
