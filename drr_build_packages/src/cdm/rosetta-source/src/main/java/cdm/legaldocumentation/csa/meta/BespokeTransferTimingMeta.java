package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.BespokeTransferTiming;
import cdm.legaldocumentation.csa.validation.BespokeTransferTimingTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.BespokeTransferTimingValidator;
import cdm.legaldocumentation.csa.validation.exists.BespokeTransferTimingOnlyExistsValidator;
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
@RosettaMeta(model=BespokeTransferTiming.class)
public class BespokeTransferTimingMeta implements RosettaMetaData<BespokeTransferTiming> {

	@Override
	public List<Validator<? super BespokeTransferTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BespokeTransferTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BespokeTransferTiming> validator(ValidatorFactory factory) {
		return factory.<BespokeTransferTiming>create(BespokeTransferTimingValidator.class);
	}

	@Override
	public Validator<? super BespokeTransferTiming> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BespokeTransferTiming>create(BespokeTransferTimingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BespokeTransferTiming> validator() {
		return new BespokeTransferTimingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BespokeTransferTiming> typeFormatValidator() {
		return new BespokeTransferTimingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BespokeTransferTiming, Set<String>> onlyExistsValidator() {
		return new BespokeTransferTimingOnlyExistsValidator();
	}
}
