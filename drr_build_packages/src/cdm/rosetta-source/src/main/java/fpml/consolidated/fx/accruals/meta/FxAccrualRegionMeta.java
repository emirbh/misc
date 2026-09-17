package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualRegion;
import fpml.consolidated.fx.accruals.validation.FxAccrualRegionTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualRegionValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualRegionChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualRegionChoice1;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualRegion.class)
public class FxAccrualRegionMeta implements RosettaMetaData<FxAccrualRegion> {

	@Override
	public List<Validator<? super FxAccrualRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualRegion>create(FxAccrualRegionChoice0.class),
			factory.<FxAccrualRegion>create(FxAccrualRegionChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualRegion> validator(ValidatorFactory factory) {
		return factory.<FxAccrualRegion>create(FxAccrualRegionValidator.class);
	}

	@Override
	public Validator<? super FxAccrualRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualRegion>create(FxAccrualRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualRegion> validator() {
		return new FxAccrualRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualRegion> typeFormatValidator() {
		return new FxAccrualRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegion, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionOnlyExistsValidator();
	}
}
