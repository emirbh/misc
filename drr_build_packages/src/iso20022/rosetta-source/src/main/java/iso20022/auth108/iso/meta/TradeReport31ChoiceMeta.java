package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeReport31Choice;
import iso20022.auth108.iso.validation.TradeReport31ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.TradeReport31ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.TradeReport31ChoiceChoice;
import iso20022.auth108.iso.validation.exists.TradeReport31ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeReport31Choice.class)
public class TradeReport31ChoiceMeta implements RosettaMetaData<TradeReport31Choice> {

	@Override
	public List<Validator<? super TradeReport31Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeReport31Choice>create(TradeReport31ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeReport31Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeReport31Choice> validator(ValidatorFactory factory) {
		return factory.<TradeReport31Choice>create(TradeReport31ChoiceValidator.class);
	}

	@Override
	public Validator<? super TradeReport31Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeReport31Choice>create(TradeReport31ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeReport31Choice> validator() {
		return new TradeReport31ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeReport31Choice> typeFormatValidator() {
		return new TradeReport31ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReport31Choice, Set<String>> onlyExistsValidator() {
		return new TradeReport31ChoiceOnlyExistsValidator();
	}
}
