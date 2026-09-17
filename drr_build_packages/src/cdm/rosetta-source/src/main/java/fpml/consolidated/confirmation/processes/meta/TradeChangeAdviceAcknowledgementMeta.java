package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.TradeChangeAdviceAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.TradeChangeAdviceAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeChangeAdviceAcknowledgement.class)
public class TradeChangeAdviceAcknowledgementMeta implements RosettaMetaData<TradeChangeAdviceAcknowledgement> {

	@Override
	public List<Validator<? super TradeChangeAdviceAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdviceAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeChangeAdviceAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<TradeChangeAdviceAcknowledgement>create(TradeChangeAdviceAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super TradeChangeAdviceAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeChangeAdviceAcknowledgement>create(TradeChangeAdviceAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdviceAcknowledgement> validator() {
		return new TradeChangeAdviceAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdviceAcknowledgement> typeFormatValidator() {
		return new TradeChangeAdviceAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdviceAcknowledgement, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceAcknowledgementOnlyExistsValidator();
	}
}
