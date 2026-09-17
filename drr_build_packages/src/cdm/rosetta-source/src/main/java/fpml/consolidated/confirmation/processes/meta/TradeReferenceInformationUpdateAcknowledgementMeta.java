package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.TradeReferenceInformationUpdateAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.TradeReferenceInformationUpdateAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.TradeReferenceInformationUpdateAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.TradeReferenceInformationUpdateAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeReferenceInformationUpdateAcknowledgement.class)
public class TradeReferenceInformationUpdateAcknowledgementMeta implements RosettaMetaData<TradeReferenceInformationUpdateAcknowledgement> {

	@Override
	public List<Validator<? super TradeReferenceInformationUpdateAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeReferenceInformationUpdateAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeReferenceInformationUpdateAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<TradeReferenceInformationUpdateAcknowledgement>create(TradeReferenceInformationUpdateAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super TradeReferenceInformationUpdateAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeReferenceInformationUpdateAcknowledgement>create(TradeReferenceInformationUpdateAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeReferenceInformationUpdateAcknowledgement> validator() {
		return new TradeReferenceInformationUpdateAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeReferenceInformationUpdateAcknowledgement> typeFormatValidator() {
		return new TradeReferenceInformationUpdateAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReferenceInformationUpdateAcknowledgement, Set<String>> onlyExistsValidator() {
		return new TradeReferenceInformationUpdateAcknowledgementOnlyExistsValidator();
	}
}
