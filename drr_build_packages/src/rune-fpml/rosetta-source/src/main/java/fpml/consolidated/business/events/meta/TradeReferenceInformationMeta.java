package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.business.events.validation.TradeReferenceInformationTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeReferenceInformationValidator;
import fpml.consolidated.business.events.validation.datarule.TradeReferenceInformationChoice;
import fpml.consolidated.business.events.validation.exists.TradeReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeReferenceInformation.class)
public class TradeReferenceInformationMeta implements RosettaMetaData<TradeReferenceInformation> {

	@Override
	public List<Validator<? super TradeReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeReferenceInformation>create(TradeReferenceInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeReferenceInformation> validator(ValidatorFactory factory) {
		return factory.<TradeReferenceInformation>create(TradeReferenceInformationValidator.class);
	}

	@Override
	public Validator<? super TradeReferenceInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeReferenceInformation>create(TradeReferenceInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeReferenceInformation> validator() {
		return new TradeReferenceInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeReferenceInformation> typeFormatValidator() {
		return new TradeReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReferenceInformation, Set<String>> onlyExistsValidator() {
		return new TradeReferenceInformationOnlyExistsValidator();
	}
}
