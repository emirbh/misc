package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralTransferTiming;
import cdm.legaldocumentation.csa.validation.CollateralTransferTimingTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralTransferTimingValidator;
import cdm.legaldocumentation.csa.validation.exists.CollateralTransferTimingOnlyExistsValidator;
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
@RosettaMeta(model=CollateralTransferTiming.class)
public class CollateralTransferTimingMeta implements RosettaMetaData<CollateralTransferTiming> {

	@Override
	public List<Validator<? super CollateralTransferTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralTransferTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralTransferTiming> validator(ValidatorFactory factory) {
		return factory.<CollateralTransferTiming>create(CollateralTransferTimingValidator.class);
	}

	@Override
	public Validator<? super CollateralTransferTiming> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralTransferTiming>create(CollateralTransferTimingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralTransferTiming> validator() {
		return new CollateralTransferTimingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralTransferTiming> typeFormatValidator() {
		return new CollateralTransferTimingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralTransferTiming, Set<String>> onlyExistsValidator() {
		return new CollateralTransferTimingOnlyExistsValidator();
	}
}
