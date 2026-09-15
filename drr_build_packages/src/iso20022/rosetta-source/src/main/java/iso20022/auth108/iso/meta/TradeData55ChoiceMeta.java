package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeData55Choice;
import iso20022.auth108.iso.validation.TradeData55ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.TradeData55ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.TradeData55ChoiceChoice;
import iso20022.auth108.iso.validation.exists.TradeData55ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData55Choice.class)
public class TradeData55ChoiceMeta implements RosettaMetaData<TradeData55Choice> {

	@Override
	public List<Validator<? super TradeData55Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeData55Choice>create(TradeData55ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeData55Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData55Choice> validator(ValidatorFactory factory) {
		return factory.<TradeData55Choice>create(TradeData55ChoiceValidator.class);
	}

	@Override
	public Validator<? super TradeData55Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData55Choice>create(TradeData55ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData55Choice> validator() {
		return new TradeData55ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData55Choice> typeFormatValidator() {
		return new TradeData55ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData55Choice, Set<String>> onlyExistsValidator() {
		return new TradeData55ChoiceOnlyExistsValidator();
	}
}
