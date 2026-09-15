package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeData42__4;
import iso20022.auth030.fca.validation.TradeData42__4TypeFormatValidator;
import iso20022.auth030.fca.validation.TradeData42__4Validator;
import iso20022.auth030.fca.validation.exists.TradeData42__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData42__4.class)
public class TradeData42__4Meta implements RosettaMetaData<TradeData42__4> {

	@Override
	public List<Validator<? super TradeData42__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData42__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData42__4> validator(ValidatorFactory factory) {
		return factory.<TradeData42__4>create(TradeData42__4Validator.class);
	}

	@Override
	public Validator<? super TradeData42__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData42__4>create(TradeData42__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__4> validator() {
		return new TradeData42__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__4> typeFormatValidator() {
		return new TradeData42__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData42__4, Set<String>> onlyExistsValidator() {
		return new TradeData42__4OnlyExistsValidator();
	}
}
