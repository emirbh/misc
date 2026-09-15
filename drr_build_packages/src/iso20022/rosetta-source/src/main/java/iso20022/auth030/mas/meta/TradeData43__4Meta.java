package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.TradeData43__4;
import iso20022.auth030.mas.validation.TradeData43__4TypeFormatValidator;
import iso20022.auth030.mas.validation.TradeData43__4Validator;
import iso20022.auth030.mas.validation.exists.TradeData43__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__4.class)
public class TradeData43__4Meta implements RosettaMetaData<TradeData43__4> {

	@Override
	public List<Validator<? super TradeData43__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__4> validator(ValidatorFactory factory) {
		return factory.<TradeData43__4>create(TradeData43__4Validator.class);
	}

	@Override
	public Validator<? super TradeData43__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__4>create(TradeData43__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__4> validator() {
		return new TradeData43__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__4> typeFormatValidator() {
		return new TradeData43__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__4, Set<String>> onlyExistsValidator() {
		return new TradeData43__4OnlyExistsValidator();
	}
}
