package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeConfirmation1Choice;
import iso20022.auth030.fca.validation.TradeConfirmation1ChoiceTypeFormatValidator;
import iso20022.auth030.fca.validation.TradeConfirmation1ChoiceValidator;
import iso20022.auth030.fca.validation.datarule.TradeConfirmation1ChoiceChoice;
import iso20022.auth030.fca.validation.exists.TradeConfirmation1ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeConfirmation1Choice.class)
public class TradeConfirmation1ChoiceMeta implements RosettaMetaData<TradeConfirmation1Choice> {

	@Override
	public List<Validator<? super TradeConfirmation1Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeConfirmation1Choice>create(TradeConfirmation1ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeConfirmation1Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeConfirmation1Choice> validator(ValidatorFactory factory) {
		return factory.<TradeConfirmation1Choice>create(TradeConfirmation1ChoiceValidator.class);
	}

	@Override
	public Validator<? super TradeConfirmation1Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeConfirmation1Choice>create(TradeConfirmation1ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation1Choice> validator() {
		return new TradeConfirmation1ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation1Choice> typeFormatValidator() {
		return new TradeConfirmation1ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeConfirmation1Choice, Set<String>> onlyExistsValidator() {
		return new TradeConfirmation1ChoiceOnlyExistsValidator();
	}
}
