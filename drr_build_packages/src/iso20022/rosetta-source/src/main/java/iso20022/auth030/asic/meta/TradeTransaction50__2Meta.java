package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.TradeTransaction50__2;
import iso20022.auth030.asic.validation.TradeTransaction50__2TypeFormatValidator;
import iso20022.auth030.asic.validation.TradeTransaction50__2Validator;
import iso20022.auth030.asic.validation.exists.TradeTransaction50__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeTransaction50__2.class)
public class TradeTransaction50__2Meta implements RosettaMetaData<TradeTransaction50__2> {

	@Override
	public List<Validator<? super TradeTransaction50__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTransaction50__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTransaction50__2> validator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__2>create(TradeTransaction50__2Validator.class);
	}

	@Override
	public Validator<? super TradeTransaction50__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__2>create(TradeTransaction50__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__2> validator() {
		return new TradeTransaction50__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__2> typeFormatValidator() {
		return new TradeTransaction50__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTransaction50__2, Set<String>> onlyExistsValidator() {
		return new TradeTransaction50__2OnlyExistsValidator();
	}
}
