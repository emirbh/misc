package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeConfirmation4Choice;
import iso20022.auth030.jfsa.validation.TradeConfirmation4ChoiceTypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeConfirmation4ChoiceValidator;
import iso20022.auth030.jfsa.validation.datarule.TradeConfirmation4ChoiceChoice;
import iso20022.auth030.jfsa.validation.exists.TradeConfirmation4ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeConfirmation4Choice.class)
public class TradeConfirmation4ChoiceMeta implements RosettaMetaData<TradeConfirmation4Choice> {

	@Override
	public List<Validator<? super TradeConfirmation4Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeConfirmation4Choice>create(TradeConfirmation4ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeConfirmation4Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeConfirmation4Choice> validator(ValidatorFactory factory) {
		return factory.<TradeConfirmation4Choice>create(TradeConfirmation4ChoiceValidator.class);
	}

	@Override
	public Validator<? super TradeConfirmation4Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeConfirmation4Choice>create(TradeConfirmation4ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation4Choice> validator() {
		return new TradeConfirmation4ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation4Choice> typeFormatValidator() {
		return new TradeConfirmation4ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeConfirmation4Choice, Set<String>> onlyExistsValidator() {
		return new TradeConfirmation4ChoiceOnlyExistsValidator();
	}
}
