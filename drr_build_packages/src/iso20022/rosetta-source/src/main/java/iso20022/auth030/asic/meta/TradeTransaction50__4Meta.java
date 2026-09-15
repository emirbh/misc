package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.TradeTransaction50__4;
import iso20022.auth030.asic.validation.TradeTransaction50__4TypeFormatValidator;
import iso20022.auth030.asic.validation.TradeTransaction50__4Validator;
import iso20022.auth030.asic.validation.exists.TradeTransaction50__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeTransaction50__4.class)
public class TradeTransaction50__4Meta implements RosettaMetaData<TradeTransaction50__4> {

	@Override
	public List<Validator<? super TradeTransaction50__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTransaction50__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTransaction50__4> validator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__4>create(TradeTransaction50__4Validator.class);
	}

	@Override
	public Validator<? super TradeTransaction50__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__4>create(TradeTransaction50__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__4> validator() {
		return new TradeTransaction50__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__4> typeFormatValidator() {
		return new TradeTransaction50__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTransaction50__4, Set<String>> onlyExistsValidator() {
		return new TradeTransaction50__4OnlyExistsValidator();
	}
}
