package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.TradeWrapper;
import fpml.consolidated.confirmation.processes.validation.TradeWrapperTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.TradeWrapperValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.TradeWrapperChoice;
import fpml.consolidated.confirmation.processes.validation.exists.TradeWrapperOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeWrapper.class)
public class TradeWrapperMeta implements RosettaMetaData<TradeWrapper> {

	@Override
	public List<Validator<? super TradeWrapper>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeWrapper>create(TradeWrapperChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeWrapper, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeWrapper> validator(ValidatorFactory factory) {
		return factory.<TradeWrapper>create(TradeWrapperValidator.class);
	}

	@Override
	public Validator<? super TradeWrapper> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeWrapper>create(TradeWrapperTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeWrapper> validator() {
		return new TradeWrapperValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeWrapper> typeFormatValidator() {
		return new TradeWrapperTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeWrapper, Set<String>> onlyExistsValidator() {
		return new TradeWrapperOnlyExistsValidator();
	}
}
