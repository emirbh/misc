package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradePackageSequence;
import fpml.consolidated.business.events.validation.TradePackageSequenceTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradePackageSequenceValidator;
import fpml.consolidated.business.events.validation.exists.TradePackageSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradePackageSequence.class)
public class TradePackageSequenceMeta implements RosettaMetaData<TradePackageSequence> {

	@Override
	public List<Validator<? super TradePackageSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradePackageSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradePackageSequence> validator(ValidatorFactory factory) {
		return factory.<TradePackageSequence>create(TradePackageSequenceValidator.class);
	}

	@Override
	public Validator<? super TradePackageSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradePackageSequence>create(TradePackageSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradePackageSequence> validator() {
		return new TradePackageSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradePackageSequence> typeFormatValidator() {
		return new TradePackageSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradePackageSequence, Set<String>> onlyExistsValidator() {
		return new TradePackageSequenceOnlyExistsValidator();
	}
}
